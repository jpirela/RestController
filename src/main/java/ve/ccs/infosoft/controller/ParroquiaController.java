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

import ve.ccs.infosoft.model.Parroquia;
import ve.ccs.infosoft.service.ParroquiaService;


@RestController
@RequestMapping("/api/parroquias")
public class ParroquiaController {

	

	 @Autowired
	    private ParroquiaService parroquiaService;

	    @PostMapping
	    public ResponseEntity<Parroquia> create(@RequestBody Parroquia parroquia) {
	        Parroquia savedParroquia = parroquiaService.save(parroquia);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedParroquia);
	    }

	    @GetMapping
	    public ResponseEntity<List<Parroquia>> getAll() {
	        List<Parroquia> formasPago = parroquiaService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Parroquia> getById(@PathVariable Integer id) {
	        return parroquiaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Parroquia> update(@PathVariable Integer id, @RequestBody Parroquia parroquia) {
	        if (!parroquiaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        parroquia.setIdParroquia(id);
	        Parroquia updatedParroquia = parroquiaService.save(parroquia);
	        return ResponseEntity.ok(updatedParroquia);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!parroquiaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        parroquiaService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Parroquia>> saveAll(@RequestBody List<Parroquia> parroquias) {
	        List<Parroquia> guardados = parroquiaService.saveAll(parroquias);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Parroquia>> getParroquiaesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Parroquia> parroquias = parroquiaService.findAll(pageable);
	            return ResponseEntity.ok(parroquias);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
	
	
}
