// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class ActParsL_ActPars extends ActParsL {

    private ActParListStart ActParListStart;
    private ActPar ActPar;
    private ActParNext ActParNext;

    public ActParsL_ActPars (ActParListStart ActParListStart, ActPar ActPar, ActParNext ActParNext) {
        this.ActParListStart=ActParListStart;
        if(ActParListStart!=null) ActParListStart.setParent(this);
        this.ActPar=ActPar;
        if(ActPar!=null) ActPar.setParent(this);
        this.ActParNext=ActParNext;
        if(ActParNext!=null) ActParNext.setParent(this);
    }

    public ActParListStart getActParListStart() {
        return ActParListStart;
    }

    public void setActParListStart(ActParListStart ActParListStart) {
        this.ActParListStart=ActParListStart;
    }

    public ActPar getActPar() {
        return ActPar;
    }

    public void setActPar(ActPar ActPar) {
        this.ActPar=ActPar;
    }

    public ActParNext getActParNext() {
        return ActParNext;
    }

    public void setActParNext(ActParNext ActParNext) {
        this.ActParNext=ActParNext;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParListStart!=null) ActParListStart.accept(visitor);
        if(ActPar!=null) ActPar.accept(visitor);
        if(ActParNext!=null) ActParNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParListStart!=null) ActParListStart.traverseTopDown(visitor);
        if(ActPar!=null) ActPar.traverseTopDown(visitor);
        if(ActParNext!=null) ActParNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParListStart!=null) ActParListStart.traverseBottomUp(visitor);
        if(ActPar!=null) ActPar.traverseBottomUp(visitor);
        if(ActParNext!=null) ActParNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsL_ActPars(\n");

        if(ActParListStart!=null)
            buffer.append(ActParListStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPar!=null)
            buffer.append(ActPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParNext!=null)
            buffer.append(ActParNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsL_ActPars]");
        return buffer.toString();
    }
}
