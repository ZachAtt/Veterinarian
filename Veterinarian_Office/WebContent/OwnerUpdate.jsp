<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Owner ${owner.ownerId}</title>
</head>
<body>
	<h1> Update Owner </h1>
	<form action="Controller" method="POST">
            <button type="submit" id="updateOwner" name="updateOwner"> Update</button>
            <button type="submit" id="cancel" name="showAllOwners"> Cancel </button><br> <br>
            Owner Identifier: ${owner.ownerId}<br>
            Update First Name: <input id="FirstName" type="text" name="FirstName" value = "${owner.firstName}"><br>
            Update Last Name: <input id="LastName" type="text" name="LastName" value = "${owner.lastName}"> <br>
            Update Phone Number: <input id="PhoneNumber" type="text" name="PhoneNumber" value = "${owner.phoneNumber}"> <br>
            Update Home Address: <input id="HomeAddress" type="text" name="HomeAddress" value = "${owner.homeAddress}"> <br>
            Update Email Address: <input id="EmailAddress" type="text" name="EmailAddress" value = "${owner.emailAddress}"> <br><br><br><br>
        </form>

</body>
</html>