## Evolución del proyecto

### 1. Diseño de la aplicación

Se ha realizado un UML que cumple con los requisitos básicos de nuestra aplicación, de esta forma comprender su
funcionamiento y la relación entre objectos. Por otro lado, debo recalcar que este UML puede variar durante el
desarrollo de la misma, adaptándose a nuevas necesidades.

Markup : ![uml](https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/blob/main/vuepress_book_find/img/uml.png "UML de la aplicacion")

### 2. Desarrollo de las entidades

Se han creado las entidades pertinentes basadas en el UML descrito con anterioridad. Dichas entidades (o clases) spring
las transforma en una base de datos H2 (no persistente) apta para continuar con el desarrollo y testeo de la aplicación.
Así mismo se han creado los controladores más básicos y esenciales, como es el controlador de usuario o el carrito.

- Se han añadido datos de prueba a la base de datos H2

### 3. Mockup front-end

Con la finalidad de crear un sitio web dinámico y visualmente agradable se ha desarrollado un Mockup que será utilizado
como guía a lo largo de progreso.

### 3. VUE front-end, creación del proyecto inicial

Con la ayuda de apis externas que faciliten en testeo y desarrollo de la aplicación se a inicializado el proyecto
front-end con vue.