package minimarketdemo.api.rest.webhook;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import minimarketdemo.model.transacciones.managers.ManagerTransacciones;
import minimarketdemo.model.core.entities.Transaccion;

@Path("/webhook")
public class PaymentWebhookResource {

    @EJB
    private ManagerTransacciones managerTransacciones;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recibirNotificacion(PaymentNotificationDTO dto) {
        try {
            // 1) Construir la entidad Transaccion con los datos del DTO
            Transaccion nueva = new Transaccion();

            // Ahora SÍ seteamos la PK que llega del JSON:
            nueva.setTransaccionId(dto.getTransaccionId());

            nueva.setClienteId(dto.getClienteId());
            nueva.setEstadotrId(dto.getEstadotrId());
            nueva.setTarjetaId(dto.getTarjetaId());
            nueva.setTransaccionDescripcion(dto.getDescripcion());

            // Si en el DTO viene la fecha (Timestamp):
            if (dto.getFecha() != null) {
                nueva.setTransaccionFecha(dto.getFecha());
            } else {
                // O, en caso de que no venga, asignamos la actual:
                nueva.setTransaccionFecha(new java.sql.Timestamp(System.currentTimeMillis()));
            }

            nueva.setTransaccionMoneda(dto.getMoneda());
            nueva.setTransaccionMonto(dto.getMonto());

            // 2) Persistir usando tu manager
            managerTransacciones.insertarTransaccion(nueva);

            // 3) Devolver respuesta exitosa
            return Response.ok("Transacción insertada correctamente.").build();

        } catch (Exception e) {
            return Response.serverError()
                    .entity("Error al procesar webhook: " + e.getMessage())
                    .build();
        }
    }
}
