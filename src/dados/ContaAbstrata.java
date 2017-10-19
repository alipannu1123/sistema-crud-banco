package dados;

/**
 *
 * @author henriquenasc
 */
public abstract class ContaAbstrata {
    private String numero;
    private double saldo;
    
    public ContaAbstrata(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public ContaAbstrata(String numero){
        this(numero, 0.0);
    }
    
    public ContaAbstrata(){
        this("", 0.0);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void creditar(double valor){
        this.saldo = this.saldo + valor;
    }
    
    public abstract void debitar(double valor);
}