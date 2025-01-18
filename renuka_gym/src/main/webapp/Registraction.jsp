<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">Register Details</h2>
        <form action="registerDetails" method="post" class="needs-validation" novalidate>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" name="name" class="form-control" onblur="handleValidate(event)" required>
                <div id="nameError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="text" id="email" name="email" class="form-control" onblur="handleValidate(event)" required>
                <div id="emailError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" class="form-control" onblur="handleValidate(event)" required>
                <div id="passwordError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="packaged" class="form-label">Packaged:</label>
                <select id="packaged" name="packaged" class="form-select" required>
                    <option value="">Select Package</option>
                    <c:forEach items="${listOfPackageEnum}" var="packaged">
                        <option value="${packaged}">${packaged}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" onblur="handleValidate(event)" required>
                <div id="phoneNumberError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="discount" class="form-label">Discount:</label>
                <input type="text" id="discount" name="discount" class="form-control" onblur="handleValidate(event)" required>
                <div id="discountError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="gymName" class="form-label">Gym Name:</label>
                <select id="gymName" name="gymName" class="form-select" required>
                    <option value="">Select Gym Name</option>
                    <c:forEach items="${listOfGymname}" var="gymName">
                        <option value="${gymName}">${gymName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="instalment" class="form-label">Instalment:</label>
                <input type="text" id="instalment" name="instalment" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="trainer" class="form-label">Trainer:</label>
                <select id="trainer" name="trainer" class="form-select" required>
                    <option value="">Select Trainer</option>
                    <c:forEach items="${listOftrainer}" var="trainer">
                        <option value="${trainer}">${trainer}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="amount" class="form-label">Amount:</label>
                <input type="text" id="amount" name="amount" class="form-control" onblur="handleValidate(event)" required>
                <div id="amountError" class="form-text"></div>
            </div>

            <div class="mb-3">
                <label for="balance" class="form-label">Balance:</label>
                <input type="text" id="balance" name="balance" class="form-control" onblur="handleValidate(event)" required>
                <div id="balanceError" class="form-text"></div>
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        const handleValidate = (event) => {
            const { name, value } = event.target;

            // Name validation
            if (name === "name") {
                if (value.length >= 4 && value.length <= 9 && value.trim()) {
                    document.getElementById("nameError").innerHTML = "<span style='color:green'>Name is Valid</span>";
                } else {
                    document.getElementById("nameError").innerHTML = "<span style='color:red'>Name is invalid (must be 4 to 9 characters)</span>";
                }
            }

            // Email validation
            if (name === "email" && value.includes("@gmail.com") && value.trim()) {
                document.getElementById("emailError").innerHTML = "<span style='color:green'>Email is Valid</span>";
            } else {
                document.getElementById("emailError").innerHTML = "<span style='color:red'>Email is invalid (must be a valid Gmail address)</span>";
            }

            // Password validation
            if (name === "password") {
                if (value.length >= 6) {
                    document.getElementById("passwordError").innerHTML = "<span style='color:green'>Password is Valid</span>";
                } else {
                    document.getElementById("passwordError").innerHTML = "<span style='color:red'>Password is invalid (must be at least 6 characters)</span>";
                }
            }

            // Phone number validation
            if (name === "phoneNumber") {
                const phonePattern = /^[0-9]{10}$/;
                if (phonePattern.test(value.trim())) {
                    document.getElementById("phoneNumberError").innerHTML = "<span style='color:green'>Phone Number is Valid</span>";
                } else {
                    document.getElementById("phoneNumberError").innerHTML = "<span style='color:red'>Phone Number is invalid (must be a 10-digit number)</span>";
                }
            }

            // Discount validation
            if (name === "discount") {
                if (!isNaN(value) && value >= 0 && value <= 100) {
                    document.getElementById("discountError").innerHTML = "<span style='color:green'>Discount is Valid</span>";
                } else {
                    document.getElementById("discountError").innerHTML = "<span style='color:red'>Discount is invalid (must be a number between 0 and 100)</span>";
                }
            }

            // Amount validation
            if (name === "amount") {
                if (!isNaN(value) && value > 0) {
                    document.getElementById("amountError").innerHTML = "<span style='color:green'>Amount is Valid</span>";
                } else {
                    document.getElementById("amountError").innerHTML = "<span style='color:red'>Amount is invalid (must be a positive number)</span>";
                }
            }

            // Balance validation
            if (name === "balance") {
                if (!isNaN(value) && value >= 0) {
                    document.getElementById("balanceError").innerHTML = "<span style='color:green'>Balance is Valid</span>";
                } else {
                    document.getElementById("balanceError").innerHTML = "<span style='color:red'>Balance is invalid (must be a non-negative number)</span>";
                }
            }
        };
    </script>
</body>
</html>
