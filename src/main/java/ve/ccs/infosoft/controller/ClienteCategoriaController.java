package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.ClienteCategoria;
import ve.ccs.infosoft.service.ClienteCategoriaService;



@RestController
@RequestMapping("/api/clientes-categorias")
public class ClienteCategoriaController {

	
	
	@Autowired
	ClienteCategoriaService clienteCategoriaService;

	@PostMapping
	public ResponseEntity<ClienteCategoria> create(@RequestBody ClienteCategoria clienteCategoria) {
		return ResponseEntity.ok(clienteCategoriaService.save(clienteCategoria));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteCategoria> update(@PathVariable Integer id,
			@RequestBody ClienteCategoria clienteCategoria) {
		clienteCategoria.setId(id);
		return ResponseEntity.ok(clienteCategoriaService.update(clienteCategoria));
	}

	@GetMapping
	public ResponseEntity<List<ClienteCategoria>> getAll() {
		return ResponseEntity.ok(clienteCategoriaService.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clienteCategoriaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
