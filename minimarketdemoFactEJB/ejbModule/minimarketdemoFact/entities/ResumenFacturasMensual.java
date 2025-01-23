package minimarketdemoFact.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the resumen_facturas_mensual database table.
 * 
 */
@Entity
@Table(name="resumen_facturas_mensual")
@NamedQuery(name="ResumenFacturasMensual.findAll", query="SELECT r FROM ResumenFacturasMensual r")
public class ResumenFacturasMensual implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_facturas")
	private Long cantidadFacturas;

	private BigDecimal mes;

	@Id
	@Column(name="suma_total")
	private BigDecimal sumaTotal;

	public ResumenFacturasMensual() {
	}

	public BigDecimal getAnio() {
		return this.anio;
	}

	public void setAnio(BigDecimal anio) {
		this.anio = anio;
	}

	public Long getCantidadFacturas() {
		return this.cantidadFacturas;
	}

	public void setCantidadFacturas(Long cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}

	public BigDecimal getMes() {
		return this.mes;
	}

	public void setMes(BigDecimal mes) {
		this.mes = mes;
	}

	public BigDecimal getSumaTotal() {
		return this.sumaTotal;
	}

	public void setSumaTotal(BigDecimal sumaTotal) {
		this.sumaTotal = sumaTotal;
	}

}