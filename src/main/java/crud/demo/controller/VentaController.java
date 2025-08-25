package crud.demo.controller;

import crud.demo.model.Venta;
import crud.demo.service.VentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @GetMapping
    public List<Venta> listarVentas() {
        return ventaService.obtenerTodasVentas();
    }
}
