create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table if not exits celda (
    id int(11) not null auto_increment,
    tipoVehiculo int(11) not null,
    estadoCelda int(11) not null,
    primary key (id)
)

