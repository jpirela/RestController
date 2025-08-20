package ve.ccs.infosoft.controller;

import ve.ccs.infosoft.model.RedSocial;
import ve.ccs.infosoft.service.RedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redes-sociales")
public class RedSocialController {

    @Autowired
    private RedSocialService redSocialService;

    @GetMapping
    public ResponseEntity<List<RedSocial>> getAllRedesSociales() {
        return ResponseEntity.ok(redSocialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedSocial> getRedSocialById(@PathVariable Integer id) {
        return redSocialService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RedSocial> createRedSocial(@RequestBody RedSocial redSocial) {
        return ResponseEntity.ok(redSocialService.save(redSocial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RedSocial> updateRedSocial(@PathVariable Integer id, @RequestBody RedSocial redSocial) {
        if (!redSocialService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        redSocial.setIdRedSocial(id);
        return ResponseEntity.ok(redSocialService.save(redSocial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRedSocial(@PathVariable Integer id) {
        if (!redSocialService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        redSocialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}