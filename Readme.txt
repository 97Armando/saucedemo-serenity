# Ejercicio de Automatización SauceDemo con Serenity BDD
Este proyecto contiene una prueba funcional automatizada (E2E) para el flujo de compra en SauceDemo, utilizando Serenity BDD con Screenplay y reportes Cucumber.
#### Tecnologías Utilizadas

* **Java Development Kit (JDK):** 17
* **Apache Maven:** 3.9.10
* **Serenity BDD:** 4.2.22
* **Serenity Screenplay:** 4.2.22
* **Serenity Cucumber:** 4.2.22
* **WebDriverManager:** 5.8.0 (para gestionar el ChromeDriver)

#### Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas en tu sistema:

1.  **JDK 17:** Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/downloads/) o usar `sdk install java 17.0.x-temurin` si usas SDKMAN!.
2.  **Maven 3.9.10:** Descárgalo desde [Apache Maven](https://maven.apache.org/download.cgi) y configura tus variables de entorno `M2_HOME` y `PATH`.
3.  **Navegador Google Chrome:** Asegúrate de tener una versión reciente instalada. WebDriverManager se encargará de descargar el ChromeDriver compatible.

## Instrucciones de Ejecución

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/97Armando/saucedemo-serenity.git]
    cd saucedemo-serenity
    ```

2.  **Ejecutar las Pruebas:**
    Abre una terminal en la raíz del proyecto y ejecuta el siguiente comando Maven:
    ```bash
    mvn clean install
    mvn clean verify
    ```
    Este comando compilará el proyecto, ejecutará las pruebas definidas en los archivos `.feature` y generará los reportes.

3.  **Visualizar los Reportes:**
    Una vez que la ejecución finalice, los reportes de Serenity BDD se encontrarán en la carpeta `target/site/serenity`.
    Abre el archivo `index.html` en tu navegador web preferido para ver el resumen detallado de la ejecución de las pruebas.

    * **En Linux/macOS:**
        ```bash
        open target/site/serenity/index.html
        ```
    * **En Windows:**
        ```bash
        start target\site\serenity\index.html
        ```