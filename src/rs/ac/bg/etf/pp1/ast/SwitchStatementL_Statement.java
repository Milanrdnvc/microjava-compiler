// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class SwitchStatementL_Statement extends SwitchStatementL {

    private Statement Statement;
    private SwitchStatementL SwitchStatementL;

    public SwitchStatementL_Statement (Statement Statement, SwitchStatementL SwitchStatementL) {
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.SwitchStatementL=SwitchStatementL;
        if(SwitchStatementL!=null) SwitchStatementL.setParent(this);
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public SwitchStatementL getSwitchStatementL() {
        return SwitchStatementL;
    }

    public void setSwitchStatementL(SwitchStatementL SwitchStatementL) {
        this.SwitchStatementL=SwitchStatementL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Statement!=null) Statement.accept(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchStatementL_Statement(\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchStatementL!=null)
            buffer.append(SwitchStatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchStatementL_Statement]");
        return buffer.toString();
    }
}
