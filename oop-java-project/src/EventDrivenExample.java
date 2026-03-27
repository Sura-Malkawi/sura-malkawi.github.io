package part2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDrivenExample 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Factorial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLayout(null);

        JTextField numberField = new JTextField();
        numberField.setBounds(150, 20, 100, 25);

        JButton calculateButton = new JButton("Calculate Factorial");
        calculateButton.setBounds(75, 60, 150, 25);

        JLabel resultLabel = new JLabel("Result will be displayed here");
        resultLabel.setBounds(50, 100, 200, 25);

        frame.add(new JLabel("Enter a number:")).
        setBounds(50, 20, 100, 25);
        frame.add(numberField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String input = numberField.getText();
                boolean isValid = true;
                
                if (input == null || input.isEmpty()) 
                {
                    isValid = false;
                } 
                else 
                {
                    for (int i = 0; i < input.length(); i++) 
                    {
                        if (!Character.isDigit(input.charAt(i))) 
                        {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (isValid)
                {
                    int number = Integer.parseInt(input);
                    int result = 1;

                    for (int i = 1; i <= number; i++) 
                    {
                        result *= i;
                    }
                    
                    resultLabel.setText("Factorial of " + number + " is: " + result);
                }
                else
                {
                    resultLabel.setText("Please enter a valid integer");
                }
            }
        });
    }
}
