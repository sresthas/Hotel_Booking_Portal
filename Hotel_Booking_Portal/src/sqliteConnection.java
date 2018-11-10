import java.sql.*;
import javax.swing.*;
public class sqliteConnection
{
	Connection conn=null;      //Connection is a datatype
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\DRISHTI MAMTANI\\UserInfo.sqlite");
			//JOptionPane.showMessageDialog(null,"Connection Successful");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
}