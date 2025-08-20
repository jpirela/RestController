package ve.ccs.infosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ve.ccs.infosoft.model.FormaPago;
import ve.ccs.infosoft.service.FormaPagoService;

import java.util.List;

@RestController
@RequestMapping("/api/formas-pago")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    @PostMapping
    public ResponseEntity<FormaPago> create(@RequestBody FormaPago formaPago) {
        FormaPago savedFormaPago = formaPagoService.save(formaPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFormaPago);
    }

    @GetMapping
    public ResponseEntity<List<FormaPago>> getAll() {
        List<FormaPago> formasPago = formaPagoService.findAll();
        return ResponseEntity.ok(formasPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPago> getById(@PathVariable Integer id) {
        return formaPagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPago> update(@PathVariable Integer id, @RequestBody FormaPago formaPago) {
        if (!formaPagoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        formaPago.setIdFormaPago(id);
        FormaPago updatedFormaPago = formaPagoService.save(formaPago);
        return ResponseEntity.ok(updatedFormaPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!formaPagoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        formaPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}