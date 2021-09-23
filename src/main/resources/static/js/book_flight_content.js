$(function () {
    $("#flight_book_btn").on('click', function () {
        $('#flight_status_content').hide();
        $('#flight_check_in_content').hide();
        $('#booker_content').show();
    });
});