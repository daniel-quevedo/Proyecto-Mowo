
var show = document.getElementById('show');
var pass = document.getElementById('pass');

show.addEventListener('click', viewpass);

function viewpass(){
    if (pass.type === "password") {
        pass.type = 'text';
        show.src = './img/eye.png';
    }else {
        pass.type = 'password';
        show.src = './img/eyeoff.png';
    }

}

//$(document).ready(function(){
//   $('#show').mousedown(function(){
//      $('#pass').removeAttr('type');
//  });
//  $('#show').mouseup(function(){
//     $('#pass').attr('type','password');
//  });
//});