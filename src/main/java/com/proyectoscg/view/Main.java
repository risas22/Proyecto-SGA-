package com.proyectoscg.view;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.model.HerramientaG;
import com.proyectoscg.model.HerramientaP;
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
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()) { // Verifica que existan herramientas y contenedores
            System.out.println("*** INVENTARIO GENERAL DE HERRAMIENTAS ***");
            for (Contenedor c : contenedores) { // Recorre todos los contenedores y muestra su inventario
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
        showContenedor(); // Muestra la lista de contenedores disponibles
        int codigoContenedor = preguntarIndexOffContenedor(); // Solicita el índice del contenedor al usuario
        if (codigoContenedor >= 0) { // Si el contenedor existe, muestra su inventario
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
        String codigoContenedor = AskData.askString("Introduzca el código del contenedor: "); // Solicita el código del contenedor al usuario
        int indexContenedor = contenedores.indexOf(new Contenedor(codigoContenedor));  // Busca el índice del contenedor en la lista
        if (indexContenedor < 0) { // Si el contenedor no existe, muestra un mensaje de error
            System.out.println("*** ERROR - ESTE CONTENEDOR NO EXISTE ***\n");
        }
        return indexContenedor; // Retorna el índice del contenedor (o -1 si no existe)
    }

    /**
     * Solicita al usuario el código de una herramienta y busca el índice de la herramienta en la lista de herramientas.
     * Si la herramienta con el código ingresado no existe en la lista, se muestra un mensaje de error.
     *
     * @return El índice de la herramienta en la lista de herramientas, o -1 si la herramienta no existe.
     */
    private static int preguntarIndexOffHerramienta() {
        String codigoHerramienta = AskData.askString("Introduzca el código de la herramienta que desea añadir al contenedor: "); // Solicita el código de la herramienta al usuario
        Herramienta herramientaBuscada = new HerramientaP("", codigoHerramienta);  // Creamos una herramienta de tipo genérico con el código proporcionado
        int indexHerramienta = herramientas.indexOf(herramientaBuscada); // Busca el índice de la herramienta en la lista
        if (indexHerramienta < 0) {   // Si la herramienta no existe, muestra un mensaje de error
            System.out.println("*** ERROR - ESTA HERRAMIENTA NO EXISTE ***\n");
        }
        return indexHerramienta; // Retorna el índice de la herramienta (o -1 si no existe)
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
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()) { // Verifica que existan herramientas y contenedores disponibles
            System.out.println("*** APARTADO DE AÑADIR HERRAMIENTAS A CONTENEDORES ***");
            int indexHerramienta = preguntarIndexOffHerramienta(); // Solicita el índice de la herramienta a añadir
            if (indexHerramienta >= 0) {  // Si se obtiene un índice válido
                Herramienta h = herramientas.get(indexHerramienta); // Obtiene la herramienta seleccionada

                // Verifica si h es una instancia de HerramientaP antes de llamar a isSmall()
                if (h instanceof HerramientaP) {
                    HerramientaP herramientaP = (HerramientaP) h;  // Cast a HerramientaP
                    if (!herramientaP.isSmall()) {    // Verifica si la herramienta es pequeña
                        System.out.println("*** ESTA HERRAMIENTA ES GRANDE Y NO VA EN CONTENEDORES ***\n");
                    } else {
                        int cantidadHerramienta = AskData.askInt("Introduzca la cantidad de unidades que quieras añadir: ",
                                "*** ERROR - TIENE QUE SER UNA CANTIDAD MÍNIMA DE 1 ***", 1);  // Solicita la cantidad de unidades a añadir
                        if (showContenedorDisponibles(cantidadHerramienta)) { // Verifica si existen contenedores con suficiente espacio para las unidades solicitadas
                            int indexContenedor = preguntarIndexOffContenedor();  // Solicita el índice del contenedor
                            if (indexContenedor >= 0) { // Si se obtiene un índice válido
                                Contenedor c = contenedores.get(indexContenedor);  // Obtiene el contenedor seleccionado
                                if (c.capacidadRestante() >= cantidadHerramienta) { // Verifica si el contenedor tiene suficiente espacio
                                    c.anadirHerramienta(h, cantidadHerramienta); // Añade las unidades de la herramienta al contenedor
                                    System.out.println("*** SE HAN AÑADIDO CORRECTAMENTE LAS UNIDADES AL CONTENEDOR ***\n");
                                } else {
                                    System.out.println("*** NO HAY SUFICIENTE ESPACIO EN ESTE CONTENEDOR ***\n");
                                }
                            }
                        } else {
                            System.out.println("*** NO HAY NINGÚN CONTENEDOR CON SUFICIENTE ESPACIO, PRUEBE A UBICAR MENOS UNIDADES  ***\n");
                        }
                    }
                } else {
                    System.out.println("*** ESTA HERRAMIENTA NO ES PEQUEÑA, NO PUEDE SER AÑADIDA A CONTENEDORES ***\n");
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
            System.out.println("*** LISTA DE CONTENEDORES ***");
            for (Contenedor c : contenedores) { // Recorre la lista de contenedores y muestra cada uno
                System.out.println(c);  // Se asume que la clase Contenedor tiene el metodo toString
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
        boolean disponible = false;  // Boleano para indicar si hay contenedores disponibles
        if (!isEmptyListContenedores()) {  // Verifica si la lista de contenedores no está vacía
            for (Contenedor c : contenedores) {   // Recorre la lista de contenedores y verifica si alguno tiene suficiente capacidad
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
        if (!isEmptyListHerramientas()) { // Llama al metodo isEmptyListHerramientas
            System.out.println("*** LISTA DE HERRAMIENTAS ***");
            for (Herramienta h : herramientas) { // Recorre la lista de herramientas y muestra cada una
                System.out.println(h);  // Se asume que la clase Herramienta tiene el metodo toString
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
        while (continuar) { // Bucle hasta que el usuario decida salir
            System.out.println("\n*** MENÚ DE AÑADIR CONTENEDOR A LA BASE DE DATOS *** \n 1.Añadir contenedor nuevo \n 2.Salir");
            int opcionContenedor = AskData.askInt("Elija una opción: ", "*** ERROR - INTRODUZCA UNA OPCIÓN VÁLIDA DEL MENÚ ***", 1, 2);

            if (opcionContenedor == 1) { // Se maneja la opción seleccionada
                String codigoContenedor = AskData.askString("Introduzca el código del contenedor: ");
                while (contenedores.contains(new Contenedor(codigoContenedor))) {   // Verifica que el código no exista ya en la lista de contenedores
                    System.out.println("*** ERROR - NO PUEDE HABER DOS CONTENEDORES CON EL MISMO CÓDIGO *** \n");
                    codigoContenedor = AskData.askString("Introduzca nuevamente el código del contenedor: ");
                }
                int capacidadContenedor = AskData.askInt("Introduzca la capacidad máxima de unidades pequeñas que se pueden guardar en este contenedor: ", "*** ERROR: EL NÚMERO DEBE SER SUPERIOR A 1 ***", 1);
                Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor); // Crea el nuevo contenedor y lo agrega a la lista
                contenedores.add(newContenedor);
                archivo.writeContenedor(newContenedor); // Guarda el contenedor en el archivo
                System.out.println("*** CONTENEDOR AÑADIDO CORRECTAMENTE *** \n");
            }
            else if (opcionContenedor == 2) {
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
        System.out.println("\n*** MENÚ DE AÑADIR HERRAMIENTA A LA BASE DE DATOS *** \n 1.Añadir herramienta nueva \n 2.Salir");
        int opcionHerramienta = AskData.askInt("Elija una opción: ", "*** ERROR - INTRODUZCA UNA OPCIÓN DEL MENÚ ***", 1, 2);
        switch(opcionHerramienta){ // Se maneja la opción seleccionada
            case 1:
                String codigoHerramienta = AskData.askString("Introduzca el código de la herramienta: ");
                Herramienta tempHerramienta = new HerramientaP("", codigoHerramienta); // Creamos una herramienta temporal solo con el código para comparar
                while (herramientas.contains(tempHerramienta)) {  // Verifica que el código no exista ya en la lista de herramientas
                    System.out.println("*** ERROR - NO PUEDE HABER DOS HERRAMIENTAS CON EL MISMO CÓDIGO *** \n");
                    codigoHerramienta = AskData.askString("Introduzca nuevamente el código de la nueva herramienta: ");
                    tempHerramienta = new HerramientaP("", codigoHerramienta);
                }
                String nombre = AskData.askString("Introduzca el nombre de la herramienta: ");
                boolean isSmall = AskData.askBoolean("¿Es una herramienta pequeña, de ser así se guardará en contenedores (S/N)?: ", "*** ERROR - LA RESPUESTA DEBE SER S O N ***", "S", "N");
                Herramienta newHerramienta; // Se crea la nueva herramienta de acuerdo al tamaño
                if (isSmall) {
                    newHerramienta = new HerramientaP(nombre, codigoHerramienta);  // Si la herramienta es pequeña, instanciamos HerramientaP
                } else {
                    newHerramienta = new HerramientaG(nombre, codigoHerramienta);  // Si la herramienta es grande, instanciamos HerramientaG
                }
                if (herramientas.contains(newHerramienta)) { // Verifica que no exista otra herramienta con el mismo código en la lista
                    System.out.println("*** ERROR - YA EXISTE UNA HERRAMIENTA CON ESE CÓDIGO ***");
                } else {
                    herramientas.add(newHerramienta); // Agrega la herramienta a la lista
                    archivo.writeHerramienta(newHerramienta);  // Guarda la herramienta en el archivo
                    System.out.println("*** HERRAMIENTA AÑADIDA CORRECTAMENTE *** \n");
                }
                break;

            case 2:
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

