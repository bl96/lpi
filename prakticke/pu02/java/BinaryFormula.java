public abstract class BinaryFormula extends Formula {

    private Formula leftFormula;
    private Formula rightFormula;

    BinaryFormula(Formula leftSide,Formula rightSide){
        leftFormula=leftSide;
        rightFormula=rightSide;
    }

    Formula leftSide(){
        return leftFormula;
    }

    Formula rightSide(){
        return rightFormula;
    }

}
