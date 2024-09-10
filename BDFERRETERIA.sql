
/*
SQL SERVER MS 20

Nombre Servidor       : localhost
Nombre usuario        : tu_usuario (al abrir sql server--> por defecto es "sa")
Contraseña            : tu_contraseña
Nº puerto             : 1433 (por defecto)
Nombre Database       : BDPROYFERRETERIA
Date: 2024-09-03 7:15:25
*/

create database BDPROYFERRETERIA
use BDPROYFERRETERIA

create table CARGO (
idcargo int identity(1,1),
nombre varchar (50) not null,
constraint PK_cargo primary key(idcargo)
)
select *from CARGO

create table EMPLEADO(
idempleado int identity(1,1),
dni char(8) not null,
nombre varchar(150) not null,
telefono char(11) not null,
sexo char(1) not null,
direccion varchar(100) not null,
fecha_ingreso date not null,
salario decimal(7,2) not null,
idcargo int not null,
clave char(10) not null,
constraint PK_empleado primary key(idempleado),
constraint FK_cargo foreign key(idcargo) references CARGO(idcargo)
)

create table CLIENTE (
idcliente int identity(1,1),
dni char(8) not null,
nombre varchar(150) not null,
telefono char(11) not null,
sexo char(1) not null,
fecha_naci date not null,
direccion varchar(100) not null
constraint PK_cliente primary key(idcliente)
)
select *from cliente


create table VENTA (
numventa char(4),
fecha date not null,
idempleado int not null,
idcliente int not null,
constraint PK_venta primary key(numventa),
constraint FK_empleado foreign key(idempleado) references EMPLEADO(idempleado),
constraint FK_cliente foreign key(idcliente) references CLIENTE(idcliente)
)
select *from venta

create table CATEGORIA (
idcategoria int identity(1,1),
nombre varchar(200) not null,
descripcion varchar(100) not null,
constraint PK_categoria primary key(idcategoria)
)
select *from CATEGORIA

create table MARCA (
idmarca int identity(1,1),
nombre varchar(100) not null,
constraint PK_marca primary key(idmarca)
)
select *from MARCA

create table PRODUCTO (
idproducto int identity(1,1),
nombre varchar(100) not null,
costo decimal(16,2) not null,
preciounit decimal(6,2) not null,
stock int not null,
fecha_venci date not null,
idmarca int not null,
idcategoria int not null,
constraint PK_producto primary key(idproducto),
constraint FK_marca foreign key(idmarca) references MARCA(idmarca),
constraint FK_categoria foreign key(idcategoria) references CATEGORIA(idcategoria)
)
select *from PRODUCTO

create table DETALLE_VENTA(
idventa char(4),
idproducto int,
cantidad int not null,
precio decimal(7,2) not null,
constraint PK_venta_producto primary key(idventa,idproducto),
constraint FK_venta foreign key(idventa) references VENTA(numventa),
constraint FK_producto foreign key(idproducto) references PRODUCTO(idproducto)
)
select *from DETALLE_VENTA

INSERT INTO CARGO VALUES('Administrador'),('Vendedor'),('Cajero'),('Almacenero'),('Supervisor');

INSERT INTO EMPLEADO (dni, nombre, telefono, sexo, direccion, fecha_ingreso, salario, idcargo, clave) VALUES
('63289575', 'Cristian Olivera Chávez', '954306632', 'M', 'Patibamba baja', '2024-07-08', 2000.00, 1, '123'),
('87654321', 'María López', '987654322', 'F', 'Calle Comercio 456', '2023-02-20', 1600.00, 2, 'clave456'),
('11223344', 'Carlos García', '987654323', 'M', 'Jr. Equipos 789', '2023-03-10', 1700.00, 3, 'clave789'),
('44332211', 'Ana Martínez', '987654324', 'F', 'Psj. Herramientas 101', '2023-04-25', 1800.00, 4, 'clave101'),
('99887766', 'Luis Rodríguez', '987654325', 'M', 'Av. Ferretería 202', '2023-05-05', 1900.00, 1, 'clave202');

