package applistas;

/**
 *
 * @author IrvinCG
 */
public class AppListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada lista = new ListaEnlazada();
//        lista.insertarInicio(1);
//        lista.insertarInicio(2);
//        lista.insertarInicio(3);
//        lista.insertarInicio(4);
//        lista.insertarInicio(5);
//        lista.insertarFinal(6);
//        lista.insertarDespues(3, 9);
//        System.out.println("Dato en Posicion a Buscar: "+lista.buscarPosicion(8));
        lista.insertarEnOrden(4);
        lista.insertarEnOrden(3);
        lista.insertarEnOrden(9);
        lista.insertarEnOrden(1);
        lista.visualizar();
        lista.eliminar(5);
        lista.visualizar();

        lista.visualizar();
        
    }
    
}
