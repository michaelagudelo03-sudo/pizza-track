public class Pizza {
    private String nombre;
    private String[] ingredientes;

    public Pizza(String nombre, String ing1, String ing2, String ing3) {
        this.nombre = nombre;
        // Arreglo de tamaño fijo (3) según los requerimientos
        this.ingredientes = new String[]{ing1, ing2, ing3};
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: [" + ingredientes[0] + ", " + 
               ingredientes[1] + ", " + ingredientes[2] + "]";
    }
}