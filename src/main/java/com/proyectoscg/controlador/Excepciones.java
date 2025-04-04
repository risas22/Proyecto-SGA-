package controlador;

public class Excepciones extends  Exception{
    private int codigo;
    private String mensajeError;

    public Excepciones(int codigoError) {
        this.codigo = codigoError;
        this.mensajeError = getMensajeError(codigo);
    }

  

    public String getMensajeError(int codigoError) {
        switch(codigoError) {
            case 1:
                return "ERROR: No pueden haber dos herramientas con el mismo código.";

            case 2:
                return "ERROR: No pueden haber dos contenedores con el mismo código.";

            case 3:
                return "ERROR: No existe una herramienta con este código. ";

            case 4:
                return "ERROR: No existe un contenedor con este código.";

            case 5:
                return "ERROR: No hay suficiente espacio en este contenedor.";

            case 6:
                return "ERROR: Esta herramienta es grande y no va en contenedores.";

            case 7:
                return "ERROR: No hay ningún contenedor con suficiente espacio.";
                
            case 8:
                return "ERROR: El formato de caracteres para el código de la herramienta no es el adecuado";

            default:
                return"Error desconocido.";
        }

    }
    public String getMessage() {
        return mensajeError;
    }
}
