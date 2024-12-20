<%@page isELIgnored = "false"%>
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
                <input type="text" id="name" name="name" class="form-control" onchange="onName()" placeholder="Enter your name">
                 <span id="nameDemo"></span>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">User Email</label>
                <input type="email" id="email" name="email" class="form-control" onchange="onEmail()" placeholder="Enter your email">
                 <span id="emailDemo"></span>

            </div>
            <div class="mb-3">
                <label for="altEmail" class="form-label">Alternative Email</label>
                <input type="email" id="alternativeEmail" name="alternativeEmail" class="form-control" onchange="onaltEmail()"  placeholder="Enter your alternative email">
                <span id="altemailDemo"></span>
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">User Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" onchange="onphoneNumber()" placeholder="Enter your phone number">
             <span id="numberDemo"></span>

            </div>
            <div class="mb-3">
                <label for="alternativePhoneNumber" class="form-label">Alternative Phone Number</label>
                <input type="text" id="alternativePhoneNumber" name="alternativePhoneNumber" class="form-control" onchange="onalterphoneNumber()" placeholder="Enter your alternative phone number">
             <span id="altnumberDemo"></span>
            </div>
            <div class="mb-3">
                <label for="location" class="form-label">User Location</label>
                <input type="text" id="location" name="location" class="form-control" placeholder="Enter your location">
             <span id="numberDemo"></span>
            </div>
            <button type="submit" class="btn btn-primary w-100">Save</button>

        </form>
         ${message}

    </div>

    <script>



    function onName() {

           var name= document.getElementById('name').value;
            console.log("User name: ", name);
            var xhttp = new XMLHttpRequest();
           xhttp.open("GET", "http://localhost:8080/xworkz_CommonModule_renuka/name/" + name, true);
           xhttp.send();
           xhttp.onload=function()
           {
           document.getElementById("nameDemo").innerHTML=this.responseText;
           }
       }
       function onEmail() {

                  var email= document.getElementById('email').value;
                   console.log("User email: ", email);
                   var xhttp = new XMLHttpRequest();
                  xhttp.open("GET", "http://localhost:8080/xworkz_CommonModule_renuka/email/" + email, true);
                  xhttp.send();
                    xhttp.onload=function()
                             {
                             document.getElementById("emailDemo").innerHTML=this.responseText;
                             }
              }
               function onaltEmail() {

                                var alternativeEmail= document.getElementById('alternativeEmail').value;
                                 console.log("User altEmail: ", email);
                                 var xhttp = new XMLHttpRequest();
                                xhttp.open("GET", "http://localhost:8080/xworkz_CommonModule_renuka/alternativeEmail/" + alternativeEmail, true);
                                xhttp.send();
                                  xhttp.onload=function()
                                           {
                                           document.getElementById("altemailDemo").innerHTML=this.responseText;
                                           }
                            }

              function onphoneNumber() {

                  var phoneNumber= document.getElementById('phoneNumber').value;
                console.log("User phoneNumber: ", phoneNumber);
                  var xhttp = new XMLHttpRequest();
               xhttp.open("GET", "http://localhost:8080/xworkz_CommonModule_renuka/phoneNumber/" + phoneNumber, true);
                   xhttp.send();
                    xhttp.onload=function()
                           {
                      document.getElementById("numberDemo").innerHTML=this.responseText;
                             }
              }

             function onalterphoneNumber()
             {

               var alternativePhoneNumber= document.getElementById('alternativePhoneNumber').value;
               console.log("User alternativePhoneNumber: ", alternativePhoneNumber);
               var xhttp = new XMLHttpRequest();
               xhttp.open("GET", "http://localhost:8080/xworkz_CommonModule_renuka/alternativePhoneNumber/" + alternativePhoneNumber, true);
                   xhttp.send();
                     xhttp.onload=function()
                                              {
                                         document.getElementById("altnumberDemo").innerHTML=this.responseText;
                                                }
             }









        </script>
        
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
