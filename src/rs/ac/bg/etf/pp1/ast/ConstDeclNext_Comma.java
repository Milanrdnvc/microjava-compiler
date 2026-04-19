// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclNext_Comma extends ConstDeclNext {

    private ConstDeclFirst ConstDeclFirst;
    private ConstDeclNext ConstDeclNext;

    public ConstDeclNext_Comma (ConstDeclFirst ConstDeclFirst, ConstDeclNext ConstDeclNext) {
        this.ConstDeclFirst=ConstDeclFirst;
        if(ConstDeclFirst!=null) ConstDeclFirst.setParent(this);
        this.ConstDeclNext=ConstDeclNext;
        if(ConstDeclNext!=null) ConstDeclNext.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclFirst!=null) ConstDeclFirst.accept(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclFirst!=null) ConstDeclFirst.traverseTopDown(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclFirst!=null) ConstDeclFirst.traverseBottomUp(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclNext_Comma(\n");

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
        buffer.append(") [ConstDeclNext_Comma]");
        return buffer.toString();
    }
}
