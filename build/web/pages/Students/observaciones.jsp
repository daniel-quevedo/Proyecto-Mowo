<%-- 
    Document   : observaciones
    Created on : 23-abr-2020, 23:49:40
    Author     : Daniel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="../../layout/head.jsp"></jsp:include>
	<title>Observaciones</title>
</head>
<body>
  <main>
    <header>
      <jsp:include page="../../layout/sideBarEst.jsp"></jsp:include>
    </header>
    <section>
      <div class="contenido abrir">
        <img src="../../img/menu.png" alt="" class="menu-bar">
        <div class="contenedor animated zoomIn">
          <section>
            <nav>
              <ul class="nav nav-pills">
                <li class="nav-item">
                  <a class="nav-link active" href="#">Primer Periodo</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Segundo Periodo</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Tercer Periodo</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Cuarto Periodo</a>
                </li>
              </ul>
            </nav>
          </section>
          <section>
            <h5>Observaciones</h5><br
            <form action="">
              <div class="table-responsive-sm">
              <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">Fecha</th>
                    <th scope="col">Observaciones Generales</th>
                    <th scope="col">Profesor</th>
                    <th scope="col">Compromiso del Estudiante</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th>08-mayo</th>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                    <td>Antonio</td>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                  </tr>
                  <tr>
                    <th>27-mayo</th>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                    <td>Alejandro</td>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                  </tr>
                  <tr>
                    <th>10-junio</th>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                    <td>Rocio</td>
                    <td><textarea class="form-control" name="name" rows="2" disabled></textarea></td>
                  </tr>
                </tbody>
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

