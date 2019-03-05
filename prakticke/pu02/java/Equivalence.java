import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Equivalence extends BinaryFormula {
    private Formula first;
    private Formula second;

    Equivalence(Formula l,Formula r){
        super(l,r);
        first=l;
        second=r;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("(");

        s.append(first);
        s.append("<->");
        s.append(second);

        s.append(")");
        return s.toString();
    }

    public int deg(){
        return first.deg()+second.deg()+1;
    }

    public Set<String> vars() {
        Set<String> vars=new HashSet<>(0);
        vars.addAll(first.vars());
        vars.addAll(second.vars());
        return vars;
    }

    public Boolean isSatisfied(Map<String,Boolean> v){
        return((!first.isSatisfied(v) || second.isSatisfied(v)) && (first.isSatisfied(v) || !second.isSatisfied(v)));
    }

    public Formula substitute (Formula what,Formula replacement){
        if(equals(what)){
            return new Equivalence(first,second);
        }

        return new Equivalence(leftSide().substitute(what,replacement),rightSide().substitute(what,replacement));
    }
}

