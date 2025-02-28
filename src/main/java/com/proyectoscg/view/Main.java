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
                opcion = AskData.askInt("Escoja una opción del menú: ", "ERROR: NÚMERO NO VÁLIDO: Tienes que escoger un número entre 1 y 6", 1, 6);
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
            System.out.println("*** NO HAY CONTENEDORES REGISTRADOS ***");
        } else {
            System.out.println("*** LISTA DE CONTENEDORES ***");
            for (Contenedor c : contenedores) {
                System.out.println(c); // Llama a toString() de cada contenedor
            }
        }
    }


    private static void showInventario() {
        if (herramientas.isEmpty()) { // Aquí cambiamos listaHerramientas por herramientas
            System.out.println("*** NO HAY HERRAMIENTAS REGISTRADAS ***");
        } else {
            System.out.println("*** LISTA DE HERRAMIENTAS ***");
            for (Herramienta herramienta : herramientas) {
                System.out.println(herramienta); // Llama a toString()
            }
        }
    }

    private static void addInventario() {
        System.out.println("*** AÑADIR HERRAMIENTA A INVENTARIO ***");
        boolean continuar = true; // Variable de control para gestionar si continuamos o no

        if (isEmptyListHerramientas() || isEmptyListContenedores()) {
            System.out.println("*** NO HAY HERRAMIENTAS NI CONTENEDORES CREADOS ***");
            continuar = false; // No continuamos si no hay herramientas o contenedores
        }

        // Pedir el código de la herramienta
        String codigoHerramienta = AskData.askString("Introduce el código de la herramienta a añadir:");
        Herramienta herramienta = buscarHerramienta(codigoHerramienta);
        if (herramienta == null) {
            System.out.println("*** ERROR: NO EXISTE NINGUNA HERRAMIENTA CON ESE CÓDIGO ***");
            continuar = false; // No continuamos si no encontramos la herramienta
        }

        // Pedir el código del contenedor
        String codigoContenedor = AskData.askString("Introduce el código del contenedor donde añadir la herramienta:");
        Contenedor contenedor = buscarContenedor(codigoContenedor);
        if (contenedor == null) {
            System.out.println("*** ERROR: NO EXISTE NINGUN CÓDIGO CON ESE CÓDIGO ***");
            continuar = false; // No continuamos si no encontramos el contenedor
        }

        // Si esta correcto, continuar con la lógica del inventario
        if (continuar) {
            // Pedir la cantidad de herramientas a añadir
            int cantidad = AskData.askInt("Introduce la cantidad de herramientas a añadir:", "ERROR: INTRODUZCA UN NÚMERO VÁLIDO.", 1, 1000);

            // Usar el getter para obtener el inventario
            HashMap<Herramienta, Integer> inventario = contenedor.getInventario();

            // Agregar la herramienta al inventario del contenedor
            int cantidadActual = inventario.getOrDefault(herramienta, 0); // Obtener la cantidad actual de la herramienta
            inventario.put(herramienta, cantidadActual + cantidad); // Actualizar la cantidad

            System.out.println("*** SE HAN AÑADIDO " + cantidad + " UNIDADES DE " + herramienta.getNombre() + " AL CONTENEDOR " + codigoContenedor + " ***");

            System.out.println("\n================================");

            // Guardar los cambios en el archivo
            try {
                archivo.writeContenedor(contenedor);
                archivo.writeInventario(contenedor); // Guardar también el inventario
            } catch (IOException ex) {
                System.out.println("ERROR AL GUARDAR LOS CAMBIOS: " + ex.getMessage());
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
        System.out.println("*** ERROR: NO EXISTE NINGUNA HERRAMIENTA CON ESE CÓDIGO ***");
        return null; // Esta parte sigue siendo necesaria para poder salir de la función
    }

    private static Contenedor buscarContenedor(String codigoContenedor) {
        for (Contenedor contenedor : contenedores) {
            if (contenedor.getCodigoContenedor().equalsIgnoreCase(codigoContenedor)) {
                return contenedor; // Devuelve el contenedor si lo encuentra
            }
        }

        // Si no se encuentra el contenedor, mostramos un mensaje de error pero no retornamos null
        System.out.println("*** ERROR: NO EXISTE NINGUN CONTENEDOR CON ESE CÓDIGO ***");
        return null; // Esta parte sigue siendo necesaria para poder salir de la función
    }

    private static boolean isEmptyListHerramientas() {
        if (herramientas.isEmpty()) {
            System.out.println("*** NO EXISTE NINGUNA HERRAMIENTA, PORFAVOR CREE ANTES UNA HERRAMIENTA *** \n");
            return true;
        }
        return false;
    }
    private static boolean isEmptyListContenedores() {
        if (contenedores.isEmpty()) {
            System.out.println("*** NO EXISTE NINGUN CONTENEDOR, PORFAVOR CREE ANTES UN CONTENEDOR *** \n");
            return true;
        }
        return false;
    }



    private static void addContenedor() throws IOException {
        System.out.println("\n *** AÑADIR CONTENEDOR A LA BASE DE DATOS ***");
        String codigoContenedor = AskData.askString("Código para el contenedor: ");

        // Mientras el código no sea único, pedirlo nuevamente
        while (contenedores.contains(new Contenedor(codigoContenedor))) {
            System.out.println("*** ERROR: NO PUEDE HABER DOS CONTENEDORES CON EL MISMO CÓDIGO *** \n");
            codigoContenedor = AskData.askString("Código para el contenedor: ");
        }
        // Pedir el resto de los datos solo si el código es válido
        int capacidadContenedor = AskData.askInt("Capacidad del contenedor en m² (largo x ancho): ", "ERROR: EL NÚMERO DEBE SER SUPERIOR A 1", 1);
        Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);    // Crear el nuevo contenedor (objeto) y agregarlo a la lista
        contenedores.add(newContenedor);
        archivo.writeContenedor(newContenedor);
        System.out.println("*** CONTENEDOR AÑADIDO CORRECTAMENTE *** \n");
    }



    private static void addHerramienta() throws IOException {
        System.out.println("\n*** MENÚ DE AÑADIR HERRAMIENTA A LA BASE DE DATOS *** \n 1.Añadir herramienta nueva \n 2.Salir");
        int opcion = AskData.askInt("Elija una opción: ", "ERROR:INTRODUZCA UNA OPCIÓN VÁLIDA.", 1, 2);
        switch(opcion){
            case 1:
                String codigoHerramienta = AskData.askString("Código para la herramienta: ");
                while (herramientas.contains(new Herramienta(codigoHerramienta))) {
                    System.out.println("*** ERROR: NO PUEDE HABER DOS HERRAMIENTAS CON EL MISMO CÓDIGO *** \n");
                    codigoHerramienta = AskData.askString("Código para la herramienta: ");
                }
                // Pedir el resto de los datos solo si el código es válido
                String nombre = AskData.askString("Nombre de la herramienta: ");
                double volumen = AskData.askDouble("Medida de la herramienta en cm² (largo x ancho): ", "ERROR: EL NÚMERO DEBE SER SUPERIOR A 1", 1);
                boolean isGrande = AskData.askBoolean("¿Es una herramienta grande (S/N)?: ", "ERROR: LA RESPUESTA DEBE SER S O N", "S", "N");

                // Crear la nueva herramienta y agregarla a la lista
                Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta, volumen, isGrande);
                herramientas.add(newHerramienta);
                archivo.writeHerramienta(newHerramienta);

                System.out.println("*** HERRAMIENTA AÑADIDA CORRECTAMENTE *** \n");
                break;
            case 2:
                System.out.println("*** VOLVIENDO AL MENÚ ***");
                break;
        }

        }






    private static void menu() {        //menu output
        System.out.println("*** Bienvenido a la App de Gestión de Almacenamiento ***\n" +
                "1. Añadir Herramienta.\n" +
                "2. Añadir Contenedor.\n" +
                "3. Añadir Inventario de Herramientas.\n" +
                "4. Mostrar Inventario.\n" +
                "5. Mostrar Contenedor.\n" +
                "6. Sortir.");


    }
}

