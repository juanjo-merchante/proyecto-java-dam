// Archivo: Cliente.java
/**
 * Representa a un Cliente de la pajarería.
 * Almacena la información personal y de contacto del cliente.
 * 
 * @author Juanjo Merchante
 * @version 1.0
 */
public class Cliente {
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

/**
 * Constructor para crear un nuevo objeto Cliente.
 * 
 * @param nombre El nombre del cliente.
 * @param dni El DNI del cliente.
 * @param telefono El teléfono de contacto del cliente.
 * @param email El correo electrónico del cliente.
 */
    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters
    /**
 * Obtiene el nombre del cliente.
 * @return El nombre del cliente.
 */
    public String getNombre() {
        return nombre;
    }

/**
 * Obtiene el Dni del cliente.
 * @return El Dni del cliente.
 */
    public String getDni() {
        return dni;
    }

/**
 * Obtiene el Telefono del cliente.
 * @return El Telefono del cliente.
 */
    public String getTelefono() {
        return telefono;
    }

/**
 * Obtiene el Email del cliente.
 * @return El Email del cliente.
 */
    public String getEmail() {
        return email;
    }

    // Setters
    /**
 * Establece o actualiza el nombre del cliente.
 * 
 * @param nombre El nuevo nombre para el cliente.
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/**
 * Establece o actualiza el teléfono del cliente.
 * 
 * @param telefono El nuevo número de teléfono para el cliente.
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
/**
 * Establece o actualiza el email del cliente.
 * 
 * @param email La nueva dirección de correo electrónico para el cliente.
 */
    public void setEmail(String email) {
        this.email = email;
    }

/**
 * Devuelve una representación en formato de cadena de texto del objeto Cliente.
 * Es útil para mostrar la información del cliente de forma rápida en la consola.
 * 
 * @return Una cadena de texto con los datos formateados del cliente.
 */
    @Override
    public String toString() {
        return "Cliente -> DNI: " + dni + " | Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }
}