package validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Verfiy
{

	public static boolean validate(String name,String pass)
	{  
		boolean status=false;  
		try
		{  
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");  
      
			PreparedStatement ps=con.prepareStatement("select * from new where NAME=? and PASSWORD=?");  
			ps.setString(1,name);  
			ps.setString(2,pass);  

			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
          
		}
		catch(Exception e){System.out.println(e);}  
		return status;  
	}  
}  
