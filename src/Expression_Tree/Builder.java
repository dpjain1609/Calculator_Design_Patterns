package Expression_Tree;

public interface Builder {

    void start_expression();
    void build_number(float num);
    void build_add_operator();
    void build_sub_operator();
    void build_multi_operator();
    void build_div_operator();
    void build_sqrt_operator();
    void build_cbrt_operator();
    float get_expression_result();

}
