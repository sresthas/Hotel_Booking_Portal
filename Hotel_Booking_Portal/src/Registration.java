import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.JPasswordField;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField User_Check;
	private JLabel lblNewLabel;
	private JTextField textField_1;
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
		User_Check.setBounds(200, 90, 114, 23);
		contentPane.add(User_Check);
		User_Check.setColumns(10);
		
		lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 147, 127, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Montserrat", Font.PLAIN, 14));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setBounds(59, 206, 89, 23);
		contentPane.add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Montserrat", Font.PLAIN, 14));
		btnSignUp.setBounds(200, 206, 89, 23);
		contentPane.add(btnSignUp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 208, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginPage.setBounds(35, 23, 161, 29);
		contentPane.add(lblLoginPage);
		
		password_check = new JPasswordField();
		password_check.setBounds(201, 151, 113, 20);
		contentPane.add(password_check);
	}
}
