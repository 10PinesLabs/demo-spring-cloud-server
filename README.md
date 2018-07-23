# Config server
Servidor que sirve de proxy para servir configuraciones.

La fuente de los archivos de configuración que sirve depende del perfil con que se corra:
  
  * fs: toma la configuración del file system buscando los archivos en directorio especificado en config-server-fs.yaml
  * demo: toma la configuración de un repositorio Git tomando la ubicación de dicho repositorio en el archivo config-server-demo.yaml 

# Requerimientos
* Java 8

# Ejecución por consola

''''
mvn clean package
cd target
PROFILE=<profile> java -jar target/<jar-generado>
''''

