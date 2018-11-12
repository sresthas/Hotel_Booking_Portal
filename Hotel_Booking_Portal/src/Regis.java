import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSlider;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;
import java.util.Properties;
import org.jdatepicker.impl.JDatePickerImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.DateComponentFormatter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regis frame = new Regis();
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
	public Regis() {
		connection=sqliteConnection.dbConnector();
		setFont(new Font("Bauhaus 93", Font.PLAIN, 17));
		setType(Type.POPUP);
		setTitle("Registration Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(166, 77, 84, 23);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(357, 81, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(166, 128, 122, 14);
		contentPane.add(lblDateOfBirth);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(357, 128, 179, 20);
		contentPane.add(dateChooser);
		
		JLabel lblResidentialAddress = new JLabel("Residential Address");
		lblResidentialAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResidentialAddress.setBounds(166, 172, 161, 14);
		contentPane.add(lblResidentialAddress);
		
		textField_1 = new JTextField();
		textField_1.setBounds(357, 172, 179, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id:");
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmailId.setBounds(166, 215, 161, 14);
		contentPane.add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_2.setBounds(357, 215, 179, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(166, 259, 161, 14);
		contentPane.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_3.setBounds(357, 259, 179, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(166, 307, 161, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setBounds(357, 307, 179, 20);
		contentPane.add(passwordField);
		
		JCheckBox chckbxIAgreeTo = new JCheckBox("I agree to the terms and conditions");
		chckbxIAgreeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbxIAgreeTo.setBounds(166, 351, 370, 23);
		contentPane.add(chckbxIAgreeTo);
		if(!chckbxIAgreeTo.getState())
		{
			JOptionPane.showMessageDialog(null,"Tick the checkbox");
			
		}
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Enter name");
						btnLogin.setEnabled(false);
				    }
					
					if(textField_2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Enter email id");
						btnLogin.setEnabled(false);
				    }
					if(textField_3.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Enter username");
						btnLogin.setEnabled(false);
				    }
					if(passwordField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Enter password");
						btnLogin.setEnabled(false);
				    }
					if(!chckbxIAgreeTo.getState())
					{
						JOptionPane.showMessageDialog(null,"Tick the checkbox");
						btnLogin.setEnabled(false);
					}
					String query="insert into user_data (username,password) values (?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField_3.getText());
					pst.setString(2,passwordField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"DataSaved");
					pst.close();
					
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogin.setBounds(199, 404, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		//Regis xy=new Regis();
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		//xy.add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(447, 404, 89, 23);
		contentPane.add(btnCancel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}