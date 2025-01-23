package minimarketdemoFact.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the resumen_facturas_anual database table.
 * 
 */
@Entity
@Table(name="resumen_facturas_anual")
@NamedQuery(name="ResumenFacturasAnual.findAll", query="SELECT r FROM ResumenFacturasAnual r")
public class ResumenFacturasAnual implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal anio;

	@Column(name="cantidad_facturas")
	private Long cantidadFacturas;

	@Id
	@Column(name="suma_total")
	private BigDecimal sumaTotal;

	public ResumenFacturasAnual() {
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

	public BigDecimal getSumaTotal() {
		return this.sumaTotal;
	}

	public void setSumaTotal(BigDecimal sumaTotal) {
		this.sumaTotal = sumaTotal;
	}

}