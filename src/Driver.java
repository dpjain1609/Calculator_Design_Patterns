public class Driver {

    public static void main(String args[]){

        CommandStack cs = new CommandStack();
        String str = cs.parse_expression("9 - ( 32 + 23 ) * 21 / 2");
        System.out.println(str);

    }

}
