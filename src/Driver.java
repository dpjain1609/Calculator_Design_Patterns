import java.util.Stack;

public class Driver {

    public static void main(String args[]){
        Stack<Float> stack = new Stack<>();
        Command num1 = new Number_Command(6);
        Command num2 = new Number_Command(729);
        num1.execute(stack);
        num2.execute(stack);
        Command a = new Cbrt_Command();
        a.execute(stack);
        System.out.println(stack.peek());
    }

}
