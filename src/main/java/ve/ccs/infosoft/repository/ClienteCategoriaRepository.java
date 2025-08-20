package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.ClienteCategoria;

@Repository
public interface ClienteCategoriaRepository extends JpaRepository<ClienteCategoria, Integer> {

}
