package part2;

import java.util.ArrayList;
import java.util.List;

public class User 
{
    protected String userName;
    protected List<Course> schedule = new ArrayList<>();

    public User(String userName) 
    {
        this.userName = userName;
    }

    public void addCourse(Course course) 
    {
        schedule.add(course);
    }

    public void displaySchedule() 
    {
        if (schedule.isEmpty()) 
        {
            System.out.println(userName + " has no courses in the schedule.");
        } 
        else
        {
            System.out.println(userName + "'s schedule:");
            for (Course course : schedule) 
            {
                System.out.println(course);
            }
        }
    }

    public String getName() 
    {
        return userName;
    }
}
