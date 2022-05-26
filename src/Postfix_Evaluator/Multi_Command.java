package Postfix_Evaluator;

public class Multi_Command extends Binary_Command{

    Multi_Command(){
        super(2);
    }

    @Override
    float evaluate(float num1, float num2) {
        return (num1 * num2);
    }
}
