package com.proyectoscg.persistence;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Persistencia {
    String nameFolder = "data";
    String herramientaFile = "herramientas.txt";     //nombre del nuevo fichero
    String contenedorFile = "contenedores.txt";
    String inventarioFile = "inventario.txt";//nombre de la nueva carpeta
    String rutaCarpeta;
    String rutaHerramienta;
    String rutaContenedor;
    String rutaInventario;

    // Constructor que crea la carpeta y el fichero en caso de que no existan
    public Persistencia() throws IOException {
        rutaCarpeta = "." + File.separator + nameFolder;      //ruta completa de la nueva carpeta
        rutaHerramienta = rutaCarpeta + File.separator + herramientaFile;
        rutaContenedor = rutaCarpeta + File.separator + contenedorFile;
        rutaInventario = rutaCarpeta + File.separator + inventarioFile;

        File folder = new File(rutaCarpeta);      //folder: objeto para poder referenciar a la carpeta
        if (!folder.exists()) {            //si la carpeta no existe, la creamos
            folder.mkdir();
        }

        File herramienta = new File(rutaHerramienta);
        if (!herramienta.exists()) {
            herramienta.createNewFile();
        }
        File contenedor = new File(rutaContenedor);
        if (!contenedor.exists()) {
            contenedor.createNewFile();
        }
        File inventario = new File(rutaInventario);
        if (!inventario.exists()) {
            inventario.createNewFile();
        }


    }

    //  Crear metodo para escribir en el fichero
    public void writeHerramienta(Herramienta h) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaHerramienta, true));
        writer.write(h.getNombre() + "-" + h.getCodigoHerramienta() + "-" + h.isSmall());
        writer.newLine();
        writer.close();
    }

    public void writeContenedor(Contenedor c ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaContenedor, true));
        writer.write(c.getCodigoContenedor() + "-" + c.getCapacidadContenedor() + "-" + c.getCapacidadUtilizada());
        writer.newLine();
        writer.close();
    }

    public void writeInventario(Contenedor c) throws IOException {       //método a revisar
        HashMap<Herramienta, Integer> inventario = c.getInventario();     // Obtenemos el inventario del contenedor (HashMap)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaInventario, true))) {    // Usamos un BufferedWriter con try-with-resources para asegurar el cierre automático


            for (Herramienta herramienta : inventario.keySet()) {   // Recorremos el inventario del contenedor
                int cantidad = inventario.get(herramienta);     // Obtenemos la cantidad de la herramienta en el contenedor
                writer.write(c.getCodigoContenedor() + "-" + herramienta.getCodigoHerramienta() + "-" + cantidad);    // Escribimos en el archivo con el formato: codigoContenedor-herramienta-cantidad
                writer.newLine(); // Salto de línea
            }
        } catch (IOException ex) {
            // Manejo de excepciones
            System.out.println("Error al escribir el inventario: " + ex.getMessage());
        }
    }      //método a revisar




    public void reWriteHerramienta(ArrayList<Herramienta> herramientas) throws IOException {
        BufferedWriter reWriter = new BufferedWriter(new FileWriter(rutaHerramienta, false));
        for (Herramienta i : herramientas){
            writeHerramienta(i);
        }
        reWriter.close();
    }

    public void reWriteContenedor(ArrayList<Contenedor> contenedores) throws IOException {         //método a revisar
        BufferedWriter reWriter = new BufferedWriter(new FileWriter(rutaContenedor, false));
        for (Contenedor i : contenedores){
            writeContenedor(i);
        }
        reWriter.close();
    }  //método a revisar

    // Crear metodo para leer el fichero
    public ArrayList<Herramienta> readFicheroHerramienta() throws IOException {
        ArrayList<Herramienta> herramientas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaHerramienta));
        String line;   //variable que lee cada línea del fichero
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("-");      //desglosamos los datos de la línea para crear un objeto Casa (lo separamos de la manera dentro del regex)
            String nombre = data[0];
            String codigoHerramienta = data[1];
            boolean isSmall = Boolean.parseBoolean(data[2]);
            Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta, isSmall);
            herramientas.add(newHerramienta);
        }
        reader.close();
        return herramientas;
    }

    public ArrayList<Contenedor> readFicheroContenedor() throws IOException {
        ArrayList<Contenedor> contenedores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaContenedor));
        String line;   //variable que lee cada línea del fichero
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("-");      //desglosamos los datos de la línea para crear un objeto Casa (lo separamos de la manera dentro del regex)
            String codigoContenedor = data[0];
            int capacidadContenedor = Integer.parseInt(data[1]);
            int capacidadUtilizada = Integer.parseInt(data[2]);
            Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor, capacidadUtilizada);
            contenedores.add(newContenedor);
        }
        reader.close();
        return contenedores;
    }

//        reader = new BufferedReader(new FileReader(rutaPlaca));
//        while ((line = reader.readLine()) != null) {
//            String[] data = line.split("-");    //desglosamos los datos de la línea para crear un objeto Casa (lo separamos de la manera dentro del regex)
//            String nif = data[0];
//            int surface = Integer.parseInt(data[1]);
//            double price = Double.parseDouble(data[2]);
//            int powerPlaca = Integer.parseInt(data[3]);
//            Placa newPlaca = new Placa (surface, price , powerPlaca);
//            int posicionCasa = casas.indexOf(new Casa(nif));
//            System.out.println(nif);
//            System.out.println(posicionCasa);
//            Casa c = casas.get(posicionCasa);
//            c.anadirPlaca_Lista(newPlaca);
//
//        }
//        reader.close();
//
//        reader = new BufferedReader(new FileReader(rutaElectro));
//        while((line = reader.readLine()) != null){
//            String [] data = line.split("-");
//            String nif = data[0];
//            String description = data[1];
//            int powerElectro = Integer.parseInt(data[2]);
//            boolean interruptorElectros = Boolean.parseBoolean(data[3]);
//            Electrodomesticos newElectro = new Electrodomesticos (description,powerElectro,interruptorElectros);
//            int posicionCasa = casas.indexOf(new Casa(nif));
//
//            Casa c = casas.get(posicionCasa);
//            c.anadirElectro_Lista(newElectro);
//
//        }
//        reader.close();
//
//        return casas;   //devolvemos solo la lista (casas) para sacarla en el main para que pueda leer que hemos creado al principio del metodo cuando creamos la lista
//    }

}
