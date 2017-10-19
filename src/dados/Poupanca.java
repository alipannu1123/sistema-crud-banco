package dados;

/**
 *
 * @author henriquenasc
 */
public class Poupanca extends Conta{
    
    public Poupanca(String numero, double saldo){
        super(numero, saldo);
    }
    
    public Poupanca(String numero){
        super(numero);
    }
    
    public Poupanca(){
        super();
    }
    
    public void renderJuros(){
        double taxa = 0.01;
        super.setSaldo(super.getSaldo() + (super.getSaldo() * taxa));
    }
}
