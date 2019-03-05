import java.util.Map;
import java.util.Set;

public class Negation extends Formula {
    private Formula formula;

    Negation(Formula originalFormula){
        formula=originalFormula;
    }

    public Formula originalFormula(){
        return formula;
    }

    public String toString(){
        return "-"+originalFormula().toString();
    }

    public int deg(){
        return originalFormula().deg()+1;
    }

    public Set<String> vars() {
        return formula.vars();
    }

    public Boolean isSatisfied(Map<String,Boolean> v) {  //probably
        return !originalFormula().isSatisfied(v);
    }

    public Formula substitute (Formula what,Formula replacement){
        if(equals(what)){
            return new Negation(replacement);
        }
        return new Negation(originalFormula().substitute(what,replacement));
    }
}
