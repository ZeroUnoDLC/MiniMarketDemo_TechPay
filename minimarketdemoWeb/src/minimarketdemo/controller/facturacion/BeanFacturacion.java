package minimarketdemo.controller.facturacion;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.TipoInstrumento;
import minimarketdemo.model.musica.managers.ManagerMusica;
import minimarketdemoFact.entities.VwEvento;
import minimarketdemoFact.manager.ManagerMinimarketdemoFact;

@Named
@SessionScoped
public class BeanFacturacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerMinimarketdemoFact mVwEvento;
	private List<VwEvento> listaVwEvento;
	
	public BeanFacturacion() {
		// TODO Auto-generated constructor stub
	}
	
	public String actionCargarMenuEvento() {
		listaVwEvento= mVwEvento.findAllEvento();
		return "facturas";
	}

	public List<VwEvento> getListaVwEvento() {
		return listaVwEvento;
	}

	public void setListaVwEvento(List<VwEvento> listaVwEvento) {
		this.listaVwEvento = listaVwEvento;
	}
	
	
	
}
