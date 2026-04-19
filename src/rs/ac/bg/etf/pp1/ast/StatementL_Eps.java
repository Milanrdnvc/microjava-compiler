// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class StatementL_Eps extends StatementL {

    public StatementL_Eps () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementL_Eps(\n");

        buffer.append(tab);
        buffer.append(") [StatementL_Eps]");
        return buffer.toString();
    }
}
