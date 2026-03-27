package part2;

public class ProceduralExample 
{
    public static int factorial(int number) 
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

    public static void main(String[] args) 
    {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
