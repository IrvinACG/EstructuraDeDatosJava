package applistas.dobleCircular;

/**
 *
 * @author IrvinCG
 */
public class NodoDC {
    
    int dato;
    NodoDC adelante;
    NodoDC atras;
    
   public NodoDC(int dato){
       this.dato=dato;
       adelante=atras=null;
   }
    
}
