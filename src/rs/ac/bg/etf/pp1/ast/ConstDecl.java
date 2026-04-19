// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstDeclFirst ConstDeclFirst;
    private ConstDeclNext ConstDeclNext;

    public ConstDecl (Type Type, ConstDeclFirst ConstDeclFirst, ConstDeclNext ConstDeclNext) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDeclFirst=ConstDeclFirst;
        if(ConstDeclFirst!=null) ConstDeclFirst.setParent(this);
        this.ConstDeclNext=ConstDeclNext;
        if(ConstDeclNext!=null) ConstDeclNext.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstDeclFirst getConstDeclFirst() {
        return ConstDeclFirst;
    }

    public void setConstDeclFirst(ConstDeclFirst ConstDeclFirst) {
        this.ConstDeclFirst=ConstDeclFirst;
    }

    public ConstDeclNext getConstDeclNext() {
        return ConstDeclNext;
    }

    public void setConstDeclNext(ConstDeclNext ConstDeclNext) {
        this.ConstDeclNext=ConstDeclNext;
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
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclFirst!=null) ConstDeclFirst.accept(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclFirst!=null) ConstDeclFirst.traverseTopDown(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclFirst!=null) ConstDeclFirst.traverseBottomUp(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclFirst!=null)
            buffer.append(ConstDeclFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNext!=null)
            buffer.append(ConstDeclNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
