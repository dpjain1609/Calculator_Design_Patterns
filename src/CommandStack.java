import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CommandStack implements Strategy{

    @Override
    public void input() {

        boolean keepGoing = true;
        Scanner scan = new Scanner(System.in);

        while(keepGoing){
            System.out.println("Enter expression : ");
            String expression = scan.nextLine();

            if(expression.equalsIgnoreCase("quit")){
                keepGoing = false;
                continue;
            }

            String parse = parse_expression(expression);
            int result = evaluate_expression(parse);
            System.out.println("Result = " + result);
        }
    }

    @Override
    public String parse_expression(String expression) {

        StringTokenizer tokenizer = new StringTokenizer(expression);
        String token;
        String postfix = "";
        Stack<String> stack = new Stack<>();

        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();

            if(isFloat(token)){
                stack.push(token);
            }

            else if(token.equals("(")){
                stack.push(token);
            }

            else if(token.equals(")")){
                while(!stack.peek().equals("(")){
                    postfix = postfix + stack.peek() + " ";
                    stack.pop();
                }

                stack.pop();

            }

            else if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equalsIgnoreCase("SQRT") || token.equalsIgnoreCase("CBRT")){
                while(!stack.empty() && operatorPrecedence(token) <= operatorPrecedence(stack.peek())){
                    postfix = postfix + stack.peek() + " ";
                    stack.pop();
                }

                stack.push(token);
            }

            else {
                throw new IllegalStateException();
            }
        }

        while(!stack.empty()) {
            postfix = postfix + stack.peek() + " ";
            stack.pop();
        }

        return postfix;
    }

    @Override
    public int evaluate_expression(String parse) {

        int result;

        return result;

    }

    private boolean isFloat(String str){
        try{
            Float.parseFloat(str);
            return true;
        }
        catch(NumberFormatException exception){
            return false;
        }
    }

    private int operatorPrecedence(String str){
        if(str.equalsIgnoreCase("SQRT") || str.equalsIgnoreCase("CBRT")){
            return 3;
        }

        else if(str.equals("*") || str.equals("/")){
            return 2;
        }

        else if(str.equals("+") || str.equals("-")){
            return 1;
        }

        else if(isFloat(str)){
            return 5;
        }

	else
        return -1;
    }

}
