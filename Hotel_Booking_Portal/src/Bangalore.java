import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Bangalore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bangalore frame = new Bangalore();
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
	public Bangalore(final String person,final String checkin,final String checkout,final String rooms,final long days) {
		setTitle("Bangalore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 0, 0)));
		panel.setBounds(30, 15, 283, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 283, 176);
		panel.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\hyatt.jpg"));
		
		JButton btnNewButton = new JButton("Hyatt");
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hyatt hyatt=new Hyatt(person,checkin,checkout,rooms,days);
				hyatt.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 187, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u20B9 12,000");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(182, 191, 75, 14);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 102, 102));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 0, 0)));
		panel_1.setBounds(401, 11, 283, 217);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\Webp.net-resizeimage.jpg"));
		label_1.setBounds(0, 0, 278, 179);
		panel_1.add(label_1);
		
		JButton btnWestern = new JButton("Western");
		btnWestern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Western western=new Western();
				western.setVisible(true);
			}
		});
		btnWestern.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnWestern.setBounds(10, 187, 138, 23);
		panel_1.add(btnWestern);
		
		JLabel label_2 = new JLabel("\u20B9 8,000");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(182, 191, 75, 14);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 255, 102));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 0, 0)));
		panel_2.setBounds(30, 269, 283, 217);
		contentPane.add(panel_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\oberoi.jpg"));
		label_3.setBounds(0, 0, 275, 183);
		panel_2.add(label_3);
		
		JButton btnOberoiVilla = new JButton("Oberoi Villa");
		btnOberoiVilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberoi_Villa oberoivilla=new Oberoi_Villa();
				oberoivilla.setVisible(true);
				
			}
		});
		btnOberoiVilla.setHorizontalAlignment(SwingConstants.LEFT);
		btnOberoiVilla.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnOberoiVilla.setBounds(10, 187, 160, 23);
		panel_2.add(btnOberoiVilla);
		
		JLabel label_4 = new JLabel("\u20B9 3,500");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(182, 191, 75, 14);
		panel_2.add(label_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 51));
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(204, 0, 0)));
		panel_3.setBounds(401, 269, 283, 217);
		contentPane.add(panel_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\Webp.net-resizeimage (1).jpg"));
		label_5.setBounds(0, 0, 273, 179);
		panel_3.add(label_5);
		
		JButton btnRenaissance = new JButton("Renaissance");
		btnRenaissance.setHorizontalAlignment(SwingConstants.LEFT);
		btnRenaissance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Renaissance renaissance =new Renaissance();
				renaissance.setVisible(true); 
			}
		});
		btnRenaissance.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnRenaissance.setBounds(10, 187, 160, 23);
		panel_3.add(btnRenaissance);
		
		JLabel label_6 = new JLabel("\u20B9 4,500");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(182, 191, 75, 14);
		panel_3.add(label_6);
	}
}