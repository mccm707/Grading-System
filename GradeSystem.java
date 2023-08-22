import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GradeSystem {
	
	static JTextField t;
	static JFrame f;
	static JButton b;
	static JLabel l;
	static JTextField j;
	static JTextField m;
	static JTextField u;
	static JTextField x;
	static JTextField y;
	static JTextField z;
	static JLabel a;
	static JLabel labelResult;
	static JTextField c; // first name
	static JTextField d; // last name

	public static void main(String[] args) throws SQLException {
		
		{
			JPanel panel = new JPanel();
			JFrame window = new JFrame();
			window.setContentPane(panel);
			
			JFrame frame = new JFrame();  
	    
	        JLabel label = new JLabel("Student Grading System");
	        JButton submit = new JButton("Calculate");
	        JLabel label0 = new JLabel("                           ");
	        JLabel first_name = new JLabel("Enter your first name: ");
	        f = new JFrame("textfield");
	        c = new JTextField("", 6);
	        JLabel last_name = new JLabel("Enter your last name: ");
	        f = new JFrame("textfield");
	        d = new JTextField("", 6);
	        JLabel label1 = new JLabel("Grade in Subject 1: ");
	        f = new JFrame("textfield");
	        t = new JTextField("", 2);
	        JLabel label2 = new JLabel("Grade in Subject 2: ");
	        f = new JFrame("textfield");
	        j = new JTextField("", 2);
	        JLabel label3 = new JLabel("Grade in Subject 3: ");
	        f = new JFrame("textfield");
	        m = new JTextField("", 2);
	        JLabel label4 = new JLabel("Grade in Subject 4: ");
	        f = new JFrame("textfield");
	        u = new JTextField("", 2);
	        JLabel label5 = new JLabel("Grade in Subject 5:");
	        f = new JFrame("textfield");
	        x = new JTextField("", 2);
	        JLabel label6 = new JLabel("Grade in Subject 6:");
	        f = new JFrame("textfield");
	        y = new JTextField("", 2);
	        JLabel label7 = new JLabel("Grade in Subject 7:");
	        f = new JFrame("textfield");
	        z = new JTextField("", 2);
	        JLabel label01 = new JLabel("                                      ");
	        submit.setActionCommand("input1");
			JLabel labelFinal = new JLabel("Grade: " + "");
	        
	        submit.addActionListener( new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if ("input1".equals(e.getActionCommand())) {
	            		            		
	            		
	            		String firstName = c.getText();
	            		String lastName = d.getText();
	            		int b;
	            		b = Integer.parseInt(t.getText());
	            		int c;
	            		c = Integer.parseInt(j.getText());
	            		int d;
	            		d = Integer.parseInt(m.getText());
	            		int g;
	            		g = Integer.parseInt(u.getText());
	            		int h;
	            		h = Integer.parseInt(x.getText());
	            		int i;
	            		i = Integer.parseInt(y.getText());
	            		int k;
	            		k = Integer.parseInt(z.getText());
	            		int result;
	            		result = (b + c + d + g + h + i + k)/7;
	            		System.out.println(result);
	            		labelResult = new JLabel("Test");
	            		
	            		
	            		if(result>=90) {
	            			labelResult.setText("Your overall grade is an: A");
	            		}
	            		else if(result>=80 && result<90) {
	            			labelResult.setText("Your overall grade is a: B");
	            		}
	            		else if(result>=70 && result<80) {
	            			labelResult.setText("Your overall grade is a: C");
	            		}
	            		else if(result>=60 && result<70) {
	            			labelResult.setText("Your overall grade is a: D");
	            		}
	            		else if(result<60){
	            			labelResult.setText("Your overall grade is an: E");
	            		}
	            		
	            		panel.add(labelResult);
	            		labelResult.setVisible(true);
	            		frame.setSize(220, 405);
	            		String url = "jdbc:mysql://localhost:3306/mydb";
	            		String user = "root";
	            		String password = "JmN$890nop56#";
	            		// 1) Create a connection
	            		try {
	            			Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection(url, user, password);
							
							// 2) Create the statement
							Statement statement = con.createStatement();
							
							String s = "INSERT INTO grades (first_name, last_name, grade) VALUES ('" + firstName + "', '" + lastName + "', " + result + ");";
							
							// 3) Execute the statement
							statement.execute(s);
							System.out.println("Executing query...");
							// 4) Close the connection
							con.close();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
	            		
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            }
	        }});
	        
	        panel.add(label);
	        panel.add(label0);
	        panel.add(first_name);
	        panel.add(c);
	        panel.add(last_name);
	        panel.add(d);
	        panel.add(label1);
	        panel.add(t);
	        panel.add(label2);
	        panel.add(j);
	        panel.add(label3);
	        panel.add(m);
	        panel.add(label4);
	        panel.add(u);
	        panel.add(label5);
	        panel.add(x);
	        panel.add(label6);
	        panel.add(y);
	        panel.add(label7);
	        panel.add(z);
	        panel.add(label01);
	        panel.add(submit);
	        
	        
	        frame.add(panel);  
	        frame.setSize(220, 400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.setVisible(true);
			
		}
		
	}
		
}