<%-- 
    Document   : servicioSocial
    Created on : 23-abr-2020, 23:51:14
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
            <h5>Servicio Social</h5><br>
            <form action="">
              <table class="table table-light table-responsive-sm table-hover">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">Opciones</th>
                    <th scope="col">Horario</th>
                    <th scope="col">Lugar</th>
                    <th scope="col">Jornada</th>
                    <th scope="col">Docente a Cargo</th>
                    <th scope="col">Disponible</th>
                    <th scope="col">Escoger</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th>Comedor</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>No</td>
                    <td><a href="#">Selecionar</a></td>
                  </tr>
                  <tr>
                    <th>Cafeteria</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>No</td>
                    <td><a href="#">Selecionar</a></td>
                  </tr>
                  <tr>
                    <th>Primaria</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Si</td>
                    <td><a href="planillaSS.jsp">Selecionar</a></td>
                  </tr>
                  <tr>
                    <th>Inclusion</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>No</td>
                    <td><a href="#">Selecionar</a></td>
                  </tr>
                  <tr>
                    <th>Coordinacion Academica</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>No</td>
                    <td><a href="#">Selecionar</a></td>
                  </tr>
                  <tr>
                    <th>Coordinacion Estudiantil</th>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>No</td>
                    <td><a href="#">Selecionar</a></td>
                  </tr>
                </tbody>
              </table>
            </form>
          </section>
        </div>
      </div>
    </section>
  </main>

	<jsp:include page="../../layout/scripts.jsp"></jsp:include>
</body>
</html>

