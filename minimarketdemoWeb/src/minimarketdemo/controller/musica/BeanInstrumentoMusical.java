package minimarketdemo.controller.musica;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.InstrumentoMusical;
import minimarketdemo.model.core.entities.SegModulo;
import minimarketdemo.model.core.entities.SegPerfil;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.entities.TipoInstrumento;
import minimarketdemo.model.musica.managers.ManagerMusica;

@Named
@SessionScoped
public class BeanInstrumentoMusical implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerMusica mMusica;
	private List<TipoInstrumento> listaTipoInstrumento;
	private List<InstrumentoMusical> listaInstrumentoMusical;
	private InstrumentoMusical nuevoInstrumentoMusical;
	private InstrumentoMusical edicionInstrumentoMusical;
	private int idTipoInstrumento;
	private int idInstrumentoMusical;
	
	@PostConstruct
	public void inicializacion() {
		nuevoInstrumentoMusical=new InstrumentoMusical();
	}
	
	
	//Cargar instrumentos y tipos de instrumentos
	public void actionListenerCargarInstrumento(InstrumentoMusical instrumento) {
		edicionInstrumentoMusical=instrumento;
	}
	
	public String actionCargarMenuInstrumentosMusicales() {
		listaTipoInstrumento= mMusica.findAllTipoInstrumento();
		listaInstrumentoMusical= mMusica.findAllInstrumentoMusical();
		return "instrumentos_musicales";
	}
	
	public void actionListenerInsertarInstrumento() {
	    try {
	        mMusica.insertarInstrumentoMusical(nuevoInstrumentoMusical, idTipoInstrumento);
	        listaInstrumentoMusical = mMusica.findAllInstrumentoMusical();
	        JSFUtil.crearMensajeINFO("Instrumento agregado");
	        nuevoInstrumentoMusical = new InstrumentoMusical(); 
	    } catch (Exception e) {
	        JSFUtil.crearMensajeERROR("Asegurese de llenar todos los campos correspondientes");
	        e.printStackTrace();
	    }
	}
	
	public void actionListenerGuardarEdicionInstrumento() {
		try {
			mMusica.actualizarInstrumentoMusical(edicionInstrumentoMusical);
			listaInstrumentoMusical=mMusica.findAllInstrumentoMusical();
			JSFUtil.crearMensajeINFO("Instrumento editado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR("Asegurese de llenar los campos correctamente");
			e.printStackTrace();
		}
		
	}
	
	public void actionListenerEliminarInstrumento(int idInstrumento) {
		try {
			mMusica.eliminarInstrumentoMusical(idInstrumento);
			listaInstrumentoMusical=mMusica.findAllInstrumentoMusical();
			JSFUtil.crearMensajeINFO("Instrumento eliminado");
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


	public List<InstrumentoMusical> getListaInstrumentoMusical() {
		return listaInstrumentoMusical;
	}


	public void setListaInstrumentoMusical(List<InstrumentoMusical> listaInstrumentoMusical) {
		this.listaInstrumentoMusical = listaInstrumentoMusical;
	}


	public InstrumentoMusical getNuevoInstrumentoMusical() {
		return nuevoInstrumentoMusical;
	}


	public void setNuevoInstrumentoMusical(InstrumentoMusical nuevoInstrumentoMusical) {
		this.nuevoInstrumentoMusical = nuevoInstrumentoMusical;
	}


	public InstrumentoMusical getEdicionInstrumentoMusical() {
		return edicionInstrumentoMusical;
	}


	public void setEdicionInstrumentoMusical(InstrumentoMusical edicionInstrumentoMusical) {
		this.edicionInstrumentoMusical = edicionInstrumentoMusical;
	}


	public int getIdTipoInstrumento() {
		return idTipoInstrumento;
	}


	public void setIdTipoInstrumento(int idTipoInstrumento) {
		this.idTipoInstrumento = idTipoInstrumento;
	}


	public int getIdInstrumentoMusical() {
		return idInstrumentoMusical;
	}


	public void setIdInstrumentoMusical(int idInstrumentoMusical) {
		this.idInstrumentoMusical = idInstrumentoMusical;
	}


	public BeanInstrumentoMusical() {
		// TODO Auto-generated constructor stub
	}

}
