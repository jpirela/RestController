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

import ve.ccs.infosoft.model.ClienteRedSocial;
import ve.ccs.infosoft.service.ClienteRedSocialService;

@RestController
@RequestMapping("/api/clientes-redes-sociales")
public class ClienteRedSocialController {

	@Autowired
	ClienteRedSocialService clienteRedSocialService;

	@PostMapping
	public ResponseEntity<ClienteRedSocial> create(@RequestBody ClienteRedSocial clienteRedSocial) {
		return ResponseEntity.ok(clienteRedSocialService.save(clienteRedSocial));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteRedSocial> update(@PathVariable Integer id,
			@RequestBody ClienteRedSocial clienteRedSocial) {
		clienteRedSocial.setId(id);
		return ResponseEntity.ok(clienteRedSocialService.update(clienteRedSocial));
	}

	@GetMapping
	public ResponseEntity<List<ClienteRedSocial>> getAll() {
		return ResponseEntity.ok(clienteRedSocialService.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clienteRedSocialService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
