package part2;

public class Student extends User 
{
    private String studentID;

    public Student(String userName, String studentID) 
    {
        super(userName);
        this.studentID = studentID;
    }

    public String getId() 
    {
        return studentID;
    }
}
