# Evaluacion final Mitocode Java Backend Developer

## Video Explicacion

- <a href="https://res.cloudinary.com/dlixnwuhi/video/upload/v1722647298/video-mitocode_ldwfrv.mp4">Click aqui</a> para ver el video. 

## Deploy

- <a href="https://retofinal-mitocode.onrender.com/courses">Backend</a> deployado en render. Porfavor dejar que realize la peticion por unos minutos porque tiene que levantar el proyecto nuevamente debido al plan free de render de suspensión por inactividad.
- <a href="https://documenter.getpostman.com/view/31249307/2sA3rwMDsK">Documentación</a> realizado con postman. 

## Instrucciones

- Puedes realizar el `mvn install` para la instalacion de las dependencias o sino hacer reload de su archivo `pom.xml`
- Configurar sus variables de entorno creando un archivo `.env` en la raiz de su proyecto

```bash
DB_URL=tu_url_de_base_de_datos
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña
```
- En el archivo principal de la aplicacion:

```java
package com.luisguzman;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendLuisguzmanApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        //Las variables de entorno se cargan en el sistema
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        SpringApplication.run(BackendLuisguzmanApplication.class, args);
    }
}
```

- Si levanta la aplicacion con docker ya esta la configuracion en los archivos `Dockerfile` y `docker-compose.xml`. No olvides comentar las lineas donde traemos las variables de entorno con el `dotenv-java` en la funcion que inicia nuestra aplicación.
