package excecoes;

/**
 *
 * @author henriquenasc
 */
public class ValorNegativoException extends Exception{
    public ValorNegativoException(){
        super("Operação não realizada. Valor negativo!");
    }
}
