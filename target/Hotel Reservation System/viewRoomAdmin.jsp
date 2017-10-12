<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/10/2017
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="adminPage.jsp"%>
<html>
<head>
    <title>View Rooms</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="20%">Room Number</th>
        <th width="20%">Room Category</th>
        <th width="20%">Description</th>
        <th width="20%">Cost of the Room</th>
        <th width="20%">Status of Room </th>

        <th width="20%">Action</th>

    </tr>
    <c:forEach var="rooms" items="${viewroomlist}">
        <tr>
            <td width="20%"><c:out value="${rooms.room_number}"></c:out></td>
            <td width="20%"><c:out value="${rooms.roomCategory}"></c:out></td>
            <td width="20%"><c:out value="${rooms.room_description}"></c:out></td>
            <td width="20%"><c:out value="${rooms.room_rent}"></c:out></td>
            <td width="20%"><c:out value="${rooms.room_status}"></c:out></td>
            <form action="DeleteRoomMap" method="post">
              <input type="hidden" name="number" value="${rooms.room_number}">
                <td width="20%"><input type="submit" value="Delete"></td>
            </form>


                <%--<td width="20%"><a href=""> Edit</a> </td>
                <td width="20%"><a href=""> Delete</a> </td>--%>

        </tr>


    </c:forEach>
</TABLE>
</body>
</html>
