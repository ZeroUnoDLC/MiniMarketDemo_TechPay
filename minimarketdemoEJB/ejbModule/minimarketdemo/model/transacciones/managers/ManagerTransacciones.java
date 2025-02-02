package minimarketdemo.model.transacciones.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.Transaccion;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerTransacciones
 */
@Stateless
@LocalBean
public class ManagerTransacciones {
	@EJB
	private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerTransacciones() {
        // TODO Auto-generated constructor stub
    }
    
    // Listar todas las transacciones
    @SuppressWarnings("unchecked")
	public List<Transaccion> findAllTransaccion(){
    	return mDAO.findAll(Transaccion.class);
    }
    
    // Método para buscar una transacción por ID
    public Transaccion findTransaccionById(Integer idTransaccion) throws Exception {
        return (Transaccion) mDAO.findById(Transaccion.class, idTransaccion);
    }
    
    // Método para insertar una transacción
    public Transaccion insertarTransaccion(Transaccion nuevaTransaccion) throws Exception {
        try {
            mDAO.insertar(nuevaTransaccion);
            return nuevaTransaccion;
        } catch (Exception e) {
            throw new Exception("Error al insertar transacción: " + e.getMessage());
        }
    }
    
    // Método para actualizar una transaccion 
    public Transaccion actualizarTransaccion(Transaccion transaccionActualizada) throws Exception {
        try {
            mDAO.actualizar(transaccionActualizada);
            return transaccionActualizada;
        } catch (Exception e) {
            throw new Exception("Error al actualizar la transaccion: " + e.getMessage());
        }
    }
    
    // Método para eliminar una transacción por ID
    public void eliminarTransaccion(Integer idTransaccion) throws Exception {
        try {
            Transaccion transaccion = findTransaccionById(idTransaccion);
            if (transaccion != null) {
                mDAO.eliminar(Transaccion.class, idTransaccion);
            } else {
                throw new Exception("No existe esta transacción");
            }
        } catch (Exception e) {
            throw new Exception("" + e.getMessage());
        }
    }

}
