import DAO.GrupoDAO;
import DTO.GrupoDTO;
import java.util.List;
import java.util.Scanner;

public class Grupo {
  private static final Scanner sc = new Scanner(System.in);
    private static final GrupoDAO grupoDAO = new GrupoDAO();

    public static void main(String[] args) throws Exception {


        int opcion = 0;

        while (opcion != 6) {
            MenuGrupo();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> CrearGrupo();
                case 2 -> ListarGrupo();
                case 3 -> ModificarGrupo();
                case 4 -> EliminarGrupo();
                case 5 -> VerContactosGrupo();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }

    public static void MenuGrupo() {
        System.out.println("\n--- Menú de Grupos ---");
        System.out.println("1. Crear grupo");
        System.out.println("2. Listar grupos");
        System.out.println("3. Modificar grupos");
        System.out.println("4. Eliminar grupos");
        System.out.println("5. Ver contactos del grupo");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void CrearGrupo(){
    System.out.print("Introduce nombre: ");
        String nombre = sc.nextLine();
      
        GrupoDTO nuevo = new GrupoDTO();
        nuevo.setNomeGrupo(nombre);
        
        GrupoDAO.CrearGrupo(nuevo);
        System.out.println("Grupo creado con ID: " + nuevo.getIdGrupo());
    }

    private static void ListarGrupo(){
        List<GrupoDTO> grupos = GrupoDAO.findAll();
        for(GrupoDTO grupo : grupos){
            System.out.println(grupo);
        }
    }
    private static void ModificarGrupo(){

    }

    private static void EliminarGrupo(){
 System.out.print("Introduce ID del grupo a borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        grupoDAO.EliminarGrupo(id);
        System.out.println("Grupo borrado si existía.");
    }
    
    private static void VerContactosGrupo(){

    }

    public int DameOpcionMenu() {
            MenuGrupo();
            int op = sc.nextInt();
            sc.nextLine();
            return op;
        }
}