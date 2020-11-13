<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Create By</th><th>Create Date</th></tr>  
   <c:forEach var="u" items="${list}">   
   <tr>  
   <td>${u.userId}</td>  
   <td>${u.userName}</td>  
   <td>${u.createdBy}</td>  
   <td>${u.createdDate}</td>  
   </tr>  
   </c:forEach>  
   </table>

    </body>
</html>

