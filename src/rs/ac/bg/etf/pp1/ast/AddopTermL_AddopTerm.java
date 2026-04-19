// generated with ast extension for cup
// version 0.8
// 19/3/2026 14:46:7


package rs.ac.bg.etf.pp1.ast;

public class AddopTermL_AddopTerm extends AddopTermL {

    private AddopTermL AddopTermL;
    private Addop Addop;
    private Term Term;

    public AddopTermL_AddopTerm (AddopTermL AddopTermL, Addop Addop, Term Term) {
        this.AddopTermL=AddopTermL;
        if(AddopTermL!=null) AddopTermL.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public AddopTermL getAddopTermL() {
        return AddopTermL;
    }

    public void setAddopTermL(AddopTermL AddopTermL) {
        this.AddopTermL=AddopTermL;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopTermL!=null) AddopTermL.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTermL!=null) AddopTermL.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTermL!=null) AddopTermL.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopTermL_AddopTerm(\n");

        if(AddopTermL!=null)
            buffer.append(AddopTermL.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddopTermL_AddopTerm]");
        return buffer.toString();
    }
}
