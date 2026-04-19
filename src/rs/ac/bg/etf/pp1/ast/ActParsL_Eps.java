// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class ActParsL_Eps extends ActParsL {

    private ActParListStart ActParListStart;

    public ActParsL_Eps (ActParListStart ActParListStart) {
        this.ActParListStart=ActParListStart;
        if(ActParListStart!=null) ActParListStart.setParent(this);
    }

    public ActParListStart getActParListStart() {
        return ActParListStart;
    }

    public void setActParListStart(ActParListStart ActParListStart) {
        this.ActParListStart=ActParListStart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParListStart!=null) ActParListStart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParListStart!=null) ActParListStart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParListStart!=null) ActParListStart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsL_Eps(\n");

        if(ActParListStart!=null)
            buffer.append(ActParListStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsL_Eps]");
        return buffer.toString();
    }
}
