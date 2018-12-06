<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<link rel="stylesheet" type="text/css" href="MyCss.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create your profile:</h1>



<center><img src="${user.pic}"><br>
${user.studentName}</center>
<br><br>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost/groupproject" user="root" password="1234"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM school;
</sql:query>

<form  method="post">
<select onchange="submit()" name="schools" id="kk">
<option>Select your school
<c:forEach var="row" items="${result.rows}">
<option value= "<c:out value='${row.schoolid}'/>"><c:out value="${row.schoolname}"/>
</c:forEach>
</select>
</form>
<c:choose>
<c:when test="${param.schools=='1'}">
<p>Sheridan</p>
<sql:query dataSource="${snapshot}" var="resultt">
SELECT * FROM program WHERE schoolid='1';
</sql:query> 
</c:when>

<c:when test="${param.schools=='2'}">
<p>George Brown</p>
<sql:query dataSource="${snapshot}" var="resultt">
SELECT * FROM program WHERE schoolid='2';
</sql:query>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>





<form action="Courses.jsp" method="post">
<select  name="programs">
<c:forEach var="row" items="${resultt.rows}">
<option value="<c:out value="${row.programid}"/>"  id="program"><c:out value="${row.programname}"/></option>
</c:forEach>
</select>
<input type="hidden" value="${param.schools}" name="schoolid"/>
<input type="submit"/>
</form>






</body>
</html>