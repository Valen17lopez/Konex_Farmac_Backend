package crud.demo.controller;

import crud.demo.model.Medicamento;
import crud.demo.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin(origins = "http://localhost:4200") // permite que tu frontend (Angular u otro) pueda consumir el API
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    // ✅ Consultar todos los medicamentos
    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.findAll();
    }

    // ✅ Consultar un medicamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
        return medicamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Crear un nuevo medicamento
    @PostMapping
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        try {
            Medicamento saved = medicamentoService.save(medicamento);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            e.printStackTrace(); // Esto te permite ver el error en la consola
            return ResponseEntity.status(500).build();
        }
    }

    // ✅ Actualizar medicamento existente
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamentoDetails) {
        return medicamentoService.findById(id)
                .map(medicamento -> {
                    medicamento.setNombre(medicamentoDetails.getNombre());
                    medicamento.setLaboratorio(medicamentoDetails.getLaboratorio());
                    medicamento.setFechaFabricacion(medicamentoDetails.getFechaFabricacion());
                    medicamento.setFechaVencimiento(medicamentoDetails.getFechaVencimiento());
                    medicamento.setCantidadStock(medicamentoDetails.getCantidadStock());
                    medicamento.setValorUnitario(medicamentoDetails.getValorUnitario());

                    Medicamento updated = medicamentoService.save(medicamento);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Eliminar medicamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        return medicamentoService.findById(id)
                .map(medicamento -> {
                    medicamentoService.delete(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
