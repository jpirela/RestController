package ve.ccs.infosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ve.ccs.infosoft.model.CondicionPago;
import ve.ccs.infosoft.service.CondicionPagoService;

import java.util.List;

@RestController
@RequestMapping("/api/condiciones-pago")
public class CondicionPagoController {

    @Autowired
    private CondicionPagoService condicionPagoService;

    @GetMapping
    public ResponseEntity<List<CondicionPago>> getAllCondicionesPago() {
        return ResponseEntity.ok(condicionPagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionPago> getCondicionPagoById(@PathVariable Integer id) {
        CondicionPago condicion = condicionPagoService.findById(id);
        return condicion != null ? ResponseEntity.ok(condicion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CondicionPago> createCondicionPago(@RequestBody CondicionPago condicionPago) {
        return ResponseEntity.ok(condicionPagoService.save(condicionPago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicionPago> updateCondicionPago(
            @PathVariable Integer id, 
            @RequestBody CondicionPago condicionPago) {
        if (condicionPagoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        condicionPago.setIdCondicionPago(id);
        return ResponseEntity.ok(condicionPagoService.save(condicionPago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCondicionPago(@PathVariable Integer id) {
        if (condicionPagoService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        condicionPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}