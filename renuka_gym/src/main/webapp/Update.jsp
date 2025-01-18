<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Display DTO List</title>
</head>
<body>
    <form action="updateRegDetails" method="post">
        <!-- Table displaying the data -->
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Discount</th>
                <th>GymName</th>
                <th>Instalment</th>
                <th>Package</th>
                <th>Trainer</th>
                <th>Amount</th>
                <th>Balance</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="dto">
                <tr>
                    <!-- Hidden field for registerId -->
                    <input type="hidden" name="registerId" value="${dto.id}" />
                    <td>${dto.name}</td>
                    <td>${dto.email}</td>
                    <td>${dto.password}</td>
                    <td>${dto.discount}</td>
                    <td>
                        <label for="gymName" class="form-label"></label>
                        <select id="gymName" name="gymName" class="form-control">
                            <option value="">Select Gym</option>
                            <c:forEach items="${listOfGymname}" var="gymName">
                                <option value="${gymName}">${gymName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>${dto.instalment}</td>
                    <td>
                        <select id="packaged" name="packaged" class="form-control">
                            <option value="">Select Package</option>
                            <c:forEach items="${listOfPackageEnum}" var="packaged">
                                <option value="${packaged}"

                                >${packaged}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select id="trainer" name="trainer" class="form-control">
                            <option value="">Select Trainer</option>
                            <c:forEach items="${listOftrainer}" var="trainer">
                                <option value="${trainer}"
                                        <c:if test="${trainer == dto.trainer}">selected</c:if>
                                >${trainer}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="text" name="amount" value="${dto.amount}" /></td>
                    <td><input type="text" name="balance" value="${dto.balance}" /></td>
                    <td>
                        <button type="submit" class="btn btn-success w-100">Submit</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>
