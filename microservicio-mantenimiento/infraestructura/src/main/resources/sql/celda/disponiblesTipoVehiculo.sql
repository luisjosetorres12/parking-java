select id,tipoVehiculo,estadoCelda
from celda
where estadoCelda = 1 and tipoVehiculo = :tipoVehiculo;