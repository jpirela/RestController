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

import ve.ccs.infosoft.DTO.CiudadDTO;
import ve.ccs.infosoft.model.Ciudad;
import ve.ccs.infosoft.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;

	@PostMapping
	public ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad) {
		Ciudad savedCiudad = ciudadService.save(ciudad);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCiudad);
	}

//	@GetMapping
//	public ResponseEntity<List<Ciudad>> getAll() {
//		List<Ciudad> formasPago = ciudadService.findAll();
//		return ResponseEntity.ok(formasPago);
//	}
	
	
	
	  @GetMapping
	    public List<CiudadDTO> getAllCiudadesWithEstadoId() {
	        return ciudadService.findAllWithEstadoId();
	    }
	
	  @GetMapping("/estado/{idEstado}")
	    public List<CiudadDTO> getCiudadesByEstadoId(@PathVariable Integer idEstado) {
	        return ciudadService.findByEstadoId(idEstado);
	    }
	  
	  

	@GetMapping("/{id}")
	public ResponseEntity<Ciudad> getById(@PathVariable Integer id) {
		return ciudadService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ciudad> update(@PathVariable Integer id, @RequestBody Ciudad ciudad) {
		if (!ciudadService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		ciudad.setIdCiudad(id);
		Ciudad updatedCiudad = ciudadService.save(ciudad);
		return ResponseEntity.ok(updatedCiudad);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (!ciudadService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		ciudadService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/lote")
	public ResponseEntity<List<Ciudad>> saveAll(@RequestBody List<Ciudad> ciudads) {
		List<Ciudad> guardados = ciudadService.saveAll(ciudads);
		return ResponseEntity.ok(guardados);
	}

	@GetMapping("/paginado")
	public ResponseEntity<Page<Ciudad>> getCiudadesPaginados(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		try {
			PageRequest pageable = PageRequest.of(page, size);
			Page<Ciudad> ciudads = ciudadService.findAll(pageable);
			return ResponseEntity.ok(ciudads);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
