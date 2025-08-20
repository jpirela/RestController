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

import ve.ccs.infosoft.model.Categoria;
import ve.ccs.infosoft.service.CategoriaService;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	
	
	 @Autowired
	    private CategoriaService categoriaService;

	    @PostMapping
	    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
	        Categoria savedCategoria = categoriaService.save(categoria);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
	    }

	    @GetMapping
	    public ResponseEntity<List<Categoria>> getAll() {
	        List<Categoria> formasPago = categoriaService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
	        return categoriaService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
	        if (!categoriaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        categoria.setIdCategoria(id);
	        Categoria updatedCategoria = categoriaService.save(categoria);
	        return ResponseEntity.ok(updatedCategoria);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!categoriaService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        categoriaService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Categoria>> saveAll(@RequestBody List<Categoria> categorias) {
	        List<Categoria> guardados = categoriaService.saveAll(categorias);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Categoria>> getCategoriaesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Categoria> categorias = categoriaService.findAll(pageable);
	            return ResponseEntity.ok(categorias);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
}
