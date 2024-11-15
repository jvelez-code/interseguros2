# Selecciona una imagen base de Tomcat
FROM tomcat:11.0.0-jdk21

# Copia el archivo WAR de la aplicación en el directorio webapps de Tomcat
COPY aseguradora.war /usr/local/tomcat/webapps/
COPY app-aseguradora /usr/local/tomcat/webapps/app-asegurador

RUN apt-get update && apt-get install -y tzdata && \
    ln -fs /usr/share/zoneinfo/America/Bogota /etc/localtime && \
    dpkg-reconfigure --frontend noninteractive tzdata
    
EXPOSE 9898

# Comando de inicio de Tomcat
CMD ["catalina.sh", "run"]


