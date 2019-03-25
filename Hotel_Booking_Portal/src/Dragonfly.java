import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dragonfly extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dragonfly frame = new Dragonfly();
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
	public Dragonfly() {
		setTitle("DragonFly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumberOfRooms = new JLabel("Number of rooms Available:");
		lblNumberOfRooms.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNumberOfRooms.setBounds(55, 55, 212, 14);
		contentPane.add(lblNumberOfRooms);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(329, 54, 42, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmenitiesAvailable = new JLabel("Amenities Available:");
		lblAmenitiesAvailable.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblAmenitiesAvailable.setBounds(55, 124, 189, 14);
		contentPane.add(lblAmenitiesAvailable);
		
		JLabel lblNewLabel = new JLabel(" Air Conditioner");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\air-conditioner (1).png"));
		lblNewLabel.setBounds(55, 162, 130, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Complementary Breakfast");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\coffee-cup (1).png"));
		lblNewLabel_1.setBounds(55, 197, 189, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Card Payment");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\credit-cards-payment.png"));
		lblNewLabel_2.setBounds(55, 232, 114, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" TV");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\monitor.png"));
		lblNewLabel_3.setBounds(55, 267, 74, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Parking and Rental");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\parking.png"));
		lblNewLabel_4.setBounds(55, 302, 144, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" Toiletries");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\shampoo.png"));
		lblNewLabel_5.setBounds(329, 162, 92, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" Spa");
		lblNewLabel_6.setEnabled(false);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\massage-spa-body-treatment.png"));
		lblNewLabel_6.setBounds(329, 197, 74, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(" Laundry");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\washing-machine.png"));
		lblNewLabel_7.setBounds(329, 232, 92, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(" Wifi");
		lblNewLabel_8.setEnabled(false);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\wifi-connection-signal-symbol.png"));
		lblNewLabel_8.setBounds(329, 267, 74, 24);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(" Geyser");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\water-heater.png"));
		lblNewLabel_9.setBounds(329, 302, 92, 24);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Book Now");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(329, 409, 152, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNumberOfFeedbacks = new JButton("Ratings and Feedback");
		btnNumberOfFeedbacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNumberOfFeedbacks.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		btnNumberOfFeedbacks.setBounds(10, 409, 175, 36);
		contentPane.add(btnNumberOfFeedbacks);
		
		JLabel lblNewLabel_10 = new JLabel("Total Price:");
		lblNewLabel_10.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(303, 378, 130, 20);
		contentPane.add(lblNewLabel_10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(399, 378, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
