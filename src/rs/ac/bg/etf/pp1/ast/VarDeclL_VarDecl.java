// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class VarDeclL_VarDecl extends VarDeclL {

    private VarDecl VarDecl;
    private VarDeclL VarDeclL;

    public VarDeclL_VarDecl (VarDecl VarDecl, VarDeclL VarDeclL) {
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.VarDeclL=VarDeclL;
        if(VarDeclL!=null) VarDeclL.setParent(this);
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public VarDeclL getVarDeclL() {
        return VarDeclL;
    }

    public void setVarDeclL(VarDeclL VarDeclL) {
        this.VarDeclL=VarDeclL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(VarDeclL!=null) VarDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(VarDeclL!=null) VarDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(VarDeclL!=null) VarDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclL_VarDecl(\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclL!=null)
            buffer.append(VarDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclL_VarDecl]");
        return buffer.toString();
    }
}
