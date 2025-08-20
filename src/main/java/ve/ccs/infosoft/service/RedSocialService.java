package ve.ccs.infosoft.service;

import ve.ccs.infosoft.model.RedSocial;
import ve.ccs.infosoft.repository.RedSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedSocialService {

    @Autowired
    private RedSocialRepository redSocialRepository;

    public List<RedSocial> findAll() {
        return redSocialRepository.findAll();
    }

    public Optional<RedSocial> findById(Integer id) {
        return redSocialRepository.findById(id);
    }

    public RedSocial save(RedSocial redSocial) {
        return redSocialRepository.save(redSocial);
    }

    public void deleteById(Integer id) {
        redSocialRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return redSocialRepository.existsById(id);
    }
}