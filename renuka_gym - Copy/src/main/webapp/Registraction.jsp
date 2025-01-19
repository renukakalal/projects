<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gym Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
      /* Navigation Styles */
            .nav-container {
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                background: linear-gradient(45deg, #4ECDC4, #2ECC71);
                padding: 1rem;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                z-index: 1000;
            }

            .nav-links {
                display: flex;
                justify-content: center;
                gap: 2rem;
                list-style: none;
                margin: 0;
                padding: 0;
            }

            .nav-links a {
                color: white;
                text-decoration: none;
                font-weight: 600;
                padding: 0.5rem 1rem;
                border-radius: 8px;
                transition: all 0.3s ease;
            }

            .nav-links a:hover {
                background: rgba(255, 255, 255, 0.2);
                transform: translateY(-2px);
            }
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
            padding: 20px 0;
        }

        .container {
            max-width: 800px;
            width: 95%;
        }

        .card {
            border-radius: 20px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
            animation: fadeIn 0.5s ease-in;
            background: rgba(255, 255, 255, 0.95);
        }

        .card-header {
            background: linear-gradient(45deg, #2193b0, #6dd5ed);
            color: white;
            border-radius: 20px 20px 0 0 !important;
            padding: 1.5rem;
        }

        .form-control, .form-select {
            border-radius: 10px;
            padding: 12px;
            transition: all 0.3s ease;
            border: 2px solid #e0e0e0;
            background-color: rgba(255, 255, 255, 0.9);
        }

        .form-control:focus, .form-select:focus {
            box-shadow: 0 0 0 0.25rem rgba(33, 147, 176, 0.25);
            border-color: #2193b0;
        }

        .btn-primary {
            background: linear-gradient(45deg, #2193b0, #6dd5ed);
            border: none;
            padding: 12px 30px;
            border-radius: 10px;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(33, 147, 176, 0.3);
        }

        .form-label {
            color: #2a5298;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .form-text span {
            padding: 3px 10px;
            border-radius: 5px;
            display: inline-block;
            margin-top: 5px;
            font-weight: 500;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        @media (max-width: 768px) {
            .container {
                width: 100%;
                padding: 10px;
            }

            .card {
                border-radius: 15px;
            }

            .form-control, .form-select {
                padding: 10px;
            }
        }

        .form-section {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 20px;
        }
    </style>
</head>
<body>
   <!-- Navigation Bar -->
    <nav class="nav-container">
        <ul class="nav-links">
            <li><a href="Enquiry.jsp">Enquiry</a></li>
            <li><a href="follow">Follow</a></li>
            <li><a href="getRegister">Registration</a></li>
            <li><a href="updateList">Update</a></li>
        </ul>
    </nav>
    <div class="container">
        <div class="card">
            <div class="card-header text-center">
                <h2 class="mb-0">Gym Registration</h2>
            </div>
            <div class="card-body p-4">
                <form action="registerDetails" method="post" class="needs-validation" novalidate>
                    <div class="row g-4">
                        <!-- Personal Information -->
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" id="name" name="name" class="form-control" onblur="handleValidate(event)" required>
                                <div id="nameError" class="form-text"></div>
                            </div>

                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="text" id="email" name="email" class="form-control" onblur="handleValidate(event)" required>
                                <div id="emailError" class="form-text"></div>
                            </div>

                            <div class="mb-3">
                                <label for="phoneNumber" class="form-label">Phone Number</label>
                                <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" onblur="handleValidate(event)" required>
                                <div id="phoneNumberError" class="form-text"></div>
                            </div>
                        </div>

                        <!-- Membership Details -->
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="packaged" class="form-label">Package</label>
                                <select id="packaged" name="packaged" class="form-select" required>
                                    <option value="">Select Package</option>
                                    <c:forEach items="${listOfPackageEnum}" var="packaged">
                                        <option value="${packaged}">${packaged}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="mb-3">
                                <label for="gymName" class="form-label">Gym Location</label>
                                <select id="gymName" name="gymName" class="form-select" required>
                                    <option value="">Select Gym Location</option>
                                    <c:forEach items="${listOfGymname}" var="gymName">
                                        <option value="${gymName}">${gymName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="mb-3">
                                <label for="trainer" class="form-label">Trainer</label>
                                <select id="trainer" name="trainer" class="form-select" required>
                                    <option value="">Select Trainer</option>
                                    <c:forEach items="${listOftrainer}" var="trainer">
                                        <option value="${trainer}">${trainer}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <!-- Payment Details -->
                        <div class="col-12">
                            <div class="row g-3">
                                <div class="col-md-3">
                                    <label for="amount" class="form-label">Amount</label>
                                    <input type="text" id="amount" name="amount" class="form-control" onblur="handleValidate(event)" required>
                                    <div id="amountError" class="form-text"></div>
                                </div>

                                <div class="col-md-3">
                                    <label for="discount" class="form-label">Discount (%)</label>
                                    <input type="text" id="discount" name="discount" class="form-control" onblur="handleValidate(event)" required>
                                    <div id="discountError" class="form-text"></div>
                                </div>

                                <div class="col-md-3">
                                    <label for="instalment" class="form-label">Instalment</label>
                                    <input type="text" id="instalment" name="instalment" class="form-control" onblur="handleValidate(event)" required>
                                    <div id="installmentError" class="form-text"></div>
                                </div>

                                <div class="col-md-3">
                                    <label for="balance" class="form-label">Balance</label>
                                    <input type="text" id="balance" name="balance" class="form-control" onblur="handleValidate(event)" required>
                                    <div id="balanceError" class="form-text"></div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 text-center mt-4">
                            <button type="submit" class="btn btn-primary btn-lg px-5">Register Now</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Your existing handleValidate function remains the same
        const handleValidate = (event) => {
            const { name, value } = event.target;

            if (name === "name") {
                if (value.length >= 4 && value.length <= 9 && value.trim()) {
                    document.getElementById("nameError").innerHTML = "<span style='color:green'>Name is Valid</span>";
                } else {
                    document.getElementById("nameError").innerHTML = "<span style='color:red'>Name is invalid (must be 4 to 9 characters)</span>";
                }
            }

            if (name === "email") {
                if (value.includes("@gmail.com") && value.trim()) {
                    document.getElementById("emailError").innerHTML = "<span style='color:green'>Email is Valid</span>";
                } else {
                    document.getElementById("emailError").innerHTML = "<span style='color:red'>Email is invalid (must be a valid Gmail address)</span>";
                }
            }

            if (name === "phoneNumber") {
                const phonePattern = /^[0-9]{10}$/;
                if (phonePattern.test(value.trim())) {
                    document.getElementById("phoneNumberError").innerHTML = "<span style='color:green'>Phone Number is Valid</span>";
                } else {
                    document.getElementById("phoneNumberError").innerHTML = "<span style='color:red'>Phone Number is invalid (must be a 10-digit number)</span>";
                }
            }

            if (name === "discount") {
                if (!isNaN(value) && value >= 0 && value <= 100) {
                    document.getElementById("discountError").innerHTML = "<span style='color:green'>Discount is Valid</span>";
                } else {
                    document.getElementById("discountError").innerHTML = "<span style='color:red'>Discount is invalid (must be between 0 and 100)</span>";
                }
            }
              if (name === "instalment") {
                            if (!isNaN(value) && value >= 1 && value <= 10) {
                                document.getElementById("installmentError").innerHTML = "<span style='color:green'>installment is Valid</span>";
                            } else {
                                document.getElementById("installmentError").innerHTML = "<span style='color:red'>installment is invalid (must be between 0 and 100)</span>";
                            }
                        }

            if (name === "amount") {
                if (!isNaN(value) && value > 0) {
                    document.getElementById("amountError").innerHTML = "<span style='color:green'>Amount is Valid</span>";
                } else {
                    document.getElementById("amountError").innerHTML = "<span style='color:red'>Amount is invalid (must be positive)</span>";
                }
            }

            if (name === "balance") {
                if (!isNaN(value) && value >= 0) {
                    document.getElementById("balanceError").innerHTML = "<span style='color:green'>Balance is Valid</span>";
                } else {
                    document.getElementById("balanceError").innerHTML = "<span style='color:red'>Balance is invalid (must be non-negative)</span>";
                }
            }
        };
    </script>
</body>
</html>