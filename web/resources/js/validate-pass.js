(function validatePassword() {
    let password = document.getElementById("register-password");
    let confirm_password = document.getElementById("confirm-password");

    function validatePassword() {
        if (password.value !== confirm_password.value) {
            confirm_password.setCustomValidity("Passwords don't match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;

    $('input').keypress(function (e) {
        if (e.which === 32)
            return false;
    });
})();