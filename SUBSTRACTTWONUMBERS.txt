class SubtractTwoNumbers
{
    public static void main(String[] args) 
{
        int x, y, subtract;
        x = Integer.parseInt(args[0]);
 
        y = Integer.parseInt(args[1]);

        subtract = x - y;

        System.out.println("The subtraction of the given two Numbers: " + subtract);
    }
}
