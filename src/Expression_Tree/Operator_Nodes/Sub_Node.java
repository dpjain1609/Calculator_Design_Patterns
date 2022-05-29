package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;
import Expression_Tree.Node_Visitor;

public class Sub_Node extends Binary_Operator_Node{

    public Sub_Node(Node left, Node right){
        super(left, right);
    }

    public Sub_Node(int num1, int num2) {
        super(new Number_Node(num1), new Number_Node(num2));
    }

    @Override
    public float evaluate() {
        float num1 = getLeft_child().evaluate();
        float num2 = getRight_child().evaluate();

        return (num1 - num2);
    }

    @Override
    public void accept(Node_Visitor v) {
        v.visit_sub_node(this);
    }
}
