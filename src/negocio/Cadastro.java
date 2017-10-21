package negocio;

import dados.ContaAbstrata;
import java.util.ArrayList;
import excecoes.*;

/**
 *
 * @author henriquenasc
 */
public interface Cadastro {
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException, SaldoNegativoException;
    public ContaAbstrata consultar(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException;
    public void creditar(String numero, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException;
    public void debitar(String numero, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException, SaldoNegativoException;
    public void transferir(String origem, String destino, double valor) throws VetorVazioException, ContaAbstrataNaoEncontradaException, ValorNegativoException;
    public void renderJuros(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException, NaoEhContaPoupancaException;
    public void renderBonus(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException, NaoEhContaEspecialException;
}