package crud.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEDICAMENTOS")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Oracle generará automáticamente el ID
    @Column(name = "ID_MEDICAMENTO")
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "LABORATORIO", nullable = false)
    private String laboratorio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_FABRICACION", nullable = false)
    private LocalDate fechaFabricacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "CANTIDAD_STOCK", nullable = false)
    private Integer cantidadStock;

    @Column(name = "VALOR_UNITARIO", nullable = false)
    private Double valorUnitario;

    // Constructor vacío
    public Medicamento() {}

    // Constructor con parámetros (opcional)
    public Medicamento(String nombre, String laboratorio, LocalDate fechaFabricacion, LocalDate fechaVencimiento, Integer cantidadStock, Double valorUnitario) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidadStock = cantidadStock;
        this.valorUnitario = valorUnitario;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getLaboratorio() { return laboratorio; }
    public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }

    public LocalDate getFechaFabricacion() { return fechaFabricacion; }
    public void setFechaFabricacion(LocalDate fechaFabricacion) { this.fechaFabricacion = fechaFabricacion; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public Integer getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(Integer cantidadStock) { this.cantidadStock = cantidadStock; }

    public Double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Double valorUnitario) { this.valorUnitario = valorUnitario; }
}
