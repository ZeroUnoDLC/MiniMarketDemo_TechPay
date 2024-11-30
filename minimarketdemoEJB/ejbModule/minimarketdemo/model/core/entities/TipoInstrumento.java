package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_instrumento database table.
 * 
 */
@Entity
@Table(name="tipo_instrumento")
@NamedQuery(name="TipoInstrumento.findAll", query="SELECT t FROM TipoInstrumento t")
public class TipoInstrumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=2147483647)
	private String descripcion;

	@Column(nullable=false, length=255)
	private String nombre;

	//bi-directional many-to-one association to InstrumentoMusical
	@OneToMany(mappedBy="tipoInstrumento")
	private List<InstrumentoMusical> instrumentoMusicals;

	public TipoInstrumento() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<InstrumentoMusical> getInstrumentoMusicals() {
		return this.instrumentoMusicals;
	}

	public void setInstrumentoMusicals(List<InstrumentoMusical> instrumentoMusicals) {
		this.instrumentoMusicals = instrumentoMusicals;
	}

	public InstrumentoMusical addInstrumentoMusical(InstrumentoMusical instrumentoMusical) {
		getInstrumentoMusicals().add(instrumentoMusical);
		instrumentoMusical.setTipoInstrumento(this);

		return instrumentoMusical;
	}

	public InstrumentoMusical removeInstrumentoMusical(InstrumentoMusical instrumentoMusical) {
		getInstrumentoMusicals().remove(instrumentoMusical);
		instrumentoMusical.setTipoInstrumento(null);

		return instrumentoMusical;
	}

}