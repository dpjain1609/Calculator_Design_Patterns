package Postfix_Evaluator;

import java.util.Stack;

public abstract class Binary_Command extends Operator_Command {

    Binary_Command(int precedence){
        //set precedence according to the child class - according to the operator
        super(precedence);
    }

    @Override
    public void execute(Stack<Float> stack) {
        /*
         * Basic binary operation algorithm
         * Pop two numbers from the stack
         * Peform the required operation
         * Push it to the top of the stack
         */
        float num1 = stack.pop();
        float num2 = stack.pop();
        stack.push(this.evaluate(num1, num2));
    }

    //method to perform the required operation
    abstract float evaluate(float num1, float num2);
}