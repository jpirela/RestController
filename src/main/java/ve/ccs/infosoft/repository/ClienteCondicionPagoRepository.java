package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.ClienteCondicionPago;

@Repository
public interface ClienteCondicionPagoRepository extends JpaRepository<ClienteCondicionPago, Integer> {

}
