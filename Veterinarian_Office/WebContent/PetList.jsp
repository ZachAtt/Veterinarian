<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet List</title>
        
        
    </head>
    <body>
        <h1>Pets</h1> 
        <form action="Controller" method="POST">
        	<button type="submit" id="doUpdatePet" name="doUpdatePet"> Update</button>
            <button type="submit" id="deletePet" name="deletePet"> Delete </button>
            <button type="submit" id="addPet" name="addPet"> Add </button>
            <button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
            Pet <select name="PetID">
                <c:forEach var="petEntry" items="${petMap}">
                	<option value="${petEntry.value.petId}">${petEntry.value.petId}</option>
                 </c:forEach>
            </select><br><br>
       	</form>

		<table border = 1>
			<tr>
				<th>Pet ID</th> <th>Name</th> <th>Pet Type</th> <th>Breed</th> <th>Gender</th> <th>Size</th> <th>Owner ID</th>
			</tr>

			<c:forEach var="petEntry" items="${petMap}">
				<tr>
					<td>${petEntry.value.petId}</td>
					<td>${petEntry.value.name}</td> 
					<td>${petEntry.value.petType}</td> 
					<td>${petEntry.value.breed}</td> 
					<td>${petEntry.value.gender}</td> 
					<td>${petEntry.value.size}</td>
					<td>${petEntry.value.ownerId}</td>
				</tr>
        	</c:forEach>
		</table>    
    </body>
</html>