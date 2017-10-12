<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/10/2017
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="customerPage.jsp"%>
<html>
<head>
    <title>View Unbook Rooms</title>
</head>
<body>
<form action="bookRoomMap" method="post">
<TABLE BORDER="3" width="100%" class="table">
    <%="Welcome:"+request.getAttribute("customerSession")%>
    <tr>
        <th width="16%">Room Number</th>
        <th width="16%">Room Category</th>
        <th width="16%">Room Description</th>
        <th width="16%">Rent of the Room</th>
        <th width="16%">Status of Room</th>
        <th width="16%">Check to Book</th>

               <%-- <th width="20%">Action</th>
             <th width="20%">Action</th>
     --%>
    </tr>
    <c:forEach var="roomsUnbook" items="${viewUnbooklist}">
        <tr>
            <td width="16%"><c:out value="${roomsUnbook.room_number}"></c:out></td>
            <td width="16%"><c:out value="${roomsUnbook.roomCategory}"></c:out></td>
            <td width="16%"><c:out value="${roomsUnbook.room_description}"></c:out></td>
            <td width="16%"><c:out value="${roomsUnbook.room_rent}"></c:out></td>
            <td width="16%"><c:out value="${roomsUnbook.room_status}"></c:out></td>
            <td width="16%"> <input type="checkbox" name="chB" value ="${roomsUnbook.room_number}" ></td>


                <%--<td width="20%"><a href=""> Edit</a> </td>
                <td width="20%"><a href=""> Delete</a> </td>--%>

        </tr>


    </c:forEach>
</TABLE>
<button class="btn btn-info">Book</button>
</form>
</body>
</html>
