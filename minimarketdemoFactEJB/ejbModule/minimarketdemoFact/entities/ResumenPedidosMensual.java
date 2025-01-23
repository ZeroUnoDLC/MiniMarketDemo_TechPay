package minimarketdemoFact.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the resumen_pedidos_mensual database table.
 * 
 */
@Entity
@Table(name="resumen_pedidos_mensual")
@NamedQuery(name="ResumenPedidosMensual.findAll", query="SELECT r FROM ResumenPedidosMensual r")
public class ResumenPedidosMensual implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_pedidos")
	private Long cantidadPedidos;

	@Column(name="estado_pedido")
	private String estadoPedido;

	private BigDecimal mes;

	@Id
	@Column(name="suma_subtotal")
	private BigDecimal sumaSubtotal;

	public ResumenPedidosMensual() {
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public Long getCantidadPedidos() {
		return this.cantidadPedidos;
	}

	public void setCantidadPedidos(Long cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}

	public String getEstadoPedido() {
		return this.estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public BigDecimal getSumaSubtotal() {
		return this.sumaSubtotal;
	}

	public void setSumaSubtotal(BigDecimal sumaSubtotal) {
		this.sumaSubtotal = sumaSubtotal;
	}

}