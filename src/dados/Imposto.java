package dados;

/**
 *
 * @author henriquenasc
 */
public class Imposto extends ContaAbstrata{

    public Imposto(String numero, double saldo){
        super(numero, saldo);
    }
    
    public Imposto(String numero){
        super(numero);
    }
    
    public Imposto(){
        super();
    }
    
    @Override
    public void debitar(double valor) {
        double imposto = 0.01;
        super.setSaldo(super.getSaldo() - (valor + valor * imposto));
    }
    
}
