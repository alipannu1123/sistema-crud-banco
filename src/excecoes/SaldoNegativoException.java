package excecoes;

/**
 *
 * @author henriquenasc
 */
public class SaldoNegativoException extends Exception{
    public SaldoNegativoException(){
        super("Operação não realizada. Saldo negativo!");
    }
}
