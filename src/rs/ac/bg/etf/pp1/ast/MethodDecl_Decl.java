// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl_Decl extends MethodDecl {

    private ReturnType ReturnType;
    private MethodName MethodName;
    private FormParsL FormParsL;
    private VarDeclL VarDeclL;
    private StatementL StatementL;

    public MethodDecl_Decl (ReturnType ReturnType, MethodName MethodName, FormParsL FormParsL, VarDeclL VarDeclL, StatementL StatementL) {
        this.ReturnType=ReturnType;
        if(ReturnType!=null) ReturnType.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.FormParsL=FormParsL;
        if(FormParsL!=null) FormParsL.setParent(this);
        this.VarDeclL=VarDeclL;
        if(VarDeclL!=null) VarDeclL.setParent(this);
        this.StatementL=StatementL;
        if(StatementL!=null) StatementL.setParent(this);
    }

    public ReturnType getReturnType() {
        return ReturnType;
    }

    public void setReturnType(ReturnType ReturnType) {
        this.ReturnType=ReturnType;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public FormParsL getFormParsL() {
        return FormParsL;
    }

    public void setFormParsL(FormParsL FormParsL) {
        this.FormParsL=FormParsL;
    }

    public VarDeclL getVarDeclL() {
        return VarDeclL;
    }

    public void setVarDeclL(VarDeclL VarDeclL) {
        this.VarDeclL=VarDeclL;
    }

    public StatementL getStatementL() {
        return StatementL;
    }

    public void setStatementL(StatementL StatementL) {
        this.StatementL=StatementL;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnType!=null) ReturnType.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(FormParsL!=null) FormParsL.accept(visitor);
        if(VarDeclL!=null) VarDeclL.accept(visitor);
        if(StatementL!=null) StatementL.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnType!=null) ReturnType.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(FormParsL!=null) FormParsL.traverseTopDown(visitor);
        if(VarDeclL!=null) VarDeclL.traverseTopDown(visitor);
        if(StatementL!=null) StatementL.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnType!=null) ReturnType.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(FormParsL!=null) FormParsL.traverseBottomUp(visitor);
        if(VarDeclL!=null) VarDeclL.traverseBottomUp(visitor);
        if(StatementL!=null) StatementL.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl_Decl(\n");

        if(ReturnType!=null)
            buffer.append(ReturnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsL!=null)
            buffer.append(FormParsL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclL!=null)
            buffer.append(VarDeclL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementL!=null)
            buffer.append(StatementL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl_Decl]");
        return buffer.toString();
    }
}
