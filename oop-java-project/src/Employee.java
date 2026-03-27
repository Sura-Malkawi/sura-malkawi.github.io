package part2;

public class Employee extends User 
{
    private static final String PIN = "htu123";

    public Employee(String userName) 
    {
        super(userName);
    }

    public static boolean validPIN(String pin) 
    {
        return PIN.equals(pin);
    }
}

