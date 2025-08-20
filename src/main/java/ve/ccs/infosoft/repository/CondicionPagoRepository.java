package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ve.ccs.infosoft.model.CondicionPago;

@Repository
public interface CondicionPagoRepository extends JpaRepository<CondicionPago, Integer> {
    
    // Método para buscar por descripción (opcional, ya que es unique)
    //CondicionPago findByDescripcion(String descripcion);
    
    // Método para verificar existencia por descripción (opcional)
   // boolean existsByDescripcion(String descripcion);
}