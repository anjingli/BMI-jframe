/*
 * Name: Anjing Li 
 * Date: July 29, 2019.
 * Title: U2A5BMI
 * Purpose: Calculate a person's BMI in either imperial or metric
 */

package u2a8ali;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class U2A8BMI extends JFrame implements ActionListener {

    // State components necessary
    JLabel lblTitle;
    JLabel lblName;
    JTextField txtName = new JTextField();  // Avoids NullPointerException in ActionListener
    JLabel lblMeasurement;
    JLabel lblMeasurementChoice;
    JTextField txtMeasurement = new JTextField();  // Avoids NullPointerException in ActionListener
    JLabel lblHeight;
    JLabel lblHeightChoice;
    JTextField txtHeight = new JTextField();  // Avoids NullPointerException in ActionListener
    JButton btnCalculate;
    JLabel lblWeight = new JLabel();  // Avoids NullPointerException in ActionListener
 
    // Constructor
    public U2A8BMI() {

        super("Ideal Weight Calculator");
        setLayout(null);
        getContentPane().setBackground(Color.PINK);  // Makes background pink
        
        // Intitialize all components
        JLabel lblTitle = new JLabel("Ideal Weight Calculator");      // Title
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(Color.BLACK);

        JLabel lblName = new JLabel("Name:");  // Prompt
        lblName.setFont(new Font("Arial", Font.BOLD, 15));

        txtName.setText("");              // Input amount of purchases
        
        JLabel lblMeasurement = new JLabel("System of Measure:");  // Prompt
        lblMeasurement.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel lblMeasurementChoice = new JLabel("(M)etric or (I)mperial");  // Prompt
        lblMeasurementChoice.setFont(new Font("Arial", Font.PLAIN, 15));

        txtMeasurement.setText("");              // Input amount of purchases
        
        JLabel lblHeight = new JLabel("Height:");  // Prompt
        lblHeight.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel lblHeightChoice = new JLabel("metres or inches");  // Prompt
        lblHeightChoice.setFont(new Font("Arial", Font.PLAIN, 15));

        txtHeight.setText("");              // Input amount of purchases

        JButton btnCalculate = new JButton("Calculate");        // Calculate button
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 10));
        btnCalculate.setActionCommand("Calculate");
        btnCalculate.addActionListener(this);

        lblWeight.setFont(new Font("Arial", Font.BOLD, 15));     // Discount amount output
        lblWeight.setForeground(Color.RED);  // Set colour of font to red
        lblWeight.setText("");

        // Set size and locations
        lblTitle.setSize(400, 50);
        lblTitle.setLocation(80, 20);

        lblName.setSize(500, 50);
        lblName.setLocation(100, 90);

        txtName.setSize(100, 30);
        txtName.setLocation(290, 100);
        
        lblMeasurement.setSize(500, 50);
        lblMeasurement.setLocation(100, 150);

        lblMeasurementChoice.setSize(500, 50);
        lblMeasurementChoice.setLocation(100, 180);
        
        txtMeasurement.setSize(100, 30);
        txtMeasurement.setLocation(290, 160);
        
        lblHeight.setSize(500, 50);
        lblHeight.setLocation(100, 230);

        lblHeightChoice.setSize(500, 50);
        lblHeightChoice.setLocation(100, 260);
        
        txtHeight.setSize(100, 30);
        txtHeight.setLocation(290, 240);

        btnCalculate.setSize(90, 20);
        btnCalculate.setLocation(295, 320);

        lblWeight.setSize(500, 50);
        lblWeight.setLocation(100, 360);

        // Add to frame
        add(lblTitle);
        add(lblName);
        add(txtName);
        add(lblMeasurement);
        add(lblMeasurementChoice);
        add(txtMeasurement);
        add(lblHeight);
        add(lblHeightChoice);
        add(txtHeight);
        add(btnCalculate);
        add(lblWeight);

        // Configure window
        pack();
        setSize (500, 500);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // Closes when x is pressed
        setLocationRelativeTo (null);
        setResizable(false);   // Not resizable window
    }

    // Action listener
    public void actionPerformed(ActionEvent e) {  
        if(e.getActionCommand().equals("Calculate")){
            // Declare variables
            String strName, strMeasurement; 
            double dblHeight, dblWeight;

            // Assign variables and convert from String to double
            strName = txtName.getText();
            strMeasurement = txtMeasurement.getText();
            dblHeight = Double.parseDouble(txtHeight.getText());
            
            // Decimal format
            DecimalFormat x = new DecimalFormat("0.00");

            // Calculate and display output in decimal format with an if statement
            if (strMeasurement.equals("M")) 
            {
                dblWeight = dblHeight * dblHeight * 25;
                lblWeight.setText(strName + "'s ideal weight is " + x.format(dblWeight) + " kgs.");
            }
            else if (strMeasurement.equals("I"))
            {    
                dblWeight = (dblHeight * dblHeight * 25) / 703; 
                lblWeight.setText(strName + "'s ideal weight is " + x.format(dblWeight) + " lbs.");
            }    
            else 
            {
                lblWeight.setText("Please enter either metric (M) or imperial (I).");
            }    
        }
    }
     
    // Main method (tester) 
    public static void main( String[] args ) {
       U2A8BMI myFrame = new U2A8BMI();        
       myFrame.setVisible(true);
    } 
}
