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
    valorRecargaPorRetrasos float(11) not null,
    primary key (id),
    INDEX (celdaId),
    FOREIGN KEY(celdaId) REFERENCES celda(id)
);

create table IF NOT EXISTS diasfestivosco(
    id int(11) not null auto_increment,
    fechaFestivo Date not null,
    festividad varchar(255) not null,
    primary key (id)
);

insert into diasfestivosco (fechaFestivo, festividad) values
('2022-01-01', 'Año nuevo'),
('2022-01-10', 'Dia de reyes'),
('2022-03-21', 'Dia de San Jose'),
('2022-04-14', 'Jueves Santo'),
('2022-04-15', 'Viernes Santo'),
('2022-05-01', 'Dia del trabajo'),
('2022-05-30', 'Dia de la Ascension'),
('2022-06-20', 'Corpus Christi'),
('2022-06-27', 'Sagrado Corazon'),
('2022-07-04', 'San Pedro y San Pablo'),
('2022-07-20', 'Dia de la independencia'),
('2022-08-07', 'Batalla de Boyaca'),
('2022-08-15', 'Dia de la Asuncion'),
('2022-10-17', 'Celebracion del dia de la raza'),
('2022-11-07', 'Dia de todos los santos'),
('2022-11-14', 'Independencia de Cartagena'),
('2022-12-08', 'Inmaculada concepcion'),
('2022-12-25', 'Navidad');