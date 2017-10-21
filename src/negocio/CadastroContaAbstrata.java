package negocio;

import dados.ContaAbstrata;
import dados.Especial;
import dados.Imposto;
import dados.Poupanca;
import excecoes.ContaAbstrataNaoEncontradaException;
import excecoes.NaoEhContaEspecialException;
import excecoes.NaoEhContaPoupancaException;
import excecoes.SaldoNegativoException;
import excecoes.ValorNegativoException;
import excecoes.VetorVazioException;
import java.util.ArrayList;
import repositorio.RepositorioContaAbstrata;

/**
 *
 * @author henriquenasc
 */
public class CadastroContaAbstrata implements Cadastro{
    private RepositorioContaAbstrata repositorio;
    
    public CadastroContaAbstrata(){
        this.repositorio = new RepositorioContaAbstrata();
    }
    
    @Override
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException, SaldoNegativoException {
        this.repositorio.cadastrar(c);
    }

    @Override
    public ContaAbstrata consultar(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        return this.repositorio.consultar(numero);
    }

    @Override
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        this.repositorio.alterar(c);
    }

    @Override
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        this.repositorio.remover(numero);
    }

    @Override
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException {
        return this.repositorio.listar();
    }

    @Override
    public void creditar(String numero, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException {
        if(valor >= 0){
            ContaAbstrata c = this.consultar(numero);
            c.creditar(valor);
            this.alterar(c);
        }else{
            throw new ValorNegativoException();
        }
    }

    @Override
    public void debitar(String numero, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException, SaldoNegativoException {
        if(valor >= 0){
            ContaAbstrata c = this.consultar(numero);
            if(c.getSaldo() - valor >= 0){
                c.debitar(valor);
                this.alterar(c);
            }else{
                throw new SaldoNegativoException();
            }
        }else{
            throw new ValorNegativoException();
        }
    }

    @Override
    public void transferir(String origem, String destino, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException {
        if(valor >= 0){
            ContaAbstrata co = this.consultar(origem);
            ContaAbstrata cd = this.consultar(destino);
            co.debitar(valor);
            cd.creditar(valor);
            this.alterar(co);
            this.alterar(cd);
        }else{
            throw new ValorNegativoException();
        }
    }

    @Override
    public void renderJuros(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException, NaoEhContaPoupancaException {
        ContaAbstrata c = this.consultar(numero);
        if(c instanceof Poupanca){
            ((Poupanca) c).renderJuros();
            this.alterar(c);
        }else{
            throw new NaoEhContaPoupancaException();
        }
    }

    @Override
    public void renderBonus(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException, NaoEhContaEspecialException {
        ContaAbstrata c = this.consultar(numero);
        if(c instanceof Especial){
            ((Especial) c).renderBonus();
            this.alterar(c);
        }else{
            throw new NaoEhContaEspecialException();
        }
    }
    
}
