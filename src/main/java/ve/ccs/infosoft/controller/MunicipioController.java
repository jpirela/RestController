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

import ve.ccs.infosoft.model.Municipio;
import ve.ccs.infosoft.service.MunicipioService;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

	
	 @Autowired
	    private MunicipioService municipioService;

	    @PostMapping
	    public ResponseEntity<Municipio> create(@RequestBody Municipio municipio) {
	        Municipio savedMunicipio = municipioService.save(municipio);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedMunicipio);
	    }

	    @GetMapping
	    public ResponseEntity<List<Municipio>> getAll() {
	        List<Municipio> formasPago = municipioService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Municipio> getById(@PathVariable Integer id) {
	        return municipioService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Municipio> update(@PathVariable Integer id, @RequestBody Municipio municipio) {
	        if (!municipioService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        municipio.setIdMunicipio(id);
	        Municipio updatedMunicipio = municipioService.save(municipio);
	        return ResponseEntity.ok(updatedMunicipio);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!municipioService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        municipioService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Municipio>> saveAll(@RequestBody List<Municipio> municipios) {
	        List<Municipio> guardados = municipioService.saveAll(municipios);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Municipio>> getMunicipioesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Municipio> municipios = municipioService.findAll(pageable);
	            return ResponseEntity.ok(municipios);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
	
}
