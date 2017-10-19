package excecoes;

/**
 *
 * @author henriquenasc
 */
public class NaoEhContaPoupancaException extends Exception{
    public NaoEhContaPoupancaException(){
        super("Operação não realizada, não é uma conta poupança!");
    }
}
