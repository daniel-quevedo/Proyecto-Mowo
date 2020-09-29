<%-- 
    Document   : modalUser
    Created on : 01-may-2020, 1:13:59
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="modal fade" id="ventana1">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Modifique los Campos del Usuario</h4> 
            </div>

            <div class="modal-body">
                <form action="../../CrudUserSERVLET" method="POST">
                    <div id="tableUsers">
                        <table class="table table-responsive-sm table-light">
                            <tr>
                                <th><label>Nombre:</label></th>
                                <td><input type="text" class="form-control" name="" value="" minlength="3" maxlength="25" pattern="[A-Za-zñ ]{3,25}"></td>
                            </tr>
                            <tr>
                                <th><label>Apellido:</label></th>
                                <td><input type="text" class="form-control" name="" value="" minlength="3" maxlength="25" pattern="[A-Za-zñ ]{3,25}"></td>
                            </tr>
                            <tr>
                                <th><label>Tipo de Documento:</label></th>
                                <td>
                                    <select class="form-control" name="">
                                        <option value="">Seleccione...</option>
                                        <option value="">CC</option>
                                        <option value="">TI</option>
                                        <option value="">CE</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th><label>N° Documento:</label></th>
                                <td><input type="number" class="form-control" name="" value="" minlength="7" maxlength="10" pattern="[0-9]{3,11}"></td>
                            </tr>
                            <tr>
                                <th><label>Tipo de Usuario:</label></th>
                                <td><select class="form-control" name="">
                                        <option value="">Seleccione...</option>
                                        <option value="">Administrador</option>
                                        <option value="">Docente</option>
                                        <option value="">Estudiante</option>
                                        <option value="">Acudiente</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <th><label>Telefono:</label></th>
                                <td><input type="number" class="form-control" name="" value="" min="7" max="15" pattern="[0-9]{3,15}"></td>
                            </tr>
                            <tr>
                                <th><label>Direccion:</label></th>
                                <td><input type="text" class="form-control" name="" value="" minlength="10" maxlength="100"></td>
                            </tr>
                            <tr>
                                <th><label>Fecha de Nacimiento:</label></th>
                                <td><input type="date" class="form-control" name="" value="" min="1960-01-01" max="dd-mm-yyyy"></td>
                            </tr>
                            <tr>
                                <th><label>Correo:</label></th>
                                <td><input type="email" class="form-control" name="" value="" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></td>
                            </tr>
                            <tr>
                                <td><button class="btn btn-danger" data-dismiss="modal">Cerrar</button></td>
                                <td><button class="btn btn-success" data-dismiss="modal">Guardar</button></td>
                            </tr>
                        </table>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
</div>