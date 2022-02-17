<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Owner List</title>
        
         
        
    </head>
    <body>
    <h1>Owners</h1> 
		<form action="Controller" method="POST">
			<button type="submit" id="doUpdateOwner" name="doUpdateOwner"> Update</button>
			<button type="submit" id="deleteOwner" name="deleteOwner"> Delete </button>
			<button type="submit" id="addOwner" name="addOwner"> Add </button>
			<button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
            Owner <select name="OwnerID">
                <c:forEach var="ownerEntry" items="${ownerMap}">
                	<option value="${ownerEntry.value.ownerId}">${ownerEntry.value.ownerId}</option>
                </c:forEach>
            </select><br><br>
        </form>
        
        <table border = 1>
			<tr>
				<th>Owner ID</th> <th>First Name</th> <th>Last Name</th> <th>Phone Number</th> <th>Home Address</th> <th>Email</th>
			</tr>

			<c:forEach var="ownerEntry" items="${ownerMap}">
				<tr>
					<td>${ownerEntry.value.ownerId}</td>
					<td>${ownerEntry.value.firstName}</td> 
					<td>${ownerEntry.value.lastName}</td> 
					<td>${ownerEntry.value.phoneNumber}</td> 
					<td>${ownerEntry.value.homeAddress}</td> 
					<td>${ownerEntry.value.emailAddress}</td>
				</tr>
        	</c:forEach>
		</table>
        
    </body>
</html>