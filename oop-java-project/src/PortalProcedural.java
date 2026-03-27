package part2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortalProcedural 
{

    private static List<String[]> availableCourses = new ArrayList<>();
    private static List<String[]> employeeAddCourses = new ArrayList<>();
    private static List<String[]> studentSchedule = new ArrayList<>();
    private static String userName;
    public static void main(String[] args) 
    {
        initializeCourses();

        String userType;
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
                scanner.nextLine();

                showAvailableCourses();
                manageUserCourses(scanner);
                break;
            } 
            else if (userType.equalsIgnoreCase("Employee"))
            {
                System.out.print("Enter your name: ");
                userName = scanner.nextLine();

                System.out.print("Enter a valid PIN: ");
                String pin = scanner.nextLine();

                if (validPIN(pin)) 
                {
                    manageEmployeeCourses(scanner);
                    displayEmployeeAddedCourses();
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

    private static void initializeCourses()
    {
        availableCourses.add(new String[]{"Functional Math", "30303111", "1", "W-128", "Sunday and Wednesday 8:30 - 10:00"});
        availableCourses.add(new String[]{"Functional Math", "30303111", "2", "W-128", "Sunday and Wednesday 10:00 - 11:30"});
        availableCourses.add(new String[]{"English Intermediate", "30301122", "2", "W-109", "Sunday and Wednesday 10:00 - 11:30"});
        availableCourses.add(new String[]{"Programming", "40201100", "11", "S-209", "Saturday 8:30 - 11:30"});
        availableCourses.add(new String[]{"Networking", "10203180", "14", "S-212", "Saturday and Tuesday 1:30 - 3:30"});
    }

    private static void manageUserCourses(Scanner scanner)
    {
        String response;

        while (true)
        {
            System.out.println("Do you want to add a course to your schedule? (yes/no)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) 
            {
                addCourseToUserSchedule(scanner);
            }
            else if (response.equalsIgnoreCase("no")) 
            {
                displaySchedule();
                break;
            } 
            else
            {
                System.out.println("Invalid response! Please answer 'yes' or 'no'.");
            }
        }
    }

    private static void addCourseToUserSchedule(Scanner scanner)
    {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        List<String[]> courses = findCoursesByName(courseName);
        if (!courses.isEmpty())
        {
            System.out.println("Available sections:");
            for (String[] course : courses) 
            {
                System.out.println(formatCourse(course));
            }
            System.out.print("Enter the section number you want to add: ");
            int sectionNumber = Integer.parseInt(scanner.nextLine());

            String[] selectedCourse = null;
            for (String[] course : courses) 
            {
                if (Integer.parseInt(course[2]) == sectionNumber) 
                {
                    selectedCourse = course;
                    break;
                }
            }
            if (selectedCourse != null) 
            {
                studentSchedule.add(selectedCourse);
                System.out.println("Course added to your schedule.");
            }
        } 
        else
        {
            System.out.println("Course not found.");
        }
    }

    private static void manageEmployeeCourses(Scanner scanner)
    {
        String response;

        while (true) 
        {
            System.out.println("Do you want to add a new course? (yes/no)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes"))
            {
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();

                System.out.print("Enter course number: ");
                String courseNumber = scanner.nextLine();

                System.out.print("Enter section: ");
                int courseSection = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter location: ");
                String courseLocation = scanner.nextLine();

                System.out.print("Enter time: ");
                String courseTime = scanner.nextLine();

                String[] newCourse = new String[]{courseName, courseNumber, String.valueOf(courseSection), courseLocation, courseTime};

                availableCourses.add(newCourse);
                employeeAddCourses.add(newCourse);
                System.out.println("Course added successfully!");
            } 
            else if (response.equalsIgnoreCase("no")) 
            {
                break;
            } else 
            {
                System.out.println("Invalid response! Please answer 'yes' or 'no'.");
            }
        }
    }

    private static void displayEmployeeAddedCourses() 
    {
        if (employeeAddCourses.isEmpty())
        {
            System.out.println(userName + " has not added any courses.");
        } 
        else 
        {
            System.out.println("Courses added by " + userName + ":");
            for (String[] course : employeeAddCourses)
            {
                System.out.println(formatCourse(course));
            }
        }
    }

    private static void showAvailableCourses()
    {
        System.out.println("Available courses:");
        for (String[] course : availableCourses)
        {
            System.out.println(formatCourse(course));
        }
    }

    private static List<String[]> findCoursesByName(String courseName) {
        List<String[]> foundCourses = new ArrayList<>();
        for (String[] course : availableCourses)
        {
            if (course[0].equalsIgnoreCase(courseName)) 
            {
                foundCourses.add(course);
            }
        }
        return foundCourses;
    }

    private static void displaySchedule()
    {
        if (studentSchedule.isEmpty())
        {
            System.out.println(userName + " has no courses in the schedule.");
        } 
        else
        {
            System.out.println(userName + "'s schedule:");
            for (String[] course : studentSchedule)
            {
                System.out.println(formatCourse(course));
            }
        }
    }

    private static boolean validPIN(String pin) 
    {
        return "htu123".equals(pin);
    }

    private static String formatCourse(String[] course)
    {
        return course[0] + " (" + course[1] + "), Section " + course[2] + ", Location: " + course[3] + ", Time: " + course[4];
    }
}
