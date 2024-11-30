package minimarketdemo.controller.musica;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.TipoInstrumento;
import minimarketdemo.model.musica.managers.ManagerMusica;

@Named
@SessionScoped
public class BeanTipoInstrumento implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerMusica mMusica;
	private List<TipoInstrumento> listaTipoInstrumento;
	private TipoInstrumento nuevoTipoInstrumento;
	private TipoInstrumento edicionTipoInstrumento;
	private int idTipoInstrumento;

	public String actionCargarMenuTipoInstrumentos() {
		listaTipoInstrumento= mMusica.findAllTipoInstrumento();
		return "tipo_instrumentos_musicales?faces-redirect=true";
	}
	
	//Insertar un tipo de instrumento	
	public String actionMenuNuevoTipoInstrumento() {
		nuevoTipoInstrumento= new TipoInstrumento();
		return "tipo_instrumento_nuevo";
	}
	
	public void actionListenerInsertarTipoInstrumento(){
		try {
			mMusica.insertarTipoInstrumento(nuevoTipoInstrumento);
			JSFUtil.crearMensajeINFO("Nuevo tipo de instrumento añadido");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//Borrar un tipo de instrumento
	public void actionListenerEliminarTipoInstrumento(int idTipoInstrumento) {
		try {
			mMusica.eliminarTipoInstrumento(idTipoInstrumento);
			listaTipoInstrumento= mMusica.findAllTipoInstrumento();
			JSFUtil.crearMensajeINFO("Tipo de instrumento eliminado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR("La categoría aun contiene elementos");
			e.printStackTrace();
		}
	}
	//Cargar menu de edicion de tipo de instrumento
	public String actionSeleccionarEdicionTipoInstrumento(TipoInstrumento TipoInstrumentoSeleccionado) {
		edicionTipoInstrumento=TipoInstrumentoSeleccionado;
		return "tipo_instrumento_edicion";
	}
	
	//Actualizar un tipo de instrumento
	public void actionListenerActualizarEdicionTipoInstrumento() {
		try {
			mMusica.actualizarTipoInstrumento(edicionTipoInstrumento);
			listaTipoInstrumento= mMusica.findAllTipoInstrumento();
			JSFUtil.crearMensajeINFO("Tipo de instrumento actualizado.");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<TipoInstrumento> getListaTipoInstrumento() {
		return listaTipoInstrumento;
	}


	public void setListaTipoInstrumento(List<TipoInstrumento> listaTipoInstrumento) {
		this.listaTipoInstrumento = listaTipoInstrumento;
	}

	public TipoInstrumento getNuevoTipoInstrumento() {
		return nuevoTipoInstrumento;
	}


	public void setNuevoTipoInstrumento(TipoInstrumento nuevoTipoInstrumento) {
		this.nuevoTipoInstrumento = nuevoTipoInstrumento;
	}

	public int getIdTipoInstrumento() {
		return idTipoInstrumento;
	}

	public void setIdTipoInstrumento(int idTipoInstrumento) {
		this.idTipoInstrumento = idTipoInstrumento;
	}

	public TipoInstrumento getEdicionTipoInstrumento() {
		return edicionTipoInstrumento;
	}

	public void setEdicionTipoInstrumento(TipoInstrumento edicionTipoInstrumento) {
		this.edicionTipoInstrumento = edicionTipoInstrumento;
	}

	public BeanTipoInstrumento() {
		// TODO Auto-generated constructor stub
	}

}
