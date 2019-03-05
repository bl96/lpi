import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Disjunction extends Formula{
    public ArrayList<Formula> formulas=new ArrayList<>(0);

    Disjunction(Formula[] disjuncts){
       for(Formula var:disjuncts){
           formulas.add(var);
        }
    }

    Disjunction(Disjunction another){
        formulas=another.formulas;
    }

    public String toString(){
        StringBuffer s=new StringBuffer();
        s.append("(");
        for(Formula var:formulas){  //variables
            s.append(var.toString());
            s.append("|");
        }

        if(s.length()!=0){
            s.setLength(s.length()-1);
        }

        s.append(")");
        return s.toString();
    }

    public int deg(){
        int dg=0;
        for (Formula var:formulas){ //variables
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

    public Boolean isSatisfied(Map<String,Boolean> v){
        boolean truth=false;

        for(Formula form:formulas){
            truth=truth || form.isSatisfied(v);
        }

        return truth;
    }

    public Disjunction makeNewInstance(Disjunction which){
        return new Disjunction(which);
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

        return new Disjunction(tempArray);
    }
}
