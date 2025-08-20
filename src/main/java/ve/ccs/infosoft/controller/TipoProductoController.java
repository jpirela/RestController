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

import ve.ccs.infosoft.model.TipoProducto;
import ve.ccs.infosoft.service.TipoProductoService;



@RestController
@RequestMapping("/api/tipo-productos")
public class TipoProductoController {

	

	 @Autowired
	    private TipoProductoService tipoProductoService;

	    @PostMapping
	    public ResponseEntity<TipoProducto> create(@RequestBody TipoProducto tipoProducto) {
	        TipoProducto savedTipoProducto = tipoProductoService.save(tipoProducto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoProducto);
	    }

	    @GetMapping
	    public ResponseEntity<List<TipoProducto>> getAll() {
	        List<TipoProducto> formasPago = tipoProductoService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TipoProducto> getById(@PathVariable Integer id) {
	        return tipoProductoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<TipoProducto> update(@PathVariable Integer id, @RequestBody TipoProducto tipoProducto) {
	        if (!tipoProductoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        tipoProducto.setIdTipoProducto(id);
	        TipoProducto updatedTipoProducto = tipoProductoService.save(tipoProducto);
	        return ResponseEntity.ok(updatedTipoProducto);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!tipoProductoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        tipoProductoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<TipoProducto>> saveAll(@RequestBody List<TipoProducto> tipoProductos) {
	        List<TipoProducto> guardados = tipoProductoService.saveAll(tipoProductos);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<TipoProducto>> getTipoProductoesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<TipoProducto> tipoProductos = tipoProductoService.findAll(pageable);
	            return ResponseEntity.ok(tipoProductos);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	
}
