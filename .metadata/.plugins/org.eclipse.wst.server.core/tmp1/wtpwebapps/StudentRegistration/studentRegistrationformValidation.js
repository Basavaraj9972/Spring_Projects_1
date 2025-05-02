function validate(){
    var unp =/^[A-Za-z]+$/
    var un = document.getElementById("name").value
    var lunp =/^[A-Za-z]+$/
    var lun = document.getElementById("lastname").value
    var php =/^[6-9]{1}[0-9]{9}$/
    var ph = document.getElementById("phone").value
    var emailp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    var email = document.getElementById("email").value
    var agep =/^[2]{1}[0-9]{1}$/
    var age = document.getElementById("age").value
    document.getElementById("msg1").innerHTML = "";
    document.getElementById("msg2").innerHTML = "";
    document.getElementById("msg3").innerHTML = "";
    document.getElementById("msg4").innerHTML = "";
    document.getElementById("msg5").innerHTML = "";
    
    var isValid = true;

    if (un === "") {
        document.getElementById("msg1").innerHTML = "Username can't be empty";
        isValid = false;
    } else if (!un.match(unp)) {
        document.getElementById("msg1").innerHTML = "Username should contain alphabets only";
        isValid = false;
    } else if (un.length < 3 || un.length > 15) {
        document.getElementById("msg1").innerHTML = "Username should be between 3 and 15 characters";
        isValid = false;
    }


    if (lun === "") {
        document.getElementById("msg2").innerHTML = "Last name can't be empty";
        isValid = false;
    } else if (!lun.match(lunp)) {
        document.getElementById("msg2").innerHTML = "last Name should contain alphabets only";
        isValid = false;
    } else if (lun.length < 1 || lun.length > 15) {
        document.getElementById("msg2").innerHTML = "last name should be between 1 and 15 characters";
        isValid = false;
    }
    if (ph === "") {
        document.getElementById("msg3").innerHTML = "Phone number can't be empty";
        isValid = false;
    } else if (!ph.match(php)) {
        document.getElementById("msg3").innerHTML = "phone number must stararts with 6 and contains 10 digit";
        isValid = false;
    }

    if (email === "") {
        document.getElementById("msg4").innerHTML = "Email can't be empty";
        isValid = false;
    } else if (!email.match(emailp)) {
        document.getElementById("msg4").innerHTML = "Email address containing only letters, numbers, dots, underscores, hyphens, and @ .then character";
        isValid = false;
    }

    if (age === "") {
        document.getElementById("msg5").innerHTML = "age can't be empty";
        isValid = false;
    } else if (!age.match(agep)) {
        document.getElementById("msg5").innerHTML = "age must between20 and 29";
        isValid = false;
    }
    // Clear all error messages if the form is valid
    if (isValid) {
        document.getElementById("msg1").innerHTML = "";
        document.getElementById("msg2").innerHTML = "";
        document.getElementById("msg3").innerHTML = "";
        document.getElementById("msg4").innerHTML = "";
        document.getElementById("msg5").innerHTML = "";
    }
    return isValid;
    }
    