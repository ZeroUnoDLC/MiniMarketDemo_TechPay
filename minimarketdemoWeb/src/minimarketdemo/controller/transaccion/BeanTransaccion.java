package minimarketdemo.controller.transaccion;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.Transaccion;
import minimarketdemo.model.transacciones.dtos.ManagerTransacciones;

@Named
@SessionScoped
public class BeanTransaccion implements Serializable {
	@EJB
	private ManagerTransacciones mTransaccion;
	private Transaccion nuevaTransaccion;
	private List<Transaccion> listaTransacciones;
	
	public BeanTransaccion() {
		// TODO Auto-generated constructor stub
	}

	public String actionCargarMenuTransaccion() {
		listaTransacciones= mTransaccion.findAllTransaccion();
		return "transacciones?faces-redirect=true";
	}
	
	//Insertar transacción 
	//TODO: hacer que el método coincida con el webhook
	public void actionListenerInsertarTipoInstrumento(){
		try {
			mTransaccion.insertarTransaccion(nuevaTransaccion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Eliminar transacción
	public void actionListenerEliminarTipoInstrumento(int idTransaccion) {
		try {
			mTransaccion.eliminarTransaccion(idTransaccion);
			listaTransacciones= mTransaccion.findAllTransaccion();
			JSFUtil.crearMensajeINFO("Resgistro de transacción borrado del historial");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}

	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	
	

}
