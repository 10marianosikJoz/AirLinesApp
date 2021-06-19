
$("#form").on("submit",function validateForm() {
    if(grecaptcha.getResponse()) {
        return true;
    }
    else {
        alert("Please prove that you' re not robot")
        return false;
    }
});