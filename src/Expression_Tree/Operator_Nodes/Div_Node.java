package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;
import Expression_Tree.Node_Visitor;

public class Div_Node extends Binary_Operator_Node{

    public Div_Node(Node left, Node right){
        super(left, right);
    }

    Div_Node(float num1, float num2){
        super(new Number_Node(num1), new Number_Node(num2));
    }

    @Override
    public float evaluate() {
        float num1 = getLeft_child().evaluate();
        float num2 = getRight_child().evaluate();
        float result = 0;

        try{
            result = num1 / num2;
            return result;
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void accept(Node_Visitor v) {
        v.visit_div_node(this);
    }
}