INSERT INTO CLIENTE (dni, nombre, telefono, sexo, fecha_naci, direccion) VALUES
('54321678', 'Pedro Castillo', '987654326', 'M', '1985-06-15', 'Calle Tornillos 203'),
('65432178', 'Lucía Fernández', '987654327', 'F', '1990-07-20', 'Av. Herramientas 456'),
('76543217', 'Andrés Gómez', '987654328', 'M', '1988-08-25', 'Jr. Clavos 789'),
('87654329', 'Rosa Herrera', '987654329', 'F', '1975-09-30', 'Psj. Pinturas 123'),
('98765430', 'Roberto Morales', '987654330', 'M', '1982-10-05', 'Av. Maderas 456'),
('11221133', 'Carla Rojas', '987654331', 'F', '1992-11-10', 'Calle Fierros 789'),
('22113344', 'Miguel Díaz', '987654332', 'M', '1986-12-15', 'Jr. Cementos 101'),
('33224455', 'Sofía Torres', '987654333', 'F', '1995-01-20', 'Psj. Metales 202'),
('44335566', 'Ricardo Reyes', '987654334', 'M', '1978-02-25', 'Av. Soldaduras 303'),
('55446677', 'Gabriela Vega', '987654335', 'F', '1989-03-30', 'Calle Electricidad 404'),
('66557788', 'Raúl Salinas', '987654336', 'M', '1984-04-05', 'Jr. Herramientas 505'),
('77668899', 'Laura Calderón', '987654337', 'F', '1991-05-10', 'Psj. Tubos 606'),
('88779900', 'Oscar Chávez', '987654338', 'M', '1987-06-15', 'Av. Ladrillos 707'),
('99880011', 'Patricia Ramírez', '987654339', 'F', '1983-07-20', 'Calle Aceros 808'),
('10991022', 'Alberto Fuentes', '987654340', 'M', '1976-08-25', 'Jr. Maderas 909');
select *from CARGO
select *from EMPLEADO
delete from EMPLEADO where idempleado=6
select *from cliente
INSERT INTO VENTA (numventa, fecha, idempleado, idcliente) VALUES
('0001', '2024-08-01', 1, 1),('0002', '2024-08-02', 2, 2),('0003', '2024-08-03', 3, 3),
('0004', '2024-08-04', 4, 4),('0005', '2024-08-05', 5, 5),('0006', '2024-08-06', 1, 6),
('0007', '2024-08-07', 2, 7),('0008', '2024-08-08', 3, 8),('0009', '2024-08-09', 4, 9),
('0010', '2024-08-10', 5, 10),('0011', '2024-08-11', 1, 11),('0012', '2024-08-12', 2, 12),
('0013', '2024-08-13', 3, 13),('0014', '2024-08-14', 4, 14),('0015', '2024-08-15', 5, 15);

INSERT INTO CATEGORIA (nombre, descripcion) VALUES
('Adhesivos', 'Pegamentos y productos adhesivos.'),
('Químicos', 'Productos químicos para diferentes usos.'),
('Seguridad Personal', 'Equipos de protección personal.'),
('Baterías', 'Baterías y fuentes de energía.'),
('Pinturas', 'Pinturas y productos relacionados.'),
('Limpieza', 'Productos de limpieza y mantenimiento.'),
('Iluminación', 'Productos y equipos de iluminación.'),
('Fontanería', 'Productos para instalaciones de agua y fontanería.'),
('Jardinería', 'Herramientas y productos para jardinería.'),
('Ferretería Menor', 'Artículos de ferretería de pequeño tamaño.'),
('Electricidad', 'Productos y materiales eléctricos.'),
('Cerrajería', 'Productos para la instalación y mantenimiento de cerraduras.'),
('Seguridad Industrial', 'Equipos y productos para la seguridad en el trabajo.'),
('Materiales de Construcción', 'Materiales utilizados en la construcción de edificios.'),
('Productos Automotrices', 'Productos y herramientas para el mantenimiento de vehículos.');

INSERT INTO MARCA (nombre) VALUES('Loctite'),('Tesa'),('Duracell'),
('Energizer'),('Crown'),('Rust-Oleum'),('Fischer'),('Stanley'),('Bosch'),
('Makita'),('DeWalt'),('Truper'),('3M'),('Philips'),('Black & Decker');

