// Archivo: Pajaro.java
public class Pajaro {
    private String especie;
    private String color;
    private double precio;
    private int cantidad; // Para gestionar el stock (extra opcional)

    public Pajaro(String especie, String color, double precio, int cantidad) {
        this.especie = especie;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters
    public String getEspecie() {
        return especie;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pájaro -> Especie: " + especie + " | Color: " + color + " | Precio: " + String.format("%.2f", precio) + "€ | Stock: " + cantidad;
    }
}