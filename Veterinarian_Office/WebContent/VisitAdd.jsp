<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visit History</title>
    </head>
    <body>
        <div id="add">
        <h1> Add Visit </h1>
        <form action="Controller" method="POST">
        	<input type="submit" name="addVisit" value="Add">
            <button type="submit" name="showAllVisits">Cancel</button>
            <button type="submit" id="mainMenu" name="mainMenu"> Main Menu </button><br><br>
        </form>
        <form action="Controller" method="GET">
            <table>
                <tr>
                    <td> Visit Id: </td>
                    <td><input type="text" name="VisitID"></td>
                </tr>
                <tr>
                    <td> Pet Id: </td>
                    <td><input type="text" name="PetID"></td>
                </tr>
                <tr>
                    <td> Date: </td>
                    <td><input type="text" name="Date"></td>
                </tr>
                <tr>
                    <td> Weight: </td>
                    <td><input type="text" name="Weight"></td>
                </tr>
                <tr>
                    <td> Symptom Description: </td>
                    <td><input type="text" name="SymptomDescription"></td>
                </tr>
                <tr>
                    <td> Diagnosis: </td>
                    <td><input type="text" name="Diagnosis"></td>
                </tr>
                <tr>
                    <td> Treatment: </td>
                    <td><input type="text" name="Treatment"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>