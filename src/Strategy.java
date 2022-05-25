public interface Strategy {
    public void input();
    public String parse_expression(String expression);
    public int evaluate_expression(String parse);
}
