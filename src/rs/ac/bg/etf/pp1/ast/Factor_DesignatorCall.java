// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Factor_DesignatorCall extends FactorNext {

    private Designator Designator;
    private ActParsL ActParsL;

    public Factor_DesignatorCall (Designator Designator, ActParsL ActParsL) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsL=ActParsL;
        if(ActParsL!=null) ActParsL.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsL getActParsL() {
        return ActParsL;
    }

    public void setActParsL(ActParsL ActParsL) {
        this.ActParsL=ActParsL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsL!=null) ActParsL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsL!=null) ActParsL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsL!=null) ActParsL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor_DesignatorCall(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsL!=null)
            buffer.append(ActParsL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor_DesignatorCall]");
        return buffer.toString();
    }
}
