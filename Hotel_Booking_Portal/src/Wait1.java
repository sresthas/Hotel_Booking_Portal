import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.awt.event.ActionEvent;

public class Wait1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wait1 frame = new Wait1();
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
	public Wait1(final String person,final String checkin,final String checkout,final String rooms,final long days, final String loc,final String hotel) {
		final Connection connection = sqliteConnection.dbConnector();
		/*System.out.println(person);
		System.out.println(checkin);
		System.out.println(checkout);
		System.out.println(rooms);
		System.out.println(days);*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.activeCaption);
		
		JLabel lblDoUWant = new JLabel("Do u want to wait or check another hotel");
		lblDoUWant.setForeground(Color.RED);
		lblDoUWant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoUWant.setBounds(94, 37, 290, 16);
		contentPane.add(lblDoUWant);
		
		JButton btnNewButton = new JButton("Wait");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{		
					String sql = "insert into WaitList (username,checkindate,checkoutdate,noofrooms,noofdays,location,hotel) values (?,?,?,?,?,?,?)";
						int step=0;
						if(step==0)
						{
						
						PreparedStatement pstmt = connection.prepareStatement(sql);
						JOptionPane.showMessageDialog(null,"Data Updated");
						//pstmt.setDate(3, new java.sql.Date(check_in_date.getTime()));
						//pstmt.setDate(4, new java.sql.Date(check_out_date.getTime()));
						//pstmt.setString(5, number_of_rooms)
						//String myString = DateFormat.getDateInstance().format(new java.sql.Date(check_in_date.getTime()));
						//String myString1 = DateFormat.getDateInstance().format(new java.sql.Date(check_out_date.getTime()));
						pstmt.setString(1, person);
						pstmt.setString(2, checkin);
						pstmt.setString(3, checkout);
						pstmt.setString(4, rooms);
						pstmt.setLong(5, days);
						
						pstmt.setString(6,loc);
						pstmt.setString(7,hotel);
						int res=pstmt.executeUpdate();
						//JOptionPane.showMessageDialog(null,"DataSaved");
						
						pstmt.close();
						connection.close();
						

						step=1;
						JOptionPane.showMessageDialog(null,"Data Updated");
						}
						
						
						//pstmt.executeUpdate();
				} 
				catch (Exception en) {
						en.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(152, 95, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel_Checker hc=new Hotel_Checker(person);
				hc.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(152, 172, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}
