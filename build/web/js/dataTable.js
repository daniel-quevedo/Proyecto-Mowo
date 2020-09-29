$(document).ready(function () {
    $('.mydataTable').DataTable({
        
        "order": [[2, 'asc']],         
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "all"]],
        "pagingType": "full_numbers",        
        "language": {
            "lengthMenu":
                    "Mostrar _MENU_ Registros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Ultimo",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing": "Procesando..."
        }
    });    
});