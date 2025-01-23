package minimarketdemoFact.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import minimarketdemoFact.entities.ResumenFacturasAnual;
import minimarketdemoFact.entities.ResumenFacturasMensual;
import minimarketdemoFact.entities.ResumenPedidosMensual;
import minimarketdemoFact.entities.VwEvento;

/**
 * Session Bean implementation class ManagerMinimarketdemoFact
 */
@Stateless
@LocalBean
public class ManagerMinimarketdemoFact {
	@PersistenceContext(unitName = "facturacionDS")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public ManagerMinimarketdemoFact() {
        // TODO Auto-generated constructor stub
    }
    
    //Codigo anterior para el manejo de eventos anterior
    @SuppressWarnings("unchecked")
	public List<VwEvento> findAllEvento(){
    	Query q;
    	List<VwEvento> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM VwEvento o";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
    //--------CONFIGURACION DEL MANAGER PARA LAS VISTAS NECESARIAS--------
    //Primera vista
    @SuppressWarnings("unchecked")
	public List<ResumenFacturasAnual> findAllFacturasAnual(){
    	Query q;
    	List<ResumenFacturasAnual> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM ResumenFacturasAnual o";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
    //Segunda vista
    @SuppressWarnings("unchecked")
	public List<ResumenFacturasMensual> findAllFacturasMensual(){
    	Query q;
    	List<ResumenFacturasMensual> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM ResumenFacturasMensual o";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
    
    //Tercera vista
    @SuppressWarnings("unchecked")
	public List<ResumenPedidosMensual> findAllPedidosMensual(){
    	Query q;
    	List<ResumenPedidosMensual> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM ResumenPedidosMensual o";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
    
    //FIltrado por pedidos despachados
    @SuppressWarnings("unchecked")
	public List<ResumenPedidosMensual> findAllPedidosMensualPendientes(){
    	Query q;
    	List<ResumenPedidosMensual> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM ResumenPedidosMensual o WHERE estado_pedido = 'NV'";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
    
    //FIltrado por pedidos pendientes
    @SuppressWarnings("unchecked")
	public List<ResumenPedidosMensual> findAllPedidosMensualDespachados(){
    	Query q;
    	List<ResumenPedidosMensual> listado;
    	String sentenciaJPQL;
    	
    	sentenciaJPQL="SELECT o FROM ResumenPedidosMensual o WHERE estado_pedido = 'OK'";
    	q=em.createQuery(sentenciaJPQL);
    	listado=q.getResultList();
    	return listado;    	
    }
}
