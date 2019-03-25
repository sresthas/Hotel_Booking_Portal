import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Confirmation extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmation frame = new Confirmation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @param price 
	 * @param person 
	 */
	public Confirmation(String person, int price) {
		getContentPane().setForeground(SystemColor.activeCaption);
		//contentPane.setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblBookingConfirmed = new JLabel("Booking Confirmed");
		lblBookingConfirmed.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
		lblBookingConfirmed.setBounds(129, 34, 217, 32);
		getContentPane().add(lblBookingConfirmed);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTotalPrice.setBounds(88, 120, 152, 16);
		getContentPane().add(lblTotalPrice);
		
		JLabel lblReferenceNo = new JLabel("Reference No.");
		lblReferenceNo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReferenceNo.setBounds(88, 176, 158, 16);
		getContentPane().add(lblReferenceNo);
		
		JLabel lblWeWishFor = new JLabel("We wish for your happy stay!!");
		lblWeWishFor.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblWeWishFor.setBounds(88, 205, 258, 35);
		getContentPane().add(lblWeWishFor);
		
		textField = new JTextField();
		textField.setBounds(254, 119, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		String x=Integer.toString(price);
		textField.setText(x);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 175, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		String y=person+"000111";
		textField_1.setText(y);
		textField_1.setEditable(false);
	}

}
