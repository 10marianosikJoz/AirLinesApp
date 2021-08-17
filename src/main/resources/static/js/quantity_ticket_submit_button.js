/*var $span = $('#class_counter_ticket');

$('#butt').click(function () {
    var newNumber = Number($span.value()) + 1;
    $span.text(newNumber);
});*/
function add(){
    var a,b,c,d,sum;
    a = Number(document.getElementById("adult_counter").value);
    b = Number(document.getElementById("child_counter").value);
    c = Number(document.getElementById("infant_counter").value);
    d = Number(document.getElementById("student_counter").value);
    sum = a + b + c + d;
    document.getElementById("counter").textContent = sum
}
    /*var bidValue = document.getElementById("class_counter_ticket");
    // const counter = document.getElementById("counter").innerText;
    const button = document.getElementsByName('type');

    button.onclick = function() {
        var newNumber = Number(bidValue.value()) + 1;
        bidValue.text(newNumber);
    };*/
