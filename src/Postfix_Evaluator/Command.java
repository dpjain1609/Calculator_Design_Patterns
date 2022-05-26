package Postfix_Evaluator;

import java.util.Stack;

public interface Command {
    void execute(Stack<Float> stack);
}
