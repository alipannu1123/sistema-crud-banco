package repositorio;

import dados.ContaAbstrata;
import excecoes.ContaAbstrataNaoEncontradaException;
import excecoes.ValorNegativoException;
import excecoes.VetorVazioException;
import java.util.ArrayList;

/**
 *
 * @author henriquenasc
 */
public class RepositorioContaAbstrata implements Repositorio{
    private ArrayList<ContaAbstrata> contaAbstrata;
    
    public RepositorioContaAbstrata(){
        this.contaAbstrata = new ArrayList();
    }
    
    @Override
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException {
        if(c.getSaldo() >= 0){
            this.contaAbstrata.add(c);
        }
    }

    @Override
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException {
        if(this.contaAbstrata.size() > 0){
            return this.contaAbstrata;
        }else{
            throw new VetorVazioException();
        }
    }

    @Override
    public ContaAbstrata consultar(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        ContaAbstrata c = null;
        if(this.contaAbstrata.size() > 0){
            for (int i = 0; i < this.contaAbstrata.size(); i++) {
                if(this.contaAbstrata.get(i).getNumero().equals(numero)){
                    c = this.contaAbstrata.get(i);
                    break;
                }
            }
            if(c != null){
                return c;
            }else{
                throw new ContaAbstrataNaoEncontradaException();
            }
        }else{
            throw new VetorVazioException();
        }
    }

    @Override
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        if(this.contaAbstrata.size() > 0){
            ContaAbstrata ca = this.consultar(c.getNumero());
            ca = c;
        }else{
            throw new VetorVazioException();
        }
    }

    @Override
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        if(this.contaAbstrata.size() > 0){
            ContaAbstrata ca = this.consultar(numero);
            this.contaAbstrata.remove(ca);
        }else{
            throw new VetorVazioException();
        }
    }
    
}