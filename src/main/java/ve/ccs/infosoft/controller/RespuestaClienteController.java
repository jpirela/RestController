package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.RespuestaCliente;
import ve.ccs.infosoft.service.RespuestaClienteService;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaClienteController {

	
	 @Autowired
	RespuestaClienteService respuestaService;
	
	 
	 @PostMapping
	    public ResponseEntity<RespuestaCliente> crearRespuesta(@RequestBody RespuestaCliente respuesta) {
	        try {
	            RespuestaCliente nuevaRespuesta = respuestaService.guardarRespuesta(
	                    respuesta.getCliente().getIdCliente(),
	                    respuesta.getPregunta().getIdPregunta(),
	                    respuesta.getInstrumento().getIdInstrumento(),
	                    respuesta.getRespuesta());
	            
	            return new ResponseEntity<>(nuevaRespuesta, HttpStatus.CREATED);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 
	 @GetMapping
	    public ResponseEntity<List<RespuestaCliente>> obtenerTodasLasRespuestas() {
	        List<RespuestaCliente> respuestas = respuestaService.obtenerTodasLasRespuestas();
	        return new ResponseEntity<>(respuestas, HttpStatus.OK);
	    }
	 
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<RespuestaCliente> obtenerRespuestaPorId(@PathVariable Integer id) {
	        return respuestaService.obtenerRespuestaPorId(id)
	                .map(respuesta -> new ResponseEntity<>(respuesta, HttpStatus.OK))
	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	 
	 
	 
	 
//	  @GetMapping("/cliente/{clienteId}")
//	    public ResponseEntity<List<RespuestaCliente>> obtenerRespuestasPorCliente(@PathVariable Integer clienteId) {
//	        List<RespuestaCliente> respuestas = respuestaService.obtenerRespuestasPorCliente(clienteId);
//	        return new ResponseEntity<>(respuestas, HttpStatus.OK);
//	    }

	    // READ - Obtener respuestas por instrumento
//	    @GetMapping("/instrumento/{instrumentoId}")
//	    public ResponseEntity<List<RespuestaCliente>> obtenerRespuestasPorInstrumento(@PathVariable Integer instrumentoId) {
//	        List<RespuestaCliente> respuestas = respuestaService.obtenerRespuestasPorInstrumento(instrumentoId);
//	        return new ResponseEntity<>(respuestas, HttpStatus.OK);
//	    }

	    // UPDATE - Actualizar una respuesta
	    @PutMapping("/{id}")
	    public ResponseEntity<RespuestaCliente> actualizarRespuesta(
	            @PathVariable Integer id, @RequestBody RespuestaCliente respuesta) {
	        try {
	            // Primero actualizamos el texto de la respuesta
	            RespuestaCliente respuestaActualizada = respuestaService.actualizarRespuesta(
	                    id, respuesta.getRespuesta());
	            
	            return new ResponseEntity<>(respuestaActualizada, HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
	    }

	    // DELETE - Eliminar una respuesta
	    @DeleteMapping("/{id}")
	    public ResponseEntity<HttpStatus> eliminarRespuesta(@PathVariable Integer id) {
	        try {
	            respuestaService.eliminarRespuesta(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<RespuestaCliente>> insertarProveedores(@RequestBody List<RespuestaCliente> respuestaCliente) {
	        List<RespuestaCliente> guardados = respuestaService.guardarTodos(respuestaCliente);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    
	    

	    // Método adicional: Verificar si existe una respuesta
//	    @GetMapping("/existe")
//	    public ResponseEntity<Boolean> existeRespuesta(
//	            @RequestParam Long clienteId,
//	            @RequestParam Long preguntaId,
//	            @RequestParam Long instrumentoId) {
//	        boolean existe = respuestaService.existeRespuesta(clienteId, preguntaId, instrumentoId);
//	        return new ResponseEntity<>(existe, HttpStatus.OK);
//	    }
	
}
