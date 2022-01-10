create table ticket (
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