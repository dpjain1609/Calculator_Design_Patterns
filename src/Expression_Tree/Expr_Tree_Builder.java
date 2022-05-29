package Expression_Tree;

import Expression_Tree.Operator_Nodes.*;

import java.util.Stack;

public class Expr_Tree_Builder implements Builder{

    private Expr_Tree tree;
    private Eval_Expr_Tree eval;
    private Stack<Node> nodeStack;

    @Override
    public void start_expression() {
        tree = new Expr_Tree();
        eval = new Eval_Expr_Tree();
        nodeStack = new Stack<>();
    }

    @Override
    public void build_number(float num) {
        Node number = new Number_Node(num);
        nodeStack.push(number);
    }

    @Override
    public void build_add_operator() {
        Node right = nodeStack.pop();
        Node left = nodeStack.pop();

        Add_Node add = new Add_Node(left, right);
        nodeStack.push(add);
        eval.visit_add_node(add);
    }

    @Override
    public void build_sub_operator() {
        Node right = nodeStack.pop();
        Node left = nodeStack.pop();

        Sub_Node sub = new Sub_Node(left, right);
        nodeStack.push(sub);
        eval.visit_sub_node(sub);
    }

    @Override
    public void build_multi_operator() {
        Node right = nodeStack.pop();
        Node left = nodeStack.pop();

        Multi_Node multi = new Multi_Node(left, right);
        nodeStack.push(multi);
        eval.visit_multi_node(multi);
    }

    @Override
    public void build_div_operator() {
        Node right = nodeStack.pop();
        Node left = nodeStack.pop();

        Div_Node div = new Div_Node(left, right);
        nodeStack.push(div);
        eval.visit_div_node(div);
    }

    @Override
    public void build_sqrt_operator() {
        Node child = nodeStack.pop();

        Sqrt_Node sqrt = new Sqrt_Node(child);
        nodeStack.push(sqrt);
        eval.visit_sqrt_node(sqrt);
    }

    @Override
    public void build_cbrt_operator() {
        Node child = nodeStack.pop();

        Cbrt_Node cbrt = new Cbrt_Node(child);
        nodeStack.push(cbrt);
        eval.visit_cbrt_node(cbrt);
    }

    @Override
    public float get_expression_result() {
        return this.eval.getResult();
    }
}
