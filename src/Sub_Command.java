public class Sub_Command extends Binary_Command{

    Sub_Command(){

    }

    @Override
    float evaluate(float num1, float num2) {
        return (num2 - num1);
    }
}
