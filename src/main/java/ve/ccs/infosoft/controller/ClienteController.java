package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.Cliente;
import ve.ccs.infosoft.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	
	 @Autowired
	    private ClienteService clienteService;

	    @PostMapping
	    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
	        Cliente savedCliente = clienteService.save(cliente);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
	    }

	    @GetMapping
	    public ResponseEntity<List<Cliente>> getAll() {
	        List<Cliente> formasPago = clienteService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
	        return clienteService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
	        if (!clienteService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        cliente.setIdCliente(id);
	        Cliente updatedCliente = clienteService.save(cliente);
	        return ResponseEntity.ok(updatedCliente);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!clienteService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        clienteService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Cliente>> saveAll(@RequestBody List<Cliente> clientes) {
	        List<Cliente> guardados = clienteService.saveAll(clientes);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Cliente>> getClienteesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Cliente> clientes = clienteService.findAll(pageable);
	            return ResponseEntity.ok(clientes);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	   
	    
}
