package crud.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VENTAS")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENTA")
    private Long idVenta;

    @Column(name = "ID_MEDICAMENTO")
    private Long idMedicamento;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora = new Date();

    // Getters y Setters
    public Long getIdVenta() { return idVenta; }
    public void setIdVenta(Long idVenta) { this.idVenta = idVenta; }

    public Long getIdMedicamento() { return idMedicamento; }
    public void setIdMedicamento(Long idMedicamento) { this.idMedicamento = idMedicamento; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Double valorUnitario) { this.valorUnitario = valorUnitario; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }
}
