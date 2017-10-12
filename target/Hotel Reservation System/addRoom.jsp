<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/9/2017
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="adminPage.jsp"%>
<html>
<head>
    <title>Add Room</title>
</head>
<body>
<form method="post" action="addroomMap">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Register New Room</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Room Number</td>
                <td><input type="text" name="roomnumber" value="" /></td>
            </tr>
            <tr>
                <td>Room Category</td>
                <td>
                    <select name="category">
                        <option>PentHouse</option>
                        <option>Normal</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td>Room Description</td>
                <td>
                    <textarea name="descr"></textarea>

                </td>
            </tr>
            <tr>
                <td>Cost of Room</td>
                <td><input type="number" name="rent" value="" /></td>
            </tr>
            <tr>
                <td>Booked Status</td>
                <td>
                    <select name="status">
                        <option>BOOKED</option>
                        <option>UNBOOKED</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td><input type="submit" value="Add  Room" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
