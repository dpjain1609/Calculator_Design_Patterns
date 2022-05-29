package Expression_Tree;

import Interfaces.Strategy;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Expression_Tree implements Strategy {

    public Expression_Tree(){
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
        Expr_Tree_Builder builder = new Expr_Tree_Builder();
        builder.start_expression();

        while(tokenizer.hasMoreTokens()){

            token = tokenizer.nextToken();

            if (isFloat(token)){
                float num = Float.parseFloat(token);
                builder.build_number(num);
            }

            else if(token.equals("+")){
                builder.build_add_operator();
            }

            else if(token.equals("-")){
                builder.build_sub_operator();
            }

            else if(token.equals("*")){
                builder.build_multi_operator();
            }

            else if(token.equals("/")){
                builder.build_div_operator();
            }

            else if(token.equalsIgnoreCase("sqrt")){
                builder.build_sqrt_operator();
            }

            else if(token.equalsIgnoreCase("cbrt")){
                builder.build_cbrt_operator();
            }
        }

        float result = builder.get_expression_result();

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
