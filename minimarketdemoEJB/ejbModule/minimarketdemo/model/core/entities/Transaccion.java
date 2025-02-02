package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the transaccion database table.
 */
@Entity
@Table(name="transaccion")
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)  // Se comenta/eliminas para usar ID del JSON
    @Column(name="transaccion_id", unique=true, nullable=false)
    private Long transaccionId;

    @Column(name="cliente_id", nullable=false)
    private Long clienteId;

    @Column(name="estadotr_id", nullable=false)
    private Long estadotrId;

    @Column(name="tarjeta_id", nullable=false)
    private Long tarjetaId;

    @Column(name="transaccion_descripcion", length=2147483647)
    private String transaccionDescripcion;

    @Column(name="transaccion_fecha", nullable=false)
    private Timestamp transaccionFecha;

    @Column(name="transaccion_moneda", nullable=false, length=500)
    private String transaccionMoneda;

    @Column(name="transaccion_monto", nullable=false, precision=15, scale=2)
    private BigDecimal transaccionMonto;

    public Transaccion() {
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

    public String getTransaccionDescripcion() {
        return transaccionDescripcion;
    }

    public void setTransaccionDescripcion(String transaccionDescripcion) {
        this.transaccionDescripcion = transaccionDescripcion;
    }

    public Timestamp getTransaccionFecha() {
        return transaccionFecha;
    }

    public void setTransaccionFecha(Timestamp transaccionFecha) {
        this.transaccionFecha = transaccionFecha;
    }

    public String getTransaccionMoneda() {
        return transaccionMoneda;
    }

    public void setTransaccionMoneda(String transaccionMoneda) {
        this.transaccionMoneda = transaccionMoneda;
    }

    public BigDecimal getTransaccionMonto() {
        return transaccionMonto;
    }

    public void setTransaccionMonto(BigDecimal transaccionMonto) {
        this.transaccionMonto = transaccionMonto;
    }
}
