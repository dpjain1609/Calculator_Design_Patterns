package Expression_Tree;

import Expression_Tree.Operator_Nodes.*;

public class Eval_Expr_Tree implements Node_Visitor{

    @Override
    public void visit_add_node(Add_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_sub_node(Sub_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_multi_node(Multi_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_div_node(Div_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_sqrt_node(Sqrt_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_cbrt_node(Cbrt_Node node) {
        result = node.evaluate();
    }

    @Override
    public void visit_number_node(Number_Node node) {
        result = node.evaluate();
    }

    public float getResult(){
        return this.result;
    }

    private float result;

}
