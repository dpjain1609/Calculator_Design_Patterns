public class Div_Command extends Binary_Command{

    Div_Command(){

    }

    @Override
    float evaluate(float num1, float num2) {
        return (num2/num1);
    }
}
