package validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Creation extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String s1=request.getParameter("username");
		String s2=request.getParameter("password");
		String s3=request.getParameter("email");

		try
		{
			
			Class.forName("org.h2.Driver");
			
            System.out.println("driver loaded");

			
			Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			
            System.out.println("CONNECTION DONE");
            
            String str="insert into new values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(str);
            
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setString(3, s3);
            
            ps.execute();
            pw.print("You are successfully registered...");
            con.close();


        }
		catch(Exception e)
		{
			
			pw.print(e);
			
		}
		
		
	}

}
