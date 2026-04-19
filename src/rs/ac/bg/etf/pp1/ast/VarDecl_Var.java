// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class VarDecl_Var extends VarDecl {

    private Type Type;
    private VarDeclFirst VarDeclFirst;
    private VarDeclNext VarDeclNext;

    public VarDecl_Var (Type Type, VarDeclFirst VarDeclFirst, VarDeclNext VarDeclNext) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclFirst=VarDeclFirst;
        if(VarDeclFirst!=null) VarDeclFirst.setParent(this);
        this.VarDeclNext=VarDeclNext;
        if(VarDeclNext!=null) VarDeclNext.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclFirst getVarDeclFirst() {
        return VarDeclFirst;
    }

    public void setVarDeclFirst(VarDeclFirst VarDeclFirst) {
        this.VarDeclFirst=VarDeclFirst;
    }

    public VarDeclNext getVarDeclNext() {
        return VarDeclNext;
    }

    public void setVarDeclNext(VarDeclNext VarDeclNext) {
        this.VarDeclNext=VarDeclNext;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclFirst!=null) VarDeclFirst.accept(visitor);
        if(VarDeclNext!=null) VarDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclFirst!=null) VarDeclFirst.traverseTopDown(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclFirst!=null) VarDeclFirst.traverseBottomUp(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl_Var(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclFirst!=null)
            buffer.append(VarDeclFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNext!=null)
            buffer.append(VarDeclNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl_Var]");
        return buffer.toString();
    }
}
