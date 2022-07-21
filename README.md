# API-REST-STORE

Mi primera API REST CRUD coded en Java con el framework Spring y MySQL como database.

### Cosas pendientes:

- [x] Crear API REST CRUD con Spring.
- [x] Hacer Front-End básico con React.
- [x] Conectar API.
- [ ] Hacer Deploy de la API en Heroku.
- [ ] Hacer que la variable {operation.total} sea = {product.quantity} * {product.price}.
- [ ] Hacer que al seleccionar un customer first name en AddOperation, se seleccione su last name.
- [ ] Hacer que al seleccionar un product name en AddOperation, se seleccione su price.
- [ ] Realizar gráficos de operaciones.

- 1-Por ahora para iniciar la WebApp, creo una database en MySQL con el nombre "store_system_management". 
```
create database store_management_system
```
- 2-En la carpeta /frontend hago un "npm i" para instalar sus dependencias y luego le doy npm start.
```
$cd frontend/
$npm install
$npm start
```
- 3-En las application.properties de la API, coloco el user, password y dirección de la database.
```
spring.datasource.url=jdbc:mysql://localhost:3306/store_management_system?useSSL=false
spring.datasource.username=root
spring.datasource.password=Supagot1
#actualiza base de datos y crea entidades
spring.jpa.hibernate.ddl-auto = update
#hibernate genera SQL optimizado
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
```
- 4-Ejecuto el AppApplication.java.

