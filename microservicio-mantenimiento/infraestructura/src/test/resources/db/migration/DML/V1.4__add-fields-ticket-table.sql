alter table ticket
add column cedulaUsuario varchar(100),
add column matriculaVehiculo varchar(100),
add column estadoVehiculo int not null,
add column valorRecargaPorRetrasos float not null;
