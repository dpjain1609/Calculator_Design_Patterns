package Postfix_Evaluator;

import java.util.Stack;

public abstract class Operator_Command implements Command {

    private final int precedence;

    Operator_Command(int precedence){
        this.precedence = precedence;
    }

    public int getPrecedence(){
        return this.precedence;
    }

    public abstract void execute(Stack<Float> stack);

}
