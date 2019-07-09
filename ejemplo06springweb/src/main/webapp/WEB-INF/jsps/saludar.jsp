<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Singleton: ${objSingleton.nombre} - ${objSingleton.tipo} - ${objSingleton}</br>
Prototype: ${objPrototype.nombre} - ${objPrototype.tipo} - ${objPrototype}</br>
Request: ${objRequest.nombre} - ${objRequest.tipo} - ${objRequest}</br>
Session: ${objSession.nombre} - ${objSession.tipo} - ${objSession}</br>
</body>
</html>