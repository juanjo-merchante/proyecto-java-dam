package com.juanjomerchante.pajareria;
// Archivo: GestionPajareria.java
import java.util.*;

/**
 * Clase principal de la aplicación.
 * Se encarga de la lógica de la aplicación,
 * la gestión de datos y la interacción con el usuario.
 * 
 * @author Juanjo Merchante
 * @version 1.0
 */
public class GestionPajareria {

/**
 * Constructor por defecto para la clase de gestión.
 */
public GestionPajareria() {
    // Este constructor está intencionadamente vacío.
}
    // Listas para almacenar los datos en memoria
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pajaro> pajarosDisponibles = new ArrayList<>();
    private static List<Venta> ventasRealizadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

/**
 * Punto de entrada principal de la aplicación.
 * Carga datos iniciales y ejecuta el bucle del menú principal.
 * 
 * @param args Argumentos de línea de comandos (no se utilizan).
 */
    public static void main(String[] args) {
        // Cargamos datos iniciales para facilitar las pruebas
        cargarDatosIniciales();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    gestionarPajaros();
                    break;
                case 3:
                    realizarVenta();
                    break;
                case 4:
                    mostrarVentas();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            presionarEnterParaContinuar();
        } while (opcion != 5);
        scanner.close();
    }
    
    // --- MÉTODOS DE MENÚS ---

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL - GESTIÓN DE PAJARERÍA ===");
        System.out.println("1. Gestión de clientes");
        System.out.println("2. Gestión de pájaros (catálogo)");
        System.out.println("3. Realizar venta");
        System.out.println("4. Mostrar ventas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private static void gestionarClientes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Baja de cliente");
            System.out.println("3. Modificación de cliente");
            System.out.println("4. Búsqueda por DNI");
            System.out.println("5. Listar todos los clientes (ordenados por nombre)");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1: altaCliente(); break;
                case 2: bajaCliente(); break;
                case 3: modificarCliente(); break;
                case 4: buscarClientePorDni(); break;
                case 5: listarClientes(); break;
                case 6: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void gestionarPajaros() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Pájaros ---");
            System.out.println("1. Alta de pájaro en catálogo");
            System.out.println("2. Listar catálogo de pájaros (ordenados por especie)");
            System.out.println("3. Búsqueda por especie");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();

            switch (opcion) {
                case 1: altaPajaro(); break;
                case 2: listarPajaros(); break;
                case 3: buscarPajaroPorEspecie(); break;
                case 4: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void mostrarVentas() {
        int opcion;
        do {
            System.out.println("\n--- Mostrar Ventas ---");
            System.out.println("1. Mostrar todas las ventas realizadas");
            System.out.println("2. Mostrar ventas por cliente");
            System.out.println("3. Mostrar importe total de ventas por cliente (Extra)");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion();
            
            switch (opcion) {
                case 1: mostrarTodasLasVentas(); break;
                case 2: mostrarVentasPorCliente(); break;
                case 3: mostrarTotalVentasPorCliente(); break;
                case 4: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 4);
    }


    // --- FUNCIONALIDADES DE CLIENTES ---

   // ESTA ES LA NUEVA VERSIÓN MEJORADA
private static void altaCliente() {
    System.out.println("\n--- Alta de Cliente ---");
    System.out.println("(Escriba 'cancelar' en cualquier momento para volver)");

    System.out.print("DNI: ");
    String dni = scanner.nextLine();
    if (dni.equalsIgnoreCase("cancelar")) {
        System.out.println("Operación cancelada.");
        return; // Esto nos saca de la función y vuelve al menú
    }
    if (buscarCliente(dni) != null) {
        System.out.println("Error: Ya existe un cliente con ese DNI.");
        return;
    }
    // Validamos que el DNI no esté vacío
    if (dni.trim().isEmpty()) {
        System.out.println("Error: El DNI no puede estar vacío.");
        return;
    }

    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    if (nombre.equalsIgnoreCase("cancelar")) {
        System.out.println("Operación cancelada.");
        return;
    }
    if (nombre.trim().isEmpty()) {
        System.out.println("Error: El nombre no puede estar vacío.");
        return;
    }

    System.out.print("Teléfono: ");
    String telefono = scanner.nextLine();
    if (telefono.equalsIgnoreCase("cancelar")) {
        System.out.println("Operación cancelada.");
        return;
    }

    System.out.print("Email: ");
    String email = scanner.nextLine();
    if (email.equalsIgnoreCase("cancelar")) {
        System.out.println("Operación cancelada.");
        return;
    }

    clientes.add(new Cliente(nombre, dni, telefono, email));
    System.out.println("Cliente añadido con éxito.");
}

    private static void bajaCliente() {
        System.out.println("\n--- Baja de Cliente ---");
        System.out.print("Introduzca el DNI del cliente a dar de baja: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado con éxito.");
        } else {
            System.out.println("Error: No se encontró ningún cliente con ese DNI.");
        }
    }
    
    private static void modificarCliente() {
        System.out.println("\n--- Modificar Cliente ---");
        System.out.print("Introduzca el DNI del cliente a modificar: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            System.out.println("Datos actuales: " + cliente);
            System.out.print("Nuevo nombre (dejar en blanco para no cambiar): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) cliente.setNombre(nombre);
            
            System.out.print("Nuevo teléfono (dejar en blanco para no cambiar): ");
            String telefono = scanner.nextLine();
            if (!telefono.isEmpty()) cliente.setTelefono(telefono);
            
            System.out.print("Nuevo email (dejar en blanco para no cambiar): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) cliente.setEmail(email);

            System.out.println("Cliente modificado con éxito.");
        } else {
            System.out.println("Error: No se encontró ningún cliente con ese DNI.");
        }
    }
    
    private static void buscarClientePorDni() {
        System.out.println("\n--- Búsqueda de Cliente por DNI ---");
        System.out.print("Introduzca DNI: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
        }
    }
    
    private static void listarClientes() {
        System.out.println("\n--- Listado de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            // Extra opcional: ordenar por nombre
            clientes.sort(Comparator.comparing(Cliente::getNombre));
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    // --- FUNCIONALIDADES DE PÁJAROS ---
    
    private static void altaPajaro() {
        System.out.println("\n--- Alta de Pájaro ---");
        System.out.print("Especie: ");
        String especie = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = leerDouble();
        System.out.print("Cantidad (Stock): ");
        int cantidad = leerOpcion();

        pajarosDisponibles.add(new Pajaro(especie, color, precio, cantidad));
        System.out.println("Pájaro añadido al catálogo con éxito.");
    }
    
    private static void listarPajaros() {
        System.out.println("\n--- Catálogo de Pájaros Disponibles ---");
        if (pajarosDisponibles.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
             // Extra opcional: ordenar por especie
            pajarosDisponibles.sort(Comparator.comparing(Pajaro::getEspecie));
            for (Pajaro p : pajarosDisponibles) {
                System.out.println(p);
            }
        }
    }

    private static void buscarPajaroPorEspecie() {
        System.out.println("\n--- Búsqueda de Pájaro por Especie ---");
        System.out.print("Introduzca la especie a buscar: ");
        String especie = scanner.nextLine();
        boolean encontrado = false;
        for (Pajaro p : pajarosDisponibles) {
            if (p.getEspecie().equalsIgnoreCase(especie)) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron pájaros de esa especie.");
        }
    }
    
    // --- FUNCIONALIDADES DE VENTAS ---
    
    private static void realizarVenta() {
        System.out.println("\n--- Realizar Nueva Venta ---");
        if (clientes.isEmpty()) {
            System.out.println("Error: No hay clientes registrados. Debe dar de alta un cliente primero.");
            return;
        }
        if (pajarosDisponibles.stream().allMatch(p -> p.getCantidad() == 0)) {
            System.out.println("Error: No hay pájaros con stock disponible para la venta.");
            return;
        }

        // 1. Seleccionar cliente
        System.out.println("Seleccione un cliente:");
        listarClientes();
        System.out.print("Introduzca el DNI del cliente: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente == null) {
            System.out.println("DNI no válido. Abortando venta.");
            return;
        }

        Venta nuevaVenta = new Venta(cliente);

        // 2. Añadir pájaros
        String continuar;
        do {
            System.out.println("\nPájaros disponibles (con stock > 0):");
            List<Pajaro> pajarosConStock = new ArrayList<>();
            for (int i = 0; i < pajarosDisponibles.size(); i++) {
                if (pajarosDisponibles.get(i).getCantidad() > 0) {
                    pajarosConStock.add(pajarosDisponibles.get(i));
                    System.out.println((pajarosConStock.size()) + ". " + pajarosDisponibles.get(i));
                }
            }
            
            if (pajarosConStock.isEmpty()) {
                System.out.println("No quedan más pájaros con stock.");
                break;
            }

            System.out.print("Seleccione el número del pájaro a añadir: ");
            int seleccion = leerOpcion() - 1;

            if (seleccion >= 0 && seleccion < pajarosConStock.size()) {
                Pajaro pajaroSeleccionado = pajarosConStock.get(seleccion);
                nuevaVenta.agregarPajaro(pajaroSeleccionado);
                // Extra opcional: disminuir stock
                pajaroSeleccionado.setCantidad(pajaroSeleccionado.getCantidad() - 1);
                System.out.println(pajaroSeleccionado.getEspecie() + " añadido a la venta.");
            } else {
                System.out.println("Selección no válida.");
            }

            System.out.print("¿Añadir otro pájaro? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        if (nuevaVenta.getTotal() > 0) {
            ventasRealizadas.add(nuevaVenta);
            System.out.println("\n--- Venta Realizada con Éxito ---");
            System.out.println(nuevaVenta);
        } else {
            System.out.println("Venta cancelada (no se añadieron productos).");
        }
    }
    
    private static void mostrarTodasLasVentas() {
        System.out.println("\n--- Todas las Ventas Realizadas ---");
        if (ventasRealizadas.isEmpty()) {
            System.out.println("No se ha realizado ninguna venta.");
        } else {
            for (Venta v : ventasRealizadas) {
                System.out.println(v);
            }
        }
    }
    
    private static void mostrarVentasPorCliente() {
        System.out.println("\n--- Mostrar Ventas por Cliente ---");
        System.out.print("Introduzca el DNI del cliente: ");
        String dni = scanner.nextLine();
        boolean encontrado = false;
        for (Venta v : ventasRealizadas) {
            if (v.getCliente().getDni().equals(dni)) {
                System.out.println(v);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron ventas para el cliente con DNI: " + dni);
        }
    }

    private static void mostrarTotalVentasPorCliente() {
        System.out.println("\n--- Importe Total de Ventas por Cliente (Extra) ---");
        System.out.print("Introduzca el DNI del cliente: ");
        String dni = scanner.nextLine();
        Cliente cliente = buscarCliente(dni);

        if (cliente == null) {
            System.out.println("No se encontró al cliente con DNI: " + dni);
            return;
        }

        double totalCliente = 0;
        boolean haComprado = false;
        for (Venta v : ventasRealizadas) {
            if (v.getCliente().getDni().equals(dni)) {
                totalCliente += v.getTotal();
                haComprado = true;
            }
        }

        if(haComprado) {
            System.out.printf("El importe total de las compras de %s (DNI: %s) es: %.2f€\n",
                    cliente.getNombre(), cliente.getDni(), totalCliente);
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no ha realizado ninguna compra.");
        }
    }

    // --- MÉTODOS AUXILIARES ---
    
    private static Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe introducir un número.");
            return -1; // Devuelve un valor inválido
        }
    }
    
    private static double leerDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe introducir un número válido (ej: 15.50).");
            return -1.0;
        }
    }
    
    private static void presionarEnterParaContinuar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    private static void cargarDatosIniciales() {
        // Clientes
        clientes.add(new Cliente("Ana López", "12345678A", "611223344", "ana@email.com"));
        clientes.add(new Cliente("Luis García", "87654321B", "699887766", "luis@email.com"));
        
        // Pájaros
        pajarosDisponibles.add(new Pajaro("Canario", "Amarillo", 25.50, 10));
        pajarosDisponibles.add(new Pajaro("Periquito", "Azul", 15.00, 20));
        pajarosDisponibles.add(new Pajaro("Agapornis", "Verde", 45.75, 5));
        pajarosDisponibles.add(new Pajaro("Ninfa", "Gris", 55.00, 8));
    }
}