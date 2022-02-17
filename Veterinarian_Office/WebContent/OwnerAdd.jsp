<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Owner</title>
    </head>
    <body>
        <div id="add">
        <h1> Add Owner </h1>
        <form action="Controller" method="POST">
        	<input type="submit" name="addOwner" value="Add">
            <button type="submit" name="showAllOwners">Cancel</button>
            <button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
        </form>
        <form action="Controller" method="GET">
            <table>
                <tr>
                    <td> Owner Id: </td>
                    <td><input type="text" name="OwnerID"></td>
                </tr>
                <tr>
                    <td> First Name: </td>
                    <td><input type="text" name="FirstName"></td>
                </tr>
                <tr>
                    <td> Last Name: </td>
                    <td><input type="text" name="LastName"></td>
                </tr>
                <tr>
                    <td> Phone Number: </td>
                    <td><input type="text" name="PhoneNumber"></td>
                </tr>
                <tr>
                    <td> Home Address: </td>
                    <td><input type="text" name="HomeAddress"></td>
                </tr>
                <tr>
                    <td> Email Address: </td>
                    <td><input type="text" name="EmailAddress"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>