import java.util.Scanner;

public class Contacto {
    Scanner sc = new Scanner(System.in );
   

    public void MenuContact(){
       
        System.out.println("\n");
        System.out.println(" M E N Ú ");
        System.out.println("==========");
        System.out.println("1. Crear contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contactos");
        System.out.println("4. Modificar contacto");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. Ver a qué grupos pertenece");
        System.out.println("8. Crear grupo");
        System.out.println("9. Listar grupos");
        System.out.println("10. Modificar grupo");
        System.out.println("11. Eliminar grupo");
        System.out.println("12. Ver contactos de grupo");
        System.out.print("Elige una opción: ");
    }

        public int DameOpcionMenu() {
            MenuContact();
            int op = sc.nextInt();
            sc.nextLine();
            return op;
        }
    }

