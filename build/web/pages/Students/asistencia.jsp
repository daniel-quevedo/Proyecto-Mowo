<%-- 
    Document   : asistencia.jsp
    Created on : 23-abr-2020, 23:43:05
    Author     : Daniel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="../../layout/head.jsp"></jsp:include>
	<title>Asistencia</title>
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
            <h5>Asistencia</h5><br
            <form action="">
              <div class="table-responsive-sm">
              <table class="table table-dark">
                <thead>
                  <tr>
                    <th colspan="2"><input type="date" class="form-control" title="Buscar Fecha" ></th>
                    <th scope="col">29-abril</th>
                    <th scope="col">30-abril</th>
                    <th scope="col">01-mayo</th>
                    <th scope="col">02-mayo</th>
                    <th scope="col">03-mayo</th>
                    <th scope="col">04-mayo</th>
                    <th scope="col">05-mayo</th>
                    <th scope="col">06-mayo</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <th>N°</th>
                    <th>Materia</th>
                    <td>Lunes</td>
                    <td>Martes</td>
                    <td>Miercoles</td>
                    <td>Jueves</td>
                    <td>Viernes</td>
                    <td>Lunes</td>
                    <td>Martes</td>
                    <td>Miercoles</td>
                  </tr>
                  <tr>
                    <th>1</th>
                    <td>Matematicas</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>2</th>
                    <td>Ciencias</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>3</th>
                    <td>Historia</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>4</th>
                    <td>Educacion Fisica</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>5</th>
                    <td>Sociales</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>6</th>
                    <td>Quimica</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                  <tr>
                    <th>7</th>
                    <td>Fisica</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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

