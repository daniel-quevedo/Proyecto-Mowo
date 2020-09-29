//Definir variable global para cargar las categorias seleccionadas
var arrayCourses =[];

$('#add').click(function(e){
    //deshabilitar submit de cualquier formulario
    e.preventDefault();

    let idCourse = $("#courses").val();
    let nameCourse = $("#courses option:selected").text();
    
    if (idCourse !== '') {

        if (typeof existCourse(idCourse) === 'undefined') {
            //Agregar nuevo objeto al array
            arrayCourses.push({
                'id'  : idCourse,
                'name': nameCourse
            });
            showCourses();
            
        } else {
            alert("El curso ya se Encuentra Seleccionado");
        }

    }else{
        alert("Debe Seleccionar un Curso");
    }

});

function showCourses() {
    $('#list-courses').empty(),
    arrayCourses.forEach(function (course){
        let html = '<div class="form-group mt-2"><button onclick="removeElement('+course.id+')" class="btn btn-danger">X</button>'+course.name+'</div>';
        $("#list-courses").append(html);
    });
}
function existCourse(idCourse) {
    let existCourse = arrayCourses.find(function (course) {
        return course.id == idCourse;
    });
    return existCourse;
}
function removeElement(idCourse) {
    //Optiene el indice en donde se encuentra la categpria a eliminar 
    let index = arrayCourses.indexOf(existCourse(idCourse));
    //Eliminar el indice del array
    arrayCourses.splice(index, 1);
    showCourses();
}

