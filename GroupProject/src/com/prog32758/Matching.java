package com.prog32758;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prog32758.Student;


public class Matching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Matching() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String uId =((Student)session.getAttribute("user")).getUserId();
		String schId = request.getParameter("schoolid");
		String progId = request.getParameter("programid");
		String[] courses = request.getParameterValues("courses");
		
		   
		
		Connection connect=null;
		try {Class.forName("com.mysql.jdbc.Driver");
		
		        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject?user=root&password=1234");
		          
		        String st = "select * from grade where ;
	            PreparedStatement pstatement = connect.prepareStatement(st);
					
		            for(int i =0;i<courses.length;i++) {		            
		            pstatement.setString(1,uId);
		            pstatement.setString(2,schId);
		            pstatement.setString(3,progId);
		            pstatement.setInt(4,1);
		            pstatement.setString(5,courses[i]);
		            pstatement.setDouble(7,Double.parseDouble(request.getParameter(courses[i])));
		            int k=((request.getParameter(courses[i]+"+a"))==null)?0:1;
		            pstatement.setInt(6,k);
		            pstatement.executeUpdate();
		            }
		       }catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}finally {response.sendRedirect("Matching.jsp");}
	}

}
