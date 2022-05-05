public class CommandStack implements Strategy{

    @Override
    public void algorithm() {

    }

    public String infix_to_postfix(){



        return null;
    }

    int operatorPrecedence(String token){
        if(token == "SQRT" || token == "CBRT"){
            return 4;
        }

        else if(token == "*" || token == "/"){
            return 3;
        }

        else if(token == "+" || token == "-"){
            return 2;
        }

        return -1;
    }

}
