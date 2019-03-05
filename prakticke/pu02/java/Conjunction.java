import java.util.*;

public class Conjunction extends Formula {
    private ArrayList<Formula> formulas=new ArrayList<>(0);

    Conjunction(Formula[] conjunction){
        formulas.addAll(Arrays.asList(conjunction));
    }

    Conjunction(Conjunction another){
        formulas=another.formulas;
    }

    public String toString(){
        StringBuffer s=new StringBuffer();
        s.append("(");
        for(Formula var:formulas){ //
            s.append(var.toString());
            s.append("&");
        }

        if(s.length()!=0){
            s.setLength(s.length()-1);
        }

        s.append(")");
        return s.toString();
    }

    public int deg(){
        int dg=0;
        for (Formula var:formulas){
            dg+=var.deg();
        }
        return dg+1;
    }

    public Set<String> vars() {
        Set<String> vars=new HashSet<>(0);
        for(Formula var:formulas){
            vars.addAll(var.vars());
        }
        return vars;
    }

    public Boolean isSatisfied(Map<String,Boolean> v) {
        boolean truth = true;

        for (Formula form : formulas) {
            truth = truth && form.isSatisfied(v);
        }

        return truth;
    }

    public Conjunction makeNewInstance(Conjunction which){
        return new Conjunction(which);
    }

    public Formula substitute (Formula what,Formula replacement){
        if(equals(what)){
            return makeNewInstance(replacement);
        }

        ArrayList<Formula> tempFormulas=new ArrayList<>(0);

        for(Formula form:formulas){
            tempFormulas.add(form.substitute(what,replacement));
        }

        Formula[] tempArray=new Formula[tempFormulas.size()];
        tempArray=tempFormulas.toArray(tempArray);

        return new Conjunction(tempArray);
    }
}
