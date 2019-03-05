import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Variable extends Formula {

    public String var;

    Variable(String name){
        var=name;
    }

    public String name(){
        return var;
    }

    public String toString(){
        return name();
    }

    public int deg(){
        return 0;
    }

    public Set<String> vars() {
        Set<String> vars=new HashSet<>(0);
        vars.add(var);
        return vars;
    }

    public Boolean isSatisfied(Map<String,Boolean> v){
        if(v.get(name())==null){
            return false;
        }
        return v.get(name());
    }

    public Formula[] subf(){
        Formula [] subfArray=new Formula[0];
        return subfArray;
    }

    public Formula substitute (Formula what,Formula replacement){
        if(equals(what)){
            return new Variable(replacement.toString());
        }

        return new Variable(name());
    }
}
