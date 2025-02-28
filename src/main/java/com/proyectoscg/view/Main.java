package com.proyectoscg.view;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.persistence.Persistencia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static ArrayList<Herramienta> herramientas;
    private static ArrayList<Contenedor> contenedores;
    private static Persistencia archivo ;
    public static void main(String[] args)  {
        herramientas = new ArrayList<>();
        contenedores = new ArrayList<>();
        try {
            archivo = new Persistencia();
            herramientas = archivo.readFicheroHerramienta();
            contenedores = archivo.readFicheroContenedor();

            int opcion;
            do {
                menu();
                opcion = AskData.askInt("Qué opción desea, introduzca un número del menú: ", "ERROR: Tienes que escoger un número entre 1 y 6", 1, 6);
                switch (opcion) {
                    case 1:
                        addHerramienta();
                        break;
                    case 2:
                        addContenedor();
                        break;
                    case 3:
                        addInventario();
                        break;
                    case 4:
                        showInventario();
                        break;
                    case 5:
                        showContenedor();
                        break;
                    case 6:
                        System.out.println("*** GRACIAS POR UTILIZAR LA APLICACIÓN ***");
                        break;
                }
            } while (opcion != 6);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void showContenedor() {
        if (contenedores.isEmpty()) { // Si la lista de contenedores está vacía
            System.out.println("No hay contenedores disponibles.");
        } else {
            System.out.println("Lista de contenedores:");
            for (Contenedor contenedor : contenedores) {
                System.out.println(contenedor); // Llama a toString() de cada contenedor
            }
        }
    }


    private static void showInventario() {
        if (herramientas.isEmpty()) { // Aquí cambiamos listaHerramientas por herramientas
            System.out.println("No hay herramientas disponibles.");
        } else {
            System.out.println("Lista de herramientas:");
            for (Herramienta herramienta : herramientas) {
                System.out.println(herramienta); // Llama a toString()
            }
        }
    }

    private static void addInventario() {
        boolean continuar = true; // Variable de control para gestionar si continuamos o no

        if (isEmptyListHerramientas() || contenedores.isEmpty()) {
            System.out.println("*** No hay herramientas o contenedores disponibles para continuar. ***");
            continuar = false; // No continuamos si no hay herramientas o contenedores
        }

        // Pedir el código de la herramienta
        String codigoHerramienta = AskData.askString("Introduce el código de la herramienta a añadir:");
        Herramienta herramienta = buscarHerramienta(codigoHerramienta);
        if (herramienta == null) {
            System.out.println("*** No se encontró ninguna herramienta con ese código. ***");
            continuar = false; // No continuamos si no encontramos la herramienta
        }

        // Pedir el código del contenedor
        String codigoContenedor = AskData.askString("Introduce el código del contenedor donde añadir la herramienta:");
        Contenedor contenedor = buscarContenedor(codigoContenedor);
        if (contenedor == null) {
            System.out.println("*** No se encontró ningún contenedor con ese código. ***");
            continuar = false; // No continuamos si no encontramos el contenedor
        }

        // Si esta correcto, continuar con la lógica del inventario
        if (continuar) {
            // Pedir la cantidad de herramientas a añadir
            int cantidad = AskData.askInt("Introduce la cantidad de herramientas a añadir:", "Error, introduce un número válido.", 1, 1000);

            // Usar el getter para obtener el inventario
            HashMap<Herramienta, Integer> inventario = contenedor.getInventario();

            // Agregar la herramienta al inventario del contenedor
            int cantidadActual = inventario.getOrDefault(herramienta, 0); // Obtener la cantidad actual de la herramienta
            inventario.put(herramienta, cantidadActual + cantidad); // Actualizar la cantidad

            System.out.println("*** Se han añadido " + cantidad + " unidades de " + herramienta.getNombre() + " al contenedor " + codigoContenedor + " ***");

            // Guardar los cambios en el archivo
            try {
                archivo.writeContenedor(contenedor);
                archivo.writeInventario(contenedor); // Guardar también el inventario
            } catch (IOException ex) {
                System.out.println("Error al guardar los cambios: " + ex.getMessage());
            }

        }
    }


    private static Herramienta buscarHerramienta(String codigoHerramienta) {
        for (Herramienta herramienta : herramientas) {
            if (herramienta.getCodigoHerramienta().equalsIgnoreCase(codigoHerramienta)) {
                return herramienta; // Devuelve la herramienta si la encuentra
            }
        }

        // Si no se encuentra la herramienta, mostramos un mensaje de error pero no retornamos null
        System.out.println("*** No se encontró ninguna herramienta con ese código. ***");
        return null; // Esta parte sigue siendo necesaria para poder salir de la función
    }

    private static Contenedor buscarContenedor(String codigoContenedor) {
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getCodigoContenedor().equalsIgnoreCase(codigoContenedor)) {
                return contenedor; // Devuelve el contenedor si lo encuentra
            }
        }

        // Si no se encuentra el contenedor, mostramos un mensaje de error pero no retornamos null
        System.out.println("*** No se encontró ningún contenedor con ese código. ***");
        return null; // Esta parte sigue siendo necesaria para poder salir de la función
    }

    private static boolean isEmptyListHerramientas() {
        if (herramientas.isEmpty()) {
            System.out.println("*** No tiene ninguna herramienta creada, primero vaya a crear y luego podrá elegir esta opción *** \n");
            return true;
        }
        return false;
    }



    private static void addContenedor() throws IOException {
        System.out.println("\n *** Bienvenido al Apartado de Crear Contenedores Para Guardar Herramientas Pequeñas ***");

        // Crear una variable de bandera para comprobar si el código es único
        boolean codigoValido = false;
        String codigoContenedor = "";

        // Mientras el código no sea único, pedirlo nuevamente
        while (!codigoValido) {
            codigoContenedor = AskData.askString("Dime el código para este contenedor: ");

            // Verificamos si el código ya está en la lista
            if (contenedores.contains(new Contenedor(codigoContenedor))) {
                System.out.println("*** No puede crear dos contenedores con el mismo código *** \n");
            } else {
                codigoValido = true;  // Si no está, el código es válido y salimos del bucle
            }
        }

        // Pedir el resto de los datos solo si el código es válido
        int capacidadContenedor = AskData.askInt("Dime la capacidad que tiene el contenedor en METROS cuadrados (largo x ancho): ", "Error no puedes colocar una cantidad inferior a 1", 1);

        // Crear el nuevo contenedor y agregarlo a la lista
        Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);
        contenedores.add(newContenedor);
        archivo.writeContenedor(newContenedor);

        System.out.println("*** El contenedor se ha añadido correctamente *** \n");
    }



    private static void addHerramienta() throws IOException {
        System.out.println("\n*** Bienvenido al Apartado de Crear Herramientas Nuevas ***");

        // Crear una variable de bandera para comprobar si el código es único
        boolean codigoValido = false;
        String codigoHerramienta = "";

        // Mientras el código no sea único, pedirlo nuevamente
        while (!codigoValido) {
            codigoHerramienta = AskData.askString("Dime el código para esta herramienta: ");

            // Verificamos si el código ya está en la lista
            if (herramientas.contains(new Herramienta(codigoHerramienta))) {
                System.out.println("*** No puede crear dos herramientas con el mismo código *** \n");
            } else {
                codigoValido = true;  // Si no está, el código es válido y salimos del bucle
            }
        }

        // Pedir el resto de los datos solo si el código es válido
        String nombre = AskData.askString("Introduce el nombre de la herramienta: ");
        double volumen = AskData.askDouble("Introduce la medida de la herramienta en CENTÍMETROS cuadrados(largo x ancho): ", "Error no puedes colocar una cantidad inferior a 1", 1);
        boolean isGrande = AskData.askBoolean("¿Es una herramienta grande (En caso de ser grande no se colocará en estanterías) ? (Coloca S/N) ? : ", "La respuesta debe ser S o N", "S", "N");

        // Crear la nueva herramienta y agregarla a la lista
        Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta, volumen, isGrande);
        herramientas.add(newHerramienta);
        archivo.writeHerramienta(newHerramienta);

        System.out.println("*** La herramienta se ha añadido correctamente *** \n");
    }



    private static void menu() {        //menu output
        System.out.println("*** Bienvenido a la App de Gestión de Almacenamiento ***\n" +
                "1. Añadir Herramienta Nueva.\n" +
                "2. Añadir Contenedor Nuevo.\n" +
                "3. Añadir Inventario de Herramientas.\n" +
                "4. Mostrar Inventario.\n" +
                "5. Mostrar Contenedor.\n" +
                "6. Sortir.");


    }
}

