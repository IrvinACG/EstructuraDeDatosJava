package app.pilas;

/**
 *
 * @author IrvinCG
 */
public class Pila {

    private NodoP ultimo;
    private int tam;

    public Pila() {
        tam = 0;
        this.ultimo = null;
    }

    public void push(Object dato) {
        NodoP nuevo = new NodoP(dato);
        nuevo.siguiente = ultimo;
        ultimo = nuevo;
        tam++;
    }
    public Object pop() {
        Object aux=null;
        if (!isEmpty()) {
            aux=ultimo.dato;
            ultimo = ultimo.siguiente;
            tam--;
        }
        return aux;
    }
    
    public void clear(){
        while(!isEmpty())
            pop();
    }
    
    public Object peek(){
        return ultimo.dato;
    }
    public int size(){
        return tam;
    }
    public boolean isEmpty() {
        return tam == 0;
    }

    public void verPila() {
        NodoP actual = ultimo;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.push(1);
        pila.push("Letras");
        pila.push(3.5);
        pila.verPila();
        System.out.println("Es vacia: "+pila.isEmpty());
        System.out.println("Ultimo: "+pila.peek());
        pila.pop();
        pila.verPila();
        pila.clear();
        System.out.println("Es vacia: "+pila.isEmpty());
    }

}
