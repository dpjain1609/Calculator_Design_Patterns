package Interfaces;

public interface Strategy {
    public void input();
    public String parse_expression(String expression);
    public float evaluate_expression(String parse);
}
