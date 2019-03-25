import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

public class Cancellation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancellation frame = new Cancellation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username1 
	 */
	int tp;
	Connection connection=null;
	public Cancellation(String username1) {
		final Connection connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBill = new JLabel(" Bill : ");
		lblBill.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBill.setBounds(82, 87, 60, 13);
		contentPane.add(lblBill);
		
		
		try {
			String sql="Select TotalPrice from user_data where username='"+username1+"'";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet res=pstmt.executeQuery();
			tp=res.getInt(1);
			connection.close();
			
			
		}
		catch(Exception en)
		{
			en.printStackTrace();
		}
		textField = new JTextField();
		textField.setBounds(197, 84, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		String pp=Integer.toString(tp/2);
		textField.setText(pp);
		textField.setEditable(false);
		JLabel lblBookingCancelled = new JLabel("Booking Cancelled");
		lblBookingCancelled.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBookingCancelled.setBounds(119, 22, 251, 22);
		contentPane.add(lblBookingCancelled);
		
		JLabel lblHopeToSee = new JLabel("Hope to see you again :):)");
		lblHopeToSee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHopeToSee.setBounds(96, 180, 296, 22);
		contentPane.add(lblHopeToSee);
	}

}
