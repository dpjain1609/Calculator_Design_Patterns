import java.util.Stack;

public abstract class Unary_Command implements Operator_Command{

    @Override
    public void execute(Stack<Float> stack) {
        float num = stack.pop();
        stack.push(this.evaluate(num));
    }

    abstract float evaluate(float num);
}
