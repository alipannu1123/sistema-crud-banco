package excecoes;

/**
 *
 * @author henriquenasc
 */
public class NaoEhContaEspecialException extends Exception{
    public NaoEhContaEspecialException(){
        super("Operação não realizada, não é uma conta especial!");
    }
}
