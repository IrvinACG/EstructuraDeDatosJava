package applistas.dobleEnlazada;

/**
 *
 * @author IrvinCG
 */
public class ListaDobleEnlazada {
    
    private NodoD primero,ultimo;
    private int tamanio;
    public ListaDobleEnlazada() {
        primero = ultimo =null;
        tamanio=0;
    }
    
    public ListaDobleEnlazada insertFinal(int dato){
        NodoD nuevo = new NodoD(dato);
        if(tamanio==0)  //Primer nodo a insertar
            primero = ultimo = nuevo;
        else{
            nuevo.atras = ultimo;
            ultimo.adelante = nuevo;
            ultimo = nuevo;
        }
        tamanio++;
        return this;
    }
    
    public ListaDobleEnlazada insertInicio(int dato){
        NodoD nuevo = new NodoD(dato); 
        if(tamanio==0)
            primero = ultimo = nuevo;
        else{
            nuevo.adelante=primero;
            primero.atras=nuevo;
            primero = nuevo;
        }
        tamanio++;
        return this;
    }
    
    public void eliminarInicio(){
        if(!esVacia()){
            if(tamanio==1)
                primero=ultimo=null;
            else{
                primero.adelante.atras=null;
                primero = primero.adelante;
            }
            tamanio--;
        }
    }
    
    public void eliminarFinal(){
        if(!esVacia()){
            if(tamanio==1)  //Solo hay 1 Nodo
                primero=ultimo=null;
            else{
                ultimo.atras.adelante=null;
                ultimo = ultimo.atras;
            }
            tamanio--;
        }
    }
    
    public boolean esVacia(){
        if(tamanio>0)
            return false;
        return true;
    }
    
    public void verLista(){
        NodoD actual = primero;
        while(actual!=null){
            System.out.print(actual.dato+" ");
            actual = actual.adelante;
        }System.out.println("");
    }
    
    public int getTamanio() {
        return tamanio;
    }
    
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        lista.insertFinal(1);
        lista.insertFinal(2);
        lista.insertFinal(3);
        lista.insertFinal(4);
        lista.insertInicio(5);
        lista.verLista();
        System.out.println("Tamaño: "+lista.getTamanio());
        lista.eliminarFinal();
        lista.eliminarFinal();
        lista.verLista();
        System.out.println("Tamaño: "+lista.getTamanio());
        lista.eliminarInicio();
        lista.verLista();
        System.out.println("Tamaño: "+lista.getTamanio());
    }
    
}
