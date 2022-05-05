public class Stack_Expr_Command_Factory implements Expr_Command_Factory{

    @Override
    public Add_Command create_add_command() {
        return new Add_Command();
    }

    @Override
    public Sub_Command create_sub_command() {
        return new Sub_Command();
    }

    @Override
    public Multi_Command create_multi_command() {
        return new Multi_Command();
    }

    @Override
    public Div_Command create_div_command() {
        return new Div_Command();
    }

    @Override
    public Sqrt_Command create_sqrt_command() {
        return new Sqrt_Command();
    }

    @Override
    public Cbrt_Command create_cbrt_command() {
        return new Cbrt_Command();
    }

    @Override
    public Number_Command create_number_command(float num) {
        return new Number_Command(num);
    }
}
