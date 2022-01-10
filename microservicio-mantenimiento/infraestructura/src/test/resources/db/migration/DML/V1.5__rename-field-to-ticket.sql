alter table ticket
change column estadoVehiculo estadoTicket int not null,
add column tipoPlan int not null;