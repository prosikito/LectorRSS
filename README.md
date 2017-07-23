# LectorRSS

La app consume dos tipos de RSS:


### Formato JSON

Desde NewsApi (https://newsapi.org/). Además en este formato podemos elegir en las preferencias el origen del feed que queramos mostrar.

### Formato XML

Desde Xataka (http://www.xatakandroid.com/tag/feeds/rss2.xml). En este caso, las imágenes que trae el RSS dan error 403 y no se pueden mostrar. (Problemas de redirección y https)


## Librerías externas

### Glide

Carga asíncrona de imágenes


### JSOUP

Parsear HTML contenido en la descripción del RSS en el caso de Xataka


### PARCELER

Facilita el uso de Parcelables y reduce el código necesario


### GSON

Convertir el RSS en formato a JSON a objetos de Java.


### RETROFIT/OKHTTP3

Librería para conexiones


### RXJAVA/RXANDROID

Observables


### REALM

Base de datos local



## Patrón de diseño

Esta app utiliza una arquitectura "Clean" (Clean Architecture https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) cuyos principios se basan en la separación entre la vista, la lógica de dominio y los proveedores de datos. El Lector RSS se compone de tres módulos:

### data

A través de una clase "repositorio", contiene todo el código relacionado con conexiones, base de datos y preferencias.

### domain

Es una librería en Java, y no contiene ninguna referencia al framework de Android, sino simples POJOS.

### presentation

Contiene todo el código relacionado con la presentación de los datos y la interacción con el usuario. En esta capa aplicamos el patrón de diseño VIPER (View Interactor Presenter Entity Router https://cheesecakelabs.com/blog/using-viper-architecture-android/) y utiliza Data Binding para reducir la cantidad de código necesario en la Actividad.
Con el patrón de diseño VIPER tenemos que dentro de cada caso de uso, se declaran las interfaces de View, Presenter, Router e Interactor, y a su vez las clases encargadas de la implementación de dichas interfaces. De esta forma, al separar la vista, la interacción con el usuario, la interacción con el módulo de datos y las redirecciones de pantallas dentro de la app, conseguimos que cada clase sea más pequeña, mantenible y fácil de entender, así como de testear gracias a que cada una se comunica con la otra a traves de su interfaz.