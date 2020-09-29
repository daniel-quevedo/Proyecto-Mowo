$(document).ready(function(){
    
    $("#validatePass").submit(function(event){
       
        event.preventDefault();
            
        if($("#pass").val() === $("#pass2").val()) {

            $("#validatePass").unbind("submit").submit();

        }else{
            
            alert("las contraseñas no coinciden");
            
            $("#pass").val("");
            $("#pass2").val("");

        }
        
    });
    
});