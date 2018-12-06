package com.prog32758;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userId = request.getParameter("userid");
		String pw1= request.getParameter("pw1");
		String pw2= request.getParameter("pw2");
		String userName= request.getParameter("username");
		String gender= request.getParameter("gender");
		String pic="";
		HttpSession sess=request.getSession();
		Connection conne=null;
		ResultSet res=null;
		if(pw1.equals(pw2)) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupproject?user=root&password=1234");
			String ss="insert into users(userid,username,gender,pic,password)"
					+ "values(?,?,?,?,?)";
			PreparedStatement pst=conne.prepareStatement(ss);
			pst.setString(1,userId);
			pst.setString(2, userName);
			pst.setString(3, gender);
			pst.setString(5, pw1);
			if(gender.equals("m"))
				pic="Image/m.png";
			else if(gender.equals("f"))
				pic="Image/f.png";
				pst.setString(4,pic);
			int rss=pst.executeUpdate();
			out.println(rss);
			Student user = new Student(userId,userName,gender,pic,pw1);
			sess.setAttribute("user", user);
			conne.close();
			response.sendRedirect("Profile.jsp");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		}else {sess.setAttribute("resu","Two passwords are different.");
		response.sendRedirect("index.jsp");
		}
	}

}
