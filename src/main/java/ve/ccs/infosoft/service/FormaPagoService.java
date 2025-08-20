package ve.ccs.infosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ve.ccs.infosoft.model.FormaPago;
import ve.ccs.infosoft.repository.FormaPagoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormaPagoService {

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    public FormaPago save(FormaPago formaPago) {
        return formaPagoRepository.save(formaPago);
    }

    public List<FormaPago> findAll() {
        return formaPagoRepository.findAll();
    }

    public Optional<FormaPago> findById(Integer id) {
        return formaPagoRepository.findById(id);
    }

    public void deleteById(Integer id) {
        formaPagoRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return formaPagoRepository.existsById(id);
    }
}