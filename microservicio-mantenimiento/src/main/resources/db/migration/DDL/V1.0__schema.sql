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

create table if not exits ticket (
    id int(11) not null auto_increment,
    celdaId int(11) not null,
    valor float(11) not null,
    valorRecargaFestivos float(11) not null,
    valorTotal float(11) not null,
    fechaEntrada DATE not null,
    fechaSalida DATE,
    primary key (id),
    INDEX (celdaId),
    FOREIGN KEY(celdaId) REFERENCES celda(id)
)

alter table ticket
add column cedulaUsuario varchar(100),
add column matriculaVehiculo varchar(100),
add column estadoVehiculo int not null,
add column valorRecargaPorRetrasos float not null;

alter table ticket
change column estadoVehiculo estadoTicket int not null,
add column tipoPlan int not null;