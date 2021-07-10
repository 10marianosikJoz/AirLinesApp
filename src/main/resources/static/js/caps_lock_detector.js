$('document').ready(function () {
const password = document.querySelector('#password');
const message = document.querySelector('.capslock_message');

password.addEventListener('keyup', function (e) {
    if (e.getModifierState('CapsLock')) {
        message.textContent = 'Caps lock is on';
    } else {
        message.textContent = '';
    }
})
});