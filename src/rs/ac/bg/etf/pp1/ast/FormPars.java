// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private FormParsFirst FormParsFirst;
    private FormParsNext FormParsNext;

    public FormPars (Type Type, FormParsFirst FormParsFirst, FormParsNext FormParsNext) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParsFirst=FormParsFirst;
        if(FormParsFirst!=null) FormParsFirst.setParent(this);
        this.FormParsNext=FormParsNext;
        if(FormParsNext!=null) FormParsNext.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParsFirst getFormParsFirst() {
        return FormParsFirst;
    }

    public void setFormParsFirst(FormParsFirst FormParsFirst) {
        this.FormParsFirst=FormParsFirst;
    }

    public FormParsNext getFormParsNext() {
        return FormParsNext;
    }

    public void setFormParsNext(FormParsNext FormParsNext) {
        this.FormParsNext=FormParsNext;
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
        if(Type!=null) Type.accept(visitor);
        if(FormParsFirst!=null) FormParsFirst.accept(visitor);
        if(FormParsNext!=null) FormParsNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParsFirst!=null) FormParsFirst.traverseTopDown(visitor);
        if(FormParsNext!=null) FormParsNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParsFirst!=null) FormParsFirst.traverseBottomUp(visitor);
        if(FormParsNext!=null) FormParsNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsFirst!=null)
            buffer.append(FormParsFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsNext!=null)
            buffer.append(FormParsNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
