package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.ClienteFormaPago;
import ve.ccs.infosoft.service.ClienteFormaPagoService;

@RestController
@RequestMapping("/api/clientes-formas-pago")
public class ClienteFormaPagoController {

	@Autowired
	ClienteFormaPagoService clienteFormaPagoService;
	
	
	 @PostMapping
	    public ResponseEntity<ClienteFormaPago> create(@RequestBody ClienteFormaPago clienteFormaPago) {
	        ClienteFormaPago nuevaRelacion = clienteFormaPagoService.save(clienteFormaPago);
	        return new ResponseEntity<>(nuevaRelacion, HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ClienteFormaPago> getById(@PathVariable Integer id) {
	        return clienteFormaPagoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @GetMapping
	    public List<ClienteFormaPago> getAll() {
	        return clienteFormaPagoService.findAll();
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ClienteFormaPago> update(
	            @PathVariable Integer id, 
	            @RequestBody ClienteFormaPago clienteFormaPago) {
	        if (!clienteFormaPagoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        clienteFormaPago.setId(id);
	        ClienteFormaPago actualizada = clienteFormaPagoService.save(clienteFormaPago);
	        return ResponseEntity.ok(actualizada);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!clienteFormaPagoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        clienteFormaPagoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

}
