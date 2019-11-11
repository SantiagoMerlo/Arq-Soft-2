#Trabajo Practico Evaluativo
##Arquitectura de Software 2
Por Merlo Santiago y Misa Carolina.

##Consigna:
###Recarga de Tarjetas:
Usuario: nombre, apellido, dni
 
Tarjeta: numero, saldo

Transacción: fecha, monto, operación (Debito, Crédito), tarjeta

Enum: Debito, Credito


1)  Un usuario puede tener varias tarjetas pero una tarjeta tiene un solo usuario.

2) En una Operación de Débito tengo que consultar por el saldo antes de confirmar que se puede hacer y retronar el Error en caso de no poder operar o el OK en caso de aceptar.

3) En una Operación de Credito para asignación de carga debo verificar el endpoint 
https://iua-service.herokuapp.com/autorizar

Request Post
{
  "tarjeta": {
    "numero": "1"
  },
  "monto": 38.5
}
o 
{
  "tarjeta": {
    "numero": "2"
  },
  "monto": 38.5
}

Response
{
"codigo": "01",
"estado": "APROBADA",
"autorizacion": "01"
}
o
{
"codigo": "02",
"estado": "RECHAZADA",
"autorizacion": "02"
}



Endpoints:
1) POST carga de saldo.

2) Post Pedido de Utilización de la tarjeta con un importe XX.

3) POST Alta de Tarejeta asignandola a un usuario ya existente en Base de Datos. (Verificar existencia del usuario)

4) Listado de operaciones o transacciones de una tarjeta. (Puede ser por ID)
