$(document).ready(function(){
    $.ajax({
        
        type:"post",
        data:{option:1},
        url: "../../AssocCourseSERVLET",
        
        success:function(res){

            $("#dataCourses").html(res);
            
        },
        
        error:function(){
            
            alert("ocurrio un error inesperado");
            
        }
        
    });
});


