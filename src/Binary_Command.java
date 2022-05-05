import java.util.Stack;

public abstract class Binary_Command implements Operator_Command {

    @Override
    public void execute(Stack<Float> stack) {
        float num1 = stack.pop();
        float num2 = stack.pop();
        stack.push(this.evaluate(num1, num2));
    }

    abstract float evaluate(float num1, float num2);
}