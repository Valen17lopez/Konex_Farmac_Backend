package crud.demo.service;

import crud.demo.model.Medicamento;
import crud.demo.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional // Asegura que las operaciones de escritura se confirmen en la BD
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    // Consultar todos los medicamentos
    public List<Medicamento> findAll() {
        return medicamentoRepository.findAll();
    }

    // Consultar un medicamento por ID
    public Optional<Medicamento> findById(Long id) {
        return medicamentoRepository.findById(id);
    }

    // Guardar o actualizar un medicamento
    public Medicamento save(Medicamento medicamento) {
        try {
            return medicamentoRepository.save(medicamento);
        } catch (Exception e) {
            e.printStackTrace(); // Permite ver errores de persistencia en consola
            throw e; // Re-lanzar la excepción para que el controller pueda manejarla
        }
    }

    // Eliminar un medicamento por ID
    public void delete(Long id) {
        try {
            medicamentoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace(); // Permite ver errores de eliminación en consola
            throw e;
        }
    }
}
