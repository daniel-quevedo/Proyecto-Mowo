<%-- 
    Document   : modalPro
    Created on : 30-abr-2020, 17:47:20
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="ventana1">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Ingrese las notas</h4> 
            </div>

            <div class="modal-body">
                <form action="../../NotesSERVLET" method="POST">
                    
                    <div id="modCourse"></div>
                    <div id="modSubject"></div>
                    <div id="modStudent"></div>
                    
                    <div id="tableNotes">
                        <table class="table table-responsive-sm table-light">
                            <tr>
                                <td>Nota 1</td>
                                <td><input class="form-control" name="note1" id="note1" type="number" min="1" max="5" pattern="[1-9]" step="0.1" required></td>
                            </tr>
                            <tr>
                                <td>Nota 2</td>
                                <td><input class="form-control" name="note2" id="note2" type="number" min="1" max="5"pattern="[1-9]" step="0.1" required></td>
                            </tr>
                            <tr>
                                <td>Nota 3</td>
                                <td><input class="form-control" name="note3" id="note3" type="number" min="1" max="5" pattern="[1-9]" step="0.1" required></td>
                            </tr>
                            <tr>
                                <td>Nota 4</td>
                                <td><input class="form-control" name="note4" id="note4" type="number" min="1" max="5"pattern="[1-9]" step="0.1" required></td>
                            </tr>
                            <tr>

                                <td><button type="submit" class="btn btn-info" >Guardar</button></td>
                                <td><button type="reset" class="btn btn-secondary" data-dismiss="modal" >Cerrar</button></td>

                            </tr>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
