<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Display DTO List</title>


</head>
<body>
    <form action="updateStatus" method="post">
        <!-- Search bar for filtering the table -->

        <!-- Table displaying the data -->
        <table border="1">
          <tr>

            <th>Name</th>
            <th>Area</th>
            <th>Phone</th>
            <th>Age</th>
            <th>Status</th>
            <th>Reason</th>
             <th>Action</th>
          </tr>
          <tr>
         <c:forEach items="${list}" var="dto">
             <tr>
                 <form action="updateStatus" method="post">
                     <input type="hidden" name="enquiryId" value="${dto.id}" />
                     <input type="hidden" name="enquiryName" value="${dto.name}" />
                     <td>${dto.name}</td>
                     <td>${dto.area}</td>
                     <td>${dto.phoneNumber}</td>
                     <td>${dto.age}</td>
                     <td>
                         <select class="form-select" name="status" required>
                             <option value="Pending" ${dto.status == 'Pending' ? 'selected' : ''}>Pending</option>
                             <option value="Completed" ${dto.status == 'Completed' ? 'selected' : ''}>Completed</option>
                             <option value="In Progress" ${dto.status == 'In Progress' ? 'selected' : ''}>In Progress</option>
                         </select>
                     </td>
                     <td>
                         <input type="text" name="reason" value="${dto.reason}" />
                     </td>
                     <td>
                         <button type="submit" class="btn btn-success w-100">Submit</button>
                     </td>
                 </form>
             </tr>
         </c:forEach>



        </table>


    </form>
</body>
</html>
