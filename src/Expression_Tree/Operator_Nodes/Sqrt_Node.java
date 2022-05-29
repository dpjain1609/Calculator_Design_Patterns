package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;
import Expression_Tree.Node_Visitor;

import static java.lang.Float.NaN;

public class Sqrt_Node extends Unary_Operator_Node{

    public Sqrt_Node(Node child){
        super(child);
    }

    Sqrt_Node(float num){
        super(new Number_Node(num));
    }

    @Override
    public float evaluate() {

        float result = (float) Math.sqrt(getChild().evaluate());

        if(result == NaN){
            throw new NumberFormatException();
        }

        return result;

    }

    @Override
    public void accept(Node_Visitor v) {
        v.visit_sqrt_node(this);
    }
}
