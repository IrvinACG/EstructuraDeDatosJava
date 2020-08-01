package applistas;

/** @author IrvinCG */
public class Nodo {
    
    private int dato;
    private Nodo enlace;
    
    public Nodo(int dato){
        this.dato=dato;
        this.enlace=null;
    }
    public Nodo(int dato, Nodo nodo){
        this.dato=dato;
        this.enlace=nodo;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
}
