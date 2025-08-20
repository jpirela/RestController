package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ve.ccs.infosoft.model.ClienteCondicionPago;
import ve.ccs.infosoft.repository.ClienteCondicionPagoRepository;

@Service
@Transactional
public class ClienteCondicionPagoService {

	
	 @Autowired
	 ClienteCondicionPagoRepository clienteCondicionPagoRepository;
	 
	 
	    public ClienteCondicionPago save(ClienteCondicionPago clienteCondicionPago) {
	        return clienteCondicionPagoRepository.save(clienteCondicionPago);
	    }

	   
	    public List<ClienteCondicionPago> findAll() {
	        return clienteCondicionPagoRepository.findAll();
	    }

	    
	    public Optional<ClienteCondicionPago> findById(Integer id) {
	        return clienteCondicionPagoRepository.findById(id);
	    }

	   
	    public void deleteById(Integer id) {
	        clienteCondicionPagoRepository.deleteById(id);
	    }
}
