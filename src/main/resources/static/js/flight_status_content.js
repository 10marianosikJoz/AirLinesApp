$(function () {
    $("#flight_status_btn").on('click', function () {
        $('#booker_content').hide();
        $('#flight_check_in_content').hide();
        $('#flight_status_content').show();
    });
});