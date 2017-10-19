package dados;

/**
 *
 * @author henriquenasc
 */
public class Especial extends Conta{
    private double bonus;
    
    public Especial(String numero, double saldo){
        super(numero, saldo);
        this.bonus = 0;
    }
    
    public Especial(String numero){
        super(numero);
        this.bonus = 0;
    }
    
    public Especial(){
        super();
        this.bonus = 0;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    @Override
    public void creditar(double valor){
        super.creditar(valor);
        double taxa = 0.1;
        this.bonus += (valor * taxa);
    }
    
    public void renderBonus(){
        super.setSaldo(super.getSaldo() + this.bonus);
        this.bonus = 0;
    }
}