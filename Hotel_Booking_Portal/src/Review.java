import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Review extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Review frame = new Review();
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
	public Review() {
		setTitle("Review");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 407, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYouReview = new JLabel("Enter you review:");
		lblEnterYouReview.setBounds(10, 11, 105, 14);
		contentPane.add(lblEnterYouReview);
		
		textField = new JTextField();
		textField.setBounds(121, 8, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating:");
		lblRating.setBounds(269, 11, 65, 14);
		contentPane.add(lblRating);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spinner.setBounds(321, 8, 53, 20);
		contentPane.add(spinner);
		
		JLabel lblPreviousRatings = new JLabel("Previous Reviews:");
		lblPreviousRatings.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblPreviousRatings.setBounds(10, 57, 178, 14);
		contentPane.add(lblPreviousRatings);
		
		JEditorPane dtrpnAtulVedRating = new JEditorPane();
		dtrpnAtulVedRating.setBackground(SystemColor.control);
		dtrpnAtulVedRating.setEditable(false);
		dtrpnAtulVedRating.setText("Atul Ved\r\nRating: 5\r\nValue for money, convenient location.\r\nI like hospitality, cleanliness, and view from the roof top.\r\n\r\nVivek Bhaduria\r\nRating: 3\r\nBreakfast was not up-to mark, need improvement.\r\n\r\nDr. Harsh Vyas\r\nRating: 4\r\nOverall it was a good experience. Totally enjoyed.\r\n\r\n981 more.........");
		dtrpnAtulVedRating.setBounds(10, 82, 324, 260);
		contentPane.add(dtrpnAtulVedRating);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Thank You");
				
			}
		});
		btnSubmit.setBounds(285, 353, 89, 23);
		contentPane.add(btnSubmit);
	}
}
