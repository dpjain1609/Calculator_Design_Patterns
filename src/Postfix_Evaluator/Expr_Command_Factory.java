package Postfix_Evaluator;

public interface Expr_Command_Factory {

    Add_Command create_add_command();
    Sub_Command create_sub_command();
    Multi_Command create_multi_command();
    Div_Command create_div_command();
    Sqrt_Command create_sqrt_command();
    Cbrt_Command create_cbrt_command();
    Number_Command create_number_command(float num);

}
