package ve.ccs.infosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ve.ccs.infosoft.model.CondicionPago;
import ve.ccs.infosoft.repository.CondicionPagoRepository;

import java.util.List;

@Service
public class CondicionPagoService {

    @Autowired
    private CondicionPagoRepository condicionPagoRepository;

    public List<CondicionPago> findAll() {
        return condicionPagoRepository.findAll();
    }

    public CondicionPago findById(Integer id) {
        return condicionPagoRepository.findById(id).orElse(null);
    }

    public CondicionPago save(CondicionPago condicionPago) {
        return condicionPagoRepository.save(condicionPago);
    }

    public void deleteById(Integer id) {
        condicionPagoRepository.deleteById(id);
    }
}