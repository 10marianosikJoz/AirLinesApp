/*$(document).ready(function () {

    $("input[type=radio]").change(function () {
        $('.eco_span').text('ECO');
    });

});*/
$(document).ready(function () {

    var eco_checkbox = document.getElementById('flexRadioDefault1');
    var bus_checkbox = document.getElementById('flexRadioDefault2');

    $("input[type=radio]").change(function () {
        if(eco_checkbox.checked) {
            $('.eco_span').text("ECO");
        }
        if(bus_checkbox.checked) {
            $('.eco_span').text("BUS");
        }
    });

});