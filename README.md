### Base de datos:

```dockerfile
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=your_password -e MYSQL_USER=root -e MYSQL_PASSWORD=your_password mariadb
```

```sql
CREATE DATABASE ej02;

USE ej02;

CREATE TABLE persona
(
    id       INT                  NOT NULL AUTO_INCREMENT,
    nombre   VARCHAR(50)          NOT NULL,
    apellido VARCHAR(50)          NOT NULL,
    correo   VARCHAR(100)         NOT NULL,
    sexo     ENUM ('M', 'F', 'O') NOT NULL,
    PRIMARY KEY (id)
);
```