$(function () {
    $("#flight_check_in_btn").on('click', function () {
        $('#booker_content').hide();
        $('#flight_status_content').hide();
        $('#flight_check_in_content').show();
    });
});