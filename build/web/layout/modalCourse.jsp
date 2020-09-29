<%-- 
    Document   : modalUser
    Created on : 01-may-2020, 1:13:59
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="modal fade" id="ventana1">
    <div class="modal-dialog">
        <div class="modal-content col-9">

            <div class="modal-header">
                <h4 class="modal-title">Modificar Cursos</h4> 
            </div>

            <div class="modal-body">
                <form action="../../CrudCourseSERVLET" method="POST">
                    <input type="hidden" name="option" value="3">
                    <div id="tableCourse">
                        
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>