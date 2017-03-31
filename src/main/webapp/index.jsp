<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <!--HEAD-->
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Principal</title>
        <link rel="stylesheet" href="resources/css/style.css" type="text/css">
    </head>
    <!--BODY-->
    <body>
        <!-- ************ header ********* -->
        <jsp:include page="header.jsp"/>
        <!-- ************ main ********* -->
        <!--<h1>Hello JSP and Servlet!</h1>-->
        <div class="contenido">
            <!-- ************ menú ********* -->
            <nav>
                <ul class="menu">
                    <li><a href="index.jsp">Insertar</a></li>
                    <li><a href="consultar.jsp">Consultar</a></li>
                    <li><a href="eliminar.jsp">Eliminar</a></li>
                </ul>
            </nav>
            <!-- ************ agregar estudiante ********* -->
            <div class="columna1">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Estudiante</legend>
                        <label for="nombre">Nombre: </label><input type="text" id="nombre" name="nombreEstudiante" size="20"><br><br>
                        <label for="apellido">Apellido: </label><input type="text" id="apellido" name="apellidoEstudiante" size="20"><br><br>
                        <label for="cedula">Cedula: </label><input type="text" id="cedula" name="cedulaEstudiante" size="20"><br><br>
                        <input type="hidden" name="campoOculto" value="studentAgregar" size="20" >
                    </fieldset>
                    <input type="submit" onclick="alert('¡Estudiante Creado Exitosamente!')" value="Insertar" >
                </form>
            </div>

            <!-- ************ agregar docente ********* -->
            <div class="columna2">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Docente</legend>
                        <label for="nombre">Nombre: </label><input type="text" id="nombre" name="nombreDocente" size="20"><br><br>
                        <label for="apellido">Apellido: </label><input type="text" id="apellido" name="apellidoDocente" size="20"><br><br>
                        <label for="direccion">Dirección: </label><input type="text" id="direccion" name="direccionDocente" size="20"><br><br>
                        <label for="esp">Especialización: </label><input type="text" id="esp" name="especializacionDocente" size="20"><br><br>
                        <input type="hidden" name="campoOculto" value="teacherAgregar" size="20" >
                    </fieldset>
                    <input type="submit" onclick="alert('¡Docente Creado Exitosamente!')"value="Insertar" />
                </form>
            </div>
            <!-- ************ agregar materia ********* -->
            <div class="columna3">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Materia</legend>
                        <label for="cod">Código Docente: </label><input type="text" id="cod" name="codigoDocente" size="20"><br><br>
                        <label for="nombre">Nombre: </label><input type="text" id="nombre" name="nombreMateria" size="20"><br><br>
                        <label for="creditos">Número de Créditos: </label><input type="text" id="creditos" name="creditosMateria" size="20"><br><br>
                        <input type="hidden" name="campoOculto" value="subjectAgregar" size="20">
                    </fieldset>
                    <input class="enviar" type="submit" onclick="alert('¡Materia Creada Exitosamente!')"value="Insertar"/>
                </form>
            </div>
        </div>
        <!-- ************ footer ********* -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>