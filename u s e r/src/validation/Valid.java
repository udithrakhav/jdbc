package validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Valid  extends HttpServlet 
{  
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException 
	{  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("user");  
	    String p=request.getParameter("pass");  
	          
	    if(Verfiy.validate(n, p))
	    {  
	        RequestDispatcher rd=request.getRequestDispatcher("thank.html");  
	        rd.forward(request,response);  
	    }  
	    else
	    {  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("checking.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
	}  
