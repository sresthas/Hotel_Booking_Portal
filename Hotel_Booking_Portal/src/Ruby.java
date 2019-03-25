import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Ruby extends JFrame {
	static int[] nov = new int[31];
	static int[] dec = new int[32];
	//int f=0;
	//int choose=0;
	//final JButton btnNewButton;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	int flag=1;
	int flag1=1;
	int flag2=1;
	int check=0;
	int dd=0;
	String loc="Hyderabad";
	String ho="Ruby";
	//final JButton btnContinue;
	Connection connection=null;
	public Ruby(final String person,final String checkin,final String checkout,final String rooms,final long days) {
		final Connection connection = sqliteConnection.dbConnector();
		//JOptionPane.showMessageDialog(null,"Details");
		//JOptionPane.showMessageDialog(null,person);
		//JOptionPane.showMessageDialog(null,checkin);
		//JOptionPane.showMessageDialog(null,checkout);
		//JOptionPane.showMessageDialog(null,rooms);
		setTitle("Ruby");
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
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setEditable(false);
		textField.setBounds(329, 54, 42, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		/*Scanner ss=new Scanner("Ruby.txt");
		int y;
		for(int i=0;i<30;i++)
		{
			String x=ss.next();
			y=Integer.parseInt(x);
			////System.out.println(y);
		}
		ss.close();*/
		
		
		
		
		String in=this.findDate(checkin);
		String ou=this.findDate(checkout);
		//////System.out.println(in);
		//////System.out.println(ou);
		char da1=in.charAt(0);
		char da2=in.charAt(1);
		char da3=in.charAt(2);
		char da4=in.charAt(3);
		String s1=String.valueOf(da1);
		String s2=String.valueOf(da2);
		final int ind=Integer.parseInt(s1+s2);
		String s3=String.valueOf(da3);
		String s4=String.valueOf(da4);
		final int inm=Integer.parseInt(s3+s4);
		
		char da5=ou.charAt(0);
		char da6=ou.charAt(1);
		char da7=ou.charAt(2);
		char da8=ou.charAt(3);
		String s5=String.valueOf(da5);
		String s6=String.valueOf(da6);
		final int oud=Integer.parseInt(s5+s6);
		String s7=String.valueOf(da7);
		String s8=String.valueOf(da8);
		int oum=Integer.parseInt(s7+s8);
		final int r=Integer.parseInt(rooms);
		
		//////System.out.println(ind);
		//////System.out.println(oud);
		
		try {
			
			//JOptionPane.showMessageDialog(null,"1");
			//WHERE Days>='ind' AND Days<='oud'
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
				////System.out.println(nov[i]);
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
			////System.out.println("nov");
			for(int i=1;i<=30;i++)
			{
				////System.out.println("Day"+i+"="+nov[i]);
			}
			////System.out.println("dec");
			for(int i=1;i<=31;i++)
			{
				////System.out.println("Day"+i+"="+dec[i]);
			}
			//JOptionPane.showMessageDialog(null,"7");
			
			
			
			
			
		}
		catch(Exception en){
			en.printStackTrace();
		}
		
		
		
		if(inm==oum)
		{
		 if(inm==11)
		 {
			 
			 
			 for(int i=ind;i<=oud;i++)
			 {
				 int left=(20-nov[i]);
				 
				 //////System.out.println("left"+left);
				 
				 if(left <r)
				 {
				    flag=0;	 
				 }
			 }
			 //////System.out.println("flag"+flag);
				 if(flag==1)
				 {
					 //nov[i]=nov[i]+r;
					 textField.setText("Yes");
					 flag1=0;
					 flag2=0;
					 //f=1;
					 //choose++;
					 
				 }
				 else
				 {
					 textField.setText("No");
					 dd=1;
					 
					 //btnNewButton.setEnabled(false);
				 }
				 
			 }
			
		 
		 else if(inm==12)
		 {
			 for(int i=ind;i<=oud;i++)
			 {
				 int left=(20-dec[i]);
				 if(left<r)
				 {
				    flag=0;	 
				 }
			 }
				 if(flag==1)
				 {
					 //dec[i]=dec[i]+r;
					 textField.setText("Yes");
					 flag1=0;
					 flag2=0;
					 //f=1;
					 //choose=choose+2;
				 }
				 else
				 {
					 textField.setText("No");
					 dd=1;
					 
				 }
				 
			 } 
		 }
		 
		
		else if(flag==1 && flag2==1)
		{	////System.out.println("Hi11111");
			for(int i=ind;i<=30;i++)
			{
				int left=(20-nov[i]);
				 if(left <r)
				 {
				    flag1=0;	 
				 }
			}
			for(int i=1;i<=oud;i++)
			{
				int left=(20-dec[i]);
				 if(left <r)
				 {
				    flag2=0;	 
				 }
			}
			if(flag1==1 && flag2==1)
			{
				textField.setText("Yes");
				flag=0;
				//f=1;
				//choose=choose+3;
			}
			else
			{
				textField.setText("No");
				dd=1;
			}
			
		}
		//////System.out.println("flag="+flag);
		//////System.out.println("flag1="+flag1);
		//////System.out.println("flag2="+flag2);
		
		
		
		
		JLabel lblAmenitiesAvailable = new JLabel("Amenities Available:");
		lblAmenitiesAvailable.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		lblAmenitiesAvailable.setBounds(55, 124, 189, 14);
		contentPane.add(lblAmenitiesAvailable);
		
		JLabel lblNewLabel = new JLabel(" Air Conditioner");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\air-conditioner (1).png"));
		lblNewLabel.setBounds(55, 162, 130, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" Complementary Breakfast");
		lblNewLabel_1.setEnabled(false);
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
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\monitor.png"));
		lblNewLabel_3.setBounds(55, 267, 74, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Parking and Rental");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\DRISHTI MAMTANI\\Downloads\\Hotel_Booking_Portal-master\\Image\\parking.png"));
		lblNewLabel_4.setBounds(55, 302, 144, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" Toiletries");
		lblNewLabel_5.setEnabled(false);
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
		
		
		
		JButton btnNumberOfFeedbacks = new JButton("Ratings and Feedback");
		btnNumberOfFeedbacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Review r=new Review();
				r.setVisible(true);
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
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setEditable(false);
		textField_1.setBounds(399, 378, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		int roo=Integer.parseInt(rooms);
		System.out.println(days);
		final int price=(int) (days*5000*roo);
		String p=Integer.toString(price);
		textField_1.setText(p);
		
		JButton btnNewButton = new JButton("Book Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag==1 || (flag1==1 && flag2==1) )
				{if(inm==11 && flag==1 && !(flag1==1 && flag2==1))
				{
					for(int i=ind;i<=oud;i++)
					 {
						 nov[i]=nov[i]+r;
					 }
				}
				else if(inm==12 && flag==1 && !(flag1==1 && flag2==1))
				{
						for(int i=ind;i<=oud;i++)
						 {
							 dec[i]=dec[i]+r;
						 }
				
				}
				else if(flag==0 && flag1==1 && flag2==1)
				{	//////System.out.println("Hi");
					for(int i=ind;i<=30;i++)
					 {
						 nov[i]=nov[i]+r;
					 }
					for(int i=1;i<=oud;i++)
					 {
						 dec[i]=dec[i]+r;
					 }
				}
					
				}
				/*System.out.println("nov");
				for(int i=1;i<=30;i++)
				{
					////System.out.println("Day"+i+"="+nov[i]);
				}
				////System.out.println("dec");
				for(int i=1;i<=31;i++)
				{
					////System.out.println("Day"+i+"="+dec[i]);
				}
				*/
				
				try {
					//nov[0]=11;
					//nov[1]=6;
					////System.out.println("nov");
					for(int i=1;i<=30;i++)
					{int x=nov[i];
					////System.out.println("Day"+i+"="+x);
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
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					//connection.close();
					}
				}
				
					
					
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String query="Update user_data set Hotel='Ruby' where username='"+person+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					//connection.close();
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String query="Update user_data set Totalprice='"+price+"' where username='"+person+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					//connection.close();
					
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				try {
					String query="Update user_data set noofdays='"+days+"' where username='"+person+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					pst.close();
					connection.close();
				}
				catch(Exception en)
				{
					en.printStackTrace();
				}
				Details details=new Details(person,price);
				details.setVisible(true);
					
				
			}
			
		});
		
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(197, 407, 152, 39);
		contentPane.add(btnNewButton);
		if(dd==1)
			{
			btnNewButton.setEnabled(false);
			}
		
		
		//contentPane.add(btnNewButton);
		
		
		JButton btnContinue = new JButton("Continue");
		if(dd==0)
		{
			btnContinue.setEnabled(false);
		}
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dd==1)
				{
					Wait1 w=new Wait1(person,checkin,checkout,rooms,days,loc,ho);
					w.setVisible(true);
				}
				
			}
		});
		btnContinue.setBounds(373, 416, 97, 25);
		contentPane.add(btnContinue);
		if(textField.getText()=="No")
		
			btnNewButton.setEnabled(false);
		
		
		
		
		
		
	}//end of constructor
	
	
	
	//Connection connection=null;
	
	
	
	String findDate(String d)
	{
		//String d="Thu Nov 29 19:48:48 IST 2018";
		//String dates="a";
	
		String month="a";
		//String year="a";
		//String dash="-";
		String fin="a";
		//int digit=0;
		char a1=d.charAt(8);
		char a2=d.charAt(9);
		
		String a11=String.valueOf(a1); 
		String a12=String.valueOf(a2); 
		String dates=a11+a12;
		
		
		
		
		char a3=d.charAt(4);
		char a4=d.charAt(5);
		char a5=d.charAt(6);
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
		
		int n=d.length();
		char y1=d.charAt(n-4);
		char y2=d.charAt(n-3);
		char y3=d.charAt(n-2);
		char y4=d.charAt(n-1);
		String s1=String.valueOf(y1); 
		String s2=String.valueOf(y2); 
		String s3=String.valueOf(y3); 
		String s4=String.valueOf(y4); 
		//year=s1+s2+s3+s4;
		
		fin=dates+month;
		return fin;
	}
}

