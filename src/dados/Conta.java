
package dados;

/**
 *
 * @author henriquenasc
 */
public class Conta extends ContaAbstrata{
    
    public Conta(String numero, double saldo){
        super(numero, saldo);
    }
    
    public Conta(String numero){
        super(numero);
    }
    
    public Conta(){
        super();
    }
    
    @Override
    public void debitar(double valor) {
        super.setSaldo(super.getSaldo() - valor);
    }
    
}
