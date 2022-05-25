public class Cbrt_Command extends Unary_Command{

    private final double FACTOR = (0.33333334);

    Cbrt_Command(){
        super(3);
    }

    @Override
    float evaluate(float num) {
        return (float)(Math.pow(num, FACTOR));
    }
}
