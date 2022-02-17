<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visit List</title>
        
        
        
    </head>
    <body>
    <h1>Visits</h1> 
        <form action="Controller" method="POST">
        	<button type="submit" id="dateFilter" name="dateFilter">Date Filter</button>
        	<input id="Date" type="text" name="Date"><br>
        	<button type="submit" id="doUpdateVisit" name="doUpdateVisit"> Update</button>
            <button type="submit" id="deleteVisit" name="deleteVisit"> Delete </button>
            <button type="submit" id="addVisit" name="addVisit"> Add </button>
            <button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
            Visit ID <select name="VisitID">
                <c:forEach var="visitEntry" items="${visitMap}">
                	<option value="${visitEntry.value.visitId}">${visitEntry.value.visitId}</option>
                </c:forEach>
            </select><br><br>
       	</form>

		<table border = 1>
			<tr>
				<th>Visit ID</th> <th>Pet ID</th> <th>Date</th> <th>Weight</th> <th>SymptomDescription</th> <th>Diagnosis</th> <th>Treatment</th>
			</tr>

			<c:forEach var="visitEntry" items="${visitMap}">
				<tr>
					<td>${visitEntry.value.visitId}</td>
					<td>${visitEntry.value.petId}</td>
					<td>${visitEntry.value.date}</td> 
					<td>${visitEntry.value.weight}</td> 
					<td>${visitEntry.value.symptomDescription}</td> 
					<td>${visitEntry.value.diagnosis}</td>
					<td>${visitEntry.value.treatment}</td>
				</tr>
        	</c:forEach>
		</table>
        
    </body>
</html>