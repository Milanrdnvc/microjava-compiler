package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPC;
	
	CodeGenerator() {
		this.initializePredeclaredMethods();
	}
	
	private void initializePredeclaredMethods() {
        Obj ordMethod = Tab.find("ord");
        Obj chrMethod = Tab.find("chr");
        ordMethod.setAdr(Code.pc);
        chrMethod.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.exit);
        Code.put(Code.return_);
 
        Obj lenMethod = Tab.find("len");
        lenMethod.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(1);
        Code.put(1);
        Code.put(Code.load_n);
        Code.put(Code.arraylength);
        Code.put(Code.exit);
        Code.put(Code.return_);
 
    }
	
	public int getMainPc() {
		return this.mainPC;
	}
	
	// Methods
	
	@Override
	public void visit(MethodName methodName) {
		methodName.obj.setAdr(Code.pc);
		
		if (methodName.getI1().equals("main")) this.mainPC = Code.pc;
		
		Code.put(Code.enter);
		Code.put(methodName.obj.getLevel()); // b1
		Code.put(methodName.obj.getLocalSymbols().size()); // b1
	}
	
	@Override
	public void visit(MethodDecl_Decl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	// Designator statement
	
	@Override
	public void visit(DesignatorStatement_DesignatorAssignExpr designatorStatement_DesignatorAssignExpr) {
		Code.store(designatorStatement_DesignatorAssignExpr.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_Inc designatorStatement_Inc) {
		if (designatorStatement_Inc.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorStatement_Inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorStatement_Inc.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_Dec designatorStatement_Dec) {
		if (designatorStatement_Dec.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorStatement_Dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorStatement_Dec.getDesignator().obj);
	}
	
	@Override
	public void visit(DesignatorStatement_ActParsOpt designatorStatement_ActParsOpt) {
		int offset = designatorStatement_ActParsOpt.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		
		if (designatorStatement_ActParsOpt.getDesignator().obj.getType() != Tab.noType) {
			Code.put(Code.pop);
		}
	}
	
	// Statement
	
	@Override
	public void visit(Statement_Print statement_Print) {
		if (statement_Print.getExpr().struct.equals(Tab.charType)) {
			Code.put(Code.bprint);
		} else 
			Code.put(Code.print);
	}
	
	@Override
	public void visit(NumConstOpt_NumConst numConstOpt_NumConst) {
		Code.loadConst(numConstOpt_NumConst.getN1());
	}
	
	@Override
	public void visit(NumConstOpt_Eps numConstOpt_Eps) {
		Code.loadConst(0);
	}
	
	@Override
	public void visit(Statement_Return statement_Return) {
		if (!inWhat.empty() && inWhat.peek() == "switch") {
			Code.put(Code.pop);
		}
		
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	@Override
	public void visit(Statement_Read statement_Read) {
		if (statement_Read.getDesignator().obj.getType().equals(Tab.charType)) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		
		Code.store(statement_Read.getDesignator().obj);
	}
	
	
	// Expr
	
	@Override
	public void visit(AddopTermL_AddopTerm addopTermL_AddopTerm) {
		if (addopTermL_AddopTerm.getAddop() instanceof Addop_Plus) {
			Code.put(Code.add);
		} else if (addopTermL_AddopTerm.getAddop() instanceof Addop_Minus) {
			Code.put(Code.sub);
		}
	}
	
	@Override
	public void visit(MulopFactorL_MulopFactor mulopFactorL_MulopFactor) {
		if (mulopFactorL_MulopFactor.getMulop() instanceof Mulop_Mul) {
			Code.put(Code.mul);
		} else if (mulopFactorL_MulopFactor.getMulop() instanceof Mulop_Div) {
			Code.put(Code.div);
		} else if (mulopFactorL_MulopFactor.getMulop() instanceof Mulop_Mod) {
			Code.put(Code.rem);
		}
	}
	
	@Override
	public void visit(Factor factor) {
		if (factor.getMinusOpt() instanceof MinusOpt_Minus) {
			Code.put(Code.neg);
		}
	}
	
	// Factor
	
	@Override
	public void visit(Factor_Num factor_Num) {
		Code.loadConst(factor_Num.getN1());
	}
	
	@Override
	public void visit(Factor_Char factor_Char) {
		Code.loadConst(factor_Char.getC1());
	}
	
	@Override
	public void visit(Factor_Bool factor_Bool) {
		Code.loadConst(factor_Bool.getB1());
	}
	
	
	@Override
	public void visit(Factor_Designator factor_Designator) {
		if ((factor_Designator.getDesignator().obj.getType().getKind() != Struct.Enum // MyType.CONST not ok and array.length not ok
			&& factor_Designator.getDesignator().obj.getKind() != Obj.Elem)
			
			||
			
			(factor_Designator.getDesignator().obj.getKind() == Obj.Elem             // x[5] ok, x.length not ok
			&& !factor_Designator.getDesignator().obj.getName().contains("length"))
			
			||
			(factor_Designator.getDesignator().obj.getType().getKind() == Struct.Enum // if enum const is inside a var ok
			&& factor_Designator.getDesignator().obj.getKind() == Obj.Var
			)
			)
			Code.load(factor_Designator.getDesignator().obj);
	}
	
	@Override
	public void visit(Factor_NewTypeArray factor_NewTypeArray) {
		Code.put(Code.newarray);
		if (factor_NewTypeArray.getType().struct.equals(Tab.charType)) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}
	
	@Override
	public void visit(Factor_DesignatorCall factor_DesignatorCall) {
		int offset = factor_DesignatorCall.getDesignator().obj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	// Designator
	
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Code.load(designatorArrayName.obj);
	}
	
	@Override
	public void visit(Designator_VarProperty designator_VarProperty) {
		if (designator_VarProperty.obj.getKind() == Obj.Elem) {
			Code.put(Code.arraylength);
		} else {
			System.out.println("test");
			Code.loadConst(designator_VarProperty.obj.getAdr());
		}	
	}
	
	@Override
	public void visit(DesignatorVarPropertyName designatorVarPropertyName) {
		if (designatorVarPropertyName.obj.getType().getKind() == Struct.Array) {
			Code.load(designatorVarPropertyName.obj);
		}
	}
	
	// Condition
	
	private int intReturnRelop(Relop relop) {
		if (relop instanceof Relop_Eq) {
			return Code.eq;
		} else if (relop instanceof Relop_Neq) {
			return Code.ne;
		} else if (relop instanceof Relop_Gt) {
			return Code.gt;
		} else if (relop instanceof Relop_Geq) {
			return Code.ge;
		} else if (relop instanceof Relop_Lt) {
			return Code.lt;
		} else if (relop instanceof Relop_Leq) {
			return Code.le;
		}
		return 0;

	}
	
	private Stack<Integer> skipCondFact = new Stack<>();
	private Stack<Integer> skipCondition = new Stack<>();
	private Stack<Integer> skipThen = new Stack<>();
	private Stack<Integer> skipElse = new Stack<>();
	
	@Override
	public void visit(CondFact_NonTernaryExpr condFact_NonTernaryExpr) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0); // exprStack[top] !(ne) 0 => jmp
		skipCondFact.push(Code.pc - 2);
	}
	
	
	@Override
	public void visit(CondFact_NonTernaryExprRelopNonTernaryExpr condFact_NonTernaryExprRelopNonTernaryExpr) {
		Code.putFalseJump(intReturnRelop(condFact_NonTernaryExprRelopNonTernaryExpr.getRelop()), 0); // expStack[top] !relOp expStack[top - 1] => jmp
		skipCondFact.push(Code.pc - 2);
	}
	
	@Override
	public void visit(CondTerm condTerm) {
		Code.putJump(0); // jmp to THEN
		skipCondition.push(Code.pc - 2);
		while (!skipCondFact.empty()) {
			Code.fixup(skipCondFact.pop());
		}
	}
	
	@Override
	public void visit(Condition condition) {
		Code.putJump(0); // jmp to ELSE
		skipThen.push(Code.pc - 2);
		while (!skipCondition.empty()) {
			Code.fixup(skipCondition.pop());
		}
	}
	
	@Override
	public void visit(ElseStatement_Eps elseStatement_Eps) {
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(Else else_) {
		Code.putJump(0);
		skipElse.push(Code.pc - 2);
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(ElseStatement_Else elseStatement_Else) {
		Code.fixup(skipElse.pop());
	} 
	
	
	private Stack<List<Integer>> breakOut = new Stack<>();
	private Stack<Integer> continueOut = new Stack<>();
	
	private Stack<String> inWhat = new Stack<>();
	
	// for
	
	private Stack<Integer> forStart = new Stack<>();
	private Stack<Integer> condStartPc = new Stack<>();
	private Stack<Integer> updateDesignatorStartPc = new Stack<>();
	boolean emptyCond = false;
	
	@Override
	public void visit(For for_) {
		inWhat.push("for");
		breakOut.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(ConditionOpt_Eps conditionOpt_Eps) {
		emptyCond = true;
	}
	
	@Override
	public void visit(ForDesignatorStatementOptSecond_DesignatorStatement forDesignatorStatementOptSecond_DesignatorStatement) {
		Code.putJump(condStartPc.pop());
	}
	
	@Override
	public void visit(FirstSemicolonFor firstSemicolonFor) {
		condStartPc.push(Code.pc);
	}
	
	@Override
	public void visit(SecondSemicolonFor secondSemicolonFor) {
		Code.putJump(0);
		forStart.push(Code.pc - 2);
		
		updateDesignatorStartPc.push(Code.pc);
		continueOut.push(Code.pc);
	}
	
	@Override
	public void visit(RparenFor rparenFor) {
		Code.fixup(forStart.pop());
	}
	
	@Override
	public void visit(Statement_For statement_For) {
		Code.putJump(updateDesignatorStartPc.pop());
		
		for (int i = 0; i < breakOut.peek().size(); i++) {
			Code.fixup(breakOut.peek().get(i));
		}
		
		breakOut.pop();
		
		if (!emptyCond) {
			Code.fixup(skipThen.pop());
		}
		
		inWhat.pop();
		continueOut.pop();
	}
	
	// switch
	
	private int numConst;
	private Stack<ArrayList<Integer>> skipCase = new Stack<ArrayList<Integer>>();
	private int skipNextCaseCond;
	private Stack<Integer> caseNumber = new Stack<>();
	
	@Override
	public void visit(Switch switch_) {
		inWhat.push("switch");
		breakOut.push(new ArrayList<Integer>());
		caseNumber.push(0);
		skipCase.push(new ArrayList<Integer>());
	}
	
	@Override
	public void visit(SwitchNumConst switchNumConst) {
		numConst = switchNumConst.getN1();
	}
	
	@Override
	public void visit(SwitchCaseColon switchCaseColon) {
		Code.put(Code.dup);
		Code.loadConst(numConst);
		Code.putFalseJump(Code.eq, 0);
		skipCase.peek().add(0, Code.pc - 2);
		
		caseNumber.push(caseNumber.pop() + 1);
		if (caseNumber.peek() > 1) {
			Code.fixup(skipNextCaseCond);
		}
		
	}
	
	@Override
	public void visit(SwitchStatementL_Eps switchStatementL_Eps) {
		if (caseNumber.peek() < SemanticAnalyzer.numOfSwitchCases.get(0)) {
			Code.putJump(0);
			skipNextCaseCond = Code.pc - 2;
		} else {
			
		}
		
		Code.fixup(skipCase.peek().get(0));
	}
	
	@Override
	public void visit(Statement_Switch statement_Switch) {
		for (int i = 0; i < breakOut.peek().size(); i++) {
			Code.fixup(breakOut.peek().get(i));
		}
		breakOut.pop();
		
		Code.put(Code.pop);
		
		inWhat.pop();
		
		SemanticAnalyzer.numOfSwitchCases.remove(0);
		caseNumber.pop();
		skipCase.pop();
	}
	
	// ternary
	
	private Stack<Integer> ternarySkipElse = new Stack<>();
	
	@Override
	public void visit(ColonTernary colonTernary) {
		Code.putJump(0);
		ternarySkipElse.push(Code.pc - 2);
		
		Code.fixup(skipThen.pop());
	}
	
	@Override
	public void visit(TernaryExpr ternaryExpr) {
		Code.fixup(ternarySkipElse.pop());
	}
	
	// break
	@Override
	public void visit(Statement_Break statement_Break) {
		Code.putJump(0);
		breakOut.peek().add(Code.pc - 2);
	}
	
	public void visit(Statement_Continue statement_Continue) {
		if (!inWhat.empty() && inWhat.peek().equals("switch")) {
			Code.put(Code.pop);
		}
		
		Code.putJump(continueOut.peek());
	}
}
