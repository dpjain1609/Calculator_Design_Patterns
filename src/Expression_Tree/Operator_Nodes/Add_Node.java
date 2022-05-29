package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node_Visitor;
import Expression_Tree.Node;

public class Add_Node extends Binary_Operator_Node{

    public Add_Node(Node left, Node right){
        super(left, right);
    }

    public Add_Node(float num1, float num2){
        super(new Number_Node(num1), new Number_Node(num2));
    }

    @Override
    public float evaluate() {
        float num1 = getLeft_child().evaluate();
        float num2 = getRight_child().evaluate();

        return (num1 + num2);

    }

    @Override
    public void accept(Node_Visitor v) {
        v.visit_add_node(this);
    }
}
