<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/11/2017
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="adminPage.jsp"%>
<html>
<head>
    <title>View Booked Rooms</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="20%">Customer Name </th>
        <th width="20%">Room Number</th>
        <th width="20%">Room Category</th>

        <th width="20%">Cost of the Room</th>


        <th width="20%">Release Room</th>

    </tr>
    <c:forEach var="books" items="${viewroomlist}">
        <tr>
            <td width="20%"><c:out value="${books.cust_name}"></c:out></td>
            <td width="20%"><c:out value="${books.room_number}"></c:out></td>
            <td width="20%"><c:out value="${books.roomCategory}"></c:out></td>
            <td width="20%"><c:out value="${books.room_rent}"></c:out></td>


            <form action="releaseMap" method="post">
                <input type="hidden" name="number" value="${books.room_number}">
                <td width="20%"><input type="submit" value="UnBook"></td>
            </form>


                <%--<td width="20%"><a href=""> Edit</a> </td>
                <td width="20%"><a href=""> Delete</a> </td>--%>

        </tr>


    </c:forEach>
</TABLE>
</body>
</html>
