package fachada;

import dados.ContaAbstrata;
import excecoes.*;
import java.util.ArrayList;
/**
 *
 * @author henriquenasc
 */
public interface Fachada {
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException, SaldoNegativoException;
    public ContaAbstrata consulta(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException;
    public void creditar(String numero, double valor) throws VetorVazioException, ValorNegativoException, ContaAbstrataNaoEncontradaException;
    public void debitar(String numero, double valor) throws VetorVazioException, ValorNegativoException, ContaAbstrataNaoEncontradaException, SaldoNegativoException;
    public void tranferir(String origem, String destino, double valor) throws VetorVazioException, ValorNegativoException, SaldoNegativoException, ContaAbstrataNaoEncontradaException;
    public void renderJuros(String numero) throws VetorVazioException, NaoEhContaPoupancaException, ContaAbstrataNaoEncontradaException;
    public void renderBonus(String numero) throws VetorVazioException, NaoEhContaEspecialException, ContaAbstrataNaoEncontradaException;
}
