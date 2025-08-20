package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ve.ccs.infosoft.model.ClienteFormaPago;
import ve.ccs.infosoft.repository.ClienteFormaPagoRepository;
import ve.ccs.infosoft.repository.ClienteRepository;
import ve.ccs.infosoft.repository.FormaPagoRepository;

@Service
@Transactional
public class ClienteFormaPagoService {

	@Autowired
	ClienteFormaPagoRepository clienteFormaPagoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FormaPagoRepository formaPagoRepository;
	
	public ClienteFormaPago save(ClienteFormaPago clienteFormaPago) {
        return clienteFormaPagoRepository.save(clienteFormaPago);
    }

    public Optional<ClienteFormaPago> findById(Integer id) {
        return clienteFormaPagoRepository.findById(id);
    }

    public List<ClienteFormaPago> findAll() {
        return clienteFormaPagoRepository.findAll();
    }

    public void deleteById(Integer id) {
        clienteFormaPagoRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return clienteFormaPagoRepository.existsById(id);
    }

}
