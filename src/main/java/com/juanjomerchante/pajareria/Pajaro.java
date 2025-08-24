package com.juanjomerchante.pajareria;
// Archivo: Pajaro.java
/**
 * Representa un Pájaro en el inventario de la pajarería.
 * Contiene detalles como la especie, el precio y la edad.
 * 
 * @author Juanjo Merchante
 * @version 1.0
 */
public class Pajaro {
    private String especie;
    private String color;
    private double precio;
    private int cantidad; // Para gestionar el stock (extra opcional)

/**
 * Constructor para crear un nuevo Pájaro.
 * 
 * @param especie La especie del pájaro.
 * @param color El color del plumaje del pájaro.
 * @param precio El precio de venta del pájaro.
 * @param cantidad El número de ejemplares en stock.
 */
    public Pajaro(String especie, String color, double precio, int cantidad) {
        this.especie = especie;
        this.color = color;
        this.precio = precio;
        this.cantidad = cantidad;
    }

/**
 * Obtiene la especie del pájaro.
 * @return La especie del pájaro.
 */
    // Getters
    public String getEspecie() {
        return especie;
    }

/**
 * Obtiene la color del pájaro.
 * @return La color del pájaro.
 */
    public String getColor() {
        return color;
    }

/**
 * Obtiene la precio del pájaro.
 * @return La precio del pájaro.
 */
    public double getPrecio() {
        return precio;
    }

/**
 * Obtiene la cantidad del pájaro.
 * @return La cantidad del pájaro.
 */
    public int getCantidad() {
        return cantidad;
    }

    // Setters
    /**
 * Establece o actualiza el precio del pájaro.
 * 
 * @param precio El nuevo precio de venta del pájaro.
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

/**
 * Establece o actualiza la cantidad de pájaros de este tipo en stock.
 * 
 * @param cantidad El nuevo número de unidades disponibles.
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

/**
 * Devuelve una representación en formato de cadena de texto del objeto Pajaro.
 * Muestra los detalles principales del pájaro de forma clara.
 * 
 * @return Una cadena de texto con los datos formateados del pájaro.
 */
    @Override
    public String toString() {
        return "Pájaro -> Especie: " + especie + " | Color: " + color + " | Precio: " + String.format("%.2f", precio) + "€ | Stock: " + cantidad;
    }
}