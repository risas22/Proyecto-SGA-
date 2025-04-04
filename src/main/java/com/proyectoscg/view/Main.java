package com.proyectoscg.view;

public class Main {

    private static JFramePrincipal view;

    public static void main(String[] args) {
        view = new JFramePrincipal();
        view.setVisible(true);

////            archivo = new Persistencia();
////            herramientas = archivo.readFicheroHerramienta();
////            contenedores = archivo.readFicheroContenedor();
//            int opcion;
//            do {
//                    menu();
//                    opcion = AskData.askInt("Escoja una opción del menú: ", "ERROR: NÚMERO NO VÁLIDO: Tienes que escoger un número entre 1 y 8", 1, 8);
//                try {
//                    switch (opcion) {
//                        case 1:
//                            createHerramienta();
//                            break;
//                        case 2:
//                            createContenedor();
//                            break;
//                        case 3:
//                            addInventario();
//                            break;
//                        case 4:
//                            showHerramientas();
//                            break;
//                        case 5:
//                            showContenedor();
//                            break;
//                        case 6:
//                            showInventarioContenedor();
//                            break;
//                        case 7:
//                            showInventarioAll();
//                            break;
//                        case 8:
//                            System.out.println("*** GRACIAS POR UTILIZAR LA APLICACIÓN ***");
//                            break;
//                    }
//                } catch (Excepciones ex) {
//                    System.out.println(ex.getMessage());
//                }
//            } while (opcion != 8);
//
//    }
//
//    private static void showInventarioAll(){
//        if (!isEmptyListHerramientas() && !isEmptyListContenedores()){
//            System.out.println("*** INVENTARIO GENERAL DE HERRAMIENTAS ***");
//            for (Contenedor c : contenedores.values()) {
//                System.out.println(c.mostrarInventario());
//            }
//        }
//    }
//
//
//
//
//    private static void showInventarioContenedor() throws Excepciones {
//        showContenedor();
//        String codigoContenedor = AskData.askString("Dime el código del contenedor : " );
//        if (contenedores.containsKey(codigoContenedor)){
//            Contenedor c = contenedores.get(codigoContenedor);
//            System.out.println(c.mostrarInventario());
//        }
//        else{
//            throw new Excepciones(4);
//        }
//
//
//    }
//
//    private static void addInventario() throws Excepciones {
//        if (!isEmptyListHerramientas() && !isEmptyListContenedores()){
//            System.out.println("*** APARTADO DE AÑADIR HERRAMIENTAS A CONTENEDORES ***");
//            String codigoHerramienta = AskData.askString("Dime el código de la herramienta que desea añadir al contenedor: ");
//            if (herramientas.containsKey(codigoHerramienta) ){
//                Herramienta h = herramientas.get(codigoHerramienta);
//                if (!h.isSmall()){
//                    throw new Excepciones(6);
//                }
//                else{
//                    int cantidadHerramienta = AskData.askInt("Dime la cantidad de unidades que quieras añadir: ","ERROR: TIENE QUE SER UNA CANTIDAD MÍNIMA DE 1",1);
//                    if(showContenedorDisponibles(cantidadHerramienta)){
//                        String codigoContenedor = AskData.askString("Dime el código del contenedor : " );
//                        if (contenedores.containsKey(codigoContenedor)){
//                            Contenedor c = contenedores.get(codigoContenedor);
//                            if (c.capacidadRestante() >= cantidadHerramienta) {
//                                c.anadirHerramienta(h,cantidadHerramienta);
//                                System.out.println("*** SE HAN AÑADIDO CORRECTAMENTE LAS UNIDADES AL CONTENEDOR ***\n");
//                            }
//                            else{
//                                throw new Excepciones(5);
//                            }
//                        }
//                        else {
//                            throw new Excepciones(4);
//                        }
//                    }
//                    else{
//                        throw new Excepciones(7);
//                    }
//                }
//            }else{
//                throw new Excepciones(3);
//            }
//
//        }
//
//
//    }
//
//    private static void showContenedor() {
//        if (!isEmptyListContenedores()) { // Si la lista de contenedores está vacía
//            System.out.println("*** LISTA DE CONTENEDORES ***");
//            for (Contenedor c : contenedores.values()) {
//                System.out.println(c); // Llama a toString() de cada contenedor
//
//            }
//        }
//    }
//
//    private static boolean showContenedorDisponibles(int cantidadDeHerramientas) {
//        boolean disponible = false;
//        if (!isEmptyListContenedores()) { // Si la lista de contenedores está vacía
//            for (Contenedor c : contenedores.values()) {
//                if (c.capacidadRestante() >= cantidadDeHerramientas) {
//                    System.out.println("*** CONTENEDORES DISPONIBLES ***");
//                    System.out.println(c);    // Llama a toString() de cada contenedor
//                     disponible = true;
//                }
//
//            }
//        }return disponible;
//    }
//
//
//    private static void showHerramientas() {
//        if (!isEmptyListHerramientas()) {
//            System.out.println("*** LISTA DE HERRAMIENTAS ***");
//            for (Herramienta h : herramientas.values()) {
//                System.out.println(h);
//            }
//        }
//    }
//
//
//
//    private static boolean isEmptyListHerramientas() {
//        if (herramientas.isEmpty()) {
//            System.out.println("*** NO EXISTE NINGUNA HERRAMIENTA CREADA, PORFAVOR CREE ANTES UNA NUEVA *** \n");
//            return true;
//        }
//        return false;
//    }
//
//    private static boolean isEmptyListContenedores() {
//        if (contenedores.isEmpty()) {
//            System.out.println("*** NO EXISTE NINGÚN CONTENEDOR CREADO, PORFAVOR CREE ANTES UNO NUEVO *** \n");
//            return true;
//        }
//        return false;
//    }
//
//
//
//    private static void createContenedor() throws Excepciones {
//        System.out.println("\n*** MENÚ DE AÑADIR CONTENEDOR A LA BASE DE DATOS *** \n 1.Añadir contenedor nuevo \n 2.Salir");
//        int opcionContenedor = AskData.askInt("Elija una opción: ", "ERROR: INTRODUZCA UNA OPCIÓN VÁLIDA ENTRE 1 y 2", 1, 2);
//        switch(opcionContenedor) {
//            case 1:
//                String codigoContenedor  = AskData.askString("Código para el contenedor nuevo: ");
//                if (contenedores.containsKey(codigoContenedor)) {
//                    throw new Excepciones(2);
//                }
//                else {
//                    int capacidadContenedor = AskData.askInt("Dime la capacidad máxima de unidades pequeñas que se pueden guardar en este contenedor: ", "ERROR: EL NÚMERO DEBE SER SUPERIOR A 1", 1);
//                    Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);    // Crear el nuevo contenedor (objeto) y agregarlo a la lista
//                    contenedores.put(codigoContenedor, newContenedor);
////                  archivo.writeContenedor(newContenedor);
//                    System.out.println("*** CONTENEDOR AÑADIDO CORRECTAMENTE *** \n");
//                    break;
//                }
//            case 2:
//                System.out.println("*** VOLVIENDO AL MENÚ *** \n");
//                break;
//
//        }
//    }
//
//
//
//    private static void createHerramienta() throws Excepciones {
//        System.out.println("\n*** MENÚ DE AÑADIR HERRAMIENTA A LA BASE DE DATOS *** \n 1.Añadir herramienta nueva \n 2.Salir");
//        int opcionHerramienta = AskData.askInt("Elija una opción: ", "ERROR: INTRODUZCA UNA OPCIÓN VÁLIDA ENTRE 1 y 2.", 1, 2);
//        switch(opcionHerramienta){
//            case 1:
//                String codigoHerramienta = AskData.askString("Código para la herramienta nueva: ");
//                if (herramientas.containsKey(codigoHerramienta)) {
//                    throw new Excepciones(1);
//                }
//                    String nombre = AskData.askString("Nombre de la herramienta: ");
//                    boolean isSmall = AskData.askBoolean("¿Es una herramienta pequeña, de ser así se guardará en contenedores (S/N)?: ", "ERROR: LA RESPUESTA DEBE SER S O N", "S", "N");
//                    Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta,isSmall);
//                    herramientas.put(codigoHerramienta, newHerramienta);
////                  archivo.writeHerramienta(newHerramienta);
//                    System.out.println("*** HERRAMIENTA AÑADIDA CORRECTAMENTE *** \n");
//                break;
//
//            case 2:
//                System.out.println("*** VOLVIENDO AL MENÚ ***\n");
//                break;
//        }
//
//    }
//
//
//
//
//
//
//    private static void menu() {        //menu output
//        System.out.println("*** BIENVENIDO A LA APP DE GESTIÓN DE ALMACENAMIENTO ***\n" +
//                "1. Añadir Herramienta.\n" +
//                "2. Añadir Contenedor.\n" +
//                "3. Añadir Inventario de Herramientas.\n" +
//                "4. Mostrar Herramientas.\n" +
//                "5. Mostrar Contenedor.\n" +
//                "6. Mostrar Inventario por Contenedor.\n" +
//                "7. Mostrar Inventario total de Herramientas.\n" +
//                "8. Sortir.");
//
//
    }

}
