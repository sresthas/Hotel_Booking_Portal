import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;

import com.sun.jmx.snmp.Timestamp;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;


public class Hotel_Checker extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel_Checker frame = new Hotel_Checker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	Connection connection=null;
	public Hotel_Checker(final String username1) {
		final Connection connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("Location:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(115, 62, 121, 31);
		contentPane.add(lblNewLabel);
		
		final JLabel lblCheckInDate = new JLabel("Check In Date:");
		lblCheckInDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCheckInDate.setBounds(115, 104, 121, 25);
		contentPane.add(lblCheckInDate);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(302, 109, 122, 20);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		final JLabel lblCheckOutDate = new JLabel("Check Out Date:");
		lblCheckOutDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCheckOutDate.setBounds(115, 140, 137, 25);
		contentPane.add(lblCheckOutDate);
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(302, 145, 121, 20);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Search", "Hyderabad", "Bangalore", "Mumbai"}));
		comboBox.setEditable(true);
		comboBox.setMaximumRowCount(6);
		comboBox.setBounds(302, 70, 122, 20);
		contentPane.add(comboBox);
		
		final JLabel lblNumberOfRooms = new JLabel("Number Of Rooms:");
		lblNumberOfRooms.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNumberOfRooms.setBounds(115, 183, 171, 14);
		contentPane.add(lblNumberOfRooms);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner.setBounds(302, 183, 38, 20);
		contentPane.add(spinner);
		//final String value=spinner.getValue().toString();
		
		final JLabel lblNumberOfPeople = new JLabel("Number Of People:");
		lblNumberOfPeople.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNumberOfPeople.setBounds(115, 219, 171, 25);
		contentPane.add(lblNumberOfPeople);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		spinner_1.setBounds(302, 224, 38, 20);
		contentPane.add(spinner_1);
		//final String value_1=spinner.getValue().toString();
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
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
					long temp=x-y;
					
				if(dateChooser.getDate() == null || dateChooser_1.getDate()==null || temp<0)
				{
					JOptionPane.showMessageDialog(null,"Invalid input");
				}
				else if(2*Integer.parseInt(spinner.getValue().toString())<Integer.parseInt(spinner_1.getValue().toString()))
				{
					JOptionPane.showMessageDialog(null,"Increase number of rooms to accomadate given number of people");
				}
				
				else
				{
					SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
					Date d1=null;
					Date d2=null;
					d1=format.parse(format.format(dateChooser.getDate()));
					d2=format.parse(format.format(dateChooser_1.getDate()));
					long ans=d2.getTime()-d1.getTime();
					long da=ans/(1000*60*60*24);
					long day=da+1;
					if(day<=0)
					{
						JOptionPane.showMessageDialog(null,"Wrong dates entered");
					}
					//System.out.println(day);
					//java.sql.Date in=new java.sql.Date(dateChooser.getDate());
					else
					{
						if(comboBox.getSelectedItem()=="Hyderabad")
						{	
					
							Hyderabad hyd=new Hyderabad(username1,dateChooser.getDate().toString(),dateChooser_1.getDate().toString(),spinner.getValue().toString(),day);
							hyd.setVisible(true);

						}
						else if(comboBox.getSelectedItem()=="Bangalore")
						{	
					
							Bangalore bn=new Bangalore(username1,dateChooser.getDate().toString(),dateChooser_1.getDate().toString(),spinner.getValue().toString(),day);
							bn.setVisible(true);
					
						}
						else if(comboBox.getSelectedItem()=="Mumbai")
						{	
					
							Mumbai mn=new Mumbai();
							mn.setVisible(true);
					
						}
					
				
					this.update(dateChooser.getDate(),dateChooser_1.getDate(),spinner.getValue().toString(), spinner_1.getValue().toString(),(String) comboBox.getSelectedItem(),username1);
					}
				
					
				
				}
				}
				catch(Exception en)
				{
					JOptionPane.showMessageDialog(null,"Error");
				}
				
					
					
					
					
				
				
				
				
				
			}

			public void update(Date check_in_date,Date check_out_date,String number_of_rooms, String number_of_people,String location,String username2) 
			{		//JOptionPane.showMessageDialog(null,new java.sql.Date(check_in_date.getTime()));
					/*JOptionPane.showMessageDialog(null,check_out_date);
					JOptionPane.showMessageDialog(null,number_of_rooms);
					JOptionPane.showMessageDialog(null,number_of_people);
					JOptionPane.showMessageDialog(null,location);*/
					//JOptionPane.showMessageDialog(null,username2);
					//JOptionPane.showMessageDialog(null,username1);
					String word=username2;
					//JOptionPane.showMessageDialog(null,word);
					/*String sql = "UPDATE user_data SET check-in-date = ?," + " check-out-date = ?,  " + " number-of-rooms=?, "+" number-of-people=?, " +" location=? "
			        + "WHERE username = username";*/
					String sql = "UPDATE user_data SET location = ?,"+"numberofrooms=?,"+"numberofpeople=?,"+"checkindate=? ,"+"checkoutdate=? WHERE username ='"+username1+"' ";
					
					//String sql = "INSERT INTO user_data(location) values('hyd')";		
					//Connection connection=null;
					try 
					{		int step=0;
							if(step==0)
							{
							
							PreparedStatement pstmt = connection.prepareStatement(sql);
							JOptionPane.showMessageDialog(null,"Data Updated");
							//pstmt.setDate(3, new java.sql.Date(check_in_date.getTime()));
							//pstmt.setDate(4, new java.sql.Date(check_out_date.getTime()));
							//pstmt.setString(5, number_of_rooms)
							String myString = DateFormat.getDateInstance().format(new java.sql.Date(check_in_date.getTime()));
							String myString1 = DateFormat.getDateInstance().format(new java.sql.Date(check_out_date.getTime()));
							pstmt.setString(1, location);
							pstmt.setString(2, number_of_rooms);
							pstmt.setString(3, number_of_people);
							
							pstmt.setString(4,myString);
							pstmt.setString(5,myString1);
							int res=pstmt.executeUpdate();
							//JOptionPane.showMessageDialog(null,"DataSaved");
							
							pstmt.close();
							connection.close();
							
	
							step=1;
							//JOptionPane.showMessageDialog(null,"Data Updated");
							}
							
							
							//pstmt.executeUpdate();
					} 
					catch (Exception e) {
							e.printStackTrace();
					}
			}
		});
		btnContinue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnContinue.setBounds(231, 257, 97, 25);
		contentPane.add(btnContinue);
	}

	 







/*public static void update(Date check_in_date,Date check_out_date,int number_of_rooms, int number_of_people,String location,String username,String password) 
{
		String sql = "UPDATE user_data SET check-in-date = ?  "+" check-out-date = ?  " + " check-out-date= ? "+" number-of-rooms=? "+" number-of-people=? "
        + "WHERE username = ?"+" password=?";

		try 
		{
				Connection conn = sqliteConnection.dbConnector();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setDate(1, new java.sql.Date(check_in_date.getTime()));
				pstmt.setDate(2, new java.sql.Date(check_out_date.getTime()));
				pstmt.setInt(3, number_of_rooms);
				pstmt.setInt(4, number_of_people);
				pstmt.setString(5, location);
				
				// update 
				pstmt.executeUpdate();
		} 
		catch (SQLException e) {
				System.out.println(e.getMessage());
		}
}*/
//Hotel_Checker obj=new Hotel_Checker(username,password);
//obj.update(lblCheckInDate,lblCheckOutDate,lblNumberOfRooms,lblNumberOfPeople,comboBox,username,password);

}