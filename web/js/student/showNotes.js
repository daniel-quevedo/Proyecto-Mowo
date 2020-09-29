$(document).ready(function(){
    
    
    $.ajax({
       
        type:"post",
        data: {cod:$("#codUser").val(), period:1},
        url: "../../ShowNotesSERVLET",
        
        success:function(res){
            
            $("#tableNotesStu").html(res);
            
        },
        error:function(){
            alert("error");
        }
        
    });
    
});

function notes(per){
    
    $.ajax({
       
        type:"post",
        data: {cod:$("#codUser").val(), period:per},
        url: "../../ShowNotesSERVLET",
        
        success:function(res){
            
            $("a").removeClass("active");
            $("#period"+per).addClass("active");
            $("#tableNotesStu").html(res);
            
        },
        error:function(){
            alert("error");
        }
        
    });
    
}