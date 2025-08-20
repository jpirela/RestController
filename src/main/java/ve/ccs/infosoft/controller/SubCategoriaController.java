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

import ve.ccs.infosoft.model.SubCategoria;
import ve.ccs.infosoft.service.SubCategoriaService;


@RestController
@RequestMapping("/api/sub-categorias")
public class SubCategoriaController {

	
	
	 @Autowired
	    private SubCategoriaService subCategoriaService;

	    @PostMapping
	    public ResponseEntity<SubCategoria> create(@RequestBody SubCategoria subCategoria) {
	        SubCategoria savedSubCategoria = subCategoriaService.save(subCategoria);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubCategoria);
	    }

	    @GetMapping
	    public ResponseEntity<List<SubCategoria>> getAll() {
	        List<SubCategoria> formasPago = subCategoriaService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<SubCategoria> getById(@PathVariable Integer id) {
	        return subCategoriaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<SubCategoria> update(@PathVariable Integer id, @RequestBody SubCategoria subCategoria) {
	        if (!subCategoriaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        subCategoria.setIdSubcategoria(id);
	        SubCategoria updatedSubCategoria = subCategoriaService.save(subCategoria);
	        return ResponseEntity.ok(updatedSubCategoria);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!subCategoriaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        subCategoriaService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<SubCategoria>> saveAll(@RequestBody List<SubCategoria> subCategorias) {
	        List<SubCategoria> guardados = subCategoriaService.saveAll(subCategorias);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<SubCategoria>> getSubCategoriaesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<SubCategoria> subCategorias = subCategoriaService.findAll(pageable);
	            return ResponseEntity.ok(subCategorias);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
}
