package minimarketdemo.model.musica.managers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import minimarketdemo.model.core.entities.InstrumentoMusical;
import minimarketdemo.model.core.entities.TipoInstrumento;
import minimarketdemo.model.core.managers.ManagerDAO;

import java.util.List;

import javax.ejb.EJB;

/**
 * Session Bean implementation class ManagerMusica
 */
@Stateless
@LocalBean
public class ManagerMusica {
	@EJB
	private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerMusica() {
        // TODO Auto-generated constructor stub
    }
    
    //TIPOS INSTRUMENTOS MUSICALES
    @SuppressWarnings("unchecked")
	public List<TipoInstrumento> findAllTipoInstrumento(){
    	return mDAO.findAll(TipoInstrumento.class);
    }
    
    public TipoInstrumento insertarTipoInstrumento(TipoInstrumento nuevoTipoInstrumento) throws Exception {
        try {
            mDAO.insertar(nuevoTipoInstrumento);
            return nuevoTipoInstrumento;
        } catch (Exception e) {
            throw new Exception("Error al insertar el tipo de instrumento: " + e.getMessage());
        }
    }
    
 // Método para actualizar un tipo de instrumento existente
    public TipoInstrumento actualizarTipoInstrumento(TipoInstrumento tipoInstrumentoActualizado) throws Exception {
        try {
            mDAO.actualizar(tipoInstrumentoActualizado);
            return tipoInstrumentoActualizado;
        } catch (Exception e) {
            throw new Exception("Error al actualizar el tipo de instrumento: " + e.getMessage());
        }
    }

    // Método para buscar un tipo de instrumento por ID
    public TipoInstrumento findTipoInstrumentoById(Integer id) throws Exception {
        return (TipoInstrumento) mDAO.findById(TipoInstrumento.class, id);
    }

    // Método para eliminar un tipo de instrumento por ID
    public void eliminarTipoInstrumento(Integer id) throws Exception {
        try {
            TipoInstrumento tipoInstrumento = findTipoInstrumentoById(id);
            if (tipoInstrumento != null) {
                mDAO.eliminar(TipoInstrumento.class, id);
            } else {
                throw new Exception("La categoría aún contiene instrumentos");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el tipo de instrumento: " + e.getMessage());
        }
    }
    
    //INTRUMENTOS MUSICALES
    
    // Método para encontrar todos los instrumentos musicales
    @SuppressWarnings("unchecked")
	public List<InstrumentoMusical> findAllInstrumentoMusical() {
    	return mDAO.findAll(InstrumentoMusical.class);
    }
    
    // Método para insertar un nuevo instrumento musical
    public InstrumentoMusical insertarInstrumentoMusical(InstrumentoMusical nuevoInstrumento, int idTipoInstrumento) throws Exception {
        try {
            nuevoInstrumento.setTipoInstrumento(findTipoInstrumentoById(idTipoInstrumento));
            mDAO.insertar(nuevoInstrumento);
            return nuevoInstrumento;
        } catch (Exception e) {
            throw new Exception("Error al insertar el instrumento musical: " + e.getMessage());
        }
    }

    
 // Método para actualizar un instrumento musical existente
    public InstrumentoMusical actualizarInstrumentoMusical(InstrumentoMusical instrumentoActualizado) throws Exception {
        try {
            mDAO.actualizar(instrumentoActualizado);
            return instrumentoActualizado;
        } catch (Exception e) {
            throw new Exception("Error al actualizar el instrumento musical: " + e.getMessage());
        }
    }

    // Método para buscar un instrumento musical por ID
    public InstrumentoMusical findInstrumentoMusicalById(Integer id) throws Exception {
        return (InstrumentoMusical) mDAO.findById(InstrumentoMusical.class, id);
    }

    // Método para eliminar un instrumento musical por ID
    public void eliminarInstrumentoMusical(Integer id) throws Exception {
        try {
            InstrumentoMusical instrumento = findInstrumentoMusicalById(id);
            if (instrumento != null) {
                mDAO.eliminar(InstrumentoMusical.class, id);
            } else {
                throw new Exception("Instrumento musical no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar el instrumento musical: " + e.getMessage());
        }
    }

    // Método para buscar instrumentos musicales por tipo de instrumento
    public List<InstrumentoMusical> findInstrumentosByTipoInstrumento(Integer tipoInstrumentoId) throws Exception {
        try {
            TypedQuery<InstrumentoMusical> query = mDAO.getEntityManager()
                .createQuery("SELECT i FROM InstrumentoMusical i WHERE i.tipoInstrumento.id = :tipoId", InstrumentoMusical.class);
            query.setParameter("tipoId", tipoInstrumentoId);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Error al buscar instrumentos por tipo de instrumento: " + e.getMessage());
        }
    }
}
