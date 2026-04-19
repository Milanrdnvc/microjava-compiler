// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Statement_StatementL extends Statement {

    private StatementL StatementL;

    public Statement_StatementL (StatementL StatementL) {
        this.StatementL=StatementL;
        if(StatementL!=null) StatementL.setParent(this);
    }

    public StatementL getStatementL() {
        return StatementL;
    }

    public void setStatementL(StatementL StatementL) {
        this.StatementL=StatementL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementL!=null) StatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementL!=null) StatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementL!=null) StatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_StatementL(\n");

        if(StatementL!=null)
            buffer.append(StatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_StatementL]");
        return buffer.toString();
    }
}
