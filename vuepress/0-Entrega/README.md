# ENTREGA 0

## 1. Descripción:

Realizar una tienda de libros con su base de datos, donde el cliente puede comprar los libros directamente desde la
web.Consistirá en una página donde el usuario se puede registrar, buscar libros que quiera mediante filtros, pueda
valorarlos e incluso comprarlos (o por lo menos tener un enlace a algún sitio de compra).

## 2. Arquitectura de la aplicación:

Markup : ![picture alt](https://github.com/IES-Jaume-Balmes/2020-21-DAW2-M12-BookFind/blob/main/vuepress_book_find/img/arquitectura.png "Arquitectura de la aplicacion")

El usuario accederá a la aplicación a través del frontend web, que estará implementado en Vue. El frontend se comunicará
con el backend, que será una aplicación de Spring y que tendrá acceso a una base de datos MySQL para almacenar la
información de los libros.

## 2. Funcionamiento:

Habrá 2 perfiles de usuario, el normal y el administrador.

### Usuario:
* Registro: el usuario tienen que poder registrarse.
* Darse de baja: un usuario que se ha registrado tiene que poder darse de baja (borrarse).
* Login: el usuario registrado tiene que poder iniciar sesión.
* Logout: el usuario que ha iniciado sesión, tiene que poder cerrar sesión.
* Libros:   
    - Buscar: un usuario registrado tiene que poder buscar los libros en la base de datos.
    - Comprar: un usuario tiene que poder comprar el libro seleccionado (o por lo menos llegar al sitio de compra).
    - Valorar: un usuario tiene que poder dejar su valoración del libro.

### Administrador:

* Usuarios: CRUD (Create, Read, Update, Delete)
    - Listar usuarios
    - Crear usuarios
    - Modificar usuarios
    - Borrar usuarios
    
* Libros: CRUD
    - Listar
    - Crear 
    - Modificar
    - Borrar 

## 4. Herramientas, lenguajes y frameworks utilizados:
 
- Frontend: Vue
- Backend: Spring
- MySQ: Base de datos
- Landing page: HTML + CSS

### Proyecto:
- Documentación: 	VuePress
- Presentación:		reveal.js 

