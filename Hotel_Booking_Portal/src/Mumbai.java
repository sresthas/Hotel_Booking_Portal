import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Mumbai extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mumbai frame = new Mumbai();
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
	public Mumbai() {
		setTitle("Mumbai");
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
		label.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\download.jpg"));
		
		JButton btnNewButton = new JButton("Sahara Star");
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Saharastar saharastar=new Saharastar();
				saharastar.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 187, 163, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u20B9 5,000");
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
		label_1.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\Webp.net-resizeimage (5).jpg"));
		label_1.setBounds(0, 0, 278, 179);
		panel_1.add(label_1);
		
		JButton btnWestern = new JButton("Summergreen");
		btnWestern.setHorizontalAlignment(SwingConstants.LEFT);
		btnWestern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Summer_Green sg=new Summer_Green();
				sg.setVisible(true);
			}
		});
		btnWestern.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnWestern.setBounds(10, 187, 160, 23);
		panel_1.add(btnWestern);
		
		JLabel label_2 = new JLabel("\u20B9 15,000");
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
		label_3.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\Webp.net-resizeimage (6).jpg"));
		label_3.setBounds(0, 0, 275, 183);
		panel_2.add(label_3);
		
		JButton btnOberoiVilla = new JButton("Four Seasons");
		btnOberoiVilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FourSeasons fs=new FourSeasons();
				fs.setVisible(true);
			}
		});
		btnOberoiVilla.setHorizontalAlignment(SwingConstants.LEFT);
		btnOberoiVilla.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnOberoiVilla.setBounds(10, 187, 164, 23);
		panel_2.add(btnOberoiVilla);
		
		JLabel label_4 = new JLabel("\u20B9 4,500");
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
		label_5.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\Webp.net-resizeimage (7).jpg"));
		label_5.setBounds(0, 0, 273, 179);
		panel_3.add(label_5);
		
		JButton btnRenaissance = new JButton("Dragon Fly");
		btnRenaissance.setHorizontalAlignment(SwingConstants.LEFT);
		btnRenaissance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dragonfly df=new Dragonfly();
				df.setVisible(true);
			}
		});
		btnRenaissance.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnRenaissance.setBounds(10, 187, 162, 23);
		panel_3.add(btnRenaissance);
		
		JLabel label_6 = new JLabel("\u20B9 10,000");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(182, 191, 75, 14);
		panel_3.add(label_6);
	}

}