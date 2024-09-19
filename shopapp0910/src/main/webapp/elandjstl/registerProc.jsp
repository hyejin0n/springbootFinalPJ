<%@ page language = "java" 
		 contentType = "text/html;
		 charset=UTF-8" pageEncoding="UTF-8"%> 
		 
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
		<title> registerProc </title>
	</head>
	<body>
		<h2> registerProc </h2>
		<%
			String name = request.getParameter("name");
			String email = request.getParameter("email");
		%>
		<p> name : <%= name %> </p>
		<p> email : <%= email %> </p>
		<p> name : ${param.name} </p>
		<p> email : ${param.email} </p>	
		<p> hobby : ${paramValues.hobby[0]}
		 			${paramValues.hobby[1]} 
					${paramValues.hobby[2]}
		</p>	
	</body>
</html>