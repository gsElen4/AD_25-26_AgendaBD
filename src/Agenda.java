
import java.util.Scanner;



public class Agenda {
private static void MenuPrincipal(){
     System.out.println("\n--- Menú ---");
        System.out.println("1. Menú Contactos");
        System.out.println("2. Menú Grupos");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
}
  private static final Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    

    Grupo grupo = new Grupo();
    Contacto contacto = new Contacto();
    int opcion = 0;

    while(opcion !=6){
        MenuPrincipal();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> contacto.MenuContact();
                case 2 -> grupo.MenuGrupo();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
    }
}


 public int DameOpcion() {
        MenuPrincipal();
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

}
