import DataAccess.ZSEstadoCivilDAO;
import DataAccess.ZSSexoDAO;
import DataAccess.DTO.ZSEstadoCivilDTO;
import DataAccess.DTO.ZSSexoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            ZSSexoDAO zsSexoDAO = new ZSSexoDAO();
            ZSEstadoCivilDAO zsEstadoCivilDAO = new ZSEstadoCivilDAO();


            System.out.println("Sexo");
            for (ZSSexoDTO zsSexo : zsSexoDAO.zsReadAll()) 
                System.out.println(zsSexo.toString());
            System.out.println("Total de registros en Sexo: " + zsSexoDAO.getRowCount());


            System.out.println("--------------------------------------------------");


            System.out.println("Estado Civil");
            for (ZSEstadoCivilDTO zsEstadoCivil : zsEstadoCivilDAO.zsReadAll()) 
                System.out.println(zsEstadoCivil.toString());
            System.out.println("Total de registros en Estado Civil: " + zsEstadoCivilDAO.getRowCount());
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
