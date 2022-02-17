<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Visit ${visit.visitId}</title>
</head>
<body>
	<h1> Update Visit </h1>
	<form action="Controller" method="POST">
            <button type="submit" id="updateVisit" name="updateVisit"> Update</button>
            <button type="submit" id="cancel" name="showAllVisits"> Cancel </button><br> <br>
            Visit Identifier: ${visit.visitId}<br>
            Update PetID: <input id="PetID" type="text" name="PetID" value = "${visit.petId}"><br>
            Update Date: <input id="Date" type="text" name="Date" value = "${visit.date}"><br>
            Update Weight: <input id="Weight" type="text" name="Weight" value = "${visit.weight}"><br>
            Update Symptom Description: <input id="SymptomDescription" type="text" name="SymptomDescription" value = "${visit.symptomDescription}"><br>
            Update Diagnosis: <input id="Diagnosis" type="text" name="Diagnosis" value = "${visit.diagnosis}"><br>
            Update Treatment: <input id="Treatment" type="text" name="Treatment" value = "${visit.treatment}"><br><br><br><br>
        </form>

</body>
</html>