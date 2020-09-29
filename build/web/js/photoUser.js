$(document).ready(function () {

    $("#icon").css("display", "none");
    $("#btnEnvi").css("display", "none");

});

$("#img").hover(
    function () {
        $("#icon").css("display", "block");
        $("#btnEnvi").css("display", "block");
    }, function () {
        $("#icon").css("display", "none");
        $("#btnEnvi").css("display", "none");
    }
);

$("#file").change(function (e) {
    const _URL = window.URL || window.webkitURL;
    const file = (this).files[0];
    const nameFile = file.name;
    const sizeFile = file.size;
    const ext = nameFile.split('.').pop();

    if (sizeFile > 2000000) {

        alert("La imagen no debe superar los 2MB");
        $("#nameFile").val("");
        $("#sizeFile").val("");

    } else if (ext === 'jpg' || ext === 'jpeg') {

            const img = new Image();

            img.onload = function () {
                if (this.width !== this.height) {
                    alert("El ancho y alto de la imagen deben ser iguales ejemplo (450px * 450px )");
                    $("#nameFile").val("");
                    $("#sizeFile").val("");
                } else if(this.width < 200 && this.height < 200){
                    alert("El ancho y alto de la imagen deben ser mayores a 200px");
                    $("#nameFile").val("");
                    $("#sizeFile").val("");
                }
                else{
                    $("#nameFile").val(nameFile);
                    $("#sizeFile").val(sizeFile);
                }
            };
            img.src = _URL.createObjectURL(file);

    } else {
        alert("Debe seleccionar una imagen con una de estas extenciones (jpg, jpeg)");
        $("#nameFile").val("");
        $("#sizeFile").val("");
    }

});

$("#button").click(function(){
    
    $("#formPhoto").submit(function( event ){
        event.preventDefault();
        if ($("#nameFile").val() === null || $("#nameFile").val() === "") {
            alert("debe seleccionar una foto");
            $("#formPhoto").off("submit", changeSize);
        }else{
            $("#formPhoto").unbind("submit").submit();
        }
         
    });
    
});