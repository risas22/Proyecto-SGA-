package com.proyectoscg.view;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.persistence.Persistencia;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @author KevinColl
 * @author KristinaLlamas
 * @author VictorMedina
 *
 * */

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
                opcion = AskData.askInt("Escoja una opción del menú: ", "ERROR - NÚMERO NO VÁLIDO: TIENE QUE ESCOGER UN NÚMERO QUE ESTE EN EL MENÚ", 1, 8);
                switch (opcion) {
                    case 1 -> addHerramienta();
                    case 2 -> addContenedor();
                    case 3 -> addInventario();
                    case 4 -> showHerramientas();
                    case 5 -> showContenedor();
                    case 6 -> showInventarioContenedor();
                    case 7 -> showInventarioAll();
                    case 8 -> System.out.println("*** GRACIAS POR UTILIZAR LA APLICACIÓN ***");
                }
            } while (opcion != 8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Muestra el inventario general de herramientas en todos los contenedores.
     * Recorre todos los contenedores y muestra el inventario de herramientas que contienen.
     * Este metodo solo ejecuta su funcionalidad si existen herramientas y contenedores en las listas respectivas.
     * Si alguna de las listas está vacía, no se muestra ningún inventario.
     */
    private static void showInventarioAll() {
        // Verifica que existan herramientas y contenedores
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()) {
            System.out.println("*** INVENTARIO GENERAL DE HERRAMIENTAS ***");

            // Recorre todos los contenedores y muestra su inventario
            for (Contenedor c : contenedores) {
                System.out.println(c.mostrarInventario()); // Llama al metodo mostrarInventario() de cada contenedor
            }
        }
    }

    /**
     * Muestra el inventario de herramientas en un contenedor específico.
     * Solicita al usuario el código de un contenedor y muestra el inventario de ese contenedor.
     * Este metodo solo ejecuta su funcionalidad si existen herramientas y contenedores en las listas respectivas.
     * Si alguna de las listas está vacía, no se muestra el inventario.
     */
    private static void showInventarioContenedor() {
        // Muestra la lista de contenedores disponibles
        showContenedor();

        // Solicita el índice del contenedor al usuario
        int codigoContenedor = preguntarIndexOffContenedor();

        // Si el contenedor existe, muestra su inventario
        if (codigoContenedor >= 0) {
            Contenedor c = contenedores.get(codigoContenedor); // Obtiene el contenedor por el índice
            System.out.println(c.mostrarInventario()); // Llama al metodo mostrarInventario() del contenedor
        }
    }

    /**
     * Solicita al usuario el código de un contenedor y busca el índice del contenedor en la lista de contenedores.
     * Si el contenedor con el código ingresado no existe en la lista, se muestra un mensaje de error.
     *
     * @return El índice del contenedor en la lista de contenedores, o -1 si el contenedor no existe.
     */
    private static int preguntarIndexOffContenedor() {
        // Solicita el código del contenedor al usuario
        String codigoContenedor = AskData.askString("Introduzca el código del contenedor: ");

        // Busca el índice del contenedor en la lista
        int indexContenedor = contenedores.indexOf(new Contenedor(codigoContenedor));

        // Si el contenedor no existe, muestra un mensaje de error
        if (indexContenedor < 0) {
            System.out.println("*** ERROR - ESTE CONTENEDOR NO EXISTE ***\n");
        }

        // Retorna el índice del contenedor (o -1 si no existe)
        return indexContenedor;
    }

    /**
     * Solicita al usuario el código de una herramienta y busca el índice de la herramienta en la lista de herramientas.
     * Si la herramienta con el código ingresado no existe en la lista, se muestra un mensaje de error.
     *
     * @return El índice de la herramienta en la lista de herramientas, o -1 si la herramienta no existe.
     */
    private static int preguntarIndexOffHerramienta() {
        // Solicita el código de la herramienta al usuario
        String codigoHerramienta = AskData.askString("Introduzca el código de la herramienta que desea añadir al contenedor: ");

        // Busca el índice de la herramienta en la lista
        int indexHerramienta = herramientas.indexOf(new Herramienta(codigoHerramienta));

        // Si la herramienta no existe, muestra un mensaje de error
        if (indexHerramienta < 0) {
            System.out.println("*** ERROR - ESTA HERRAMIENTA NO EXISTE ***\n");
        }

        // Retorna el índice de la herramienta (o -1 si no existe)
        return indexHerramienta;
    }

    /**
     * Permite añadir una cantidad específica de unidades de una herramienta a un contenedor disponible.
     * El proceso se realiza en varias etapas: primero, se verifica que existan herramientas y contenedores
     * disponibles. Luego, se selecciona una herramienta del inventario y se comprueba si es pequeña, ya que solo
     * las herramientas pequeñas pueden ser almacenadas en contenedores.
     * Después, se solicita la cantidad de unidades de la herramienta a añadir y se verifica si existen contenedores
     * con suficiente capacidad. Si hay contenedores disponibles, el usuario selecciona uno y las unidades de la herramienta
     * se añaden a dicho contenedor. Si no hay espacio suficiente, se informa al usuario.
     * En caso de que no haya herramientas o contenedores disponibles, no se realiza ninguna acción.
     */
    private static void addInventario() {
        // Verifica que existan herramientas y contenedores disponibles
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()) {
            System.out.println("*** APARTADO DE AÑADIR HERRAMIENTAS A CONTENEDORES ***");

            // Solicita el índice de la herramienta a añadir
            int indexHerramienta = preguntarIndexOffHerramienta();

            // Si se obtiene un índice válido
            if (indexHerramienta >= 0) {
                // Obtiene la herramienta seleccionada
                Herramienta h = herramientas.get(indexHerramienta);

                // Verifica si la herramienta es pequeña
                if (!h.isSmall()) {
                    System.out.println("*** ESTA HERRAMIENTA ES GRANDE Y NO VA EN CONTENEDORES ***\n");
                } else {
                    // Solicita la cantidad de unidades a añadir
                    int cantidadHerramienta = AskData.askInt("Introduzca la cantidad de unidades que quieras añadir: ",
                            "*** ERROR - TIENE QUE SER UNA CANTIDAD MÍNIMA DE 1 ***", 1);

                    // Verifica si existen contenedores con suficiente espacio para las unidades solicitadas
                    if (showContenedorDisponibles(cantidadHerramienta)) {
                        // Solicita el índice del contenedor
                        int indexContenedor = preguntarIndexOffContenedor();

                        // Si se obtiene un índice válido
                        if (indexContenedor >= 0) {
                            // Obtiene el contenedor seleccionado
                            Contenedor c = contenedores.get(indexContenedor);

                            // Verifica si el contenedor tiene suficiente espacio
                            if (c.capacidadRestante() >= cantidadHerramienta) {
                                // Añade las unidades de la herramienta al contenedor
                                c.anadirHerramienta(h, cantidadHerramienta);

                                // Informa que las unidades se han añadido correctamente
                                System.out.println("*** SE HAN AÑADIDO CORRECTAMENTE LAS UNIDADES AL CONTENEDOR ***\n");
                            } else {
                                // Informa que no hay suficiente espacio en el contenedor
                                System.out.println("*** NO HAY SUFICIENTE ESPACIO EN ESTE CONTENEDOR ***\n");
                            }
                        }
                    } else {
                        // Informa que no hay contenedores con suficiente espacio
                        System.out.println("*** NO HAY NINGÚN CONTENEDOR CON SUFICIENTE ESPACIO, PRUEBE A UBICAR MENOS UNIDADES  ***\n");
                    }
                }
            }
        }
    }

    /**
     * Muestra todos los contenedores almacenados en la "base de datos" si existen.
     * Si no hay contenedores almacenados, el metodo no imprime nada.
     * Este metodo llama al metodo `isEmptyListContenedores()` para verificar si la lista de contenedores está vacía.
     * Si la lista de contenedores no está vacía, imprime el título "LISTA DE CONTENEDORES"
     * y luego recorre todos los contenedores almacenados en la lista, mostrando sus detalles.
     */
    private static void showContenedor() {
        if (!isEmptyListContenedores()) {  // Verifica si la lista de contenedores no está vacía
            // Imprime el título de la lista de contenedores
            System.out.println("*** LISTA DE CONTENEDORES ***");

            // Recorre la lista de contenedores y muestra cada uno
            for (Contenedor c : contenedores) {
                System.out.println(c);  // Se asume que la clase Contenedor tiene sobrecargado el metodo toString
            }
        }
    }

    /**
     * Muestra los contenedores disponibles para almacenar un número específico de herramientas.
     * Un contenedor es considerado disponible si su capacidad restante es mayor o igual a la cantidad de herramientas
     * que se desean almacenar.
     * Si hay contenedores disponibles, imprime el título "LISTA DE CONTENEDORES DISPONIBLES" y muestra cada contenedor
     * que cumpla con la condición de tener capacidad suficiente.
     *
     * @param cantidadDeHerramientas La cantidad de herramientas que se desea almacenar en un contenedor.
     * @return true si existen contenedores disponibles, false en caso contrario.
     */
    private static boolean showContenedorDisponibles(int cantidadDeHerramientas) {
        boolean disponible = false;  // Bandera para indicar si hay contenedores disponibles

        if (!isEmptyListContenedores()) {  // Verifica si la lista de contenedores no está vacía
            // Recorre la lista de contenedores y verifica si alguno tiene suficiente capacidad
            for (Contenedor c : contenedores) {
                if (c.capacidadRestante() >= cantidadDeHerramientas) {  // Verifica la capacidad restante
                    if (!disponible) {  // Si es el primer contenedor disponible, muestra el encabezado
                        System.out.println("*** LISTA DE CONTENEDORES DISPONIBLES ***");
                    }
                    System.out.println(c);  // Muestra el contenedor disponible
                    disponible = true;  // Marca que hay al menos un contenedor disponible
                }
            }
        }
        return disponible;  // Devuelve true si hay contenedores disponibles, false si no
    }

    /**
     * Muestra todas las herramientas almacenadas en la "base de datos" si existen.
     * Si no hay herramientas almacenadas, el metodo no imprime nada.
     * Este metodo llama al metodo 'isEmptyListHerramientas()' para verificar si la lista de herramientas está vacía.
     * Si la lista de herramientas no está vacía, imprime el título "LISTA DE HERRAMIENTAS"
     * y luego recorre todas las herramientas almacenadas en la lista, mostrando sus detalles.
     */
    private static void showHerramientas() {
        if (!isEmptyListHerramientas()) {
            // Imprime el título de la lista de herramientas
            System.out.println("*** LISTA DE HERRAMIENTAS ***");

            // Recorre la lista de herramientas y muestra cada una
            for (Herramienta h : herramientas) {
                System.out.println(h);  // Se asume que la clase Herramienta tiene sobrecargado el metodo toString
            }
        }
    }

    /**
     * Verifica si la lista de herramientas está vacía.
     * Si la lista de herramientas está vacía, muestra un mensaje indicando que no hay herramientas creadas
     * y devuelve true. Si hay herramientas almacenadas, devuelve false.
     *
     * @return true si no hay herramientas en la lista, false en caso contrario.
     */
    private static boolean isEmptyListHerramientas() {
        if (herramientas.isEmpty()) {
            // Mensaje cuando la lista está vacía
            System.out.println("*** NO EXISTE NINGUNA HERRAMIENTA CREADA, PORFAVOR CREE ANTES UNA NUEVA *** \n");
            return true;
        }
        return false;
    }

    /**
     * Verifica si la lista de contenedores está vacía.
     * Si la lista de contenedores está vacía, muestra un mensaje indicando que no hay contenedores creados
     * y devuelve true. Si hay contenedores almacenados, devuelve false.
     *
     * @return true si no hay contenedores en la lista, false en caso contrario.
     */
    private static boolean isEmptyListContenedores() {
        if (contenedores.isEmpty()) {
            // Mensaje cuando la lista está vacía
            System.out.println("*** NO EXISTE NINGÚN CONTENEDOR CREADO, PORFAVOR CREE ANTES UNO NUEVO *** \n");
            return true;
        }
        return false;
    }

    /**
     * Muestra el menú para añadir un nuevo contenedor a la base de datos.
     * Permite al usuario ingresar los datos de un nuevo contenedor, validando que no exista ya
     * un contenedor con el mismo código. Si el código es único, se solicita la capacidad máxima
     * de unidades pequeñas que se pueden almacenar en el contenedor. El contenedor se agrega a la lista
     * de contenedores y se guarda en el archivo correspondiente.
     */
    private static void addContenedor() throws IOException {
        boolean continuar = true;  // Booleano para controlar la ejecución del menú

        // Bucle hasta que el usuario decida salir
        while (continuar) {
            // Muestra las opciones del menú para añadir un contenedor
            System.out.println("\n*** MENÚ DE AÑADIR CONTENEDOR A LA BASE DE DATOS *** \n 1.Añadir contenedor nuevo \n 2.Salir");

            // Se solicita la opción al usuario
            int opcionContenedor = AskData.askInt("Elija una opción: ", "*** ERROR - INTRODUZCA UNA OPCIÓN VÁLIDA DEL MENÚ ***", 1, 2);

            // Se maneja la opción seleccionada
            if (opcionContenedor == 1) {
                // Solicita el código del nuevo contenedor
                String codigoContenedor = AskData.askString("Introduzca el código del contenedor: ");

                // Verifica que el código no exista ya en la lista de contenedores
                while (contenedores.contains(new Contenedor(codigoContenedor))) {
                    System.out.println("*** ERROR - NO PUEDE HABER DOS CONTENEDORES CON EL MISMO CÓDIGO *** \n");
                    codigoContenedor = AskData.askString("Introduzca nuevamente el código del contenedor: ");
                }

                // Solicita la capacidad máxima de unidades que puede contener el contenedor
                int capacidadContenedor = AskData.askInt("Introduzca la capacidad máxima de unidades pequeñas que se pueden guardar en este contenedor: ", "*** ERROR: EL NÚMERO DEBE SER SUPERIOR A 1 ***", 1);

                // Crea el nuevo contenedor y lo agrega a la lista
                Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);
                contenedores.add(newContenedor);

                // Guarda el contenedor en el archivo
                archivo.writeContenedor(newContenedor);

                // Informa al usuario que el contenedor ha sido añadido correctamente
                System.out.println("*** CONTENEDOR AÑADIDO CORRECTAMENTE *** \n");
            }
            else if (opcionContenedor == 2) {
                // Si el usuario elige salir, cambia el valor de continuar para salir del bucle
                System.out.println("*** VOLVIENDO AL MENÚ *** \n");
                continuar = false;
            }
        }
    }

    /**
     * Muestra el menú para añadir una nueva herramienta a la base de datos.
     * Permite al usuario ingresar los datos de una nueva herramienta, validando que no exista ya
     * una herramienta con el mismo código. Si el código es único, se solicita el nombre y si la herramienta
     * es pequeña (para almacenarla en contenedores). La herramienta se agrega a la lista de herramientas y
     * se guarda en el archivo correspondiente.
     */
    private static void addHerramienta() throws IOException {
        // Muestra las opciones del menú para añadir una herramienta
        System.out.println("\n*** MENÚ DE AÑADIR HERRAMIENTA A LA BASE DE DATOS *** \n 1.Añadir herramienta nueva \n 2.Salir");

        // Se solicita la opción al usuario
        int opcionHerramienta = AskData.askInt("Elija una opción: ", "*** ERROR - INTRODUZCA UNA OPCIÓN DEL MENÚ ***", 1, 2);

        // Se maneja la opción seleccionada
        switch(opcionHerramienta){
            case 1:
                // Solicita el código de la nueva herramienta
                String codigoHerramienta = AskData.askString("Introduzca el código de la herramienta: ");

                // Verifica que el código no exista ya en la lista de herramientas
                while (herramientas.contains(new Herramienta(codigoHerramienta))) {
                    System.out.println("*** ERROR - NO PUEDE HABER DOS HERRAMIENTAS CON EL MISMO CÓDIGO *** \n");
                    codigoHerramienta = AskData.askString("Introduzca nuevamente el código de la nueva herramienta: ");
                }

                // Solicita el nombre de la herramienta y si es pequeña
                String nombre = AskData.askString("Introduzca el nombre de la herramienta: ");
                boolean isSmall = AskData.askBoolean("¿Es una herramienta pequeña, de ser así se guardará en contenedores (S/N)?: ", "*** ERROR - LA RESPUESTA DEBE SER S O N ***", "S", "N");

                // Crea la nueva herramienta y la agrega a la lista
                Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta, isSmall);
                herramientas.add(newHerramienta);

                // Guarda la herramienta en el archivo
                archivo.writeHerramienta(newHerramienta);

                // Informa al usuario que la herramienta ha sido añadida correctamente
                System.out.println("*** HERRAMIENTA AÑADIDA CORRECTAMENTE *** \n");
                break;
            case 2:
                // Si el usuario elige salir, se vuelve al menú principal
                System.out.println("*** VOLVIENDO AL MENÚ ***\n");
                break;
        }
    }

    /**
     * Muestra el menú principal de la aplicación de gestión de almacenamiento.
     * El menú contiene varias opciones que permiten al usuario interactuar con la aplicación
     * para añadir herramientas, contenedores, ver inventarios y salir.
     */
    private static void menu() {
        // Muestra las opciones del menú
        System.out.println("*** BIENVENIDO A LA APP DE GESTIÓN DE ALMACENAMIENTO ***\n" +
                "1. Añadir Herramienta.\n" +
                "2. Añadir Contenedor.\n" +
                "3. Añadir Inventario de Herramientas.\n" +
                "4. Mostrar Herramientas.\n" +
                "5. Mostrar Contenedor.\n" +
                "6. Mostrar Inventario por Contenedor.\n" +
                "7. Mostrar Inventario total de Herramientas.\n" +
                "8. Salir.");
    }

}

