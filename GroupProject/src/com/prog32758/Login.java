package com.prog32758;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
//hello
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uId = request.getParameter("uid");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		Connection connect=null;
		try {Class.forName("com.mysql.jdbc.Driver");
		
		        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject?user=root&password=1234");
		          
		           
					String st = "select * from users where userid=?";
		            PreparedStatement pstatement = connect.prepareStatement(st);
		           
		            pstatement.setString(1, uId);
		            ResultSet resultset=pstatement.executeQuery();
		            if(resultset.next()) {
		        	   
		        	   if(pw.equals(resultset.getString(5))) {
		        		  Student user = new Student(); 
		        		  
		        			  user.setUserId(resultset.getString(1));
		        			  user.setStudentName(resultset.getString(2));
		        			  user.setGender(resultset.getString(3));
		        			  user.setPic(resultset.getString(4));
		        			  user.setPassWord(resultset.getString(5));
		        			  user.setTutorRank(resultset.getDouble(6));
		        			  
		        		  
		        		      session.setAttribute("user",user );
		        		      connect.close();
		        		      response.sendRedirect("Forum.jsp");
		        	       }else {session.setAttribute("resu", "PassWord is not correct, please try again.");
		        	               response.sendRedirect("index.jsp");}
		                }else {session.setAttribute("resu", "UserID doesn't exist, Please Sign up first.");
		                              response.sendRedirect("index.jsp");    
		                             }
		       }catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
	}

}