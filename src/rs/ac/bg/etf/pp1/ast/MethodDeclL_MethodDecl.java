// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclL_MethodDecl extends MethodDeclL {

    private MethodDecl MethodDecl;
    private MethodDeclL MethodDeclL;

    public MethodDeclL_MethodDecl (MethodDecl MethodDecl, MethodDeclL MethodDeclL) {
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.MethodDeclL=MethodDeclL;
        if(MethodDeclL!=null) MethodDeclL.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public MethodDeclL getMethodDeclL() {
        return MethodDeclL;
    }

    public void setMethodDeclL(MethodDeclL MethodDeclL) {
        this.MethodDeclL=MethodDeclL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(MethodDeclL!=null) MethodDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclL_MethodDecl(\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclL!=null)
            buffer.append(MethodDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclL_MethodDecl]");
        return buffer.toString();
    }
}
