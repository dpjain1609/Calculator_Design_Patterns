public class Add_Command extends Binary_Command{

    Add_Command(){

    }

    @Override
    public float evaluate(float num1, float num2) {
        return (num1 + num2);
    }
}
