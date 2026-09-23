public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    // Valida si la pila de pedidos se encuentra vacía
    public boolean isEmpty() {
        return tope == null;
    }

    // Inserta un objeto Pizza en el tope de la pila
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);
        // El puntero 'siguiente' del nuevo nodo apunta al nodo que actualmente es el tope
        nuevoNodo.siguiente = tope;
        // El nuevo nodo se convierte en el nuevo tope de la pila
        tope = nuevoNodo;
    }

    // Retira el objeto del tope y devuelve su contenido
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        Pizza pizzaRemovida = tope.pizza;
        // El tope se desplaza al siguiente nodo, eliminando la referencia al tope anterior
        tope = tope.siguiente;
        return pizzaRemovida;
    }

    // Visualiza la pizza en el tope sin retirarla de la lista
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.pizza;
    }
}