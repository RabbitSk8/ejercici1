<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <!--HEAD-->
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Eliminar</title>
        <link rel="stylesheet" href="resources/css/style.css" type="text/css">
        <link type="text/javascript" src="resources/js/codigo.js" href="resources/js/codigo.js">
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
            <!-- ************ eliminar estudiante ********* -->
            <div class="columna1">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Estudiante</legend>
                        <label for="codigo">Código Estudiante: </label><input type="text" id="codigo" name="codigoEstudiante" size="20">
                        <input type="hidden" name="campoOculto" value="studentEliminar" size="20" >
                    </fieldset>
                    <input class="enviar" type="submit" onclick="alert('¡Estudiante Eliminado Exitosamente!')" value="Eliminar" >
                </form>
            </div>

            <!-- ************ eliminar docente ********* -->
            <div class="columna2">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Docente</legend>
                        <label for="codigo">Código Docente: </label><input type="text" id="codigo" name="codigoDocente" size="20">
                        <input type="hidden" name="campoOculto" value="teacherEliminar" size="20" >
                    </fieldset>
                    <input type="submit" onclick="alert('¡Docente Eliminado Exitosamente!')" value="Eliminar" />
                </form>
            </div>
            <!-- ************ eliminar materia ********* -->
            <div class="columna3">
                <form action="HelloServlet" method="post">
                    <fieldset>
                        <legend>Detalle Materia</legend>
                        <label for="codigo">Código Materia: </label><input type="text" id="codigo" name="codigoMateria" size="20">
                        <input type="hidden" name="campoOculto" value="subjectEliminar" size="20">
                    </fieldset>
                    <input type="submit" onclick="alert('¡Materia Eliminada Exitosamente!')" value="Eliminar"/>
                </form>
            </div>
    </div>
    <!-- ************ footer ********* -->
    <jsp:include page="footer.jsp"/>
</body>
</html>
