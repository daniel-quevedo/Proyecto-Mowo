function modalCourse(cod){
 
    var opt = 2;    
    
    $.ajax({
        
        type: "post",
        data:{option:opt, cod:cod},
        url: "../../CrudCourseSERVLET",
        
        success:function(value){
            
            $('#tableCourse').html(value);
            //alert(value);
            
        },
        error:function(){
            
            alert("ocurrio un error al mostrar las datos del curso");
            
        }
        
    });
}
function addCourse(opt, cod){
    
    $('#addCourse').submit(function(event){
        
        event.preventDefault();                               
        
        $('#cod').val(cod);
        
        if(opt === 3){
            
            $('#opt').val(3);
            
        }else{
            
            $('#opt').val(4);
        
        }
        
        $("#addCourse").unbind("submit").submit();
        
    });
}
