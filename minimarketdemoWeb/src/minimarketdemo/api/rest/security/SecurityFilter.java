package minimarketdemo.api.rest.security;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import minimarketdemo.api.rest.util.ConfigUtil; // Importamos la clase util
import minimarketdemo.api.rest.security.Secured;

@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    // Nombre de la cabecera donde llega la clave
    private static final String HEADER_KEY = "X-Secret-Key";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // 1) Tomar la clave del archivo .properties
        String expectedSecret = ConfigUtil.getSecretKey();

        // 2) Leer la cabecera que manda el cliente/pasarela
        String headerSecret = requestContext.getHeaderString(HEADER_KEY);

        // 3) Comparar
        if (headerSecret == null || !headerSecret.equals(expectedSecret)) {
            // Abortar con 401 si no coincide
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Acceso denegado: clave secreta inválida o ausente.")
                        .build()
            );
        }

        // Si coincide, simplemente dejamos pasar.
    }
}
