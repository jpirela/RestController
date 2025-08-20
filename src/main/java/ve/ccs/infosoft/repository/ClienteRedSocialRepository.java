package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.ClienteRedSocial;

@Repository
public interface ClienteRedSocialRepository extends JpaRepository<ClienteRedSocial, Integer> {

}
