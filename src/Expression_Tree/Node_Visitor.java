package Expression_Tree;

import Expression_Tree.Operator_Nodes.*;

public interface Node_Visitor {

    void visit_add_node(Add_Node node);
    void visit_sub_node(Sub_Node node);
    void visit_multi_node(Multi_Node node);
    void visit_div_node(Div_Node node);
    void visit_sqrt_node(Sqrt_Node node);
    void visit_cbrt_node(Cbrt_Node node);
    void visit_number_node(Number_Node node);

}
