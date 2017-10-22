package fachada;

import dados.ContaAbstrata;
import excecoes.ContaAbstrataNaoEncontradaException;
import excecoes.NaoEhContaEspecialException;
import excecoes.NaoEhContaPoupancaException;
import excecoes.SaldoNegativoException;
import excecoes.ValorNegativoException;
import excecoes.VetorVazioException;
import java.util.ArrayList;
import negocio.CadastroContaAbstrata;

/**
 *
 * @author henriquenasc
 */
public class Banco implements Fachada{
    private CadastroContaAbstrata conta_abstrata;
    
    public Banco(){
        this.conta_abstrata = new CadastroContaAbstrata();
    }
    
    @Override
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException, SaldoNegativoException {
        this.conta_abstrata.cadastrar(c);
    }

    @Override
    public ContaAbstrata consulta(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        return this.conta_abstrata.consultar(numero);
    }

    @Override
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.alterar(c);
    }

    @Override
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.remover(numero);
    }

    @Override
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException {
        return this.conta_abstrata.listar();
    }

    @Override
    public void creditar(String numero, double valor) throws VetorVazioException, ValorNegativoException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.creditar(numero, valor);
    }

    @Override
    public void debitar(String numero, double valor) throws VetorVazioException, ValorNegativoException, ContaAbstrataNaoEncontradaException, SaldoNegativoException {
        this.conta_abstrata.debitar(numero, valor);
    }

    @Override
    public void tranferir(String origem, String destino, double valor) throws VetorVazioException, ValorNegativoException, SaldoNegativoException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.transferir(origem, destino, valor);
    }

    @Override
    public void renderJuros(String numero) throws VetorVazioException, NaoEhContaPoupancaException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.renderJuros(numero);
    }

    @Override
    public void renderBonus(String numero) throws VetorVazioException, NaoEhContaEspecialException, ContaAbstrataNaoEncontradaException {
        this.conta_abstrata.renderBonus(numero);
    }
    
}
