create table if not EXISTS usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table if not EXISTS celda (
    id int(11) not null auto_increment,
    tipoVehiculo int(11) not null,
    estadoCelda int(11) not null,
    primary key (id)
);

create table if not EXISTS ticket (
    id int(11) not null auto_increment,
    celdaId int(11) not null,
    valor float(11) not null,
    valorRecargaFestivos float(11) not null,
    valorTotal float(11) not null,
    fechaEntrada DATE not null,
    fechaSalida DATE,
    cedulaUsuario varchar(1000),
    matriculaVehiculo varchar(100),
    tipoPlan int not null,
    estadoTicket int not null,
    primary key (id),
    INDEX (celdaId),
    FOREIGN KEY(celdaId) REFERENCES celda(id)
);
