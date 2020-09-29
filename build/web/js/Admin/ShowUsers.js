$(document).ready(function(){
    
    $.ajax({
        
        type:"post",
        data:{option:3},
        url: "../../CrudUserSERVLET",
        
        success:function(res){
            
            $("#dataUser").html(res);
            
            
        },
        
        error:function(){
            
            alert('ocurrio un error al mostrar los usuarios');
            
        }
       
        
    });
    
    
    
});


function adUser(opt, id_course){
    $('#adUser').submit(function(event){
        
        event.preventDefault();
        
        $('#cod').val(id_course);
        
        if(opt === 2){
            
            $('#opt').val(2);
            
        }else{
            
            $('#opt').val(1);
        
        }
        
        $("#adUser").unbind("submit").submit();
        
    });
}

function modalUser(cod){
 
    var opt = 4;
    
    $.ajax({
        
        type: "post",
        data:{option:opt, nDocument:cod},
        url: "../../CrudUserSERVLET",
        
        success:function(value){
            
            $('#tableUsers').html(value);
            //alert(value);
            
        },
        error:function(){
            
            alert("ocurrio un error al mostrar las datos del usuario");
            
        }
        
    });
}


