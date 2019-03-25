import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.SimpleDateFormat;  
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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;


public class Modify extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modify frame = new Modify();
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
	long diff=0;
	Connection connection=null;
	int t1;
	String t2,t3,t4;
	String fin;
	static int[] nov = new int[31];
	static int[] dec = new int[32];
	public Modify(final String username1,final String password) {
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
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		final JLabel lblCheckOutDate = new JLabel("Check Out Date:");
		lblCheckOutDate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCheckOutDate.setBounds(115, 140, 137, 25);
		contentPane.add(lblCheckOutDate);
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(302, 145, 121, 20);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("dd-MM-yyyy");
		
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
		
		
		
		
		JButton btnNewButton = new JButton("Cancel Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String sql = "SELECT checkindate FROM user_data WHERE username ='"+username1+"' ";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					
					
					ResultSet res=pstmt.executeQuery();
					
					//JOptionPane.showMessageDialog(null,res.getString("checkindate"));
					String d=res.getString("checkindate");
					//JOptionPane.showMessageDialog(null,d);

					
					
					fin=this.findDate(d);
					//JOptionPane.showMessageDialog(null,fin);
					Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fin);
					//JOptionPane.showMessageDialog(null,date1);
					Timestamp ts=new Timestamp(System.currentTimeMillis());  
					Date date2=ts.getDate(); 
					//JOptionPane.showMessageDialog(null,date2);
					long x=date1.getTime()/(60*60*1000*24);
					
					//System.out.println(x);   
					long y=date2.getTime()/(60*60*1000*24);
					//System.out.println(y);  
					diff=x-y-1;
					
					


					
					pstmt.close();
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String sql="Select numberofrooms from user_data where username='"+username1+"'";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet res=pstmt.executeQuery();
					t1=res.getInt(1);
					//connection.close();
					
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String sql="Select checkindate from user_data where username='"+username1+"'";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet res=pstmt.executeQuery();
					t2=res.getString(1);
					//connection.close();
					
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String sql="Select checkoutdate from user_data where username='"+username1+"'";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet res=pstmt.executeQuery();
					t3=res.getString(1);
					//connection.close();
					
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String sql="Select hotel from user_data where username='"+username1+"'";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					ResultSet res=pstmt.executeQuery();
					t4=res.getString(1);
					//connection.close();
					
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				/*System.out.println(t1);
				System.out.println(t2);
				System.out.println(t3);
				System.out.println(t4);*/
				t2=this.findDate(t2);
				t3=this.findDate(t3);
				//System.out.println(t2);
				//System.out.println(t3);
				char da1=t2.charAt(0);
				char da2=t2.charAt(1);
				char da3=t2.charAt(3);
				char da4=t2.charAt(4);
				String s1=String.valueOf(da1);
				String s2=String.valueOf(da2);
				final int ind=Integer.parseInt(s1+s2);
				String s3=String.valueOf(da3);
				String s4=String.valueOf(da4);
				final int inm=Integer.parseInt(s3+s4);
				
				char da5=t3.charAt(0);
				char da6=t3.charAt(1);
				char da7=t3.charAt(3);
				char da8=t3.charAt(4);
				String s5=String.valueOf(da5);
				String s6=String.valueOf(da6);
				final int oud=Integer.parseInt(s5+s6);
				String s7=String.valueOf(da7);
				String s8=String.valueOf(da8);
				int oum=Integer.parseInt(s7+s8);
				/*System.out.println(ind);
				System.out.println(inm);
				System.out.println(oud);
				System.out.println(oum);*/
				//System.out.println(t4);
				if(t4.equals("Ruby"))
				{	//System.out.println("Yes");
					try {
					
					
					String sql = "SELECT Rooms FROM RubyN ";
					//JOptionPane.showMessageDialog(null,"2");
					PreparedStatement pstmt = connection.prepareStatement(sql);
					
					//JOptionPane.showMessageDialog(null,"3");
					ResultSet res=pstmt.executeQuery();
					//JOptionPane.showMessageDialog(null,"4");
					int count1=1;
					while(res.next())
					{	
						int id = res.getInt(1);
						nov[count1++]=id;
					}
					/*for(int i=0;i<30;i++)
					{
						System.out.println(nov[i]);
					}
					JOptionPane.showMessageDialog(null,"7");*/
					res.close();
					
					//connection.close();
					
					String sql1 = "SELECT Rooms FROM RubyD ";
					PreparedStatement pstmt1 = connection.prepareStatement(sql1);
					ResultSet res1=pstmt1.executeQuery();
					int count2=1;
					while(res1.next())
					{	
						int id = res1.getInt(1);
						dec[count2++]=id;
					}
					/*System.out.println("nov");
					for(int i=1;i<=30;i++)
					{
						System.out.println("Day"+i+"="+nov[i]);
					}
					System.out.println("dec");
					for(int i=1;i<=31;i++)
					{
						System.out.println("Day"+i+"="+dec[i]);
					}
					JOptionPane.showMessageDialog(null,"7");*/
					if(inm==oum && inm==11)
					{
						for(int i=ind;i<=oud;i++)
						{
							nov[i]=nov[i]-t1;
						}
					}
					else if(inm==oum && inm==12)
					{
						for(int i=ind;i<=oud;i++)
						{
							dec[i]=dec[i]-t1;
						}
					}
					else {
						for(int i=ind;i<=30;i++)
						{
							nov[i]=nov[i]-t1;
						}
						for(int i=1;i<=oud;i++)
						{
							dec[i]=dec[i]-t1;
						}
					}
					/*System.out.println("nov");
					for(int i=1;i<=30;i++)
					{
						System.out.println("Day"+i+"="+nov[i]);
					}
					System.out.println("dec");
					for(int i=1;i<=31;i++)
					{
						System.out.println("Day"+i+"="+dec[i]);
					}*/
					try {
						//nov[0]=11;
						//nov[1]=6;
						////System.out.println("nov");
						for(int i=1;i<=30;i++)
						{int x=nov[i];
						//System.out.println("Day"+i+"="+x);
						int y=i;
						String query="Update RubyN set Rooms='"+x+"' where Days='"+y+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						pst.close();
						}
					}
					catch(Exception en)
					{
						en.printStackTrace();
					}
					
					try
					{
						////System.out.println("dec");
						for(int i=1;i<=31;i++)
						{int x=dec[i];
						////System.out.println("Day"+i+"="+x);
						int y=i;
						String query="Update RubyD set Rooms='"+x+"' where Days='"+y+"'";
						PreparedStatement pst1=connection.prepareStatement(query);
						pst1.execute();
						pst1.close();
						//connection.close();
						}
					}
					
						
						
					catch(Exception en)
					{
						en.printStackTrace();
					}
					
					
					
					
				}
				catch(Exception en){
					en.printStackTrace();
				}
				}
				
				System.out.println(diff);
				if(diff>=3)
				{
				try 
				{		
					String sql = "delete from  user_data  WHERE username ='"+username1+"' ";
					
						PreparedStatement pstmt = connection.prepareStatement(sql);
						JOptionPane.showMessageDialog(null,"Hope to see u again");
						JOptionPane.showMessageDialog(null,"Data Deleted");
						
						int res=pstmt.executeUpdate();
						//JOptionPane.showMessageDialog(null,"DataSaved");
						
						pstmt.close();
						//connection.close();
					
						

						
				} 
				catch (Exception e) {
						e.printStackTrace();
				}
				try {
					String query="insert into user_data (username,password) values (?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,username1);
					pst.setString(2,password);
					//pst.setString(3,"0");
					pst.execute();
					JOptionPane.showMessageDialog(null,"DataSaved");
					pst.close();
					connection.close();
					
				}
				catch (Exception e) {
					e.printStackTrace();
					}
				}
				else
				{
					
					Cancellation cancel=new Cancellation(username1);
					cancel.setVisible(true);
					try 
					{		
						String sql = "delete from  user_data  WHERE username ='"+username1+"' ";
						
							PreparedStatement pstmt = connection.prepareStatement(sql);
							JOptionPane.showMessageDialog(null,"Data Deleted");
							
							int res=pstmt.executeUpdate();
							//JOptionPane.showMessageDialog(null,"DataSaved");
							
							pstmt.close();
							//connection.close();
						
							

							
					} 
					catch (Exception e) {
							e.printStackTrace();
					}
					try {
						String query="insert into user_data (username,password) values (?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1,username1);
						pst.setString(2,password);
						//pst.setString(3,"0");
						pst.execute();
						//JOptionPane.showMessageDialog(null,"DataSaved");
						pst.close();
						connection.close();
						
					}
					catch (Exception e) {
						e.printStackTrace();
						}

					
					
					
				}
		}

			String findDate(String d) {
				String dates="a";
				String month="a";
				String year="a";
				String dash="-";
				String fin="a";
				int digit=0;
				char a1=d.charAt(0);
				char a2=d.charAt(1);
				if(a2==' ')
				{
				    digit=0;
				    String s1=String.valueOf(a1); 
				    dates="0"+s1;
				}
				else
				{
				    digit=1;
				    String s1=String.valueOf(a1); 
				    String s2=String.valueOf(a2); 
				    dates=s1+s2;
				}
				if(digit==0)
				{
				    char a3=d.charAt(2);
				    char a4=d.charAt(3);
				    char a5=d.charAt(4);
				    if(a3=='F')
				    month="02";
				    else if(a3=='S')
				    month="09";
				    else if(a3=='N')
				    month="11";
				    else if(a3=='O')
				    month="10";
				    else if(a3=='D')
				    month="12";
				    else if(a3=='J')
				    {
				        if(a4=='a')
				        month="01";
				        else 
				        {
				            if(a5=='n')
				            month="06";
				            else
				            month="07";
				        }
				        
				    }
				    else if(a3=='M')
				    {
				        if(a5=='r')
				        month="03";
				        else 
				        {
				            
				            month="05";
				        }
				        
				    }
				    else if(a3=='A')
				    {
				        if(a4=='p')
				        month="04";
				        else 
				        {
				            
				            month="08";
				        }
				        
				    }
				    
				    
				
				}
			
				else
				{
				    char a3=d.charAt(3);
				    char a4=d.charAt(4);
				    char a5=d.charAt(5);
				    if(a3=='F')
				    month="02";
				    else if(a3=='S')
				    month="09";
				    else if(a3=='N')
				    month="11";
				    else if(a3=='O')
				    month="10";
				    else if(a3=='D')
				    month="12";
				    else if(a3=='J')
				    {
				        if(a4=='a')
				        month="01";
				        else 
				        {
				            if(a5=='n')
				            month="06";
				            else
				            month="07";
				        }
				        
				    }
				    else if(a3=='M')
				    {
				        if(a5=='r')
				        month="03";
				        else 
				        {
				            
				            month="05";
				        }
				        
				    }
				    else if(a3=='A')
				    {
				        if(a4=='p')
				        month="04";
				        else 
				        {
				            
				            month="08";
				        }
				        
				    }
				    
				    
				
				}
				
				int n=d.length();
				char y1=d.charAt(n-4);
				char y2=d.charAt(n-3);
				char y3=d.charAt(n-2);
				char y4=d.charAt(n-1);
				String s1=String.valueOf(y1); 
				String s2=String.valueOf(y2); 
				String s3=String.valueOf(y3); 
				String s4=String.valueOf(y4); 
				year=s1+s2+s3+s4;
				
				fin=dates+dash+month+dash+year;
				return fin;
				
			}
	});
		JButton btnContinue = new JButton("Modify");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
					Date di;
					di=format1.parse(format1.format(dateChooser.getDate()));
					Timestamp ts1=new Timestamp(System.currentTimeMillis());  
					Date datee=ts1.getDate(); 
					long x1=di.getTime()/(60*60*1000*24);
					
					//System.out.println(x);   
					long y1=datee.getTime()/(60*60*1000*24);
					//System.out.println(y);  
					long temp=x1-y1;
					SimpleDateFormat format11=new SimpleDateFormat("dd/MM/yyyy");
					Date d11=null;
					Date d21=null;
					d11=format11.parse(format11.format(dateChooser.getDate()));
					d21=format11.parse(format11.format(dateChooser_1.getDate()));
					long ans1=d21.getTime()-d11.getTime();
					long day1=ans1/(1000*60*60*24)+1;
					
					if(temp<0 || ans1<0)
					{
						JOptionPane.showMessageDialog(null,"Wrong dates entered");
					}
					else if(2*Integer.parseInt(spinner.getValue().toString())<Integer.parseInt(spinner_1.getValue().toString()))
					{
						JOptionPane.showMessageDialog(null,"Increase number of rooms to accomadate given number of people");
					}
					else if(dateChooser.getDate() == null || dateChooser_1.getDate()==null)
					{
						JOptionPane.showMessageDialog(null,"Invalid input");
					}
					else 
					{
					try {
						String sql = "SELECT checkindate FROM user_data WHERE username ='"+username1+"' ";
						
						PreparedStatement pstmt = connection.prepareStatement(sql);
						
						
						ResultSet res=pstmt.executeQuery();
						
						//JOptionPane.showMessageDialog(null,res.getString("checkindate"));
						String d=res.getString("checkindate");
						//JOptionPane.showMessageDialog(null,d);

						
						
						fin=this.findDate(d);
						//JOptionPane.showMessageDialog(null,fin);
						Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fin);
						//JOptionPane.showMessageDialog(null,date1);
						Timestamp ts=new Timestamp(System.currentTimeMillis());  
						Date date2=ts.getDate(); 
						//JOptionPane.showMessageDialog(null,date2);
						long x=date1.getTime()/(60*60*1000*24);
						
						//System.out.println(x);   
						long y=date2.getTime()/(60*60*1000*24);
						//System.out.println(y);  
						diff=x-y;
						
						
						


						
						pstmt.close();
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				if(dateChooser.getDate() == null || dateChooser_1.getDate()==null )
				{
					JOptionPane.showMessageDialog(null,"Entries cant be empty");
				}
				
				else 
				{	//System.out.println(diff);
					SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
					Date d1=null;
					Date d2=null;
					d1=format.parse(format.format(dateChooser.getDate()));
					d2=format.parse(format.format(dateChooser_1.getDate()));
					long ans=d2.getTime()-d1.getTime();
					long day=ans/(1000*60*60*24)+1;

					try {
						String sql = "SELECT checkindate FROM user_data WHERE username ='"+username1+"' ";
						
						PreparedStatement pstmt = connection.prepareStatement(sql);
						
						
						ResultSet res=pstmt.executeQuery();
						
						//JOptionPane.showMessageDialog(null,res.getString("checkindate"));
						String d=res.getString("checkindate");
						//JOptionPane.showMessageDialog(null,d);

						
						
						fin=this.findDate(d);
						//JOptionPane.showMessageDialog(null,fin);
						Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(fin);
						//JOptionPane.showMessageDialog(null,date1);
						Timestamp ts=new Timestamp(System.currentTimeMillis());  
						Date date2=ts.getDate(); 
						//JOptionPane.showMessageDialog(null,date2);
						long x=date1.getTime()/(60*60*1000*24);
						
						//System.out.println(x);   
						long y=date2.getTime()/(60*60*1000*24);
						//System.out.println(y);  
						diff=x-y+1;
						
						


						
						pstmt.close();
						
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					try {
						String sql="Select numberofrooms from user_data where username='"+username1+"'";
						PreparedStatement pstmt = connection.prepareStatement(sql);
						ResultSet res=pstmt.executeQuery();
						t1=res.getInt(1);
						//connection.close();
						
						
					}
					catch(Exception en)
					{
						en.printStackTrace();
					}
					try {
						String sql="Select checkindate from user_data where username='"+username1+"'";
						PreparedStatement pstmt = connection.prepareStatement(sql);
						ResultSet res=pstmt.executeQuery();
						t2=res.getString(1);
						//connection.close();
						
						
					}
					catch(Exception en)
					{
						en.printStackTrace();
					}
					try {
						String sql="Select checkoutdate from user_data where username='"+username1+"'";
						PreparedStatement pstmt = connection.prepareStatement(sql);
						ResultSet res=pstmt.executeQuery();
						t3=res.getString(1);
						//connection.close();
						
						
					}
					catch(Exception en)
					{
						en.printStackTrace();
					}
					try {
						String sql="Select hotel from user_data where username='"+username1+"'";
						PreparedStatement pstmt = connection.prepareStatement(sql);
						ResultSet res=pstmt.executeQuery();
						t4=res.getString(1);
						//connection.close();
						
						
					}
					catch(Exception en)
					{
						en.printStackTrace();
					}
					/*System.out.println(t1);
					System.out.println(t2);
					System.out.println(t3);
					System.out.println(t4);*/
					t2=this.findDate(t2);
					t3=this.findDate(t3);
					//System.out.println(t2);
					//System.out.println(t3);
					char da1=t2.charAt(0);
					char da2=t2.charAt(1);
					char da3=t2.charAt(3);
					char da4=t2.charAt(4);
					String s1=String.valueOf(da1);
					String s2=String.valueOf(da2);
					final int ind=Integer.parseInt(s1+s2);
					String s3=String.valueOf(da3);
					String s4=String.valueOf(da4);
					final int inm=Integer.parseInt(s3+s4);
					
					char da5=t3.charAt(0);
					char da6=t3.charAt(1);
					char da7=t3.charAt(3);
					char da8=t3.charAt(4);
					String s5=String.valueOf(da5);
					String s6=String.valueOf(da6);
					final int oud=Integer.parseInt(s5+s6);
					String s7=String.valueOf(da7);
					String s8=String.valueOf(da8);
					int oum=Integer.parseInt(s7+s8);
					/*System.out.println(ind);
					System.out.println(inm);
					System.out.println(oud);
					System.out.println(oum);*/
					//System.out.println(t4);
					if(t4.equals("Ruby"))
					{	//System.out.println("Yes");
						try {
						
						
						String sql = "SELECT Rooms FROM RubyN ";
						//JOptionPane.showMessageDialog(null,"2");
						PreparedStatement pstmt = connection.prepareStatement(sql);
						
						//JOptionPane.showMessageDialog(null,"3");
						ResultSet res=pstmt.executeQuery();
						//JOptionPane.showMessageDialog(null,"4");
						int count1=1;
						while(res.next())
						{	
							int id = res.getInt(1);
							nov[count1++]=id;
						}
						/*for(int i=0;i<30;i++)
						{
							System.out.println(nov[i]);
						}
						JOptionPane.showMessageDialog(null,"7");*/
						res.close();
						
						//connection.close();
						
						String sql1 = "SELECT Rooms FROM RubyD ";
						PreparedStatement pstmt1 = connection.prepareStatement(sql1);
						ResultSet res1=pstmt1.executeQuery();
						int count2=1;
						while(res1.next())
						{	
							int id = res1.getInt(1);
							dec[count2++]=id;
						}
						/*System.out.println("nov");
						for(int i=1;i<=30;i++)
						{
							System.out.println("Day"+i+"="+nov[i]);
						}
						System.out.println("dec");
						for(int i=1;i<=31;i++)
						{
							System.out.println("Day"+i+"="+dec[i]);
						}
						JOptionPane.showMessageDialog(null,"7");*/
						if(inm==oum && inm==11)
						{
							for(int i=ind;i<=oud;i++)
							{
								nov[i]=nov[i]-t1;
							}
						}
						else if(inm==oum && inm==12)
						{
							for(int i=ind;i<=oud;i++)
							{
								dec[i]=dec[i]-t1;
							}
						}
						else {
							for(int i=ind;i<=30;i++)
							{
								nov[i]=nov[i]-t1;
							}
							for(int i=1;i<=oud;i++)
							{
								dec[i]=dec[i]-t1;
							}
						}
						/*System.out.println("nov");
						for(int i=1;i<=30;i++)
						{
							System.out.println("Day"+i+"="+nov[i]);
						}
						System.out.println("dec");
						for(int i=1;i<=31;i++)
						{
							System.out.println("Day"+i+"="+dec[i]);
						}*/
						try {
							//nov[0]=11;
							//nov[1]=6;
							////System.out.println("nov");
							for(int i=1;i<=30;i++)
							{int x=nov[i];
							//System.out.println("Day"+i+"="+x);
							int y=i;
							String query="Update RubyN set Rooms='"+x+"' where Days='"+y+"'";
							PreparedStatement pst=connection.prepareStatement(query);
							pst.execute();
							pst.close();
							}
						}
						catch(Exception en)
						{
							en.printStackTrace();
						}
						
						try
						{
							////System.out.println("dec");
							for(int i=1;i<=31;i++)
							{int x=dec[i];
							////System.out.println("Day"+i+"="+x);
							int y=i;
							String query="Update RubyD set Rooms='"+x+"' where Days='"+y+"'";
							PreparedStatement pst1=connection.prepareStatement(query);
							pst1.execute();
							pst1.close();
							//connection.close();
							}
						}
						
							
							
						catch(Exception en)
						{
							en.printStackTrace();
						}
						
						
						
						
					}
					catch(Exception en){
						en.printStackTrace();
					}
					}
					
				if(day<=0)
				{
					JOptionPane.showMessageDialog(null,"Wrong dates entered");
				}
				else if(diff<3)
				{	System.out.println(diff);
					JOptionPane.showMessageDialog(null,"Details cannot be modified now!! Sorry!!");
				}
				
				else 
				{
				System.out.println(diff);
					if(comboBox.getSelectedItem()=="Hyderabad")
				{	
					
					Hyderabad hyd=new Hyderabad(username1,dateChooser.getDate().toString(),dateChooser_1.getDate().toString(),spinner.getValue().toString(),day);
					hyd.setVisible(true);

				}
				else if(comboBox.getSelectedItem()=="Banglore")
				{	
					
					Bangalore bn=new Bangalore(username1,dateChooser.getDate().toString(),dateChooser_1.getDate().toString(),spinner.getValue().toString(),day);
					bn.setVisible(true);
					
				}
				else if(comboBox.getSelectedItem()=="Mumbai")
				{	
					
					Mumbai mn=new Mumbai();
					mn.setVisible(true);
					
				}
				
				
				//JOptionPane.showMessageDialog(null,"Hi");
				this.update(dateChooser.getDate(),dateChooser_1.getDate(),spinner.getValue().toString(), spinner_1.getValue().toString(),(String) comboBox.getSelectedItem(),username1);
				//JOptionPane.showMessageDialog(null,"Hii");
				
				}
				
				
				}
				}
				}
				catch(Exception en)
				{
					en.printStackTrace();
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
							//JOptionPane.showMessageDialog(null,"Data Updated");
							//pstmt.setDate(3, new java.sql.Date(check_in_date.getTime()));
							//pstmt.setDate(4, new java.sql.Date(check_out_date.getTime()));
							//pstmt.setString(5, number_of_rooms)
							String myString = DateFormat.getDateInstance().format(new java.sql.Date(check_in_date.getTime()));
							//JOptionPane.showMessageDialog(null,myString);
							String myString1 = DateFormat.getDateInstance().format(new java.sql.Date(check_out_date.getTime()));
							pstmt.setString(1, location);
							pstmt.setString(2, number_of_rooms);
							pstmt.setString(3, number_of_people);
							
							pstmt.setString(4,myString);
							pstmt.setString(5,myString1);
							int res=pstmt.executeUpdate();
							//JOptionPane.showMessageDialog(null,"myString");
							//JOptionPane.showMessageDialog(null,myString);
							
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
			String findDate(String d) {
				String dates="a";
				String month="a";
				String year="a";
				String dash="-";
				String fin="a";
				int digit=0;
				char a1=d.charAt(0);
				char a2=d.charAt(1);
				if(a2==' ')
				{
				    digit=0;
				    String s1=String.valueOf(a1); 
				    dates="0"+s1;
				}
				else
				{
				    digit=1;
				    String s1=String.valueOf(a1); 
				    String s2=String.valueOf(a2); 
				    dates=s1+s2;
				}
				if(digit==0)
				{
				    char a3=d.charAt(2);
				    char a4=d.charAt(3);
				    char a5=d.charAt(4);
				    if(a3=='F')
				    month="02";
				    else if(a3=='S')
				    month="09";
				    else if(a3=='N')
				    month="11";
				    else if(a3=='O')
				    month="10";
				    else if(a3=='D')
				    month="12";
				    else if(a3=='J')
				    {
				        if(a4=='a')
				        month="01";
				        else 
				        {
				            if(a5=='n')
				            month="06";
				            else
				            month="07";
				        }
				        
				    }
				    else if(a3=='M')
				    {
				        if(a5=='r')
				        month="03";
				        else 
				        {
				            
				            month="05";
				        }
				        
				    }
				    else if(a3=='A')
				    {
				        if(a4=='p')
				        month="04";
				        else 
				        {
				            
				            month="08";
				        }
				        
				    }
				    
				    
				
				}
			
				else
				{
				    char a3=d.charAt(3);
				    char a4=d.charAt(4);
				    char a5=d.charAt(5);
				    if(a3=='F')
				    month="02";
				    else if(a3=='S')
				    month="09";
				    else if(a3=='N')
				    month="11";
				    else if(a3=='O')
				    month="10";
				    else if(a3=='D')
				    month="12";
				    else if(a3=='J')
				    {
				        if(a4=='a')
				        month="01";
				        else 
				        {
				            if(a5=='n')
				            month="06";
				            else
				            month="07";
				        }
				        
				    }
				    else if(a3=='M')
				    {
				        if(a5=='r')
				        month="03";
				        else 
				        {
				            
				            month="05";
				        }
				        
				    }
				    else if(a3=='A')
				    {
				        if(a4=='p')
				        month="04";
				        else 
				        {
				            
				            month="08";
				        }
				        
				    }
				    
				    
				
				}
				
				int n=d.length();
				char y1=d.charAt(n-4);
				char y2=d.charAt(n-3);
				char y3=d.charAt(n-2);
				char y4=d.charAt(n-1);
				String s1=String.valueOf(y1); 
				String s2=String.valueOf(y2); 
				String s3=String.valueOf(y3); 
				String s4=String.valueOf(y4); 
				year=s1+s2+s3+s4;
				
				fin=dates+dash+month+dash+year;
				return fin;
				
			}
		});
		btnContinue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnContinue.setBounds(231, 257, 97, 25);
		contentPane.add(btnContinue);
		
		btnNewButton.setBounds(36, 257, 137, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(405, 257, 97, 25);
		contentPane.add(btnNewButton_1);
		
	}

	
}