# MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER - BONO PARCIAL

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/49c2ebd2-755b-40be-9b29-c8257436c0f9)


Una aplicacion web creada utilizando Spark Java, un micro-framework, la cual publica servicios REST para calcular diferentes funcionalidades, incluso de manera asincrona. En adicion, se contruyo un Docker Container para la app, se desplego y configuro localmente y se subio la imagen a los repositorios "pachitoteranr/sparktaller5" y "pachitoteranr/bono-parcial", en DockerHub, segun correspondio.

## Instrucciones para ejecutar

A continuacion, dejo respectivas instrucciones para correr el proyecto adecuadamente tras obtener la direccion a este repositorio GitHub. Igualmente, mas abajo dejare evidencia detallada para garantizar que se entienda su implementacion. La aplicacion debe usarse para fines de prueba y desarrollo.

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java 20 instalado (si cuenta con otra version, probablemente deba hacer la respectiva modificacion en el archivo "pom.xml".

- Maven instalado

- JavaScript instalado

- Conexion a internet

- Explorador web

(RECOMENDACION) Tener todo actualizado
```

### Instalando

Paso a paso

```
1. Descargar el codigo: Bajar el .ZIP correspondiente al repositorio.

2. Extraer el contenido del archivo comprimido.

3. Abrir el Shell de su preferencia.

4. Desde el Shell, muevase a la ubicacion donde extrajo el archivo .ZIP (Deberia estar dentro de la carpeta llamada  "ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL-master").

5. Desde el Shell, escriba "mvn clean install" (este comando compila el proyecto Java y copiara sus dependencias en el directorio "target" en formato ".jar".

6. Desde el Shell, escriba "java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer" para ejecutar la aplicacion.
   Deberia ver un mensaje diciendo "Listo para recibir... ".

7. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente:
   
   - "localhost:4567/sin/*numero*" (SIN LAS COMILLAS) - Pagina para calcular el seno de *numero* (INTRODUCIR SIN LOS ASTERISCOS).
   - "localhost:4567/cos/*numero*" (SIN LAS COMILLAS) - agina para calcular el coseno de *numero* (INTRODUCIR SIN LOS ASTERISCOS).
   - "localhost:4567/palindrome*/*cadena*" (SIN LAS COMILLAS) - Pagina para determinar si *cadena* es palindrome o no (INTRODUCIR SIN LOS ASTERISCOS).
   - "localhost:4567/magvec/*dimension1*/*dimension2*" (SIN LAS COMILLAS) - Pagina para calcular la magnitud de un vector de dos dimensiones reales, *dimension1* y *dimension2* (INTRODUCIR SIN LOS ASTERISCOS).
   - "localhost:4567/index.html" (SIN LAS COMILLAS) - Pagina con formularios para cada funcion anterior, permitiendo llamados asincronos.

NOTA: Para abortar el shell con el servidor encendido, podemos presionar "CTRL" + "C".
```


## Evaluacion

Ejemplo de uso de la app web, llamando a sus respectivos servicios REST, ya desplegada:


- Sin:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/9d18c09d-1b11-44ee-98c8-3770aced6f0c)


- Cos:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/5e8b6fcf-a1ff-4d3c-9960-c42a4afbad46)

- Determinar si una cadena es un palíndromo:

  True:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/df4793f3-1370-46e8-817c-a1c5bd2f700e)


  False:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/256c971d-d149-4607-afcc-13bcd0ee38fa)

- Retorna la maginitud de un vector real de dos dimensiones, es decir recibe dos parámetros reales:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/11e2629c-2c56-4a0e-b5b4-69abc7cb85d2)

- Cliente con formularios para cada funcion:

  ![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/92a9a510-bc2d-4cd4-8e6e-337d02e1c0e8)











## Implementacion

### Arquitectura

Clase SparkWebServer: Esta clase principal configura el servidor web utilizando Spark Java. Define las rutas y controladores para manejar las solicitudes entrantes. Proporciona endpoints para calcular seno, coseno, verificar palíndromos y calcular la magnitud de un vector. Además, sirve una página HTML de inicio.

HTML Index.html: Una página web que incluye formularios que permiten a los usuarios ingresar datos y realizar solicitudes a través de llamadas asíncronas a los servicios del servidor. Estos formularios incluyen campos para calcular seno, coseno, verificar palíndromos y calcular la magnitud de un vector.

JavaScript: Se utiliza para capturar los datos ingresados por el usuario y enviar solicitudes GET al servidor mediante objetos XMLHttpRequest. Las respuestas del servidor se actualizan dinámicamente en la página web, lo que permite a los usuarios ver los resultados de sus solicitudes sin necesidad de recargar la página.


### Generar imagenes para desplegarlo

El explorador pide y ejecuta lo que el servidor web le envie, y luego el servidor devuelve el resultado (paginas html, archivos css y js e imagenes jpg).
Para esta conversion, se tiene en cuenta el encabezado del archivo y se devuelve en bytes. Este proceso varia segun el tipo de contenido.
App permite crear una aplicacion de backend, la cual estara en el servidor web, y funciona como un framework IoC para la construccion aplicaciones, derivando en una webapp a partir de un POJO cargado. Para esto se explora el directorio raiz para buscar aquellas clases marcadas con la anotacion @component (la cual indica que son componentes-beans) y cargarlas, de tal manera que cuando se invoca el framework este sepa el path de las clases que necesita. En el POJO se especifica cual servicio retornar segun la URI que se indique, atendiendo con la anotacion @GetMapping.
Se hace uso del patron de diseño SINGLETON, para instanciar por unica vez "HttpServer".

### Diagrama de clases

![image](https://github.com/TeranRyl/ARQUITECTURAS-EMPRESARIALES-BONO-PARCIAL/assets/81679109/54dded83-6ad7-40d7-a12d-94a5ab021638)




## Construido con

* [Java](https://www.oracle.com/co/java/) - Backend
* [Maven](https://maven.apache.org/) - Gestion de ciclo de vida, codigo fuente y dependencias
* [Git/Github](https://git-scm.com/) - Almacenar el codigo fuente
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE para desarrollo
* [Docker](https://www.docker.com/) - Virtualizacion y contenedores.

## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion para el taller e introduccion al tema
