// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramName ProgramName;
    private ConstVarEnumDecl ConstVarEnumDecl;
    private MethodDeclL MethodDeclL;

    public Program (ProgramName ProgramName, ConstVarEnumDecl ConstVarEnumDecl, MethodDeclL MethodDeclL) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.ConstVarEnumDecl=ConstVarEnumDecl;
        if(ConstVarEnumDecl!=null) ConstVarEnumDecl.setParent(this);
        this.MethodDeclL=MethodDeclL;
        if(MethodDeclL!=null) MethodDeclL.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public ConstVarEnumDecl getConstVarEnumDecl() {
        return ConstVarEnumDecl;
    }

    public void setConstVarEnumDecl(ConstVarEnumDecl ConstVarEnumDecl) {
        this.ConstVarEnumDecl=ConstVarEnumDecl;
    }

    public MethodDeclL getMethodDeclL() {
        return MethodDeclL;
    }

    public void setMethodDeclL(MethodDeclL MethodDeclL) {
        this.MethodDeclL=MethodDeclL;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(ConstVarEnumDecl!=null) ConstVarEnumDecl.accept(visitor);
        if(MethodDeclL!=null) MethodDeclL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(ConstVarEnumDecl!=null) ConstVarEnumDecl.traverseTopDown(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(ConstVarEnumDecl!=null) ConstVarEnumDecl.traverseBottomUp(visitor);
        if(MethodDeclL!=null) MethodDeclL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstVarEnumDecl!=null)
            buffer.append(ConstVarEnumDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclL!=null)
            buffer.append(MethodDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
