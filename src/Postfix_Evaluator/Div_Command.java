package Postfix_Evaluator;

public class Div_Command extends Binary_Command{

    Div_Command(){
        super(2);
    }

    @Override
    float evaluate(float num1, float num2) {
        return (num2/num1);
    }
}
