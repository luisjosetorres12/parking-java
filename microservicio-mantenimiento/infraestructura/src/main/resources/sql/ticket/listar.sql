SELECT ticket.id, celdaId, valor, valorRecargaFestivos, valorTotal,
fechaEntrada, fechaSalida, celda.tipoVehiculo, celda.estadoCelda, cedulaUsuario, matriculaVehiculo
FROM ticket
inner join celda on ticket.celdaId = celda.id;
