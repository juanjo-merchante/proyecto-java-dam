// Archivo: Venta.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Cliente cliente;
    private List<Pajaro> lineasDeVenta;
    private LocalDate fecha;
    private double total;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now(); // Asigna la fecha actual
        this.lineasDeVenta = new ArrayList<>();
        this.total = 0;
    }

    public void agregarPajaro(Pajaro pajaro) {
        // Creamos una copia para la venta, para no referenciar el objeto del catálogo
        Pajaro pajaroVendido = new Pajaro(pajaro.getEspecie(), pajaro.getColor(), pajaro.getPrecio(), 1);
        this.lineasDeVenta.add(pajaroVendido);
        calcularTotal();
    }

    public void calcularTotal() {
        this.total = 0;
        for (Pajaro p : lineasDeVenta) {
            this.total += p.getPrecio();
        }
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append("====================================================\n");
        sb.append("Venta - Fecha: ").append(fecha.format(formatter)).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append(" (DNI: ").append(cliente.getDni()).append(")\n");
        sb.append("----------------------------------------------------\n");
        sb.append("Pájaros comprados:\n");
        for (Pajaro p : lineasDeVenta) {
            sb.append(" - ").append(p.getEspecie()).append(" (").append(p.getColor()).append(") - ")
              .append(String.format("%.2f", p.getPrecio())).append("€\n");
        }
        sb.append("----------------------------------------------------\n");
        sb.append("IMPORTE TOTAL: ").append(String.format("%.2f", total)).append("€\n");
        sb.append("====================================================\n");
        return sb.toString();
    }
}