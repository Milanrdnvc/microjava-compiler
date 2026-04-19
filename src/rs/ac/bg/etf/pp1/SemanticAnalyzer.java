package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class SemanticAnalyzer extends VisitorAdaptor {
	private boolean errorDetected = false;
	Logger log = Logger.getLogger(getClass());
	private Obj currentProg;
	private Struct currentEnum;
	private Struct currentType;
	private int constant;
	private Struct constType;
	private Struct boolType = Tab.find("bool").getType();
	private Obj main;
	private Obj currentMeth;
	private Struct retType;
	private int currEnumNumConst = 0;
	private String currentPropertySuffix;
	private boolean returnHappened;
	private int loopNestCnt = 0;
	private Stack<Integer> inSwitch = new Stack<>();
	Stack <Set<Integer>> caseValues = new Stack<>();
	int nVars;
	
	static ArrayList<Integer> numOfSwitchCases = new ArrayList<Integer>();
	
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected  = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public boolean passed() {
		return !errorDetected;
	}
	
	/* TRAVERSE AST AND INITIALIZE SYMBOL TABLE */
	
	@Override
	public void visit(ProgramName programName) {
		currentProg = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope();
	}
	
	@Override
	public void visit(Program program) {
		nVars = Tab.currentScope().getnVars();
		Tab.chainLocalSymbols(currentProg);
		Tab.closeScope();
		currentProg = null;
		
		if (main == null || main.getLevel() > 0) {
			report_error("Program nema adekvatnu main metodu.", program);
		} else {
			
		}
		
	}
	
	// Constants 
	
	@Override
	public void visit(ConstDeclFirst constDeclFirst) {
		Obj conObj = Tab.find(constDeclFirst.getI1());
		
		if (conObj != Tab.noObj) {
			report_error("Visestruka definicija konstante: " + constDeclFirst.getI1(), constDeclFirst);
		} else {
			if (constType.assignableTo(currentType)) {
				conObj = Tab.insert(Obj.Con, constDeclFirst.getI1(), currentType);
				conObj.setAdr(constant);
			} else {
				report_error("Neadekvatna dodela konstante: " + constDeclFirst.getI1(), constDeclFirst);
			}
		}
	}
	
	@Override
	public void visit(Constant_Num constant_Num) {
		constant = constant_Num.getN1();
		constType = Tab.intType;
	}
	
	@Override
	public void visit(Constant_Char constant_Char) {
		constant = constant_Char.getC1();
		constType = Tab.charType;
	}
	
	@Override
	public void visit(Constant_Bool constant_Bool) {
		constant = constant_Bool.getB1();
		constType = boolType;
	}
	
	// Variables
	
	@Override
	public void visit(VarDeclFirst_Var varDeclFirst_Var) {
		Obj varObj = null;
		
		if (currentMeth == null) {
			varObj = Tab.find(varDeclFirst_Var.getI1());
		} else {
			varObj = Tab.currentScope().findSymbol(varDeclFirst_Var.getI1());
		}
		 
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varDeclFirst_Var.getI1(), currentType);
		} else {
			report_error("Visestruka definicija promenljive: " + varDeclFirst_Var.getI1(), varDeclFirst_Var);
		}
	}
	
	@Override
	public void visit(VarDeclFirst_Array varDeclFirst_Array) {
		Obj varObj = null;
		
		if (currentMeth == null) {
			varObj = Tab.find(varDeclFirst_Array.getI1());
		} else {
			varObj = Tab.currentScope().findSymbol(varDeclFirst_Array.getI1());
		}
		
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, varDeclFirst_Array.getI1(), new Struct(Struct.Array, currentType));
		} else {
			report_error("Visestruka definicija promenljive: " + varDeclFirst_Array.getI1(), varDeclFirst_Array);
		}
	}
	
	// Enumerations
	
	@Override
	public void visit(EnumName enumName) {
		Obj enumObj = Tab.find(enumName.getI1());
		
		if (enumObj != Tab.noObj) {
			report_error("Visestruka definicija enumeracije: " + enumName.getI1(), enumName);
			currentEnum = new Struct(Struct.None);
		} else {
			currentEnum = new Struct(Struct.Enum);
			enumObj = Tab.insert(Obj.Type, enumName.getI1(), currentEnum);
			Tab.openScope();
		}
	}
	
	@Override
	public void visit(EnumDecl enumDecl) {
		Tab.chainLocalSymbols(currentEnum);
		Tab.closeScope();
		currentEnum = null;
		currEnumNumConst = 0;
	}
	
	@Override
	public void visit(EnumDeclFirst enumDeclFirst) {
		Obj enumConstObj = null;
		
		enumConstObj = Tab.currentScope().findSymbol(enumDeclFirst.getI1());
		
		if (enumConstObj == null) {
			enumConstObj = Tab.insert(Obj.Fld, enumDeclFirst.getI1(), currentEnum);
			enumConstObj.setLevel(2);
			enumConstObj.setAdr(currEnumNumConst++);
		} else {
			report_error("Visestruka definicija enumeracijske konstante: " + enumDeclFirst.getI1(), enumDeclFirst);
		}
	}
	
	@Override
	public void visit(NumConst_Num numConst_Num) {
		currEnumNumConst = numConst_Num.getN1();
	}
	
	// Methods
	
	@Override
	public void visit(MethodName methodName) {
		methodName.obj = currentMeth = Tab.insert(Obj.Meth, methodName.getI1(), retType);
		if (methodName.getI1().equalsIgnoreCase("main") && retType == Tab.noType) {
			main = currentMeth;
		}
		Tab.openScope();
	}
	
	@Override
	public void visit(MethodDecl_Decl methodDecl) {
		Tab.chainLocalSymbols(currentMeth);
		Tab.closeScope();
		
		if (currentMeth.getType() != Tab.noType && !returnHappened) {
			report_error("Ne postoji return unutar metode: " + currentMeth.getName(), methodDecl);
		}
		
		currentMeth = null;
		returnHappened = false;
	}
	
	@Override
	public void visit(FormParsFirst_Var formParsFirst_Var) {
		Obj varObj = null;
		
		if (currentMeth == null) {
			report_error("Semanticka greska.", formParsFirst_Var);
		} else {
			varObj = Tab.currentScope().findSymbol(formParsFirst_Var.getI1());
		}
		 
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formParsFirst_Var.getI1(), currentType);
			varObj.setFpPos(1);
			currentMeth.setLevel(currentMeth.getLevel() + 1);
		} else {
			report_error("Visestruka definicija formalnog parametra: " + formParsFirst_Var.getI1(), formParsFirst_Var);
		}
	}
	
	@Override
	public void visit(FormParsFirst_Array formParsFirst_Array) {
		Obj varObj = null;
		
		if (currentMeth == null) {
			varObj = Tab.find(formParsFirst_Array.getI1());
		} else {
			varObj = Tab.currentScope().findSymbol(formParsFirst_Array.getI1());
		}
		
		if (varObj == null || varObj == Tab.noObj) {
			varObj = Tab.insert(Obj.Var, formParsFirst_Array.getI1(), new Struct(Struct.Array, currentType));
			varObj.setFpPos(1);
			currentMeth.setLevel(currentMeth.getLevel() + 1);
		} else {
			report_error("Visestruka definicija promenljive: " + formParsFirst_Array.getI1(), formParsFirst_Array);
		}
	}
	
	@Override
	public void visit(ReturnType_Type returnType_Type) {
		retType = currentType;
	}
	
	@Override
	public void visit(ReturnType_Void returnType_Void) {
		retType = Tab.noType;
	}
	
	@Override
	public void visit(Type type) {
		Obj typeObj = Tab.find(type.getI1());
		
		if (typeObj == Tab.noObj) {
			report_error("Nepostojeci tip podatka " + type.getI1(), type);
			type.struct = currentType = Tab.noType;
		} else if (typeObj.getKind() != Obj.Type) {
			report_error("Neadekvatan tip podatka " + type.getI1(), type);
			type.struct = currentType = Tab.noType;
		} else {
			type.struct = currentType = typeObj.getType();
		}
	}
	
	/* TRAVERSE AST AND CHECK CONTEXT CONDITIONS */
	
	// Designator
	
	@Override
	public void visit(Designator_Var designator_Var) {
		Obj varObj = Tab.find(designator_Var.getI1());
		
		if (varObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj promenljivi: " +  designator_Var.getI1(), designator_Var);
			designator_Var.obj = Tab.noObj;
		} else if (varObj.getKind() != Obj.Var && varObj.getKind() != Obj.Con && varObj.getKind() != Obj.Meth) {
			report_error("Neadekvatna promenljiva: " +  designator_Var.getI1(), designator_Var);
			designator_Var.obj = Tab.noObj;
		} else {
			designator_Var.obj = varObj;
		}
		
		report_info("Pristup promenljivoj: " + varObj.getName() + " " + varObj, designator_Var);
	}
	
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Obj arrObj = Tab.find(designatorArrayName.getI1());
		
		if (arrObj == Tab.noObj) {
			report_error("Pristup nedefinisanoj nizovskoj promenljivi: " +  designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		} else if (arrObj.getKind() != Obj.Var || arrObj.getType().getKind() != Struct.Array){
			report_error("Neadekvatna nizovska promenljiva: " +  designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		} else {
			designatorArrayName.obj = arrObj;
		}
	}
	
	@Override
	public void visit(Designator_Array designator_Array) {
		Obj arrObj = designator_Array.getDesignatorArrayName().obj;
		
		if (arrObj == Tab.noObj) {
			designator_Array.obj = Tab.noObj;
		} else if (!designator_Array.getExpr().struct.equals(Tab.intType) && (designator_Array.getExpr().struct.getKind() != Struct.Enum)) {
			report_error("Neadekvatno indeksiranje niza ", designator_Array);
			designator_Array.obj = Tab.noObj;
		}
		else {
			designator_Array.obj = new Obj(Obj.Elem, designator_Array.getDesignatorArrayName().getI1() + "[i]", arrObj.getType().getElemType());
			
			report_info("Pristup elementu niza: " + arrObj.getName() + " " + arrObj, designator_Array);
		}
	}
	
	@Override
	public void visit(DesignatorVarPropertyName designatorVarPropertyName) {
		Obj obj = Tab.find(designatorVarPropertyName.getI1());
		
		if (obj == Tab.noObj) {
			report_error("Pristup svojstvu nedefinisane promenljive: " +  designatorVarPropertyName.getI1(), designatorVarPropertyName);
			designatorVarPropertyName.obj = Tab.noObj;
		} else if (!(obj.getKind() == Obj.Var && obj.getType().getKind() == Struct.Array) 
				&& !(obj.getKind() == Obj.Type && obj.getType().getKind() == Struct.Enum)){
			report_error("Neadekvatna promenljiva za pristup svojstvima: " +  designatorVarPropertyName.getI1(), designatorVarPropertyName);
			designatorVarPropertyName.obj = Tab.noObj;
		} else { 
			designatorVarPropertyName.obj = obj;
		}
	}
	
	@Override
	public void visit(DesignatorPropertySuffix_Length designatorPropertySuffix_Length) {
		currentPropertySuffix = "length";
	}
	
	@Override
	public void visit(DesignatorPropertySuffix_EnumConst designatorPropertySuffix_EnumConst) {
		currentPropertySuffix = designatorPropertySuffix_EnumConst.getI1();
	}
	
	@Override
	public void visit(Designator_VarProperty designator_VarProperty) {
		
		if (designator_VarProperty.getDesignatorVarPropertyName().obj == Tab.noObj) {
			designator_VarProperty.obj = Tab.noObj;
			return;
		}
		
		Obj obj = designator_VarProperty.getDesignatorVarPropertyName().obj;
		
		if (obj.getType().getKind() == Struct.Array && currentPropertySuffix.equals("length")) {
			designator_VarProperty.obj = new Obj(Obj.Elem, designator_VarProperty.getDesignatorVarPropertyName().getI1() + ".length", 
												Tab.intType);
			
		} else if (obj.getType().getKind() == Struct.Enum) {
			boolean validConst = false;
			for (Obj o : obj.getType().getMembers()) {
			    if (o.getName().equals(currentPropertySuffix)) {
					designator_VarProperty.obj = o;
					validConst = true;
					
					report_info("Pristup simbolickoj konstanti: " + o.getName() + " " + o, designator_VarProperty);
					break;
			    }
			}
			
			if (!validConst) {
				report_error("Tip enumeracije nema datu konstantu " +  currentPropertySuffix, designator_VarProperty);
				designator_VarProperty.obj = Tab.noObj;
			}

		} else {
			report_error("Neadekvatno svojstvo za datu promenljivu: " +  
		                 designator_VarProperty.getDesignatorVarPropertyName().getI1(), designator_VarProperty);
			designator_VarProperty.obj = Tab.noObj;
		}
	}
	
	// FactorNext
	
	@Override
	public void visit(Factor_Char factor_Char) {
		factor_Char.struct = Tab.charType;
	}
	
	@Override
	public void visit(Factor_Num factor_Num) {
		factor_Num.struct = Tab.intType;
	}
	
	@Override
	public void visit(Factor_Bool factor_Bool) {
		factor_Bool.struct = boolType;
	}
	
	@Override
	public void visit(Factor_Designator factor_Designator) {
		factor_Designator.struct = factor_Designator.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(Factor_NewTypeArray factor_NewTypeArray) {
		if (!factor_NewTypeArray.getExpr().struct.equals(Tab.intType) && factor_NewTypeArray.getExpr().struct.getKind() != Struct.Enum) {
			report_error("Neadekvatno indeksiranje prilikom kreiranja niza ", factor_NewTypeArray);
			factor_NewTypeArray.struct = Tab.noType;
		} else {
			factor_NewTypeArray.struct = new Struct(Struct.Array, currentType);
		}
	}
	
	@Override
	public void visit(Factor_ExprParen factor_ExprParen) {
		factor_ExprParen.struct = factor_ExprParen.getExpr().struct;
	}
	
	@Override
	public void visit(Factor_DesignatorCall factor_DesignatorCall) {
		int k = factor_DesignatorCall.getDesignator().obj.getKind();
		
		if (k != Obj.Meth) {
			report_error("Neadekvatna promenljiva za poziv funkcije: " + factor_DesignatorCall.getDesignator().obj.getName(), 
					factor_DesignatorCall);
			factor_DesignatorCall.struct = Tab.noType;
			
		} else {
			factor_DesignatorCall.struct = factor_DesignatorCall.getDesignator().obj.getType();
			

			List<Struct> fpList = new ArrayList<>();
			
			for (Obj local : factor_DesignatorCall.getDesignator().obj.getLocalSymbols()) {
				if (local.getKind() == Obj.Var && local.getLevel() == 1 && local.getFpPos() == 1) {
					fpList.add(local.getType());
				}
			}
			
			ActParsAnalyzer apc = new ActParsAnalyzer();
			factor_DesignatorCall.getActParsL().traverseBottomUp(apc);
			List <Struct> apList = apc.finalApList;
			
			try {
				if (fpList.size() != apList.size()) {
					throw new Exception("Err velicina");
				}
				
				for (int i = 0; i < fpList.size(); i++) {
					Struct fps = fpList.get(i);
					Struct aps = apList.get(i);
					
					if (!aps.assignableTo(fps) &&
						!(aps.getKind() == Struct.Enum && fps.getKind() == Struct.Int)	// enum -> int implicitno
						) {
						throw new Exception("Err tipovi");
					}
				}
				
			} catch (Exception e) {
				report_error(e.getMessage() + ": " + "Nekompatibilni parametri pri pozivu metode: " + factor_DesignatorCall.getDesignator().obj.getName(), 
						factor_DesignatorCall);
			}
				
			report_info("Poziv funkcije: " + factor_DesignatorCall.getDesignator().obj.getName() + " " + factor_DesignatorCall.getDesignator().obj, factor_DesignatorCall);
		}
	}
	
	// Factor
	
	@Override
	public void visit(Factor factor) {
		if (factor.getMinusOpt() instanceof MinusOpt_Minus) {
			if (factor.getFactorNext().struct.equals(Tab.intType)) {
				factor.struct = Tab.intType;
			} else {
				report_error("Negacija ne int vrednosti", factor);
				factor.struct = Tab.noType;
			}
		} 
		else {
			factor.struct = factor.getFactorNext().struct;
		}
	}
	
	// Expr
	
	@Override
	public void visit(MulopFactorL_Factor fulopFactorL_Factor) {
		fulopFactorL_Factor.struct = fulopFactorL_Factor.getFactor().struct;
	}
	
	@Override
	public void visit(MulopFactorL_MulopFactor mulopFactorL_MulopFactor) {
		Struct leftOpType = mulopFactorL_MulopFactor.getMulopFactorL().struct;
		Struct rightOpType = mulopFactorL_MulopFactor.getFactor().struct;
		
		if ((leftOpType.equals(Tab.intType) || leftOpType.getKind() == Struct.Enum) && 
				(rightOpType.equals(Tab.intType) || rightOpType.getKind() == Struct.Enum)
				) {
			mulopFactorL_MulopFactor.struct = Tab.intType;
		}  else {
			report_error("Mnozenje sa pogresnim tipom podataka.", mulopFactorL_MulopFactor);
			mulopFactorL_MulopFactor.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(Term term) {
		term.struct = term.getMulopFactorL().struct;
	}
	
	@Override
	public void visit(AddopTermL_Term addopTermL_Term) {
		addopTermL_Term.struct = addopTermL_Term.getTerm().struct;
	}
	
	@Override
	public void visit(AddopTermL_AddopTerm addopTermL_AddopTerm) {
		Struct leftOpType = addopTermL_AddopTerm.getAddopTermL().struct;
		Struct rightOpType = addopTermL_AddopTerm.getTerm().struct;
		
		if ((leftOpType.equals(Tab.intType) || leftOpType.getKind() == Struct.Enum) && 
			(rightOpType.equals(Tab.intType) || rightOpType.getKind() == Struct.Enum)
			) {
			addopTermL_AddopTerm.struct = Tab.intType;
		}  else {
			report_error("Sabiranje sa pogresnim tipom podataka.", addopTermL_AddopTerm);
			addopTermL_AddopTerm.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(NonTernaryExpr nonTernaryExpr) {
		nonTernaryExpr.struct = nonTernaryExpr.getAddopTermL().struct;
	}
	
	@Override
	public void visit(Expr_NonTernaryExpr expr_NonTernaryExpr) {
		expr_NonTernaryExpr.struct = expr_NonTernaryExpr.getNonTernaryExpr().struct;
	}
	
	@Override
	public void visit(TernaryExpr ternaryExpr) {
		if (!ternaryExpr.getExpr().struct.equals(ternaryExpr.getExpr1().struct)) {
			report_error("Povratni izrazi unutar ternarnog operatora moraju biti istog tipa", ternaryExpr);
			ternaryExpr.struct = Tab.noType;
		} else {
			ternaryExpr.struct = ternaryExpr.getExpr().struct;
		}
	}
	
	@Override
	public void visit(Expr_TernaryExpr expr_TernaryExpr) {
		expr_TernaryExpr.struct = expr_TernaryExpr.getTernaryExpr().struct;
	}
	
	// Designator statement
	
	@Override
	public void visit(DesignatorStatement_DesignatorAssignExpr dsignatorStatement_DesignatorAssignExpr) {
		int k = dsignatorStatement_DesignatorAssignExpr.getDesignator().obj.getKind();
		
		if (k != Obj.Var && k != Obj.Elem) {
			report_error("Neadekvatna promenljiva za dodelu: " + dsignatorStatement_DesignatorAssignExpr.getDesignator().obj.getName(), 
					dsignatorStatement_DesignatorAssignExpr);
			
		} else if (!dsignatorStatement_DesignatorAssignExpr.getExpr().struct
				   .assignableTo(dsignatorStatement_DesignatorAssignExpr.getDesignator().obj.getType())
				   &&
				   !(dsignatorStatement_DesignatorAssignExpr.getExpr().struct.getKind() == Struct.Enum &&  
				     dsignatorStatement_DesignatorAssignExpr.getDesignator().obj.getType().getKind() == Struct.Int) // enum -> int
				) {
			
			report_error("Neadekvatna dodela vrednosti: " + dsignatorStatement_DesignatorAssignExpr.getDesignator().obj.getName(), 
					dsignatorStatement_DesignatorAssignExpr);
		}
	}
	
	@Override
	public void visit(DesignatorStatement_Inc designatorStatement_Inc) {
		int k = designatorStatement_Inc.getDesignator().obj.getKind();
		
		if (k != Obj.Var && k != Obj.Elem) {
			report_error("Neadekvatna promenljiva za inkrementiranje: " + designatorStatement_Inc.getDesignator().obj.getName(), 
					designatorStatement_Inc);
			
		} else if (!designatorStatement_Inc.getDesignator().obj.getType().equals(Tab.intType)) {
			
			report_error("Inkrementiranje pogresnog tipa podataka: " + designatorStatement_Inc.getDesignator().obj.getName(), 
					designatorStatement_Inc);
		}
	}
	
	@Override
	public void visit(DesignatorStatement_Dec designatorStatement_Dec) {
		int k = designatorStatement_Dec.getDesignator().obj.getKind();
		
		if (k != Obj.Var && k != Obj.Elem) {
			report_error("Neadekvatna promenljiva za dekrementiranje: " + designatorStatement_Dec.getDesignator().obj.getName(), 
					designatorStatement_Dec);
			
		} else if (!designatorStatement_Dec.getDesignator().obj.getType().equals(Tab.intType)) {
			
			report_error("Dekrementiranje pogresnog tipa podataka: " + designatorStatement_Dec.getDesignator().obj.getName(), 
					designatorStatement_Dec);
		}
	}
	
	@Override
	public void visit(DesignatorStatement_ActParsOpt designatorStatement_ActParsOpt) {
		int k = designatorStatement_ActParsOpt.getDesignator().obj.getKind();
		
		if (k != Obj.Meth) {
			report_error("Neadekvatna promenljiva za poziv funkcije: " + designatorStatement_ActParsOpt.getDesignator().obj.getName(), 
					designatorStatement_ActParsOpt);
		} else {
			List<Struct> fpList = new ArrayList<>();
			
			for (Obj local : designatorStatement_ActParsOpt.getDesignator().obj.getLocalSymbols()) {
				if (local.getKind() == Obj.Var && local.getLevel() == 1 && local.getFpPos() == 1) {
					fpList.add(local.getType());
				}
			}
			
			ActParsAnalyzer apc = new ActParsAnalyzer();
			designatorStatement_ActParsOpt.getActParsL().traverseBottomUp(apc);
			List <Struct> apList = apc.finalApList;
			
			try {
				if (fpList.size() != apList.size()) {
					throw new Exception("Err velicina");
				}
				
				for (int i = 0; i < fpList.size(); i++) {
					Struct fps = fpList.get(i);
					Struct aps = apList.get(i);
					
					if (!aps.assignableTo(fps) &&
						!(aps.getKind() == Struct.Enum && fps.getKind() == Struct.Int)	// enum -> int implicitno
						) {
						throw new Exception("Err tipovi");
					}
				}
				
			} catch (Exception e) {
				report_error(e.getMessage() + ": " + "Nekompatibilni parametri pri pozivu metode: " + designatorStatement_ActParsOpt.getDesignator().obj.getName(), 
						designatorStatement_ActParsOpt);
			}
			
			report_info("Poziv funkcije: " + designatorStatement_ActParsOpt.getDesignator().obj.getName() + " " + designatorStatement_ActParsOpt.getDesignator().obj, designatorStatement_ActParsOpt);
		}
	}
	
	// Statement
	
	@Override
	public void visit(Statement_Read statement_Read) {
		int k = statement_Read.getDesignator().obj.getKind();
		
		if (k != Obj.Var && k != Obj.Elem) {
			report_error("Neadekvatna promenljiva za read: " + statement_Read.getDesignator().obj.getName(), 
					statement_Read);
			
		} else if (!statement_Read.getDesignator().obj.getType().equals(Tab.intType) 
				&& !statement_Read.getDesignator().obj.getType().equals(Tab.charType)
				&& !statement_Read.getDesignator().obj.getType().equals(boolType)
				) {
			
			report_error("read pogresnog tipa podataka: " + statement_Read.getDesignator().obj.getName(), 
					statement_Read);
		}
	}
	
	@Override
	public void visit(Statement_Print statement_Print) {
		Struct k = statement_Print.getExpr().struct;
		
		if (!k.equals(Tab.intType) 
				&& !k.equals(Tab.charType)
				&& !k.equals(boolType)
				&& !(k.getKind() == Struct.Enum)
				)  {
			report_error("Neadekvatan izraz za print", statement_Print);
		}
	}
	
	@Override
	public void visit(Statement_Return statement_Return) {
		returnHappened = true;
	}
	
	@Override
	public void visit(ExprOpt_Eps exprOpt_Eps) {
		if (currentMeth.getType() != Tab.noType) {
			report_error("Nevalidan return iskaz unutar metode: " + currentMeth.getName(), exprOpt_Eps);
		}
	}
	
	@Override
	public void visit(ExprOpt_Expr exprOpt_Expr) {
		if (!currentMeth.getType().equals(exprOpt_Expr.getExpr().struct)
			&&
			!(currentMeth.getType().getKind() == Struct.Int && exprOpt_Expr.getExpr().struct.getKind() == Struct.Enum)) {
			report_error("Nevalidan tip podatka za return iskaz unutar metode: " + currentMeth.getName(), exprOpt_Expr);
		}
	}
	
	@Override
	public void visit(For for_) {
		loopNestCnt++;
	}
	
	@Override
	public void visit(Statement_For statement_For) {
		loopNestCnt--;
	}
	
	@Override
	public void visit(Statement_Break statement_Break) {
		if (loopNestCnt == 0 && inSwitch.empty()) {
			report_error("Break naredba na pogresnom mestu.", statement_Break);
		}
	}
	
	@Override
	public void visit(Statement_Continue statement_Continue) {
		if (loopNestCnt == 0) {
			report_error("Continue naredba na pogresnom mestu.", statement_Continue);
		}
	}
	

	private Stack<Integer> switchStack = new Stack<Integer>();
	
	@Override
	public void visit(Switch switchSt) {
		inSwitch.push(1);
		caseValues.push(new HashSet<>());
		switchStack.push(0);
	}
	
	@Override
	public void visit(SwitchCase_Case switchCase_Case) {
		switchStack.push(switchStack.pop() + 1);
		
		int value = switchCase_Case.getSwitchNumConst().getN1();
		
		if (!caseValues.peek().add(value)) {
		    report_error("Duplikat konstante unutar case-a.: " + value, switchCase_Case);
		}
	}
	
	@Override
	public void visit(Statement_Switch statement_Switch) {
		inSwitch.pop();
		caseValues.pop();
		
		numOfSwitchCases.add(switchStack.pop());
		
		if (!statement_Switch.getExpr().struct.equals(Tab.intType)) {
			report_error("Izraz za switch mora biti int tipa.", statement_Switch);
		}
	}
	
	// Condition
	
	@Override
	public void visit(CondFact_NonTernaryExpr condFact_NonTernaryExpr) {
		if (!condFact_NonTernaryExpr.getNonTernaryExpr().struct.equals(boolType)) {
			report_error("Uslov mora biti bool tipa.", condFact_NonTernaryExpr);
			condFact_NonTernaryExpr.struct = Tab.noType;
		} else {
			condFact_NonTernaryExpr.struct = boolType;
		}
	}
	
	@Override
	public void visit(CondFact_NonTernaryExprRelopNonTernaryExpr condFact_NonTernaryExprRelopNonTernaryExpr) {
		Struct l = condFact_NonTernaryExprRelopNonTernaryExpr.getNonTernaryExpr().struct;
		Struct r = condFact_NonTernaryExprRelopNonTernaryExpr.getNonTernaryExpr1().struct;
		
		if (l.compatibleWith(r) 
		   || (l.getKind() == Struct.Enum && r.getKind() == Struct.Int) // enum i int mogu da se porede
		   || (r.getKind() == Struct.Enum && l.getKind() == Struct.Int) ) {
			if (l.isRefType() || r.isRefType()) {
				if (condFact_NonTernaryExprRelopNonTernaryExpr.getRelop() instanceof Relop_Eq ||
					condFact_NonTernaryExprRelopNonTernaryExpr.getRelop() instanceof Relop_Neq
					) {
					condFact_NonTernaryExprRelopNonTernaryExpr.struct = boolType;
				} else {
					report_error("Ref operandi se ne porede korektno.", condFact_NonTernaryExprRelopNonTernaryExpr);
					condFact_NonTernaryExprRelopNonTernaryExpr.struct = Tab.noType;
				}
			} else {
				condFact_NonTernaryExprRelopNonTernaryExpr.struct = boolType;
			}
		} else {
			report_error("Operandi nisu kompatibilni za poredjenje.", condFact_NonTernaryExprRelopNonTernaryExpr);
			condFact_NonTernaryExprRelopNonTernaryExpr.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(CondFactNext_CondFact condFactNext_CondFact) {
		condFactNext_CondFact.struct = condFactNext_CondFact.getCondFact().struct;
	}
	
	@Override
	public void visit(CondFactNext_And condFactNext_And) {
		Struct leftOpType = condFactNext_And.getCondFactL().struct;
		Struct rightOpType = condFactNext_And.getCondFact().struct;
		
		if (leftOpType.equals(boolType) && rightOpType.equals(boolType)) {
			condFactNext_And.struct = boolType;
		}  else {
			report_error("Operacije && sa pogresnim tipom podataka.", condFactNext_And);
			condFactNext_And.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(CondTerm condTerm) {
		condTerm.struct = condTerm.getCondFactL().struct;
	}
	
	@Override
	public void visit(CondTermOr_CondTerm condTermOr_CondTerm) {
		condTermOr_CondTerm.struct = condTermOr_CondTerm.getCondTerm().struct;
	}
	
	@Override
	public void visit(CondTermOr_Or condTermOr_Or) {
		Struct leftOpType = condTermOr_Or.getCondTermL().struct;
		Struct rightOpType = condTermOr_Or.getCondTerm().struct;
		
		if (leftOpType.equals(boolType) && rightOpType.equals(boolType)) {
			condTermOr_Or.struct = boolType;
		}  else {
			report_error("Operacije || sa pogresnim tipom podataka.", condTermOr_Or);
			condTermOr_Or.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(Condition condition) {
		condition.struct = condition.getCondTermL().struct;
		
		if (!condition.struct.equals(boolType)) {
			report_error("Uslov mora biti bool tipa.", condition);
		}
	}
}
