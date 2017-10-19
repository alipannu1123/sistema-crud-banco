package excecoes;

/**
 *
 * @author henriquenasc
 */
public class ContaAbstrataNaoEncontradaException extends Exception{
    public ContaAbstrataNaoEncontradaException(){
        super("Conta abstrata não encontrada!");
    }
}
