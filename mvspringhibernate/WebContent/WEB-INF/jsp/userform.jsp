<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Form</title>
    </head>
    <body>
     <form:form method="post" action="saveuser">    
        <table >    
         <tr>    
          <td>user ID : </td>   
          <td><form:input path="userId"  /></td>  
         </tr>    
         <tr>    
          <td>Name :</td>    
          <td><form:input path="userName" /></td>  
         </tr>   
         <tr>    
          <td>Created By :</td>    
          <td><form:input path="createdBy" /></td>  
         </tr>   
         <tr>    
          <td>Created Date :</td>    
          <td><form:input path="createdDate"  /></td>  
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    


    </body>
</html>
