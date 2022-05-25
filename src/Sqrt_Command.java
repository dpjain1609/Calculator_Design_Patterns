public class Sqrt_Command extends Unary_Command{

    Sqrt_Command(){
        super(3);
    }

    @Override
    float evaluate(float num) {
        return (float)(Math.pow(num, 0.5));
    }
}
