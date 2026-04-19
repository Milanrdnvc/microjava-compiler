// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Designator_VarProperty extends Designator {

    private DesignatorVarPropertyName DesignatorVarPropertyName;
    private DesignatorPropertySuffix DesignatorPropertySuffix;

    public Designator_VarProperty (DesignatorVarPropertyName DesignatorVarPropertyName, DesignatorPropertySuffix DesignatorPropertySuffix) {
        this.DesignatorVarPropertyName=DesignatorVarPropertyName;
        if(DesignatorVarPropertyName!=null) DesignatorVarPropertyName.setParent(this);
        this.DesignatorPropertySuffix=DesignatorPropertySuffix;
        if(DesignatorPropertySuffix!=null) DesignatorPropertySuffix.setParent(this);
    }

    public DesignatorVarPropertyName getDesignatorVarPropertyName() {
        return DesignatorVarPropertyName;
    }

    public void setDesignatorVarPropertyName(DesignatorVarPropertyName DesignatorVarPropertyName) {
        this.DesignatorVarPropertyName=DesignatorVarPropertyName;
    }

    public DesignatorPropertySuffix getDesignatorPropertySuffix() {
        return DesignatorPropertySuffix;
    }

    public void setDesignatorPropertySuffix(DesignatorPropertySuffix DesignatorPropertySuffix) {
        this.DesignatorPropertySuffix=DesignatorPropertySuffix;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorVarPropertyName!=null) DesignatorVarPropertyName.accept(visitor);
        if(DesignatorPropertySuffix!=null) DesignatorPropertySuffix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorVarPropertyName!=null) DesignatorVarPropertyName.traverseTopDown(visitor);
        if(DesignatorPropertySuffix!=null) DesignatorPropertySuffix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorVarPropertyName!=null) DesignatorVarPropertyName.traverseBottomUp(visitor);
        if(DesignatorPropertySuffix!=null) DesignatorPropertySuffix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator_VarProperty(\n");

        if(DesignatorVarPropertyName!=null)
            buffer.append(DesignatorVarPropertyName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorPropertySuffix!=null)
            buffer.append(DesignatorPropertySuffix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator_VarProperty]");
        return buffer.toString();
    }
}
