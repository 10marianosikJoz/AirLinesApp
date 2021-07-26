var $span = $('#class_counter_ticket');

$('#butt').click(function () {
    var newNumber = Number($span.value()) + 1;
    $span.text(newNumber);
});

    /*var bidValue = document.getElementById("class_counter_ticket");
    // const counter = document.getElementById("counter").innerText;
    const button = document.getElementsByName('type');

    button.onclick = function() {
        var newNumber = Number(bidValue.value()) + 1;
        bidValue.text(newNumber);
    };*/
