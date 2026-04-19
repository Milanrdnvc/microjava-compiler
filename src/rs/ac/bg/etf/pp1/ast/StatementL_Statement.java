// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class StatementL_Statement extends StatementL {

    private Statement Statement;
    private StatementL StatementL;

    public StatementL_Statement (Statement Statement, StatementL StatementL) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.StatementL=StatementL;
        if(StatementL!=null) StatementL.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
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
        if(Statement!=null) Statement.accept(visitor);
        if(StatementL!=null) StatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(StatementL!=null) StatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(StatementL!=null) StatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementL_Statement(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementL!=null)
            buffer.append(StatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementL_Statement]");
        return buffer.toString();
    }
}
