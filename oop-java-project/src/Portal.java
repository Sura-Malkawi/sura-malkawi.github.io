package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Portal 
{
    private static List<Course> availableCourses = new ArrayList<>();
    private static List<Course> employeeAddCourses = new ArrayList<>();

    static 
    {
        availableCourses.add(new Course("Functional Math", "30303111", 1, "W-128", "Sunday and Wednesday 8:30 - 10:00"));
        availableCourses.add(new Course("Functional Math", "30303111", 2, "W-128", "Sunday and Wednesday 10:00 - 11:30"));
        availableCourses.add(new Course("English Intermediate", "30301122", 2, "W-109", "Sunday and Wednesday 10:00 - 11:30"));
        availableCourses.add(new Course("Programming", "40201100", 11, "S-209", "Saturday 8:30 - 11:30"));
        availableCourses.add(new Course("Networking", "10203180", 14, "S-212", "Saturday and Tuesday 1:30 - 3:30"));
    }

    public static List<Course> findCoursesByName(String courseName) 
    {
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : availableCourses) 
        {
            if (course.getName().equalsIgnoreCase(courseName)) 
            {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    public static void main(String[] args)
    {
    	String userType;
    	String userName;
    	String studentID;
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the HTU Portal!");

        while (true)
        {
            System.out.println("Are you a Student or an Employee?");
            userType = scanner.nextLine();

            if (userType.equalsIgnoreCase("Student")) 
            {
                System.out.print("Enter your name: ");
                userName = scanner.nextLine();
                
                System.out.print("Enter your ID: ");
                studentID = scanner.nextLine();
                
                Student student = new Student(userName, studentID);
                
                showAvailableCourses();
                manageUserCourses(scanner, student);
                break;
            } 
            else if (userType.equalsIgnoreCase("Employee")) 
            {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter a valid PIN: ");
                String pin = scanner.nextLine();
                
                if (Employee.validPIN(pin)) 
                {
                    Employee employee = new Employee(name);
                    manageEmployeeCourses(scanner, employee);
                    displayEmployeeAddedCourses(name);
                    break;
                } 
                else
                {
                    System.out.println("Invalid PIN! Try again.");
                }
            } 
            else 
            {
                System.out.println("Invalid user type! Try again.");
            }
        }
        scanner.close();
    }

    private static void manageUserCourses(Scanner scanner, User user) 
    {
    	String response;
    	
        while (true) 
        {
            System.out.println("Do you want to add a course to your schedule? (yes/no)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) 
            {
                addCourseToUserSchedule(scanner, user);
            } 
            else if (response.equalsIgnoreCase("no"))
            {
                user.displaySchedule();
                break;
            }
            else
            {
                System.out.println("Invalid response! Please answer 'yes' or 'no'.");
            }
        }
    }

    private static void addCourseToUserSchedule(Scanner scanner, User user) 
    {
    	String courseName;
        System.out.print("Enter course name: ");
        courseName = scanner.nextLine();
        
        List<Course> courses = findCoursesByName(courseName);
        if (!courses.isEmpty()) 
        {
            System.out.println("Available sections:");
            for (Course course : courses) 
            {
                System.out.println(course);
            }
            System.out.print("Enter the section number you want to add: ");
            int sectionNumber = Integer.parseInt(scanner.nextLine());

            Course selectedCourse = null;
            for (Course course : courses) 
            {
                if (course.getSection() == sectionNumber) 
                {
                    selectedCourse = course;
                    break;
                }
            }
            if (selectedCourse != null) 
            {
                user.addCourse(selectedCourse);
                System.out.println("Course added to your schedule.");
            } 
        }
        else 
        {
            System.out.println("Course not found.");
        }
    }

    private static void manageEmployeeCourses(Scanner scanner, Employee employee) 
    {
    	String response;
    	String courseName;
    	String courseNumber;
    	int courseSection;
    	String courseLocation;
    	String courseTime;
    	
        while (true) 
        {
            System.out.println("Do you want to add a new course? (yes/no)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) 
            {
                System.out.print("Enter course name: ");
                courseName = scanner.nextLine();
                
                System.out.print("Enter course number: ");
                courseNumber = scanner.nextLine();
                
                System.out.print("Enter section: ");
                courseSection = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Enter location: ");
                courseLocation = scanner.nextLine();
                
                System.out.print("Enter time: ");
                courseTime = scanner.nextLine();

                Course newCourse = new Course(courseName, courseNumber, courseSection, courseLocation, courseTime);
                
                availableCourses.add(newCourse);
                employeeAddCourses.add(newCourse);
                System.out.println("Course added successfully!");
            } 
            else if (response.equalsIgnoreCase("no")) 
            {
                break;
            } 
            else 
            {
                System.out.println("Invalid response! Please answer 'yes' or 'no'.");
            }
        }
    }

    private static void displayEmployeeAddedCourses(String employeeName) 
    {
        if (employeeAddCourses.isEmpty()) 
        {
            System.out.println(employeeName + " has not added any courses.");
        } 
        else 
        {
            System.out.println("Courses added by " + employeeName + ":");
            for (Course course : employeeAddCourses) 
            {
                System.out.println(course);
            }
        }
    }

    private static void showAvailableCourses()
    {
        System.out.println("Available courses:");
        for (Course course : availableCourses) 
        {
            System.out.println(course);
        }
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
