package Postfix_Evaluator;

import java.util.Stack;

public abstract class Unary_Command extends Operator_Command{

    Unary_Command(int precedence){
        super(precedence);
    }

    @Override
    public void execute(Stack<Float> stack) {
        float num = stack.pop();
        stack.push(this.evaluate(num));
    }

    abstract float evaluate(float num);
}
