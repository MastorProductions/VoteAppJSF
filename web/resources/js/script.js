$(function () {

    activateNav();

    $('#login-form-link').click(function (e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        $("#error").empty();
        e.preventDefault();
    });

    $('#register-form-link').click(function (e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        $("#error").empty();
        e.preventDefault();
    });
});

function myFilter() {
    // Declare variables
    let input, filter, table, tr, td, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        let elements = tr[i].getElementsByTagName("td");
        let surnameIndex = elements.length - 2;
        td = elements[surnameIndex];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function activateNav() {
    let path = window.location.pathname;
    path = path.replace(/\/$/, "");
    path = decodeURIComponent(path);

    $(".nav a").each(function () {
        let href = $(this).attr('href');
        if (path.substring(0, href.length) === href) {
            $(this).closest('li').addClass('active');
        }
    });
}