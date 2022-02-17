<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Pet ${pet.petId}</title>
</head>
<body>
	<h1> Update Pet </h1>
	<form action="Controller" method="POST">
            <button type="submit" id="updatePet" name="updatePet"> Update</button>
            <button type="submit" id="cancel" name="showAllPets"> Cancel </button><br> <br>
            Pet Identifier: ${pet.petId}<br>
            Update Name: <input id="Name" type="text" name="Name" value = "${pet.name}"><br>
            Update Pet Type: <input id="PetType" type="text" name="PetType" value = "${pet.petType}"> <br>
            Update Breed: <input id="Breed" type="text" name="Breed" value = "${pet.breed}"> <br>
            Update Gender: <input id="Gender" type="text" name="Gender" value = "${pet.gender}"> <br>
            Update Size: <input id="Size" type="text" name="Size" value = "${pet.size}"> <br>
            Update OwnerID: <input id="OwnerID" type="text" name="OwnerID" value = "${pet.ownerId}"><br><br><br><br>
        </form>

</body>
</html>