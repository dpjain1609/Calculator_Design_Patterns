public class Sqrt_Command extends Unary_Command{

    Sqrt_Command(){

    }

    @Override
    float evaluate(float num) {
        return (float)(Math.pow(num, 0.5));
    }
}
