package part2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EventDrivenPortal 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("HTU Portal");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        JLabel label = new JLabel("Welcome to HTU Portal!");
        label.setBounds(100, 20, 200, 50);
        frame.add(label);
        
        JCheckBox studentCheckBox = new JCheckBox("Student");
        studentCheckBox.setBounds(100, 80, 150, 50);

        JCheckBox employeeCheckBox = new JCheckBox("Employee");
        employeeCheckBox.setBounds(100, 140, 150, 50);
        
        ButtonGroup group = new ButtonGroup();
        group.add(studentCheckBox);
        group.add(employeeCheckBox);

        frame.add(studentCheckBox);
        frame.add(employeeCheckBox);
        
        frame.setLayout(null);
        
        studentCheckBox.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new StudentPortal().showLogin();
            }
        });

        employeeCheckBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeePortal().showLogin();
            }
        });
    }
}

class PortalEventDrieven
{
    public JFrame frame;
    public List<Course> courses;
    
    public PortalEventDrieven(String title)
    {
        frame = new JFrame(title);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        courses = new ArrayList<>();
    }
    
    public JTextField createTextField(String labelText, int yPos)
    {
        JLabel label = new JLabel(labelText);
        label.setBounds(10, yPos, 100, 25);
        frame.add(label);

        JTextField textField = new JTextField(20);
        textField.setBounds(120, yPos, 165, 25);
        frame.add(textField);

        return textField;
    }

    public void clearTextFields(List<JTextField> textFields) 
    {
    	for (JTextField textField : textFields) 
        {
    		textField.setText("");
        }
}

     public void showSchedule(List<Course> coursesToShow)
     {
    	 frame.getContentPane().removeAll();
         frame.repaint();
         JLabel scheduleLabel = new JLabel("Schedule:");
         scheduleLabel.setBounds(10, 20, 250, 25);
         frame.add(scheduleLabel);

         JTextArea scheduleArea = new JTextArea();
         scheduleArea.setBounds(10, 50, 560, 500);
    
         for (Course course : coursesToShow) 
         {
        	 scheduleArea.append(course.toString() + "\n");
         }
         frame.add(scheduleArea);
     }
}

class StudentPortal extends PortalEventDrieven
{
    public StudentPortal() 
    {
        super("HTU Student Portal");
        initializeCourses();
    }

    private void initializeCourses() 
    {
        courses.add(new Course("Functional Math", "30303111", 1, "W-128", "Sunday and Wednesday 8:30 - 10:00"));
        courses.add(new Course("Functional Math", "30303111", 2, "W-128", "Sunday and Wednesday 10:00 - 11:30"));
        courses.add(new Course("English Intermediate", "30301122", 2, "W-109", "Sunday and Wednesday 10:00 - 11:30"));
        courses.add(new Course("Programming", "40201100", 11, "S-209", "Saturday 8:30 - 11:30"));
        courses.add(new Course("Networking", "10203180", 14, "S-212", "Saturday and Tuesday 1:30 - 3:30"));
    }

    public void showLogin() 
    {
        frame.setVisible(true);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 20, 80, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField(20);
        idField.setBounds(100, 20, 165, 25);
        frame.add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 60, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 60, 165, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        frame.add(loginButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 140, 255, 25);
        frame.add(resultLabel);

        loginButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String password = new String(passwordField.getPassword());
                if (password.equals("htu123"))
                {
                    resultLabel.setText("Login successful!");
                    showCourseSelection();
                } 
                else
                {
                    resultLabel.setText("Invalid password, try again.");
                }
            }
        });
    }

    private void showCourseSelection() 
    {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel courseInfoLabel = new JLabel("Available Courses:");
        courseInfoLabel.setBounds(10, 20, 250, 25);
        frame.add(courseInfoLabel);

        int yPosition = 50;
        for (Course course : courses) 
        {
            JCheckBox courseCheckBox = new JCheckBox(course.toString());
            courseCheckBox.setBounds(10, yPosition, 560, 25);
            frame.add(courseCheckBox);
            yPosition += 30;
        }

        JButton finishButton = new JButton("Finish");
        finishButton.setBounds(10, yPosition, 120, 25);
        frame.add(finishButton);

        finishButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showStudentSchedule();
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    private void showStudentSchedule() 
    {
        frame.getContentPane().removeAll();
        frame.repaint();

        JLabel scheduleLabel = new JLabel("Your Schedule:");
        scheduleLabel.setBounds(10, 20, 250, 25);
        frame.add(scheduleLabel);

        JTextArea scheduleArea = new JTextArea();
        scheduleArea.setBounds(10, 50, 560, 500);
        for (Course course : courses)
        {
            scheduleArea.append(course.toString() + "\n");
        }
        frame.add(scheduleArea);
    }
}

class EmployeePortal extends PortalEventDrieven
{
    public EmployeePortal() 
    {
        super("HTU Employee Portal");
    }

    public void showLogin() 
    {
        frame.setVisible(true);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(10, 20, 80, 25);
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        frame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 60, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 60, 165, 25);
        frame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        frame.add(loginButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 140, 255, 25);
        frame.add(resultLabel);

        loginButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String password = new String(passwordField.getPassword());
                if (password.equals("htu123"))
                {
                    resultLabel.setText("Login successful!");
                    showCourseForm();
                }
                else
                {
                    resultLabel.setText("Invalid password, try again.");
                }
            }
        });
    }

    private void showCourseForm() 
    {
        frame.getContentPane().removeAll();
        frame.repaint();
        
        JLabel courseInfoLabel = new JLabel("Please enter course information:");
        courseInfoLabel.setBounds(100, 20, 250, 25);
        frame.add(courseInfoLabel);

        JTextField courseNameField = createTextField("Course Name:", 50);
        JTextField courseNumberField = createTextField("Course Number:", 90);
        JTextField sectionField = createTextField("Section:", 130);
        JTextField locationField = createTextField("Location:", 170);
        JTextField timeField = createTextField("Time:", 210);

        JButton addButton = new JButton("Add Course");
        addButton.setBounds(100, 250, 120, 25);
        frame.add(addButton);

        addButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Course coursse = new Course(courseNameField.getText(), courseNumberField.getText(),
                        sectionField.getText(), locationField.getText(), timeField.getText());
                courses.add((Course) courses);
                List<JTextField> fields = List.of(courseNameField, courseNumberField, sectionField, locationField, timeField);
                clearTextFields(fields);
                JOptionPane.showMessageDialog(frame, "Course added successfully!");
            }
        });

        JButton viewScheduleButton = new JButton("View Schedule");
        viewScheduleButton.setBounds(230, 250, 150, 25);
        frame.add(viewScheduleButton);

        viewScheduleButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                showSchedule(courses);
            }
        });

        frame.revalidate();
        frame.repaint();
    }
}

class Courses
{
    private String courseName;
    private String courseNumber;
    private String section;
    private String location;
    private String time;

    public Courses(String courseName, String courseNumber, String section, String location, String time)
    {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.section = section;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Course Name: " + courseName + ", Course Number: " + courseNumber + ", Section: " + section
                + ", Location: " + location + ", Time: " + time;
    }
}
