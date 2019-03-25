//Registration page
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
import java.awt.SystemColor;

import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;

import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePickerImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.impl.DateComponentFormatter;

import com.sun.jmx.snmp.Timestamp;
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
	/*final JButton btnLogin;
	final JCheckBox chckbxIAgreeTo;*/
	private static final long serialVersionUID = 1L;
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
		
	//	JButton btnNewButton= new JButton("Login");
		
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
		contentPane.setBackground(SystemColor.activeCaption);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(166, 77, 84, 23);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*if(textField.getText().trim().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty");
				//	btnNewButton.setEnabled(false);
				}*/
					
				
			}
		});
		textField.setBounds(357, 81, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(166, 128, 122, 14);
		contentPane.add(lblDateOfBirth);
		
		final JDateChooser dateChooser = new JDateChooser();
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
		//String x=textField_3.getText();
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(166, 308, 161, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setBounds(357, 307, 179, 20);
		contentPane.add(passwordField);
		//String y=passwordField.getText();
		
		 /*chckbxIAgreeTo = new JCheckBox("I agree to the terms and conditions");
		chckbxIAgreeTo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbxIAgreeTo.setBounds(166, 351, 370, 23);
		contentPane.add(chckbxIAgreeTo);*/
		
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
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
					Date d;
					d=format1.parse(format1.format(dateChooser.getDate()));
					Timestamp ts=new Timestamp(System.currentTimeMillis());  
					Date date2=ts.getDate(); 
					long x=d.getTime()/(60*60*1000*24);
					
					//System.out.println(x);   
					long y=date2.getTime()/(60*60*1000*24);
					//System.out.println(y);  
					long temp=y-x;
					//System.out.println(temp);
					if(textField.getText().trim().isEmpty()||dateChooser.getDate()==null ||textField_1.getText().trim().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()||passwordField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Entries cant be empty");
						//btnNewButton.setEnabled(b);
					}
					else if(temp<6570){
						JOptionPane.showMessageDialog(null,"Below 18!!!!");
					}
					else {
					String query="insert into user_data (username,password) values (?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,textField_3.getText());
					pst.setString(2,passwordField.getText());
					//pst.setString(3,"0");
					pst.execute();
					JOptionPane.showMessageDialog(null,"DataSaved");
					pst.close();
					int flag=0;
					Hotel_Checker hc=new Hotel_Checker(textField_3.getText());
					hc.setVisible(true);
					}
					
				}
				catch(Exception end)
				{
					JOptionPane.showMessageDialog(null,"Username already exists.Try another!!");
				}
				
			
			}
		});
		btnNewButton.setBounds(191, 405, 89, 23);
		contentPane.add(btnNewButton);
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