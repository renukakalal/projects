<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Gym Management System</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f4f9;
        }
        /* Navigation Bar Custom Styles */
        .navbar {
            background-color: #ff6347; /* Tomato color */
        }
        .navbar-brand, .nav-link {
            color: #fff !important;
        }
        .navbar-toggler-icon {
            background-color: #fff;
        }
        .navbar-nav .nav-item {
            margin-right: 15px;
        }
        .navbar-nav .nav-link:hover {
            color: #ffc107 !important; /* Hover color */
        }

        /* Table Styling */
        .table thead {
            background-color: #ff6347; /* Tomato color */
            color: white;
        }
        .table tbody tr:nth-child(even) {
            background-color: #f8f9fa; /* Light gray */
        }
        .table tbody tr:hover {
            background-color: #e2e6ea; /* Hover effect */
        }
        .form-control {
            border-radius: 10px;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
    </style>
</head>
<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Gym Management</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Enquiry.jsp">Enquiry</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="follow">Follow</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="getRegister">Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="updateList">Update</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <!-- Search Container -->
        <div class="search-container mb-4">
            <div class="row">
                <div class="col-md-6 mb-3 mb-md-0">
                    <input type="text" id="searchInput" class="form-control" placeholder="Search by name..." onkeyup="searchTable()">
                </div>
                <div class="col-md-6">
                    <select id="updateSelect" class="form-control" onchange="filterBySelect()">
                        <option value="">Select records</option>
                        <option value="all">View All</option>
                        <option value="updated">Updated Records</option>
                        <option value="not-updated">Not Updated Records</option>
                    </select>
                </div>
            </div>
        </div>

        <!-- Table Form -->
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Discount</th>
                        <th>Gym Name</th>
                        <th>Instalment</th>
                        <th>Package</th>
                        <th>Trainer</th>
                        <th>Amount</th>
                        <th>Balance</th>
                        <th>Action</th>
                        <th>view</th>
                    </tr>
                </thead>
                <tbody id="tableBody">
                    <c:forEach items="${list}" var="dto">
                        <form action="updateRegDetails" method="post">
                            <input type="hidden" name="registerId" value="${dto.id}" />
                            <tr>
                                <td><input type="text" name="name" value="${dto.name}"1 class="form-control" /></td>
                                <td>${dto.email}</td>
                                <td>${dto.password}</td>
                                <td>${dto.discount}</td>
                                <td>
                                    <select name="gymName" class="form-control">
                                        <option value="">Select Gym</option>
                                        <c:forEach items="${listOfGymname}" var="gymName">
                                            <option value="${gymName}">${gymName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <select name="instalment" id="instalment">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                    </select>
                                </td>

                                <td>
                                    <select name="packaged" class="form-control package-select" ">
                                        <option value="">Select Package</option>
                                        <option value="ELITE">ELITE - Rs 25,000</option>
                                        <option value="PRO">PRO - Rs 10,000</option>
                                        <option value="TRANSFORM">TRANSFORM - Rs 5,000</option>
                                        <option value="PLATINUM">PLATINUM - Rs 15,000</option>
                                    </select>
                                </td>
                                <td>
                                    <select name="trainer" class="form-control">
                                        <option value="">Select Trainer</option>
                                        <c:forEach items="${listOftrainer}" var="trainer">
                                            <option value="${trainer}"
                                                <c:if test="${trainer == dto.trainer}">selected</c:if>
                                            >${trainer}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td><input type="text" name="amount" class="form-control amount-input" value="${dto.amount}" onchange="calculateBalance(this.closest('tr').querySelector('.package-select'))" /></td>
                                <td><input type="text" name="balance" class="form-control balance-input" value="${dto.balance}" readonly /></td>
                                <td>
                                    <button type="submit" class="btn btn-success w-100">Submit</button>
                                </td>
                                 <td>
                                  <a href="registerView?id=${dto.id}" class="btn btn-info">View</a>
                                  </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script>
        const packagePrices = {
            'ELITE': 25000,
            'PRO': 10000,
            'TRANSFORM': 5000,
            'PLATINUM': 15000
        };

        function searchTable() {
            const input = document.getElementById('searchInput');
            const filter = input.value.toLowerCase();
            const tbody = document.getElementById('tableBody');
            const rows = tbody.getElementsByTagName('tr');

            for (let row of rows) {
                const nameCell = row.getElementsByTagName('td')[0];
                if (nameCell) {
                    const text = nameCell.textContent || nameCell.innerText;
                    row.style.display = text.toLowerCase().includes(filter) ? '' : 'none';
                }
            }
        }

        function filterBySelect() {
            const select = document.getElementById('updateSelect');
            const filter = select.value;
            const tbody = document.getElementById('tableBody');
            const rows = tbody.getElementsByTagName('tr');

            if (filter === '' || filter === 'all') {
                Array.from(rows).forEach(row => row.style.display = '');
                return;
            }

            for (let row of rows) {
                const selects = row.querySelectorAll('select');
                const isUpdated = Array.from(selects).some(select => select.value !== '');

                if (filter === 'updated') {
                    row.style.display = isUpdated ? '' : 'none';
                } else if (filter === 'not-updated') {
                    row.style.display = !isUpdated ? '' : 'none';
                }
            }
        }

        function calculateBalance(amountPaid) {
            const row = packageSelect.closest('tr');
            const amountInput = row.querySelector('.amount-input');
            const balanceInput = row.querySelector('.balance-input');

            const selectedPackage = packageSelect.value;
            const amountPaid = parseFloat(amountInput.value) || 0;

            if (selectedPackage && packagePrices[selectedPackage]) {
                const totalPrice = packagePrices[selectedPackage];
                const balance = totalPrice - amountPaid;
                balanceInput.value = Math.max(0, balance);
            } else {
                balanceInput.value = '';
            }
        }

        document.addEventListener('DOMContentLoaded', function() {
            const packageSelects = document.querySelectorAll('.package-select');
            packageSelects.forEach(select => {
                if (select.value) {
                    calculateBalance(select);
                }
            });
        });
    </script>
</body>
</html>
