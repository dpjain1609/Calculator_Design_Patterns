package Expression_Tree;

public interface Node {
    float evaluate();
    void accept(Node_Visitor v);
}
