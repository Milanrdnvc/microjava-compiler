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

public class ActParsAnalyzer extends VisitorAdaptor {
	List <Struct> finalApList = new ArrayList<>();
	
	
	Stack<List<Struct>> actParLists = new Stack<>();
	
	@Override
	public void visit(ActParListStart actParListStart) {
		actParLists.push(new ArrayList<>());
	}
	
	@Override
	public void visit(ActPar actPar) {
		actParLists.peek().add(actPar.getExpr().struct);
	}
	
	@Override
	public void visit(ActParsL_ActPars actParsL_ActPars) {
		finalApList = actParLists.pop();
	}
	
	@Override
	public void visit(ActParsL_Eps actParsL_Eps) {
		finalApList = actParLists.pop();
	}
	
}
