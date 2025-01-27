<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gym Website</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            min-height: 100vh;
            position: relative;
        }

        .admin-section {
            position: absolute;
            top: 20px;
            right: 20px;
            z-index: 100;
        }

        .admin-login,
        .user-login {
            display: flex;
            align-items: center;
            text-decoration: none;
            color: #1a237e;
            padding: 0.5rem 1rem;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 4px;
            transition: background-color 0.3s;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .admin-login:hover,
        .user-login:hover {
            background-color: white;
            box-shadow: 0 3px 8px rgba(0, 0, 0, 0.15);
        }

        .admin-icon {
            width: 24px;
            height: 24px;
            margin-right: 8px;
            fill: currentColor;
        }

        .main-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }

        .site-title {
            font-size: 3.5rem;
            margin: 0;
            font-weight: bold;
            color: #1a237e;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="admin-section">
        <a href="SignIn.jsp" class="admin-login">
            <svg class="admin-icon" viewBox="0 0 24 24">
                <path d="M12 4a4 4 0 014 4 4 4 0 01-4 4 4 4 0 01-4-4 4 4 0 014-4m0 10c4.42 0 8 1.79 8 4v2H4v-2c0-2.21 3.58-4 8-4z"/>
            </svg>
            Admin Login
        </a>
        <a href="UserSignIn" class="user-login">
            <svg class="admin-icon" viewBox="0 0 24 24">
                <path d="M12 4a4 4 0 014 4 4 4 0 01-4 4 4 4 0 01-4-4 4 4 0 014-4m0 10c4.42 0 8 1.79 8 4v2H4v-2c0-2.21 3.58-4 8-4z"/>
            </svg>
            User Login
        </a>
    </div>
    <div class="main-content">
        <h2 class="site-title">Gym Website</h2>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
