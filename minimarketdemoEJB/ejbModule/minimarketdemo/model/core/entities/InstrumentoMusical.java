package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the instrumento_musical database table.
 * 
 */
@Entity
@Table(name="instrumento_musical")
@NamedQuery(name="InstrumentoMusical.findAll", query="SELECT i FROM InstrumentoMusical i")
public class InstrumentoMusical implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=2147483647)
	private String descripcion;

	private double descuento;

	@Column(length=255)
	private String marca;

	@Column(length=255)
	private String material;

	@Column(nullable=false, length=255)
	private String nombre;

	@Column(nullable=false)
	private double precio;

	//bi-directional many-to-one association to TipoInstrumento
	@ManyToOne
	@JoinColumn(name="idtipo_instrumento", nullable=false)
	private TipoInstrumento tipoInstrumento;

	public InstrumentoMusical() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoInstrumento getTipoInstrumento() {
		return this.tipoInstrumento;
	}

	public void setTipoInstrumento(TipoInstrumento tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}

}