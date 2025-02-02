package minimarketdemo.api.rest.webhook;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentNotificationDTO {

    private Long transaccionId;
    private Long clienteId;
    private Long estadotrId;
    private Long tarjetaId;
    private String descripcion;    // transaccion_descripcion
    private Timestamp fecha;       // transaccion_fecha
    private String moneda;         // transaccion_moneda
    private BigDecimal monto;      // transaccion_monto

    public PaymentNotificationDTO() {
    }

    public Long getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Long transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getEstadotrId() {
        return estadotrId;
    }

    public void setEstadotrId(Long estadotrId) {
        this.estadotrId = estadotrId;
    }

    public Long getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(Long tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
