// Archivo: Venta.java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una transacción de venta en la pajarería.
 * Almacena información sobre el cliente, el producto vendido y la fecha.
 * 
 * @author Juanjo Merchante
 * @version 1.0
 */
public class Venta {
    private Cliente cliente;
    private List<Pajaro> lineasDeVenta;
    private LocalDate fecha;
    private double total;

/**
 * Constructor para iniciar una nueva Venta.
 * Asigna el cliente y establece la fecha actual de la venta.
 * 
 * @param cliente El objeto Cliente que realiza la compra.
 */
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now(); // Asigna la fecha actual
        this.lineasDeVenta = new ArrayList<>();
        this.total = 0;
    }

/**
 * Añade un pájaro a la lista de artículos de esta venta.
 * Crea una copia del pájaro para asegurar que la venta refleje el estado
 * del producto en el momento de la compra. Recalcula el total.
 * 
 * @param pajaro El pájaro a añadir a la venta.
 */
    public void agregarPajaro(Pajaro pajaro) {
        // Creamos una copia para la venta, para no referenciar el objeto del catálogo
        Pajaro pajaroVendido = new Pajaro(pajaro.getEspecie(), pajaro.getColor(), pajaro.getPrecio(), 1);
        this.lineasDeVenta.add(pajaroVendido);
        calcularTotal();
    }

/**
 * Calcula el coste total de la venta sumando el precio de todos los pájaros
 * en la lista de la venta.
 */
    public void calcularTotal() {
        this.total = 0;
        for (Pajaro p : lineasDeVenta) {
            this.total += p.getPrecio();
        }
    }

    // Getters
    /**
 * Obtiene el cliente asociado a esta venta.
 * 
 * @return El objeto Cliente de la venta.
 */
    public Cliente getCliente() {
        return cliente;
    }

/**
 * Obtiene el total monetario de la venta.
 * 
 * @return El coste total de la venta.
 */
    public double getTotal() {
        return total;
    }
    
    /**
 * Genera una representación textual detallada de la venta, similar a un ticket.
 * Incluye fecha, datos del cliente, lista de pájaros y total.
 * 
 * @return Una cadena de texto formateada con toda la información de la venta.
 */
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