import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Implication extends BinaryFormula{
    private Formula first;
    private Formula second;

    Implication(Formula l,Formula r){
        super(l,r);
        first=l;
        second=r;
    }

    public String toString(){
        StringBuffer s=new StringBuffer();
        s.append("(");

        s.append(first);
        s.append("->");
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
        return(!first.isSatisfied(v) || second.isSatisfied(v));
    }

    public Formula substitute (Formula what,Formula replacement){
        if(equals(what)){
            return new Implication(first,second);
        }
       return new Implication(first.substitute(what,replacement),second.substitute(what,replacement));
    }
}
