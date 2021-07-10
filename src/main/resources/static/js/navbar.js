$('document').ready(function () {
  const bars = document.querySelector('.bars');
  const navbar = document.querySelector('.#navbar');
  bars.addEventListener('click', () => {
    bars.classList.toggle('active')
    bars.classList.toggle('rotate')
  })

})