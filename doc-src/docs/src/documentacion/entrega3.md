# Entrega 3


<!-- ### Evolución del proyecto -->

## Diseño de la aplicación VUE front-end

El front-end ha evolucionado considerablemente, se han añadido vistas para registrar usuarios y otra para la creación de nuevos libros, todo ello implementado con una seguridad, los campos no pueden estar en blanco y concuerdan con los requisitos especificados de cada sección. También se ha desarrollado una vista que sirve para mostrar más detalle del libro seleccionado.

### Galeria

Vista para crear un Libro:

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/createLibro.png)

Seguridad para los requisitos del Libro:

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/createLibro2.png)

Vista para registrar un usuario:

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/userRegister.png)

Vista del inicio de session del usuario:

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/usershow.png)

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/usershow2.png)

Vista de Detalle del libro:

![Disseño Vue](/2020-21-DAW2-M12-BookFind/img/detalleLibro.jpeg)


## Desarrollo del backend SPRING

El desarrollo del SRING durante la semana se ha centrado en implementar la seguridad del registro y el inicio de session del usuario, y despues de muchos problemas se consiguio implementar un metodo de seguridad mediante TOKENS(JWT). És un metodo de autenticación para poder garantizar que los usuarios que consumen nuestros servicios tienen permisos para hacerlo y son quien dicen ser. 

### Galeria

Esquema del SPRING:

![Backend](/2020-21-DAW2-M12-BookFind/img/seguridad2.png)

![Backend](/2020-21-DAW2-M12-BookFind/img/seguridad.png)

