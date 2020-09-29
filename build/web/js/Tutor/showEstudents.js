$(document).ready(function(){
    
    var codUser = $("#codUser").val();  
    var option = 1;
    var url = "../../ShowEstutorSERVLET";
    
    $.ajax({
        
        type:"post",
        data:{option:option, codUser:codUser},
        url:url,
        
        success:function(result){
            
            $("#dataUser").html(result);
            //alert(result);
            
            
        }
        
    });
    
});