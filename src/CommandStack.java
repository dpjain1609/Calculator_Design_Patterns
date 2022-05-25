import java.util.Scanner;

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



        return null;
    }

    @Override
    public int evaluate_expression(String parse) {
        return 0;
    }

}
