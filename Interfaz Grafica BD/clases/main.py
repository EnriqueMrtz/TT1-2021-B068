import tarifa as tf
import CRUD as bd
tarifas=tf.tarifa()
CRUD=bd.CRUD(tarifas.tarifa)
print(CRUD.pago_tarifa("enrique"))