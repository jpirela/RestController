package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.ClienteFormaPago;

@Repository
public interface ClienteFormaPagoRepository extends JpaRepository<ClienteFormaPago, Integer> {

}
