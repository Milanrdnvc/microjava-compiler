// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class EnumDeclFirst implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private NumConst NumConst;

    public EnumDeclFirst (String I1, NumConst NumConst) {
        this.I1=I1;
        this.NumConst=NumConst;
        if(NumConst!=null) NumConst.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public NumConst getNumConst() {
        return NumConst;
    }

    public void setNumConst(NumConst NumConst) {
        this.NumConst=NumConst;
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
        if(NumConst!=null) NumConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NumConst!=null) NumConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NumConst!=null) NumConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("EnumDeclFirst(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(NumConst!=null)
            buffer.append(NumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [EnumDeclFirst]");
        return buffer.toString();
    }
}
