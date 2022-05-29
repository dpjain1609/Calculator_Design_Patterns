package Expression_Tree.Operator_Nodes;

import Expression_Tree.Node;

public abstract class Binary_Operator_Node implements Node {

    private Node left_child;
    private Node right_child;

    Binary_Operator_Node(Node left_child, Node right_child){
        this.left_child = left_child;
        this.right_child = right_child;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public Node getRight_child() {
        return right_child;
    }
}
