package ZSFramework;

public class ZSException extends Exception{


    public static final String ROJO = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public ZSException(String e, String clase, String metodo){
        //grabar el log
        System.out.println("[ERROR EN ZSIABot para el LOG " + clase + "." + metodo + "]: " + e);
    }

    @Override
    public String getMessage(){
        return ROJO + "\n==============ERROR==============\n" +
               "Ha ocurrido un error en ZSIABot. Por favor, intente nuevamente.\n" +
               "=============================" + RESET + "\n";
    }
}
