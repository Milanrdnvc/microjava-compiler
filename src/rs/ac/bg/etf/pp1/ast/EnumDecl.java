// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class EnumDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private EnumName EnumName;
    private EnumDeclFirst EnumDeclFirst;
    private EnumDeclNext EnumDeclNext;

    public EnumDecl (EnumName EnumName, EnumDeclFirst EnumDeclFirst, EnumDeclNext EnumDeclNext) {
        this.EnumName=EnumName;
        if(EnumName!=null) EnumName.setParent(this);
        this.EnumDeclFirst=EnumDeclFirst;
        if(EnumDeclFirst!=null) EnumDeclFirst.setParent(this);
        this.EnumDeclNext=EnumDeclNext;
        if(EnumDeclNext!=null) EnumDeclNext.setParent(this);
    }

    public EnumName getEnumName() {
        return EnumName;
    }

    public void setEnumName(EnumName EnumName) {
        this.EnumName=EnumName;
    }

    public EnumDeclFirst getEnumDeclFirst() {
        return EnumDeclFirst;
    }

    public void setEnumDeclFirst(EnumDeclFirst EnumDeclFirst) {
        this.EnumDeclFirst=EnumDeclFirst;
    }

    public EnumDeclNext getEnumDeclNext() {
        return EnumDeclNext;
    }

    public void setEnumDeclNext(EnumDeclNext EnumDeclNext) {
        this.EnumDeclNext=EnumDeclNext;
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
        if(EnumName!=null) EnumName.accept(visitor);
        if(EnumDeclFirst!=null) EnumDeclFirst.accept(visitor);
        if(EnumDeclNext!=null) EnumDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EnumName!=null) EnumName.traverseTopDown(visitor);
        if(EnumDeclFirst!=null) EnumDeclFirst.traverseTopDown(visitor);
        if(EnumDeclNext!=null) EnumDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EnumName!=null) EnumName.traverseBottomUp(visitor);
        if(EnumDeclFirst!=null) EnumDeclFirst.traverseBottomUp(visitor);
        if(EnumDeclNext!=null) EnumDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDecl(\n");

        if(EnumName!=null)
            buffer.append(EnumName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumDeclFirst!=null)
            buffer.append(EnumDeclFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(EnumDeclNext!=null)
            buffer.append(EnumDeclNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDecl]");
        return buffer.toString();
    }
}
