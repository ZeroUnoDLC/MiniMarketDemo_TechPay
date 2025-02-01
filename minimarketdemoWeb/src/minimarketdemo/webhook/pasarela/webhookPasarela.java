package minimarketdemo.webhook.pasarela;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

// Define la URL del webhook
@Path("/webhook")
public class webhookPasarela {

    @POST // Define que este endpoint recibe solicitudes POST
    @Consumes("application/json") // Indica que recibirá datos en formato JSON
    public Response receivePaymentNotification(String payload) {
        // Aquí procesarás los datos que envíe la pasarela
        System.out.println("Datos recibidos: " + payload);

        // Devuelve una respuesta al cliente (pasarela de pagos)
        return Response.ok().build();
    }
}

