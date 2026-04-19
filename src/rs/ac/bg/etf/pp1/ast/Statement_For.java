// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Statement_For extends Statement {

    private For For;
    private ForDesignatorStatementOptFirst ForDesignatorStatementOptFirst;
    private FirstSemicolonFor FirstSemicolonFor;
    private ConditionOpt ConditionOpt;
    private SecondSemicolonFor SecondSemicolonFor;
    private ForDesignatorStatementOptSecond ForDesignatorStatementOptSecond;
    private RparenFor RparenFor;
    private Statement Statement;

    public Statement_For (For For, ForDesignatorStatementOptFirst ForDesignatorStatementOptFirst, FirstSemicolonFor FirstSemicolonFor, ConditionOpt ConditionOpt, SecondSemicolonFor SecondSemicolonFor, ForDesignatorStatementOptSecond ForDesignatorStatementOptSecond, RparenFor RparenFor, Statement Statement) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForDesignatorStatementOptFirst=ForDesignatorStatementOptFirst;
        if(ForDesignatorStatementOptFirst!=null) ForDesignatorStatementOptFirst.setParent(this);
        this.FirstSemicolonFor=FirstSemicolonFor;
        if(FirstSemicolonFor!=null) FirstSemicolonFor.setParent(this);
        this.ConditionOpt=ConditionOpt;
        if(ConditionOpt!=null) ConditionOpt.setParent(this);
        this.SecondSemicolonFor=SecondSemicolonFor;
        if(SecondSemicolonFor!=null) SecondSemicolonFor.setParent(this);
        this.ForDesignatorStatementOptSecond=ForDesignatorStatementOptSecond;
        if(ForDesignatorStatementOptSecond!=null) ForDesignatorStatementOptSecond.setParent(this);
        this.RparenFor=RparenFor;
        if(RparenFor!=null) RparenFor.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public ForDesignatorStatementOptFirst getForDesignatorStatementOptFirst() {
        return ForDesignatorStatementOptFirst;
    }

    public void setForDesignatorStatementOptFirst(ForDesignatorStatementOptFirst ForDesignatorStatementOptFirst) {
        this.ForDesignatorStatementOptFirst=ForDesignatorStatementOptFirst;
    }

    public FirstSemicolonFor getFirstSemicolonFor() {
        return FirstSemicolonFor;
    }

    public void setFirstSemicolonFor(FirstSemicolonFor FirstSemicolonFor) {
        this.FirstSemicolonFor=FirstSemicolonFor;
    }

    public ConditionOpt getConditionOpt() {
        return ConditionOpt;
    }

    public void setConditionOpt(ConditionOpt ConditionOpt) {
        this.ConditionOpt=ConditionOpt;
    }

    public SecondSemicolonFor getSecondSemicolonFor() {
        return SecondSemicolonFor;
    }

    public void setSecondSemicolonFor(SecondSemicolonFor SecondSemicolonFor) {
        this.SecondSemicolonFor=SecondSemicolonFor;
    }

    public ForDesignatorStatementOptSecond getForDesignatorStatementOptSecond() {
        return ForDesignatorStatementOptSecond;
    }

    public void setForDesignatorStatementOptSecond(ForDesignatorStatementOptSecond ForDesignatorStatementOptSecond) {
        this.ForDesignatorStatementOptSecond=ForDesignatorStatementOptSecond;
    }

    public RparenFor getRparenFor() {
        return RparenFor;
    }

    public void setRparenFor(RparenFor RparenFor) {
        this.RparenFor=RparenFor;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(For!=null) For.accept(visitor);
        if(ForDesignatorStatementOptFirst!=null) ForDesignatorStatementOptFirst.accept(visitor);
        if(FirstSemicolonFor!=null) FirstSemicolonFor.accept(visitor);
        if(ConditionOpt!=null) ConditionOpt.accept(visitor);
        if(SecondSemicolonFor!=null) SecondSemicolonFor.accept(visitor);
        if(ForDesignatorStatementOptSecond!=null) ForDesignatorStatementOptSecond.accept(visitor);
        if(RparenFor!=null) RparenFor.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForDesignatorStatementOptFirst!=null) ForDesignatorStatementOptFirst.traverseTopDown(visitor);
        if(FirstSemicolonFor!=null) FirstSemicolonFor.traverseTopDown(visitor);
        if(ConditionOpt!=null) ConditionOpt.traverseTopDown(visitor);
        if(SecondSemicolonFor!=null) SecondSemicolonFor.traverseTopDown(visitor);
        if(ForDesignatorStatementOptSecond!=null) ForDesignatorStatementOptSecond.traverseTopDown(visitor);
        if(RparenFor!=null) RparenFor.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForDesignatorStatementOptFirst!=null) ForDesignatorStatementOptFirst.traverseBottomUp(visitor);
        if(FirstSemicolonFor!=null) FirstSemicolonFor.traverseBottomUp(visitor);
        if(ConditionOpt!=null) ConditionOpt.traverseBottomUp(visitor);
        if(SecondSemicolonFor!=null) SecondSemicolonFor.traverseBottomUp(visitor);
        if(ForDesignatorStatementOptSecond!=null) ForDesignatorStatementOptSecond.traverseBottomUp(visitor);
        if(RparenFor!=null) RparenFor.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_For(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForDesignatorStatementOptFirst!=null)
            buffer.append(ForDesignatorStatementOptFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstSemicolonFor!=null)
            buffer.append(FirstSemicolonFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionOpt!=null)
            buffer.append(ConditionOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SecondSemicolonFor!=null)
            buffer.append(SecondSemicolonFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForDesignatorStatementOptSecond!=null)
            buffer.append(ForDesignatorStatementOptSecond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RparenFor!=null)
            buffer.append(RparenFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_For]");
        return buffer.toString();
    }
}