INSERT INTO PRODUCTO (nombre, costo, preciounit, stock, fecha_venci, idmarca, idcategoria) VALUES
('Adhesivo Epóxico', 5.00, 8.00, 100, '2025-06-30', 1, 1), 
('Pintura Acrílica', 15.00, 25.00, 80, '2024-12-31', 6, 5), 
('Baterías Alcalinas', 2.00, 5.00, 200, '2026-01-15', 3, 4), 
('Guantes de Nitrilo', 1.50, 3.00, 500, '2025-11-30', 13, 3), 
('Filtro de Agua', 10.00, 18.00, 70, '2024-09-30', 7, 8),
('Limpiador Multiuso', 3.50, 6.00, 150, '2024-11-15', 11, 6),
('Extintor de Incendios', 50.00, 75.00, 30, '2027-10-10', 9, 13), 
('Cinta Aislante', 0.50, 1.00, 300, '2026-05-01', 2, 10),
('Aceite para Motosierra', 8.00, 12.00, 60, '2025-07-01', 5, 15),
('Mascarillas Desechables', 0.20, 0.50, 1000, '2024-10-01', 14, 3),
('Spray Anti-Corrosión', 12.00, 18.00, 40, '2026-02-15', 8, 2),
('Desinfectante de Manos', 1.00, 3.00, 500, '2024-09-01', 10, 6), 
('Batería de Litio CR2032', 0.80, 1.50, 800, '2027-04-01', 4, 4), 
('Sellador de Silicona', 6.00, 10.00, 90, '2025-08-15', 12, 1), 
('Insecticida en Aerosol', 3.00, 5.00, 200, '2025-09-01', 15, 9); 


INSERT INTO DETALLE_VENTA (idventa, idproducto, cantidad, precio) VALUES
('0001', 1, 2, 400.00),('0002', 3, 1, 25.00),('0003', 4, 3, 45.00),
('0004', 5, 4, 20.00),('0005', 2, 1, 400.00),('0006', 6, 2, 240.00),
('0007', 7, 1, 180.00),('0008', 8, 1, 270.00),('0009', 9, 1, 500.00),
('0010', 10, 3, 45.00),('0011', 11, 4, 16.00),('0012', 12, 1, 35.00),
('0013', 13, 2, 300.00),('0014', 14, 1, 700.00),('0015', 15, 1, 700.00);

--=================consultas que involucran 1 sola tabla=======================
--1. listar empleados que han ingresado en el último año y ganan un salario superior a 1700:
select nombre, telefono, fecha_ingreso, salario
from empleado
where fecha_ingreso >= dateadd(year, -1, getdate())
and salario > 1700;

select *from empleado
--2. listar productos con stock menor a 50 y cuyo precio unitario sea mayor a 150:
select nombre, stock, preciounit
from producto
where stock < 50
and preciounit > 150;

select *from PRODUCTO
--================consultas que involucran 2 tablas===========================
--1. mostrar los nombres de los empleados que realizaron una venta en la última semana, junto con la fecha de la venta:
select e.nombre as empleado, v.fecha as fechaventa
from empleado e
inner join venta v on e.idempleado = v.idempleado
where v.fecha >= dateadd(week, -1, getdate());

--2. listar los nombres de los productos y sus respectivas marcas, cuyo stock sea menor a 100:
select p.nombre as producto, m.nombre as marca, p.stock
from producto p
inner join marca m on p.idmarca = m.idmarca
where p.stock < 100;

--===============consultas que involucran 3 tablas===========================
--1. listar las ventas realizadas en el último mes, mostrando el nombre del cliente, el nombre del empleado que realizó la venta, y el número de venta:
select c.nombre as cliente, e.nombre as empleado, v.numventa
from venta v
inner join cliente c on v.idcliente = c.idcliente
inner join empleado e on v.idempleado = e.idempleado
where v.fecha >= dateadd(month, -1, getdate());

--2. mostrar el detalle de ventas realizadas por un cliente específico (por ejemplo, 'pedro castillo'), incluyendo el nombre del producto, la cantidad comprada y el precio total de cada producto:
select c.nombre as cliente, p.nombre as producto, dv.cantidad, dv.precio
from detalle_venta dv
inner join venta v on dv.idventa = v.numventa
inner join producto p on dv.idproducto = p.idproducto
inner join cliente c on v.idcliente = c.idcliente
where c.nombre = 'pedro castillo';


select *from DETALLE_VENTA

--===============CREANDO VISTAS PARA UTILIZARLO EN EL BACKEND DEL PROYECTO==================

-- 1.- Proporciona detalles de ventas incluyendo producto, cliente, empleado y cálculos de precios totales.
create view V_CONSULTA_DETALLE as  
select detalle_venta.idventa, detalle_venta.cantidad, producto.nombre, detalle_venta.precio,
cliente.nombre as cliente, venta.fecha, detalle_venta.precio * detalle_venta.cantidad as total,
empleado.nombre as nombreempleado, producto.costo  
from detalle_venta 
inner join producto on detalle_venta.idproducto = producto.idproducto 
inner join venta on detalle_venta.idventa = venta.numventa 
inner join cliente on venta.idcliente = cliente.idcliente 
inner join empleado on venta.idempleado = empleado.idempleado;

