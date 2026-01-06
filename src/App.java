import DataAccess.ZSEstadoCivilDAO;
import DataAccess.ZSEtniaDAO;
import DataAccess.ZSSexoDAO;
import DataAccess.ZSTipoPersonaDAO;
import DataAccess.DTO.ZSEstadoCivilDTO;
import DataAccess.DTO.ZSEtniaDTO;
import DataAccess.DTO.ZSSexoDTO;
import DataAccess.DTO.ZSTipoPersonaDTO;

public class App {

    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static void main(String[] args) throws Exception {
        try{
            ZSTipoPersonaDAO zsTipoPersonaDAO = new ZSTipoPersonaDAO();
            ZSSexoDAO zsSexoDAO = new ZSSexoDAO();
            ZSEstadoCivilDAO zsEstadoCivilDAO = new ZSEstadoCivilDAO();
            ZSEtniaDAO zsEtniaDAO = new ZSEtniaDAO();
            


            System.out.println(VERDE + "Iniciando pruebas de acceso a datos..." + RESET);
            System.out.println("--------------------------------------------------");

            System.out.println(AMARILLO  + "Tipo Persona:" + RESET);
            for (ZSTipoPersonaDTO zsTipoPersona : zsTipoPersonaDAO.zsReadAll()) 
                System.out.println(zsTipoPersona);
            System.out.println("Total de registros en Tipo Persona: " + zsTipoPersonaDAO.getRowCount());

            System.out.println("--------------------------------------------------\n");

            System.out.println(AMARILLO + "Sexo" + RESET);
            for (ZSSexoDTO zsSexo : zsSexoDAO.zsReadAll()) 
                System.out.println(zsSexo.toString());
            System.out.println("Total de registros en Sexo: " + zsSexoDAO.getRowCount());


            
            System.out.println("--------------------------------------------------\n");

            System.out.println(AMARILLO + "Estado Civil" + RESET);
            for (ZSEstadoCivilDTO zsEstadoCivil : zsEstadoCivilDAO.zsReadAll()) 
                System.out.println(zsEstadoCivil.toString());
            System.out.println("Total de registros en Estado Civil: " + zsEstadoCivilDAO.getRowCount());

            System.out.println("--------------------------------------------------\n");


            System.out.println(AMARILLO + "Etnia" + RESET);
            for (ZSEtniaDTO zsEtnia : zsEtniaDAO.zsReadAll())
                System.out.println(zsEtnia.toString());
            System.out.println("Total de registros en Etnia: " + zsEtniaDAO.getRowCount());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
