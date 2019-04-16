# POC-TorneoFrescas

Maven es una herramienta open-source de gestión de proyectos. Se basa en un fichero central, pom.xml, donde se define todo lo que necesita el proyecto. Maven maneja las dependencias del proyecto, compila, empaqueta y ejecuta los test.

POM.XML (Project Object Model) es un archivo que contiene la información del proyecto y los detalles de configuración usados por Maven para construir el proyecto.

Archetype es un conjunto de herramientas para la creación de plantillas del proyecto Maven.
Artifactid es el nombre identificador del proyecto jar sin la versión.

Goals de Maven: 
  - clean: intenta limpiar los archivos y directorios generados por Maven durante su compilación. Se utiliza el comando "mvn clean: clean" donde el primer "clean" se refiere al alias del complemento, y el segundo se refiere al objetivo del complemento. 
  - package: toma el codigo compilado y lo empaqueta con un formato .jar
  - compile: compila el codigo fuente del proyecto
  - install: instala el paquete en el directorio local para usar como dependencia en otros proyectos locales

Scopes de Maven: Se utiliza para limitar la transitividad de una dependencia.
  - compile: Este es el scope por default. Las dependencias de compilación están disponibles en todos los classpaths de un proyecto. Además, esas dependencias se propagan a proyectos dependientes.
  - provide: Muy parecido a compile, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de ejecución. Este scope solo está disponible en la compilación y prueba classpath, y no es transitivo.
  - runtime: Indica que la dependencia no es necesaria para la compilación, pero lo es para la ejecución. Se encuentra en entorno de ejecución y en la prueba de los classpath, pero no en la compilación los mismos.
  - test: Indica que la dependencia no es necesaria para el uso normal de la aplicación y solo está disponible para las fases de compilación y ejecución de la prueba. Este alcance no es transitivo.
  - system: Similar a provide, excepto que debe proporcionar el JAR que lo contiene explícitamente. El artefacto siempre está disponible y no se busca en un repositorio.
