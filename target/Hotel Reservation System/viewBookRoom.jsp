<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/10/2017
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="customerPage.jsp"%>
<html>
<head>
    <title>View Room</title>
</head>
<body>
<form action="payMap" method="post">
<TABLE BORDER="3" width="100%" class="table">
        <tr>
            <th width="20%"> Customer Name</th>
            <th width="20%">Room Number</th>
            <th width="20%">Room Category</th>
            <th width="20%">Room Description </th>
            <th width="20%">Rent of Room </th>




        </tr>
        <c:forEach var="bookroom" items="${viewBroomlist}">
            <tr>
                <td width="20%"><c:out value="${bookroom.cust_name}"></c:out></td>
                <td width="20%"><c:out value="${bookroom.room_number}"></c:out></td>
                <td width="20%"><c:out value="${bookroom.roomCategory}"></c:out></td>
                <td width="20%"><c:out value="${bookroom.room_description}"></c:out></td>
                <td width="20%"><c:out value="${bookroom.room_rent}"></c:out></td>


                <input type="hidden" name="number" value="${bookroom.room_number}">



            </tr>


        </c:forEach>
    </TABLE>
    <button class="btn btn-info">Confirm</button>

</form>
<%--<button class="btn btn-info">GoBack <a href="viewRoomCustomer.jsp"></a> </button>--%>
</body>
</html>
