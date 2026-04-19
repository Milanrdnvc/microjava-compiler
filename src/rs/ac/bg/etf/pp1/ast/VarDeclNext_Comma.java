// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class VarDeclNext_Comma extends VarDeclNext {

    private VarDeclFirst VarDeclFirst;
    private VarDeclNext VarDeclNext;

    public VarDeclNext_Comma (VarDeclFirst VarDeclFirst, VarDeclNext VarDeclNext) {
        this.VarDeclFirst=VarDeclFirst;
        if(VarDeclFirst!=null) VarDeclFirst.setParent(this);
        this.VarDeclNext=VarDeclNext;
        if(VarDeclNext!=null) VarDeclNext.setParent(this);
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
        if(VarDeclFirst!=null) VarDeclFirst.accept(visitor);
        if(VarDeclNext!=null) VarDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclFirst!=null) VarDeclFirst.traverseTopDown(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclFirst!=null) VarDeclFirst.traverseBottomUp(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclNext_Comma(\n");

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
        buffer.append(") [VarDeclNext_Comma]");
        return buffer.toString();
    }
}
