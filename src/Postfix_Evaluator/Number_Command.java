package Postfix_Evaluator;

import java.util.Stack;

public class Number_Command implements Command{

    Number_Command(){
        this.num = 0;
    }

    Number_Command(float num){
        this.num = num;
    }

    @Override
    public void execute(Stack<Float> stack) {
        stack.push(this.num);
    }

    private float num;
}
