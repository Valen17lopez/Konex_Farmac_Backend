package crud.demo.service;

import crud.demo.model.Venta;
import crud.demo.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public Venta guardarVenta(Venta venta) {
        venta.setValorTotal(venta.getCantidad() * venta.getValorUnitario());
        return ventaRepository.save(venta);
    }

    public List<Venta> obtenerTodasVentas() {
        return ventaRepository.findAll();
    }
}
