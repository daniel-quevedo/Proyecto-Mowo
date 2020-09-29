$("#idCourse").change(function(){
    
    var idCourse = $("#idCourse").val();
    
    $.ajax({
       
        type:"post",
        url:"../../AssocCourseSERVLET",
        data:{option:2, idCourse:idCourse},
        
        success:function(data){
            $("#dataUser").html(data);
        }
        
    });
    
});
