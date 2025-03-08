package com.proyectoscg.view;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.persistence.Persistencia;
import java.io.IOException;
import java.util.ArrayList;


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
                opcion = AskData.askInt("Escoja una opción del menú: ", "ERROR: NÚMERO NO VÁLIDO: Tienes que escoger un número entre 1 y 8", 1, 8);
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
                        showHerramientas();
                        break;
                    case 5:
                        showContenedor();
                        break;
                    case 6:
                        showInventarioContenedor();
                        break;
                    case 7:
                        showInventarioAll();
                        break;
                    case 8:
                        System.out.println("*** GRACIAS POR UTILIZAR LA APLICACIÓN ***");
                        break;
                }
            } while (opcion != 8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void showInventarioAll(){
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()){
            System.out.println("*** INVENTARIO GENERAL DE HERRAMIENTAS ***");
            for (Contenedor c : contenedores) {
                System.out.println(c.mostrarInventario());
            }
        }
    }




    private static void showInventarioContenedor() {
        if (!isEmptyListContenedores()) {
            System.out.println("*** LISTA DE CONTENEDORES ***");
            showContenedor();
            int codigoContenedor = preguntarIndexOffContenedor();
            Contenedor c = contenedores.get(codigoContenedor);
            System.out.println(c.mostrarInventario());
        }
    }


    private static int preguntarIndexOffContenedor(){
        String codigoContenedor = AskData.askString("Dime el código del contenedor : " );
        int indexContenedor = contenedores.indexOf(new Contenedor(codigoContenedor));
        if (indexContenedor < 0 ){
            System.out.println("*** ERROR: ESTE CONTENEDOR NO EXISTE ***\n");
        }
        return indexContenedor;
    }

    private static int preguntarIndexOffHerramienta(){
        String codigoHerramienta = AskData.askString("Dime el código de la herramienta que desea añadir al contenedor: ");
        int indexHerramienta = herramientas.indexOf(new Herramienta(codigoHerramienta));
        if (indexHerramienta < 0 ){
            System.out.println("*** ERROR: ESTA HERRAMIENTA NO EXISTE ***\n");
        }
        return indexHerramienta;
    }

    private static void addInventario(){
        if (!isEmptyListHerramientas() && !isEmptyListContenedores()){
            System.out.println("*** APARTADO DE AÑADIR HERRAMIENTAS A CONTENEDORES ***");
            int indexHerramienta = preguntarIndexOffHerramienta();
            if (indexHerramienta >= 0 ){
                Herramienta h = herramientas.get(indexHerramienta);
                if (!h.isSmall()){
                    System.out.println("*** ESTA HERRAMIENTA ES GRANDE Y NO VA EN CONTENEDORES ***\n");
                }
                else{
                    int cantidadHerramienta = AskData.askInt("Dime la cantidad de unidades que quieras añadir: ","ERROR: TIENE QUE SER UNA CANTIDAD MÍNIMA DE 1",1);
                    if(showContenedorDisponibles(cantidadHerramienta)){
                        int indexContenedor = preguntarIndexOffContenedor();
                        if (indexContenedor >= 0) {
                            Contenedor c = contenedores.get(indexContenedor);
                            if (c.capacidadRestante() >= cantidadHerramienta) {
                                c.anadirHerramienta(h, cantidadHerramienta);


                                System.out.println("*** SE HAN AÑADIDO CORRECTAMENTE LAS UNIDADES AL CONTENEDOR ***\n");
                            }
                            else{
                                System.out.println("*** NO HAY SUFICIENTE ESPACIO EN ESTE CONTENEDOR ***\n");
                            }
                        }
                    }
                    else{
                        System.out.println("*** NO HAY NINGÚN CONTENEDOR CON SUFICIENTE ESPACIO, PRUEBE A UBICAR MENOS UNIDADES  ***\n");
                    }



                }

            }

        }


    }

    private static void showContenedor() {
        if (!isEmptyListContenedores()) { // Si la lista de contenedores está vacía
            System.out.println("*** LISTA DE CONTENEDORES ***");
            for (Contenedor c : contenedores) {
                System.out.println(c); // Llama a toString() de cada contenedor

            }
        }
    }

    private static boolean showContenedorDisponibles(int cantidadDeHerramientas) {
        boolean disponible = false;
        if (!isEmptyListContenedores()) { // Si la lista de contenedores está vacía
            for (Contenedor c : contenedores) {
                if (c.capacidadRestante() >= cantidadDeHerramientas) {
                    System.out.println("*** LISTA DE CONTENEDORES DISPONIBLES ***");
                    System.out.println(c);    // Llama a toString() de cada contenedor
                     disponible = true;
                }

            }
        }return disponible;
    }


    private static void showHerramientas() {
        if (!isEmptyListHerramientas()) {
            System.out.println("*** LISTA DE HERRAMIENTAS ***");
            for (Herramienta h : herramientas) {
                System.out.println(h);// Aquí cambiamos listaHerramientas por herramientas
            }
        }
    }



    private static boolean isEmptyListHerramientas() {
        if (herramientas.isEmpty()) {
            System.out.println("*** NO EXISTE NINGUNA HERRAMIENTA CREADA, PORFAVOR CREE ANTES UNA NUEVA *** \n");
            return true;
        }
        return false;
    }

    private static boolean isEmptyListContenedores() {
        if (contenedores.isEmpty()) {
            System.out.println("*** NO EXISTE NINGÚN CONTENEDOR CREADO, PORFAVOR CREE ANTES UNO NUEVO *** \n");
            return true;
        }
        return false;
    }



    private static void addContenedor() throws IOException {
        System.out.println("\n*** MENÚ DE AÑADIR CONTENEDOR A LA BASE DE DATOS *** \n 1.Añadir contenedor nuevo \n 2.Salir");
        int opcionContenedor = AskData.askInt("Elija una opción: ", "ERROR: INTRODUZCA UNA OPCIÓN VÁLIDA ENTRE 1 y 2", 1, 2);
        switch(opcionContenedor) {
            case 1:
                String codigoContenedor  = AskData.askString("Código para el contenedor nuevo: ");
                while (contenedores.contains(new Contenedor(codigoContenedor))) {
                    System.out.println("*** ERROR: NO PUEDE HABER DOS CONTENEDORES CON EL MISMO CÓDIGO *** \n");
                    codigoContenedor = AskData.askString("Código correcto para el contenedor: ");
                }
                // Pedir el resto de los datos solo si el código es válido
                int capacidadContenedor = AskData.askInt("Dime la capacidad máxima de unidades pequeñas que se pueden guardar en este contenedor: ", "ERROR: EL NÚMERO DEBE SER SUPERIOR A 1", 1);
                Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);    // Crear el nuevo contenedor (objeto) y agregarlo a la lista
                contenedores.add(newContenedor);
                archivo.writeContenedor(newContenedor);
                System.out.println("*** CONTENEDOR AÑADIDO CORRECTAMENTE *** \n");
                break;

            case 2:
                System.out.println("*** VOLVIENDO AL MENÚ *** \n");
                break;

        }
    }



    private static void addHerramienta() throws IOException {
        System.out.println("\n*** MENÚ DE AÑADIR HERRAMIENTA A LA BASE DE DATOS *** \n 1.Añadir herramienta nueva \n 2.Salir");
        int opcionHerramienta = AskData.askInt("Elija una opción: ", "ERROR: INTRODUZCA UNA OPCIÓN VÁLIDA ENTRE 1 y 2.", 1, 2);
        switch(opcionHerramienta){
            case 1:
                String codigoHerramienta = AskData.askString("Código para la herramienta nueva: ");
                while (herramientas.contains(new Herramienta(codigoHerramienta))) {
                    System.out.println("*** ERROR: NO PUEDE HABER DOS HERRAMIENTAS CON EL MISMO CÓDIGO *** \n");
                    codigoHerramienta = AskData.askString("Código correcto para la herramienta: ");
                }
                // Pedir el resto de los datos solo si el código es válido
                String nombre = AskData.askString("Nombre de la herramienta: ");
                boolean isSmall = AskData.askBoolean("¿Es una herramienta pequeña, de ser así se guardará en contenedores (S/N)?: ", "ERROR: LA RESPUESTA DEBE SER S O N", "S", "N");
                Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta,isSmall);   // Crear la nueva herramienta y agregarla a la lista
                herramientas.add(newHerramienta);
                archivo.writeHerramienta(newHerramienta);

                System.out.println("*** HERRAMIENTA AÑADIDA CORRECTAMENTE *** \n");
                break;
            case 2:
                System.out.println("*** VOLVIENDO AL MENÚ ***\n");
                break;
        }

    }






    private static void menu() {        //menu output
        System.out.println("*** BIENVENIDO A LA APP DE GESTIÓN DE ALMACENAMIENTO ***\n" +
                "1. Añadir Herramienta.\n" +
                "2. Añadir Contenedor.\n" +
                "3. Añadir Inventario de Herramientas.\n" +
                "4. Mostrar Herramientas.\n" +
                "5. Mostrar Contenedor.\n" +
                "6. Mostrar Inventario por Contenedor.\n" +
                "7. Mostrar Inventario total de Herramientas.\n" +
                "8. Sortir.");


    }
}

