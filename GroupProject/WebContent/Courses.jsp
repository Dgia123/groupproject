<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="MyCss.css"/>
</head>
<body>
${param.schoolid}
${param.programs}


<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost/groupproject" user="root" password="1234"/>


    <c:choose>
<c:when test="${param.schoolid=='1'}">
<c:choose>
<c:when test="${param.programs=='COMPP'}">
<p>Computer Programmer</p>
<sql:query dataSource = "${snapshot}" var="resulttt">
SELECT * FROM course WHERE schoolid='1' and programid='COMPP';
</sql:query></c:when>
<c:when test="${param.programs=='SDNE'}">
<p>SDNE</p>
<sql:query dataSource = "${snapshot}" var="resulttt">
SELECT * FROM course WHERE schoolid='1' and programid='SDNE';
</sql:query>
</c:when>
<c:when test="${param.programs=='SOEN'}">
<p>Software Engineering</p>
<sql:query dataSource = "${snapshot}" var="resulttt">
SELECT * FROM course WHERE schoolid='1' and programid='SOEN';
</sql:query>
</c:when>
</c:choose>
</c:when>
        



<c:when test="${param.schoolid=='2'}">
<c:choose>
<c:when test="${param.programs=='T127'}">
<p>ComputerProgrammerAnalysis</p>
<sql:query dataSource = "${snapshot}" var="resulttt">
SELECT * FROM course WHERE schoolid='2' and programid='T127';
</sql:query></c:when>
<c:when test="${param.programs=='T147'}">
<p>ComputerSystemsTechnicien</p>
<sql:query dataSource = "${snapshot}" var="resulttt">
SELECT * FROM course WHERE schoolid='2' and programid='T147';
</sql:query>
</c:when>
</c:choose>
</c:when>
        </c:choose>
        
        
<form action="CreateProfile" method="post">

<c:forEach var="row" items="${resulttt.rows}">
<input type="checkbox" name="courses" value="${row.courseid}" id="course">${row.coursename} 
<span id="gradeneed">
<input type="number" max="100" min="0" name="${row.courseid}"  placeholder="Grade"/>
<input type="checkbox" name="${row.courseid}+a" value="1" />Need Help?</span><br><br><br></input>
</c:forEach>

<input type="hidden" value="${param.schoolid}" name="schoolid"/>
<input type="hidden" value="${param.programs}" name="programid"/>
<input type="submit"/>
</form>


</body>
</html>