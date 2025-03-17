package com.proyectoscg.persistence;
import com.proyectoscg.model.Contenedor;
import com.proyectoscg.model.Herramienta;
import com.proyectoscg.model.Inventario;

import java.io.*;
import java.util.ArrayList;

/**
 * @author KevinColl
 * @author KristinaLlamas
 * @author VictorMedina
 *
 * */
public class Persistencia {
    String nameFolder = "data";
    String herramientaFile = "herramientas.txt";     //nombre del nuevo fichero
    String contenedorFile = "contenedores.txt";
    String inventarioFile = "inventario.txt";//nombre de la nueva carpeta
    String rutaCarpeta;
    String rutaHerramienta;
    String rutaContenedor;
    String rutaInventario;

    /**
     * Constructor de la clase Persistencia que crea una carpeta y archivos necesarios si no existen.
     * Este constructor se encarga de inicializar las rutas de los archivos y crear la carpeta y los archivos
     * si no se encuentran presentes en el sistema de archivos.
     *
     * @throws IOException Si ocurre un error al crear los archivos o la carpeta.
     */
    public Persistencia() throws IOException {
        // Se inicializa la ruta completa de la carpeta donde se almacenarán los archivos
        rutaCarpeta = "." + File.separator + nameFolder;      // Ruta completa de la nueva carpeta
        rutaHerramienta = rutaCarpeta + File.separator + herramientaFile; // Se establece la ruta para el archivo de herramientas
        rutaContenedor = rutaCarpeta + File.separator + contenedorFile; // Se establece la ruta para el archivo de contenedores
        rutaInventario = rutaCarpeta + File.separator + inventarioFile;  // Se establece la ruta para el archivo de inventarios

        // Se crea un objeto File que representa la carpeta que contendrá los archivos
        File folder = new File(rutaCarpeta);      // folder: objeto para poder referenciar a la carpeta
        if (!folder.exists()) {            // Verifica si la carpeta no existe y, si es el caso, la crea
            folder.mkdir();                 // Crea la carpeta
        }
        File herramienta = new File(rutaHerramienta); // Se crea un objeto File que representa el archivo de herramientas
        if (!herramienta.exists()) { // Verifica si el archivo de herramientas no existe y, si es el caso, lo crea
            herramienta.createNewFile();    // Crea el archivo de herramientas
        }
        File contenedor = new File(rutaContenedor); // Se crea un objeto File que representa el archivo de contenedores
        if (!contenedor.exists()) { // Verifica si el archivo de contenedores no existe y, si es el caso, lo crea
            contenedor.createNewFile();    // Crea el archivo de contenedores
        }
        File inventario = new File(rutaInventario);  // Se crea un objeto File que representa el archivo de inventarios
        if (!inventario.exists()) { // Verifica si el archivo de inventarios no existe y, si es el caso, lo crea
            inventario.createNewFile();    // crea el archivo de inventarios
        }
    }

    /**
     * Escribe un objeto Herramienta en el archivo de herramientas.
     * El archivo de herramientas se abre en modo de adición para no sobrescribir los datos existentes.
     *
     * @param h El objeto Herramienta que se va a escribir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void writeHerramienta(Herramienta h) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaHerramienta, true));
        writer.write(h.getNombre() + "-" + h.getCodigoHerramienta() + "-" + h.isSmall());
        writer.newLine();
        writer.close();
    }

    /**
     * Escribe un objeto Contenedor en el archivo de contenedores.
     * El archivo de contenedores se abre en modo de adición para no sobrescribir los datos existentes.
     *
     * @param c El objeto Contenedor que se va a escribir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void writeContenedor(Contenedor c ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaContenedor, true));
        writer.write(c.getCodigoContenedor() + "-" + c.getCapacidadContenedor());
        writer.newLine();
        writer.close();
    }

    /**
     * Escribe un objeto Inventario asociado a un Contenedor en el archivo de inventarios.
     * El archivo de inventarios se abre en modo de adición para no sobrescribir los datos existentes.
     *
     * @param c El objeto Contenedor al que pertenece el inventario.
     * @param i El objeto Inventario que se va a escribir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void writeInventario(Contenedor c, Inventario i ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaInventario, true));
        writer.write(c.getCodigoContenedor() + "-" + i.getHerramienta().getCodigoHerramienta() + "-" + i.getCantidad());
        writer.newLine();
        writer.close();
    }

    /**
     * Reescribe el archivo de herramientas con los objetos Herramienta proporcionados.
     * El archivo se sobrescribe completamente y los datos anteriores se eliminan.
     *
     * @param herramientas Una lista de objetos Herramienta que se van a escribir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void reWriteHerramienta(ArrayList<Herramienta> herramientas) throws IOException {
        BufferedWriter reWriter = new BufferedWriter(new FileWriter(rutaHerramienta, false));
        for (Herramienta i : herramientas){
            writeHerramienta(i);
        }
        reWriter.close();
    }

    /**
     * Reescribe el archivo de contenedores con los objetos Contenedor proporcionados.
     * El archivo se sobrescribe completamente y los datos anteriores se eliminan.
     *
     * @param contenedores Una lista de objetos Contenedor que se van a escribir en el archivo.
     * @throws IOException Si ocurre un error al escribir en el archivo.
     */
    public void reWriteContenedor(ArrayList<Contenedor> contenedores) throws IOException {
        BufferedWriter reWriter = new BufferedWriter(new FileWriter(rutaContenedor, false));
        for (Contenedor i : contenedores){
            writeContenedor(i);
        }
        reWriter.close();
    }

    /**
     * Lee el archivo de herramientas y devuelve una lista de objetos de tipo Herramienta.
     * Cada línea del archivo contiene los datos de una herramienta, que se desglosan y se usan
     * para crear instancias de Herramienta.
     * @return Una lista de objetos Herramienta leídos desde el archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public ArrayList<Herramienta> readFicheroHerramienta() throws IOException {
        ArrayList<Herramienta> herramientas = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaHerramienta));
        String line;   //Variable que lee cada línea del fichero
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("-");      //Desglosamos los datos de la línea para crear un objeto Casa (lo separamos de la manera dentro del regex)
            String nombre = data[0];
            String codigoHerramienta = data[1];
            boolean isSmall = Boolean.parseBoolean(data[2]);
            Herramienta newHerramienta = new Herramienta(nombre, codigoHerramienta, isSmall);
            herramientas.add(newHerramienta);
        }
        reader.close();
        return herramientas;
    }

    /**
     * Lee el archivo de contenedores y devuelve una lista de objetos de tipo Contenedor.
     * Cada línea del archivo contiene los datos de un contenedor, que se desglosan y se usan
     * para crear instancias de Contenedor.
     *
     * @return Una lista de objetos Contenedor leídos desde el archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public ArrayList<Contenedor> readFicheroContenedor() throws IOException {
        ArrayList<Contenedor> contenedores = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(rutaContenedor));
        String line;   //Variable que lee cada línea del fichero
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("-");      //Desglosamos los datos de la línea para crear un objeto Casa (lo separamos de la manera dentro del regex)
            String codigoContenedor = data[0];
            int capacidadContenedor = Integer.parseInt(data[1]);
            Contenedor newContenedor = new Contenedor(codigoContenedor, capacidadContenedor);
            contenedores.add(newContenedor);
        }
        reader.close();
        return contenedores;
    }
}
