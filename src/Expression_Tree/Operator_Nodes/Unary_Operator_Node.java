package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;

public abstract class Unary_Operator_Node implements Node {

    private Node child;

    Unary_Operator_Node(Node child){
        this.child = child;
    }

    public Node getChild() {
        return child;
    }
}
