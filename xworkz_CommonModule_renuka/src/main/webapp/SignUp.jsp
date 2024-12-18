<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: #fff;
            border-radius: 10px;
            padding: 30px;
            width: 100%;
            max-width: 500px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .btn-primary {
            background-color: #1877f2;
            border-color: #1877f2;
        }
        .btn-primary:hover {
            background-color: #145dbf;
            border-color: #145dbf;
        }
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h3 class="text-center mb-4">User Registration</h3>
        <form action="save" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">User Name</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="Enter your name" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">User Email</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="altNumber" class="form-label">Alternative Email</label>
                <input type="email" id="altNumber" name="altNumber" class="form-control" placeholder="Enter your alternative email">
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">User Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter your phone number" required>
            </div>
            <div class="mb-3">
                <label for="AltphoneNumber" class="form-label">Alternative Phone Number</label>
                <input type="text" id="AltphoneNumber" name="AltphoneNumber" class="form-control" placeholder="Enter your alternative phone number">
            </div>
            <div class="mb-3">
                <label for="location" class="form-label">User Location</label>
                <input type="text" id="location" name="location" class="form-control" placeholder="Enter your location" required>
            </div>
            <button type="submit" class="btn btn-primary w-100">Save</button>
        </form>
    </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
