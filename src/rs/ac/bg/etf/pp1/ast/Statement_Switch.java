// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class Statement_Switch extends Statement {

    private Switch Switch;
    private Expr Expr;
    private SwitchCase SwitchCase;

    public Statement_Switch (Switch Switch, Expr Expr, SwitchCase SwitchCase) {
        this.Switch=Switch;
        if(Switch!=null) Switch.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.SwitchCase=SwitchCase;
        if(SwitchCase!=null) SwitchCase.setParent(this);
    }

    public Switch getSwitch() {
        return Switch;
    }

    public void setSwitch(Switch Switch) {
        this.Switch=Switch;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(Switch!=null) Switch.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(SwitchCase!=null) SwitchCase.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Switch!=null) Switch.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(SwitchCase!=null) SwitchCase.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Switch!=null) Switch.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(SwitchCase!=null) SwitchCase.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statement_Switch(\n");

        if(Switch!=null)
            buffer.append(Switch.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SwitchCase!=null)
            buffer.append(SwitchCase.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statement_Switch]");
        return buffer.toString();
    }
}
