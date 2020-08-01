package applistas;

/**
 * * @author IrvinCG
 */
public class ListaEnlazada {

    private Nodo primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public ListaEnlazada insertarInicio(int dato) {
        Nodo nuevo; //Se crea nuevo nodo
        nuevo = new Nodo(dato);
        nuevo.setEnlace(primero);   //Nuevo apunta al primer nodo (primero) | al Nodo que ve antes de actualizar
        primero = nuevo;   //primero apunta al nuevo nodo, actualiza la primera posicion con el nodo nuevo,
        //ya que el creado anteriormente es el segundo y nuevo es primero que vee
        return this;    //Devuelve referencia del objeto listaEnlanzada
    }

    public ListaEnlazada insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
            return this;
        }
        //Recorre todos los nodos hasta llegar a la ultima referencia
        Nodo temp = primero;
        //for (temp = primero; temp.getEnlace() != null; temp = temp.getEnlace());
        while (temp.getEnlace() != null) 
            temp = temp.getEnlace(); 
        temp.setEnlace(nuevo);
        return this;
    }

    public ListaEnlazada insertarDespues(int buscar, int dato) {
        Nodo nuevo, anterior;
        anterior = buscarLista(buscar);
        if (anterior != null) {
            nuevo = new Nodo(dato);
            nuevo.setEnlace(anterior.getEnlace());
            anterior.setEnlace(nuevo);
        }
        return this;
    }

    public Nodo buscarLista(int buscar) {
        Nodo aux;
        for (aux = primero; aux != null; aux = aux.getEnlace())
            if (buscar == aux.getDato())
                return aux;
        return null;
    }

    public int buscarPosicion(int pos) {
        Nodo actual;
        int aux = -1;
        actual = primero;
        if (pos <= 0)   //Solo numeros positivos
            return aux;
        for (int i = 1; (i < pos) && (actual != null); i++) 
            actual = actual.getEnlace();
        if (actual != null) //Posicion es mayor a nodos existentes
            aux = actual.getDato();
        return aux;
    }

    public void eliminar(int dato) {
        Nodo actual, anterior = null;
        boolean encontrado = false;
        actual = primero;
        while (!encontrado && actual != null) {
            encontrado = (actual.getDato() == dato);
            if (encontrado != true) {
                anterior = actual;
                actual = actual.getEnlace();
            }
        }
        if(actual!=null)//Comprobar que si se encontro dato
            if(actual ==primero)//Caso de ser el nodo 1
                primero = actual.getEnlace();
            else
                anterior.setEnlace(actual.getEnlace());
    }
    public ListaEnlazada insertarEnOrden(int dato){
        Nodo nuevo= new Nodo(dato);
        if (primero == null) // lista vacía Inserta primer dato
            primero = nuevo;    
        else if (dato < primero.getDato()){ //Inserta segundo dato
            nuevo. setEnlace(primero);
            primero = nuevo;
        }else{ /* búsqueda del nodo anterior a partir del que se debe insertar */
            Nodo anterior, actual;
            anterior = actual = primero;
            while ((actual.getEnlace() != null) && (dato > actual.getDato())){
               anterior = actual;
               actual = actual.getEnlace();
            }
            if (dato > actual.getDato()) //se inserta después del último nodo
                anterior = actual;
            // Se procede al enlace del nuevo nodo
            nuevo.setEnlace(anterior.getEnlace());
            anterior.setEnlace(nuevo);
        }
    return this;
    }

    public void visualizar() {
        Nodo actual;
        actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getEnlace();
        }
        System.out.println("");        
    }
}
