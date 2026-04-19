// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class SwitchCase_Case extends SwitchCase {

    private SwitchNumConst SwitchNumConst;
    private SwitchCaseColon SwitchCaseColon;
    private SwitchStatementL SwitchStatementL;
    private SwitchCase SwitchCase;

    public SwitchCase_Case (SwitchNumConst SwitchNumConst, SwitchCaseColon SwitchCaseColon, SwitchStatementL SwitchStatementL, SwitchCase SwitchCase) {
        this.SwitchNumConst=SwitchNumConst;
        if(SwitchNumConst!=null) SwitchNumConst.setParent(this);
        this.SwitchCaseColon=SwitchCaseColon;
        if(SwitchCaseColon!=null) SwitchCaseColon.setParent(this);
        this.SwitchStatementL=SwitchStatementL;
        if(SwitchStatementL!=null) SwitchStatementL.setParent(this);
        this.SwitchCase=SwitchCase;
        if(SwitchCase!=null) SwitchCase.setParent(this);
    }

    public SwitchNumConst getSwitchNumConst() {
        return SwitchNumConst;
    }

    public void setSwitchNumConst(SwitchNumConst SwitchNumConst) {
        this.SwitchNumConst=SwitchNumConst;
    }

    public SwitchCaseColon getSwitchCaseColon() {
        return SwitchCaseColon;
    }

    public void setSwitchCaseColon(SwitchCaseColon SwitchCaseColon) {
        this.SwitchCaseColon=SwitchCaseColon;
    }

    public SwitchStatementL getSwitchStatementL() {
        return SwitchStatementL;
    }

    public void setSwitchStatementL(SwitchStatementL SwitchStatementL) {
        this.SwitchStatementL=SwitchStatementL;
    }

    public SwitchCase getSwitchCase() {
        return SwitchCase;
    }

    public void setSwitchCase(SwitchCase SwitchCase) {
        this.SwitchCase=SwitchCase;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SwitchNumConst!=null) SwitchNumConst.accept(visitor);
        if(SwitchCaseColon!=null) SwitchCaseColon.accept(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.accept(visitor);
        if(SwitchCase!=null) SwitchCase.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SwitchNumConst!=null) SwitchNumConst.traverseTopDown(visitor);
        if(SwitchCaseColon!=null) SwitchCaseColon.traverseTopDown(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.traverseTopDown(visitor);
        if(SwitchCase!=null) SwitchCase.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SwitchNumConst!=null) SwitchNumConst.traverseBottomUp(visitor);
        if(SwitchCaseColon!=null) SwitchCaseColon.traverseBottomUp(visitor);
        if(SwitchStatementL!=null) SwitchStatementL.traverseBottomUp(visitor);
        if(SwitchCase!=null) SwitchCase.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SwitchCase_Case(\n");

        if(SwitchNumConst!=null)
            buffer.append(SwitchNumConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchCaseColon!=null)
            buffer.append(SwitchCaseColon.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchStatementL!=null)
            buffer.append(SwitchStatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchCase!=null)
            buffer.append(SwitchCase.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SwitchCase_Case]");
        return buffer.toString();
    }
}
