<%-- 
    Document   : asignaturas
    Created on : 23-abr-2020, 23:46:47
    Author     : Daniel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="../../layout/head.jsp"></jsp:include>
	<title>Asignaturas</title>
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
            <h5>Asignaturas</h5><br
            <form action="">
              <div class="table-responsive-sm">
              <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">N°</th>
                    <th scope="col">Asignaturas</th>
                    <th scope="col">Profesor</th>
                    <th scope="col">Salon</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th>1</th>
                    <td>Matematicas</td>
                    <td>Antonio</td>
                    <td>403</td>
                  </tr>
                  <tr>
                    <th>2</th>
                    <td>Ciencias</td>
                    <td>Miguel</td>
                    <td>205</td>
                  </tr>
                  <tr>
                    <th>3</th>
                    <td>Historia</td>
                    <td>Camilo</td>
                    <td>306</td>
                  </tr>
                  <tr>
                    <th>4</th>
                    <td>Educacion Fisica</td>
                    <td>Julian</td>
                    <td>402</td>
                  </tr>
                  <tr>
                    <th>5</th>
                    <td>Sociales</td>
                    <td>Fredy</td>
                    <td>408</td>
                  </tr>
                  <tr>
                    <th>6</th>
                    <td>Quimica</td>
                    <td>Carlos</td>
                    <td>207</td>
                  </tr>
                  <tr>
                    <th>7</th>
                    <td>Fisica</td>
                    <td>Andrea</td>
                    <td>303</td>
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

	<script src="../../js/jquery.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/abrir.js" charset="utf-8"></script>
</body>
</html>