-- 2.- Similar a la vista anterior, enfocado en detalles específicos de cada venta.
create view V_CONSULTA_DETALLEVENTA as  
select venta.numventa, detalle_venta.cantidad, producto.nombre, detalle_venta.precio,
cliente.nombre as cliente, venta.fecha, detalle_venta.precio * detalle_venta.cantidad as total,
empleado.nombre as nombreempleado, producto.costo  
from detalle_venta 
inner join venta on detalle_venta.idventa = venta.numventa 
inner join cliente on venta.idcliente = cliente.idcliente 
inner join producto on detalle_venta.idproducto = producto.idproducto 
inner join empleado on venta.idempleado = empleado.idempleado;

-- 3.- Lista los detalles de ventas individuales con cálculos de totales.						 
create view V_DETALLE_VENTA as  
select venta.numventa, producto.nombre, detalle_venta.cantidad, detalle_venta.precio,
detalle_venta.precio * detalle_venta.cantidad as total  
from detalle_venta 
inner join venta on detalle_venta.idventa = venta.numventa 
inner join producto on detalle_venta.idproducto = producto.idproducto;

-- 4.- Resume las ventas diarias totales.
create view V_DIA as  
select sum(detalle_venta.cantidad * detalle_venta.precio) as ventadia, venta.fecha  
from detalle_venta 
inner join venta on detalle_venta.idventa = venta.numventa  
group by venta.fecha;

-- 5.- Proporciona información principal sobre las ventas, incluyendo cliente y empleado.
create view V_ENCABEZADO as  
select venta.numventa, venta.fecha, cliente.nombre, empleado.nombre as nombreempleado  
from venta 
inner join cliente on venta.idcliente = cliente.idcliente 
inner join empleado on venta.idempleado = empleado.idempleado;

-- 6.- Calcula las ganancias diarias totales.
create view V_GANANCIA as  
select sum((detalle_venta.precio - producto.costo) * detalle_venta.cantidad) as utilidad, venta.fecha  
from detalle_venta 
inner join producto on detalle_venta.idproducto = producto.idproducto 
inner join venta on detalle_venta.idventa = venta.numventa  
group by venta.fecha;

-- 7.- Lista de cargos disponibles en la organización.
create view V_MANTENIMIENTO_CARGO as  
select idcargo, nombre  
from cargo;

-- 8.- Muestra las categorías de productos con descripciones.
create view V_MANTENIMIENTO_CATEGORIA as  
select idcategoria, nombre, descripcion  
from categoria;

-- 9.- Información detallada de clientes.
create view V_MANTENIMIENTO_CLIENTE as  
select idcliente, dni, nombre, telefono, sexo, fecha_naci, direccion  
from cliente;

-- 10.- Detalles de empleados junto con sus cargos.
create view V_MANTENIMIENTO_EMPLEADO as  
select empleado.idempleado, empleado.dni, empleado.nombre, empleado.telefono, empleado.sexo,
empleado.direccion, empleado.fecha_ingreso, empleado.salario, cargo.nombre as cargo, empleado.clave  
from empleado 
inner join cargo on empleado.idcargo = cargo.idcargo;

-- 11.- Lista de marcas disponibles.
create view V_MANTENIMIENTO_MARCA as  
select idmarca, nombre  
from marca;

-- 12.- Detalles de productos con información de marca y categoría.
create view V_MANTENIMIENTO_PRODUCTO as  
select producto.idproducto, producto.nombre, producto.costo, producto.preciounit, producto.stock,
producto.fecha_venci, marca.nombre as marca, categoria.nombre as categoria  
from producto 
inner join marca on producto.idmarca = marca.idmarca 
inner join categoria on producto.idcategoria = categoria.idcategoria;

-- 13.- Calcula la utilidad de cada producto basado en costo y precio unitario.
create view V_UTILIDAD as  
select producto.idproducto, producto.nombre, producto.costo, producto.preciounit,
producto.preciounit - producto.costo as utilidad, producto.stock, producto.fecha_venci,
marca.nombre as marca,categoria.nombre as categoria  
from producto 
inner join marca on producto.idmarca = marca.idmarca 
inner join categoria on producto.idcategoria = categoria.idcategoria;

select *from CATEGORIA
select *from MARCA
select*from cliente