$("#idCourse").change(function(){
    var idCourse = $("#idCourse").val();
    var idTeacher = 0;
    $.ajax({
       
        type:"post",
        url:"../../AssocSubjectSERVLET",
        data:{option:2, idCourse:idCourse, idTeacher:idTeacher},
        
        success:function(data){
            $("#dataSubject").html(data);
        },
        error:function(){
            alert("error, comunicarse con el administrador");
        }
        
    });
});



$("#idTeacher").change(function(){
    var idTeacher = $("#idTeacher").val();
    
    var idCourse = 0;
    
    $.ajax({
       
        type:"post",
        url:"../../AssocSubjectSERVLET",
        data:{option:2, idCourse:idCourse, idTeacher:idTeacher},
        
        success:function(data){
            $("#dataSubject").html(data);
        },
        error:function(){
            alert("error, comunicarse con el administrador");
        }
        
    });
});



