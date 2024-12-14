# API Rest para un sistema de ventas en línea

## Cómo ejecutar?

1. Descargar o clonar el proyecto.
2. Para que el proyecto inicie, es necesario crear la base de datos `ventas_db` y cambiar la contraseña para el usuario de la base de datos por la del usuario que se tenga configurado en su sistema. El archivo está dentro de la carpeta `src/main/resources > application.properties`.
3. También es importante crear un archivo en la raíz del proyecto con el nombre `.env`. Este almacenará la variable `MONGO_URI` que tiene como valor el enlace del cluster de MongoDB donde se alojará la base de datos.

## Importante

Las tablas, los triggers y los procedimientos almacenados de la base de datos están dentro del proyecto, ya que se utiliza la librería Flyway para realizar la migración de la base de datos. Esto quiere decir que las tablas y demás se crean dentro de la base de datos mencionada anteriormente con la aplicación. **Por lo tanto, NO ES NECESARIO CREAR LAS TABLAS, TRIGGERS Y STORED PROCEDURES MANUALMENTE**.
