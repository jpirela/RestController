package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.ClienteCondicionPago;
import ve.ccs.infosoft.service.ClienteCondicionPagoService;

@RestController
@RequestMapping("/api/clientes-condicion-pago")
public class ClienteCondicionPagoController {

	@Autowired
	ClienteCondicionPagoService clienteCondicionPagoService;

	@PostMapping
	public ResponseEntity<ClienteCondicionPago> create(@RequestBody ClienteCondicionPago clienteCondicionPago) {
		ClienteCondicionPago saved = clienteCondicionPagoService.save(clienteCondicionPago);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ClienteCondicionPago>> getAll() {
		List<ClienteCondicionPago> relaciones = clienteCondicionPagoService.findAll();
		return new ResponseEntity<>(relaciones, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteCondicionPago> getById(@PathVariable Integer id) {
		return clienteCondicionPagoService.findById(id).map(relacion -> new ResponseEntity<>(relacion, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		clienteCondicionPagoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
