import java.util.*;

public abstract class Formula {

    Formula(){}

    public abstract String toString();

    public abstract int deg();

    public abstract Boolean isSatisfied(Map<String,Boolean> v);

    public abstract Set<String>  vars();

    public abstract Formula substitute(Formula what, Formula replacement);

    public Boolean equals(Formula other){
        return toString().equals(other.toString());
    }

    public Formula makeNewInstance(Formula which){
        return which;
    }
}