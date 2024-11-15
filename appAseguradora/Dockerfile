
# Usa una imagen base de Node para construir la aplicación
FROM node:20.10.0 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia el package.json y el package-lock.json
COPY package*.json ./

# Instala las dependencias
RUN npm install

# Copia el resto de la aplicación
COPY . .

#o Construye la aplicación
RUN npm run build -- --configuration production

# Usa una imagen base de Nginx para servir los archivos estáticos
FROM nginx:alpine

# Copia los archivos construidos desde la etapa anterior
COPY --from=builder /app/dist/app-aseguradora /usr/share/nginx/html

# Copia la configuración de Nginx
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expone el puerto en el que Nginx servirá la aplicación
EXPOSE 80

# Comando para iniciar Nginx
CMD ["nginx", "-g", "daemon off;"]


#docker build -t iapp-seguradoras .
#docker run -d --name capp-seguradoras -p 8081:80 iapp-seguradoras

