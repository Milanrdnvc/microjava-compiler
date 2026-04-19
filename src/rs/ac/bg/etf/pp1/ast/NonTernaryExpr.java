// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class NonTernaryExpr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private AddopTermL AddopTermL;

    public NonTernaryExpr (AddopTermL AddopTermL) {
        this.AddopTermL=AddopTermL;
        if(AddopTermL!=null) AddopTermL.setParent(this);
    }

    public AddopTermL getAddopTermL() {
        return AddopTermL;
    }

    public void setAddopTermL(AddopTermL AddopTermL) {
        this.AddopTermL=AddopTermL;
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
        if(AddopTermL!=null) AddopTermL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTermL!=null) AddopTermL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTermL!=null) AddopTermL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NonTernaryExpr(\n");

        if(AddopTermL!=null)
            buffer.append(AddopTermL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NonTernaryExpr]");
        return buffer.toString();
    }
}
