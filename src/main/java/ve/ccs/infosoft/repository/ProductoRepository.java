package ve.ccs.infosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ve.ccs.infosoft.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	 @Query("SELECT p FROM Producto p LEFT JOIN FETCH p.categorias WHERE p.id = :id")
	    Optional<Producto> findByIdWithCategorias(@Param("id") Integer id);
	
}
