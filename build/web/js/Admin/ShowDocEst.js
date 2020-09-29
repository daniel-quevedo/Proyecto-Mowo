$(document).ready(function(){
    
    var option = 1;
    var url="../../AssocCourseSERVLET";
    
    
    $.ajax({
        
        type:"post",
        data:{user: $('#user').val(), option:option},
        url:url,
        
    success:function(result)
    {
        
        $("#listUser").html(result);
        
    }    
    });
});