# Ejercicio de Automatización SauceDemo con Serenity BDD
Este proyecto contiene una prueba funcional automatizada (E2E) para el flujo de compra en SauceDemo, utilizando Serenity BDD con Screenplay y reportes Cucumber.

## Tecnologías Utilizadas
Java Development Kit (JDK): 17
Apache Maven: 3.9.10
Serenity BDD: 4.2.22
Serenity Screenplay: 4.2.22
Serenity Cucumber: 4.2.22
IntelliJ IDEA 2025.1.2 (Community Edition)
WebDriverManager: 5.8.0

### Prerrequisitos
Asegurece de tener instaladas las siguientes herramientas en su sistema:

1.  JDK 17: Puede descargarlo desde [Oracle](https://www.oracle.com/java/technologies/downloads/)
2.  Maven 3.9.10: Descárguelo desde [Apache Maven](https://maven.apache.org/download.cgi) y configure sus variables de entorno 'M2_HOME' y 'PATH'.
3.  Navegador Edge: Asegurece de tener una versión reciente. WebDriverManager se encargará de descargar el EdgeDriver compatible.

## Instrucciones de Ejecución

1.  Clonar el Repositorio:
    git clone [https://github.com/97Armando/saucedemo-serenity.git]
    cd saucedemo-serenity

2.  Ejecutar las Pruebas:
    Abra una terminal en la raíz del proyecto y ejecute el siguiente comando Maven:
    mvn clean install
    mvn clean verify
    
    Este comando compila el proyecto, ejecuta las pruebas definidas en los archivos '.feature' y generará los reportes.

3.  Visualizar los Reportes:
    Una vez que la ejecución finalice, los reportes de Serenity BDD se encontrarán en la carpeta 'target/site/serenity'.
    Abra el archivo 'index.html' en su navegador web preferido para ver el resumen detallado de la ejecución de las pruebas.

    En Windows:
        start target\site\serenity\index.html