package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;
import Expression_Tree.Node_Visitor;

public class Number_Node implements Node {

    private final float num;

    public Number_Node(float num){
        this.num = num;
    }

    @Override
    public float evaluate() {
        return this.num;
    }

    @Override
    public void accept(Node_Visitor v) {
        v.visit_number_node(this);
    }
}
