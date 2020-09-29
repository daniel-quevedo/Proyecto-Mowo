<%-- 
    Document   : planillaSS
    Created on : 23-abr-2020, 23:52:40
    Author     : Daniel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="../../layout/head.jsp"></jsp:include>
	<title>Servicio Social</title>
</head>
<body>
  <main>
    <header>
      <jsp:include page="../../layout/sideBarEst.jsp"></jsp:include>
    </header>
    <section>
      <div class="contenido abrir">
        <img src="../../img/menu.png" alt="" class="menu-bar">
        <div class="contenedor animated zoomIn mt-5">
          <section>
          </section>
          <section>
            <h5>Servicio Social</h5><br>
            <form action="">
              <div class="table-responsive-sm">
              <table class="table table-light">
                <thead class="thead-light">
                  <tr>
                    <th colspan="2">Primaria - Salon 204 - Jornada Mañana - Profesora Yolanda</th>
                  </tr>
                </thead>

                <tr>
                  <td>Ingrese la Planilla con los Datos Completos</td>
                  <td><input type="file" accept="image/*"></td>
                </tr>
              </table>
              </div>
            </form>
          </section>
        </div>
      </div>
    </section>
  </main>

	<jsp:include page="../../layout/scripts.jsp"></jsp:include>
</body>
</html>

