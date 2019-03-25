import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

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
		setForeground(Color.CYAN);
		connection=sqliteConnection.dbConnector();
		setTitle("Login Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 300);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(SystemColor.activeCaption);
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
				try {int check=0;
					if(User_Check.getText().trim().isEmpty()||password_check.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Entries cant be empty");
						//btnNewButton.setEnabled(b);
						check=1;
					}
					if(check==0)
					{
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
					{	String person=User_Check.getText();
						//JOptionPane.showMessageDialog(null,person);
						String sql = "SELECT numberofrooms FROM user_data WHERE username='"+person+"'";
						try {
							PreparedStatement pstmt = connection.prepareStatement(sql);
							int flag=0;
							ResultSet rs1  = pstmt.executeQuery();
							//JOptionPane.showMessageDialog(null, "Yas");
							//JOptionPane.showMessageDialog(null, rs1.getInt("numberofrooms"));
							//System.out.println(rs1.getInt("numberofrooms"));
							if(rs1.getInt("numberofrooms")>=1)
							{
								Modify m=new Modify(User_Check.getText(),password_check.getText());
								m.setVisible(true);
							}
							else
							{
							Hotel_Checker hc=new Hotel_Checker(User_Check.getText());
							hc.setVisible(true);
							}	
							
								
							
							
						}
						catch (Exception en) {
							en.printStackTrace();
					}
						
						//JOptionPane.showMessageDialog(null, "Username and password is correct");
						//Hotel_Checker hc=new Hotel_Checker(User_Check.getText(),password_check.getText());
						//hc.setVisible(true);
					}
					if(count!=1)
					{
						JOptionPane.showMessageDialog(null, "Username and password is incorrect. Please signup");
						
						
					}
					rs.close();
					pst.close();
					connection.close();
					}
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