package applistas.dobleCircular;

/**
 *
 * @author IrvinCG
 */
public class ListaDobleEnlazadaCircular {

    private NodoDC primero, ultimo;
    private int tamanio;

    public ListaDobleEnlazadaCircular() {
        this.tamanio = 0;
        primero = ultimo = null;
    }

    public void insertar(int dato) {
        NodoDC nuevo = new NodoDC(dato);
        if (tamanio == 0) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.adelante = primero;
            nuevo.atras = ultimo;
        } else {
            nuevo.adelante = primero;
            nuevo.atras = ultimo;
            ultimo.adelante = nuevo;
            primero.atras = nuevo;
            ultimo = nuevo;
        }
        tamanio++;
    }

    public void insertarDespues(int pos, int dato) {
        NodoDC  actual, nuevo;
        actual = primero;
        int auxPos = 1;
        if (!esVacia()) {   //Default inserta primer nodo, aunque posicion no exista
            do {
                if ((pos == auxPos) && (pos <= tamanio)) {
                    nuevo = new NodoDC(dato);
                    if (auxPos == tamanio) {//Insertar al ultimo
                        nuevo.adelante = primero;
                        nuevo.atras = ultimo;
                        ultimo.adelante = nuevo;
                        primero.atras = nuevo;
                        ultimo = nuevo;
                    } else {  //Insertar Despues de
                        actual.adelante.atras=nuevo;
                        nuevo.adelante=actual.adelante;
                        nuevo.atras=actual;
                        actual.adelante=nuevo;
                    }
                    tamanio++;
                }
                actual = actual.adelante;
                auxPos++;
            } while (actual != primero);
        } else {  //Insertar Primer Nodo
            insertar(dato);
        }
    }

    public void borrar(int pos) {
        NodoDC anterior, actual;
        actual = primero;
        anterior = primero;
        int auxPos = 1;
        if (!esVacia()) { //Lista tiene Nodos
            do {
                if (pos == auxPos) {    //Encuentra Nodo en Posicion
                    if (actual == primero) {  //Nodo Primero
                        primero = primero.adelante;
                        ultimo.adelante = primero;
                        primero.atras = ultimo;
                    } else if (actual == ultimo) {  //Nodo ultimo
                        ultimo = anterior;
                        ultimo.adelante = primero;
                        primero.atras = ultimo;
                    } else {  //Nodo Intermedio
                        anterior.adelante = actual.adelante;
                        actual.adelante.atras = anterior;
                    }
                    tamanio--;
                }
                auxPos++;
                anterior = actual;
                actual = actual.adelante;
            } while (actual != primero);
            if (tamanio == 0) { //Lista Vacia
                primero = null;
                ultimo = null;
            }
        }
    }
    
    public int getDato(int pos){
        int valor=-1;
        int auxPos=1;
        NodoDC actual=primero;
        do{
            if(actual!=null)
                if(pos==auxPos)
                    valor=actual.dato;
            auxPos++;
            actual=actual.adelante;
        }while(actual!=primero);
        return valor;
    }

    public boolean esVacia() {
        if (tamanio != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void verLista() {
        NodoDC actual = primero;
        do {
            if (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.adelante;
            }
        } while (actual != primero);
        System.out.println("");
    }

    public void verListaReversa() {
        NodoDC actual = ultimo;
        do {
            if (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.atras;
            }
        } while (actual != ultimo);
        System.out.println("");
    }

    public static void main(String[] args) {
        ListaDobleEnlazadaCircular l = new ListaDobleEnlazadaCircular();
        l.insertar(1);
        l.verLista();
        l.insertarDespues(1,2);
        l.verLista();
        l.insertarDespues(2,3);
        l.verLista();
        l.insertarDespues(3,4);
        l.verLista();
        l.insertarDespues(1,5);
        l.verLista();
        System.out.println("Dato: "+l.getDato(3));
    }

}
