package part2;

public class Course
{
    private String courseName;
    private String courseNumber;
    private int courseSection;
    private String courseLocation;
    private String courseTime;

    public Course(String courseName, String courseNumber, int courseSection, String courseLocation, String courseTime) 
    {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseSection = courseSection;
        this.courseLocation = courseLocation;
        this.courseTime = courseTime;
    }

    public String getName() 
    {
        return courseName;
    }

    public String getNumber() 
    {
        return courseNumber;
    }

    public int getSection() 
    {
        return courseSection;
    }

    @Override
    public String toString() 
    {
        return courseName + " (" + courseNumber + "), Section " + courseSection + ", Location: " + courseLocation + ", Time: " + courseTime;
    }
}
