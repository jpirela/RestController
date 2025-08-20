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

import ve.ccs.infosoft.model.Pregunta;
import ve.ccs.infosoft.service.PreguntaService;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

	@Autowired
	private PreguntaService preguntaService;

	@PostMapping
	public ResponseEntity<Pregunta> create(@RequestBody Pregunta pregunta) {
		Pregunta savedPregunta = preguntaService.save(pregunta);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPregunta);
	}

	@GetMapping
	public ResponseEntity<List<Pregunta>> getAll() {
		List<Pregunta> formasPago = preguntaService.findAll();
		return ResponseEntity.ok(formasPago);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pregunta> getById(@PathVariable Integer id) {
		return preguntaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pregunta> update(@PathVariable Integer id, @RequestBody Pregunta pregunta) {
		if (!preguntaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		pregunta.setIdPregunta(id);
		Pregunta updatedPregunta = preguntaService.save(pregunta);
		return ResponseEntity.ok(updatedPregunta);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (!preguntaService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		preguntaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/lote")
	public ResponseEntity<List<Pregunta>> saveAll(@RequestBody List<Pregunta> preguntas) {
		List<Pregunta> guardados = preguntaService.saveAll(preguntas);
		return ResponseEntity.ok(guardados);
	}

	@GetMapping("/paginado")
	public ResponseEntity<Page<Pregunta>> getPreguntaesPaginados(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {
			PageRequest pageable = PageRequest.of(page, size);
			Page<Pregunta> preguntas = preguntaService.findAll(pageable);
			return ResponseEntity.ok(preguntas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
