<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
  <h2>Register</h2>
  <div>
    <jsp:useBean id="reg" class="com.sunbeam.RegistrationBean"/>
   <jsp:setProperty property="first_name" name="reg" param="first_name"/>
   <jsp:setProperty property="last_name" name="reg" param="last_name"/>
   <jsp:setProperty property="email" name="reg" param="email"/>
   <jsp:setProperty property="password" name="reg" param="password"/>
   <jsp:setProperty property="dob" name="reg" param="dob"/>
    ${reg.registerUser()}<br/>
  </div>
 <c:choose>
    <c:when test="${lg.user != null }" >
		<c:choose>
			<c:when test="${lg.user.role == 'admin'}">
			    <p>Login Successful...</p>
				<c:redirect url="result.jsp"/>
		    </c:when>
			<c:otherwise>
				<c:redirect url="candlist.jsp"/>
			</c:otherwise>
        </c:choose>
	</c:when>
	<c:otherwise>
		<h1>Login Failed</h1>
		<p>Invalid Email or password </p>
		<a href="index.jsp" >Login again</a>
	</c:otherwise>
</c:choose>
  
  
  
</body>
</html>