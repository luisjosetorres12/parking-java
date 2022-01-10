select count(id) as quantity, (select count(id) from mantenimiento.celda where estadoCelda = 1 and tipoVehiculo = :tipoVehiculo) as aviables,
(select count(id) from mantenimiento.celda where estadoCelda = 0 and tipoVehiculo = :tipoVehiculo) as unaviables,
case
 when tipoVehiculo = 1 then "Motocicletas"
 when tipoVehiculo = 2 then "Carros"
 end as tipoCelda
from mantenimiento.celda where tipoVehiculo = :tipoVehiculo;