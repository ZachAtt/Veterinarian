<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
</head>

<style>
	.center {
	  margin: 0;
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  -ms-transform: translate(-50%, -50%);
	  transform: translate(-50%, -50%);
	}
</style>

<body>
	
	<div class="center">
	<h1> Healthy Pet Veterinarian </h1>
		<form action="Controller" method="POST">
			<input type="submit" name="showAllOwners" value="Show Owners"> &nbsp; &nbsp;
			<input type="submit" name="showAllPets" value="Show Pets"> &nbsp; &nbsp;
			<input type="submit" name="showAllVisits" value="Show Visits"> &nbsp; &nbsp;
			<br><br><br><br><br><br><br><br><br><br>
		</form>
	</div>
	
	<div class="center">
		<button type="submit" onclick="window.open('', '_self', ''); window.close();">Quit</button>
	</div>
	
</body>
</html>