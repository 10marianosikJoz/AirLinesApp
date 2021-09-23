$(function () {

    $('#datetimepicker3').datetimepicker({
        useCurrent: false,


        format: 'YYYY-MM-DD'
    }).on('dp.change', function (e) {
        console.log('here1');
        console.log(e);

        $(".day").click(function () {
            $("a[data-action='togglePicker']").trigger('click');
        });
    });

});



