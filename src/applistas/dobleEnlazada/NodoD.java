package applistas.dobleEnlazada;

/**
 * * @author IrvinCG
 */
public class NodoD {

    int dato;
    NodoD adelante;
    NodoD atras;

    public NodoD(int dato) {
        this.dato = dato;
        adelante = atras = null;
    }

}
