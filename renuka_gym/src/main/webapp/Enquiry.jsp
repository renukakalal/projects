<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enquiry Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">Enquiry Form</h3>
            </div>
            <div class="card-body">
                <form action="enquiry" method="post">
                    <!-- Name -->
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" onblur="handleValidate(event)" placeholder="Enter your name">
                        <div id="nameError" class="form-text"></div>
                    </div>
                    <!-- Area -->
                    <div class="mb-3">
                        <label for="area" class="form-label">Area</label>
                        <input type="text" class="form-control" id="area" name="area" onblur="handleValidate(event)" placeholder="Enter your area">
                        <div id="areaError" class="form-text"></div>
                    </div>
                    <!-- Phone Number -->
                    <div class="mb-3">
                        <label for="phoneNumber" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" onblur="handleValidate(event)" placeholder="Enter your phone number">
                        <div id="phoneNumberError" class="form-text"></div>
                    </div>
                    <!-- Distance -->
                    <div class="mb-3">
                        <label for="distance" class="form-label">Distance</label>
                        <input type="text" class="form-control" id="distance" name="distance" onblur="handleValidate(event)" placeholder="Enter distance">
                        <div id="distanceError" class="form-text"></div>
                    </div>
                    <!-- Age -->
                    <div class="mb-3">
                        <label for="age" class="form-label">Age</label>
                        <input type="text" class="form-control" id="age" name="age" onblur="handleValidate(event)" placeholder="Enter your age">
                        <div id="ageError" class="form-text"></div>
                    </div>
                    <!-- Hidden Fields -->
                    <input type="hidden" name="status">
                    <input type="hidden" name="reason">
                    <!-- Submit Button -->
                    <div class="text-end">
                        <button type="submit" class="btn btn-success">Submit Enquiry</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

 <script>
        const handleValidate = (event) => {
            const { name, value } = event.target;
            const errorElement = document.getElementById(`${name}Error`);

             if (name === "name") {
                           if (value.length > 3 && value.length < 10 && value.trim()) {
                               document.getElementById("nameError").innerHTML = "<span style='color:green'>Name is Valid</span>";
                           } else {
                               document.getElementById("nameError").innerHTML = "<span style='color:red'>Name is invalid (must be 4 to 9 characters)</span>";
                           }
                       }
              if (name === "area") {
                            if (value.length > 3 && value.length < 100 && value.trim()) {
                                document.getElementById("areaError").innerHTML = "<span style='color:green'>area is Valid</span>";
                            } else {
                                document.getElementById("areaError").innerHTML = "<span style='color:red'>area is invalid (must be 4 to 9 characters)</span>";
                            }
                        }
            if (name === "phoneNumber") {
            const phonePattern = /^[0-9]{10}$/;
                            if (phonePattern.test(value.trim())) {
                                document.getElementById("phoneNumberError").innerHTML = "<span style='color:green'>Phone number is valid</span>";
                            } else {
                                document.getElementById("phoneNumberError").innerHTML = "<span style='color:red'>Phone number must be 10 digits</span>";
                            }
                        }
                        if (name === "distance") {
                            if (!isNaN(value) && value >= 1 && value <= 1000) {
                                document.getElementById("distanceError").innerHTML = "<span style='color:green'>Distance is Valid</span>";
                            } else {
                                document.getElementById("distanceError").innerHTML = "<span style='color:red'>Distance is invalid (must be a number between 1 and 1000)</span>";
                            }
                        }

           if (name === "age") {
               if (!isNaN(value) && value >= 10 && value <= 120) {
                   document.getElementById("ageError").innerHTML = "<span style='color:green'>Age is Valid</span>";
               } else {
                   document.getElementById("ageError").innerHTML = "<span style='color:red'>Age is invalid (must be a number between 1 and 120)</span>";
               }
           }

        };
    </script>
