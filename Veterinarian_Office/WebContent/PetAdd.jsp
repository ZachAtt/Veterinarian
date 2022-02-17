<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet</title>
    </head>
    <body>
        <div id="add">
        <h1> Add Pet </h1>
        <form action="Controller" method="POST">
        	<input type="submit" name="addPet" value="Add">
            <button type="submit" name="showAllPets">Cancel</button>
            <button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
        </form>
        <form action="Controller" method="GET">
            <table>
                <tr>
                    <td> Pet Id: </td>
                    <td><input type="text" name="PetID"></td>
                </tr>
                <tr>
                    <td> Name: </td>
                    <td><input type="text" name="Name"></td>
                </tr>
                <tr>
                    <td> Pet Type: </td>
                    <td><input type="text" name="PetType"></td>
                </tr>
                <tr>
                    <td> Breed: </td>
                    <td><input type="text" name="Breed"></td>
                </tr>
                <tr>
                    <td> Gender: </td>
                    <td><input type="text" name="Gender"></td>
                </tr>
                <tr>
                    <td> Size: </td>
                    <td><input type="text" name="Size"></td>
                </tr>
                <tr>
                    <td> Owner Id: </td>
                    <td><input type="text" name="OwnerID"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>