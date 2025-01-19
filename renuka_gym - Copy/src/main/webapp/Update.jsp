<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Gym Management System</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .top-nav {
            background: linear-gradient(135deg, #FF6B6B 0%, #FF8E53 100%);
            padding: 0;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        .nav-list {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        .nav-item {
            padding: 15px 30px;
            position: relative;
        }

        .nav-item a {
            color: white;
            text-decoration: none;
            font-weight: 500;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .nav-item:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .nav-item a:hover {
            color: #FFE66D;
        }

        .search-container {
            background: white;
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            margin: 25px 0;
        }

        .table {
            background: white;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }

        .table th {
            background: #4ECDC4;
            color: white;
            font-weight: 600;
        }

        .form-control {
            border: 2px solid rgba(78, 205, 196, 0.3);
            border-radius: 8px;
            padding: 10px 15px;
        }

        .btn-success {
            background: linear-gradient(135deg, #4ECDC4 0%, #2EAF7D 100%);
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
        }

        select.form-control {
            cursor: pointer;
        }
    </style>
</head>
<body class="bg-light">
    <!-- Navigation Bar -->
    <nav class="top-nav">
        <ul class="nav-list">
            <li class="nav-item">
                <a href="Enquiry.jsp">Enquiry</a>
            </li>
            <li class="nav-item">
                <a href="follow">Follow</a>
            </li>
            <li class="nav-item">
                <a href="getRegister">Registration</a>
            </li>
            <li class="nav-item">
                <a href="updateList">Update</a>
            </li>
        </ul>
    </nav>

    <div class="container mt-4">
        <!-- Search Container -->
        <div class="search-container">
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
        <form action="updateRegDetails" method="post">
            <div class="table-responsive">
                <table class="table">
                    <thead>
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
                    </thead>
                    <tbody id="tableBody">
                        <c:forEach items="${list}" var="dto">
                            <tr>
                                <input type="hidden" name="registerId" value="${dto.id}" />
                                <td>${dto.name}</td>
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
                                <td>${dto.instalment}</td>
                                <td>
                                    <select name="packaged" class="form-control package-select" onchange="calculateBalance(this)">
                                        <option value="">Select Package</option>
                                        <c:forEach items="${listOfPackageEnum}" var="packaged">
                                            <option value="${packaged}">${packaged}</option>
                                        </c:forEach>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script>
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

        function calculateBalance(packageSelect) {
            const row = packageSelect.closest('tr');
            const amountInput = row.querySelector('.amount-input');
            const balanceInput = row.querySelector('.balance-input');

            const packagePrices = {
                'ELITE': 25000,
                'PRO': 10000,
                'TRASFROM': 5000,
                'PLATINUM': 15000
            };

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