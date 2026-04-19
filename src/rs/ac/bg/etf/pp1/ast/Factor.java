// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Factor implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private MinusOpt MinusOpt;
    private FactorNext FactorNext;

    public Factor (MinusOpt MinusOpt, FactorNext FactorNext) {
        this.MinusOpt=MinusOpt;
        if(MinusOpt!=null) MinusOpt.setParent(this);
        this.FactorNext=FactorNext;
        if(FactorNext!=null) FactorNext.setParent(this);
    }

    public MinusOpt getMinusOpt() {
        return MinusOpt;
    }

    public void setMinusOpt(MinusOpt MinusOpt) {
        this.MinusOpt=MinusOpt;
    }

    public FactorNext getFactorNext() {
        return FactorNext;
    }

    public void setFactorNext(FactorNext FactorNext) {
        this.FactorNext=FactorNext;
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
        if(MinusOpt!=null) MinusOpt.accept(visitor);
        if(FactorNext!=null) FactorNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusOpt!=null) MinusOpt.traverseTopDown(visitor);
        if(FactorNext!=null) FactorNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusOpt!=null) MinusOpt.traverseBottomUp(visitor);
        if(FactorNext!=null) FactorNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor(\n");

        if(MinusOpt!=null)
            buffer.append(MinusOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorNext!=null)
            buffer.append(FactorNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor]");
        return buffer.toString();
    }
}
