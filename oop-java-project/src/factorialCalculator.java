package part2;

public class factorialCalculator 
{
    private int number;

    public factorialCalculator(int number) 
    {
        this.number = number;
    }

    public int factorial() 
    {
        if (number == 0) 
        {
            return 1;
        }
        int result = 1;
        
        for (int i = 1; i <= number; i++) 
        {
            result *= i;
        }
        return result;
    }

    public static void OOPExample (String[] args) 
    {
        int number = 5;
        factorialCalculator calculator = new factorialCalculator(number);
        int result = calculator.factorial();
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
