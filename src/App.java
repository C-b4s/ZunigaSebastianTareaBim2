import ZSBusinessLogic.ZSEstadoCivilBL;
import ZSBusinessLogic.ZSEtniaBL;
import ZSBusinessLogic.ZSSexoBL;
import ZSBusinessLogic.ZSTipoPersonaBL;
import ZSDataAccess.ZSDTO.ZSEstadoCivilDTO;
import ZSDataAccess.ZSDTO.ZSEtniaDTO;
import ZSDataAccess.ZSDTO.ZSSexoDTO;
import ZSDataAccess.ZSDTO.ZSTipoPersonaDTO;
import ZSGraphicUserInterface.ZSForm.ZSSplashScreenForm;

public class App {

    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static void main(String[] args) throws Exception {
        // Testing DAO try{
        //     ZSTipoPersonaDAO zsTipoPersonaDAO = new ZSTipoPersonaDAO();
        //     ZSSexoDAO zsSexoDAO = new ZSSexoDAO();
        //     ZSEstadoCivilDAO zsEstadoCivilDAO = new ZSEstadoCivilDAO();
        //     ZSEtniaDAO zsEtniaDAO = new ZSEtniaDAO();
            


        //     System.out.println(VERDE + "Iniciando pruebas de acceso a datos..." + RESET);
        //     System.out.println("--------------------------------------------------");

        //     System.out.println(AMARILLO  + "Tipo Persona:" + RESET);
        //     for (ZSTipoPersonaDTO zsTipoPersona : zsTipoPersonaDAO.zsReadAll()) 
        //         System.out.println(zsTipoPersona);
        //     System.out.println("Total de registros en Tipo Persona: " + zsTipoPersonaDAO.zsGetRowCount());

        //     System.out.println("--------------------------------------------------\n");

        //     System.out.println(AMARILLO + "Sexo" + RESET);
        //     for (ZSSexoDTO zsSexo : zsSexoDAO.zsReadAll()) 
        //         System.out.println(zsSexo.toString());
        //     System.out.println("Total de registros en Sexo: " + zsSexoDAO.zsGetRowCount());


            
        //     System.out.println("--------------------------------------------------\n");

        //     System.out.println(AMARILLO + "Estado Civil" + RESET);
        //     for (ZSEstadoCivilDTO zsEstadoCivil : zsEstadoCivilDAO.zsReadAll()) 
        //         System.out.println(zsEstadoCivil.toString());
        //     System.out.println("Total de registros en Estado Civil: " + zsEstadoCivilDAO.zsGetRowCount());

        //     System.out.println("--------------------------------------------------\n");


        //     System.out.println(AMARILLO + "Etnia" + RESET);
        //     for (ZSEtniaDTO zsEtnia : zsEtniaDAO.zsReadAll())
        //         System.out.println(zsEtnia.toString());
        //     System.out.println("Total de registros en Etnia: " + zsEtniaDAO.etRowCount());
            
        // }catch (Exception e){
        //     System.out.println(e.getMessage());
        // }

        //Testing BL
        // try{
                      
        //     ZSTipoPersonaBL zsTipoPersona = new ZSTipoPersonaBL();
        //     for (ZSTipoPersonaDTO zsTp : zsTipoPersona.zsGetAll()) 
        //         System.out.println(zsTp.toString());

        //      ZSSexoBL zsSexo = new ZSSexoBL();
        //     for (ZSSexoDTO zsSexoDTO : zsSexo.zsGetAll()) 
        //         System.out.println(zsSexoDTO.toString());

        //     ZSEstadoCivilBL zsEstadoCivil = new ZSEstadoCivilBL();
        //     for (ZSEstadoCivilDTO zsEc : zsEstadoCivil.zsGetAll())
        //         System.out.println(zsEc.toString());

        //     ZSEtniaBL zsEtnia = new ZSEtniaBL();
        //     for (ZSEtniaDTO zsEt : zsEtnia.zsGetAll())
        //         System.out.println(zsEt.toString());

        // }catch (Exception e){   
        //     throw e;
        // }

        ZSSplashScreenForm.show();


    }
}
