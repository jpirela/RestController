package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	
	
	 // Buscar categoría por nombre exacto
    Categoria findByNombre(String nombre);
    
    // Buscar categorías que contengan en el nombre (case insensitive)
    //List<Categoria> findByNombreContainingIgnoreCase(String nombre);
    
    // Verificar si existe una categoría con un nombre específico
    //boolean existsByNombre(String nombre);
}
