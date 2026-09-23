import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila pilaPrincipal = new Pila(); // Pila Undo
        Pila pilaSecundaria = new Pila(); // Pila Redo
        int opcion;

        do {
            System.out.println("\n--- PIZZA-TRACK: GESTIÓN DE PEDIDOS ---");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la pizza: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrediente 1: ");
                    String ing1 = scanner.nextLine();
                    System.out.print("Ingrediente 2: ");
                    String ing2 = scanner.nextLine();
                    System.out.print("Ingrediente 3: ");
                    String ing3 = scanner.nextLine();
                    
                    Pizza nuevaPizza = new Pizza(nombre, ing1, ing2, ing3);
                    pilaPrincipal.push(nuevaPizza);
                    // Al registrar un nuevo pedido, se limpia el historial de rehacer
                    pilaSecundaria = new Pila(); 
                    System.out.println("✅ Pedido registrado exitosamente.");
                    break;

                case 2: // Deshacer (Undo)
                    if (!pilaPrincipal.isEmpty()) {
                        Pizza pizzaDeshecha = pilaPrincipal.pop();
                        pilaSecundaria.push(pizzaDeshecha);
                        System.out.println("↩️ Acción deshecha. Se removió: " + pizzaDeshecha);
                    } else {
                        System.out.println("⚠️ No hay pedidos para deshacer.");
                    }
                    break;

                case 3: // Rehacer (Redo)
                    if (!pilaSecundaria.isEmpty()) {
                        Pizza pizzaRehecha = pilaSecundaria.pop();
                        pilaPrincipal.push(pizzaRehecha);
                        System.out.println("↪️ Acción rehecha. Se restauró: " + pizzaRehecha);
                    } else {
                        System.out.println("⚠️ No hay acciones para rehacer.");
                    }
                    break;

                case 4:
                    if (!pilaPrincipal.isEmpty()) {
                        System.out.println("🍕 Pedido actual en tope: " + pilaPrincipal.peek());
                    } else {
                        System.out.println("📭 La lista de pedidos está vacía.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}