import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CommandStack implements Strategy{

    CommandStack(){
        input();
    }

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
            float result = evaluate_expression(parse);
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
                throw new IllegalStateException("Invalid Character");
            }
        }

        while(!stack.empty()) {
            postfix = postfix + stack.peek() + " ";
            stack.pop();
        }

        return postfix;
    }

    @Override
    public float evaluate_expression(String parse) {

        StringTokenizer tokenizer = new StringTokenizer(parse);
        String token;
        Stack<Float> stack = new Stack<>();
        Command cmd = null;

        Stack_Expr_Command_Factory factory = new Stack_Expr_Command_Factory();

        while(tokenizer.hasMoreTokens()){
            token = tokenizer.nextToken();

            if(isFloat(token)){
                cmd = factory.create_number_command(Float.parseFloat(token));
            }

            else if(token.equals("+")){
                cmd = factory.create_add_command();
            }

            else if(token.equals("-")){
                cmd = factory.create_sub_command();
            }

            else if(token.equals("*")){
                cmd = factory.create_multi_command();
            }

            else if(token.equals("/")){
                cmd = factory.create_div_command();
            }

            else if(token.equals("SQRT")){
                cmd = factory.create_sqrt_command();
            }

            else if(token.equals("CBRT")){
                cmd = factory.create_cbrt_command();
            }

            cmd.execute(stack);

        }

        return stack.peek();

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
