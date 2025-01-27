<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Registration</title>
</head>
<body>
    <h2>Admin Registration Details</h2>

    <form action="yourSubmitUrl" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" value="${adminRegEntity.id}" readonly /><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${adminRegEntity.name}" readonly /><br><br>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${adminRegEntity.email}" readonly /><br><br>

        <label for="gymName">Gym Name:</label>
        <input type="text" id="gymName" name="gymName" value="${adminRegEntity.gymName}" readonly /><br><br>

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" value="${adminRegEntity.amount}" readonly /><br><br>

        <label for="instalment">Instalment:</label>
        <input type="text" id="instalment" name="instalment" value="${adminRegEntity.instalment}" readonly /><br><br>

        <label for="discount">Discount:</label>
        <input type="text" id="discount" name="discount" value="${adminRegEntity.discount}" readonly /><br><br>

        <label for="balance">Balance:</label>
        <input type="text" id="balance" name="balance" value="${adminRegEntity.balance}" readonly /><br><br>

        <label for="trainer">Trainer:</label>
        <input type="text" id="trainer" name="trainer" value="${adminRegEntity.trainer}" readonly /><br><br>

        <label for="packaged">Packaged:</label>
        <input type="text" id="packaged" name="packaged" value="${adminRegEntity.packaged}" readonly /><br><br>


        <label for="filePath">File Path:</label>
        <input type="text" id="filePath">
        <br>

        <a href="EditProfile.jsp">edit profile</a>
        <a href="ResetPassword">reset password</a>

