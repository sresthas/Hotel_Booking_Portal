import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField User_Check;
	private JLabel lblNewLabel;
	private JPasswordField password_check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection=null;
	public Registration() {
		connection=sqliteConnection.dbConnector();
		setTitle("Login Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 18));
		lblUsername.setBounds(47, 84, 143, 29);
		contentPane.add(lblUsername);
		
		User_Check = new JTextField();
		User_Check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		User_Check.setBounds(200, 90, 114, 23);
		contentPane.add(User_Check);
		User_Check.setColumns(10);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 147, 127, 23);
		contentPane.add(lblNewLabel);
		
		
		
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regis reg=new Regis();
				reg.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Montserrat", Font.PLAIN, 14));
		btnSignUp.setBounds(200, 206, 89, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginPage.setBounds(35, 23, 161, 29);
		contentPane.add(lblLoginPage);
		
		password_check = new JPasswordField();
		password_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		password_check.setBounds(201, 151, 113, 20);
		contentPane.add(password_check);
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Montserrat", Font.PLAIN, 14));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from user_data where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, User_Check.getText());
					pst.setString(2, password_check.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count=count+1;
						
					}
					if(count==1)
					{
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password is incorrect. Please signup");
						
						
					}
					rs.close();
					pst.close();
				}
				catch(Exception en)
				{
					JOptionPane.showMessageDialog(null,en);
				}
				
			}
		});
		btnSignIn.setBounds(59, 206, 89, 23);
		contentPane.add(btnSignIn);
	}
}
