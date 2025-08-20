package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.RedSocial;


@Repository
public interface RedSocialRepository extends JpaRepository<RedSocial, Integer> {
   
}