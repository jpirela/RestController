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

import ve.ccs.infosoft.model.Estado;
import ve.ccs.infosoft.service.EstadoService;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

	
	
	 @Autowired
	    private EstadoService estadoService;

	    @PostMapping
	    public ResponseEntity<Estado> create(@RequestBody Estado estado) {
	        Estado savedEstado = estadoService.save(estado);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedEstado);
	    }

	    @GetMapping
	    public ResponseEntity<List<Estado>> getAll() {
	        List<Estado> formasPago = estadoService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Estado> getById(@PathVariable Integer id) {
	        return estadoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Estado> update(@PathVariable Integer id, @RequestBody Estado estado) {
	        if (!estadoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        estado.setIdEstado(id);
	        Estado updatedEstado = estadoService.save(estado);
	        return ResponseEntity.ok(updatedEstado);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!estadoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        estadoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Estado>> saveAll(@RequestBody List<Estado> estados) {
	        List<Estado> guardados = estadoService.saveAll(estados);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Estado>> getEstadoesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Estado> estados = estadoService.findAll(pageable);
	            return ResponseEntity.ok(estados);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	   
	    

	
}
