<%@page isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
            --fb-blue: #1877f2;
            --fb-blue-hover: #166fe5;
            --fb-bg: #f0f2f5;
            --fb-text: #1c1e21;
            --fb-green: #42b72a;
            --fb-green-hover: #36a420;
        }

        body {
            margin: 0;
            padding: 20px;
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
            background-color: var(--fb-bg);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            background: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1), 0 8px 16px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 400px;
        }

        .login-header {
            text-align: center;
            margin-bottom: 1.5rem;
        }

        .admin-icon {
            width: 50px;
            height: 50px;
            margin-bottom: 0.5rem;
            fill: var(--fb-blue);
        }

        h1 {
            color: var(--fb-blue);
            margin: 0;
            font-size: 1.5rem;
            font-weight: 600;
            margin-bottom: 1rem;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .form-group input {
            width: 100%;
            padding: 14px 16px;
            border: 1px solid #dddfe2;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 17px;
            transition: border-color 0.3s ease;
        }

        .form-group input:focus {
            outline: none;
            border-color: var(--fb-blue);
            box-shadow: 0 0 0 2px #e7f3ff;
        }

        .form-group input::placeholder {
            color: #90949c;
        }

        .submit-btn {
            background: var(--fb-blue);
            color: white;
            padding: 0.8rem;
            border: none;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            font-size: 1.2rem;
            font-weight: bold;
            transition: background 0.3s ease;
            margin-bottom: 1rem;
        }

        .submit-btn:hover {
            background: var(--fb-blue-hover);
        }

        .divider {
            border-bottom: 1px solid #dadde1;
            margin: 20px 0;
        }

        .create-account-btn {
            background: var(--fb-green);
            color: white;
            padding: 0.8rem;
            border: none;
            border-radius: 6px;
            width: 100%;
            cursor: pointer;
            font-size: 1rem;
            font-weight: bold;
            transition: background 0.3s ease;
        }

        .create-account-btn:hover {
            background: var(--fb-green-hover);
        }

        /* Responsive Design */
        @media (max-width: 480px) {
            .login-container {
                padding: 1rem;
                width: 100%;
                box-shadow: none;
            }

            body {
                background-color: white;
                padding: 0;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-header">
            <svg class="admin-icon" viewBox="0 0 24 24">
                <path d="M12 4a4 4 0 014 4 4 4 0 01-4 4 4 4 0 01-4-4 4 4 0 014-4m0 10c4.42 0 8 1.79 8 4v2H4v-2c0-2.21 3.58-4 8-4z"/>
            </svg>
            <h1>Admin Login</h1>
        </div>
        <form action="signIn">
            <div class="form-group">
                <input type="email" id="email" name="email" required placeholder="Email address">
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" required placeholder="Password">
            </div>
            <input type="submit" value="Log In" class="submit-btn">
        </form>


    </div>
</body>
</html>