package app.colas;

/**
 *
 * @author IrvinCG
 */
public class Colas {

    NodoC primero, ultimo;
    private int size;

    public Colas() {
        this.size = 0;
        primero = ultimo = null;
    }

    public void insert(int dato) {
        NodoC nuevo = new NodoC(dato);
        if (isEmpty()) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        size++;
    }

    public Object delete() {
        Object aux = null;
        if (!isEmpty()) {
            aux = primero.dato;
            primero = primero.siguiente;
            size--;
        }
        return aux;
    }

    public void verCola() {
        NodoC actual = primero;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        Colas cola = new Colas();
        System.out.println("Vacio: "+cola.isEmpty());
        cola.insert(1);
        cola.insert(2);
        cola.insert(3);
        cola.insert(4);
        cola.verCola();
        cola.delete();
        cola.verCola();
        System.out.println("Vacio: "+cola.isEmpty());
        System.out.println("Tamaño: "+cola.getSize());
        while(!cola.isEmpty())
            cola.delete();
        System.out.println("Vacio: "+cola.isEmpty());
        System.out.println("Tamaño: "+cola.getSize());
    }
}
