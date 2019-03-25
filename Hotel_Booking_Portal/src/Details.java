import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Details extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details frame = new Details();
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
	int flag=0;
	public Details(final String person,final int price) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadharNumber = new JLabel("Aadhar Number");
		lblAadharNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblAadharNumber.setBounds(67, 56, 133, 27);
		contentPane.add(lblAadharNumber);
		
		JLabel lblNewLabel = new JLabel("PAN Number");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel.setBounds(67, 136, 113, 19);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(251, 59, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(251, 135, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//int flag=0;
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Entries cant be empty");
					flag=1;
					//btnNewButton.setEnabled(b);
					//check=1;
				}
				if(flag==0)
				{
					Confirmation c=new Confirmation(person,price);
					c.setVisible(true);
				}
			}
		});
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setBounds(173, 200, 97, 25);
		contentPane.add(btnSubmit);
	}
}
