package repositorio;

import dados.ContaAbstrata;
import excecoes.*;
import java.util.ArrayList;

/**
 *
 * @author henriquenasc
 */
public interface Repositorio {
    public void cadastrar(ContaAbstrata c) throws ValorNegativoException;
    public ArrayList<ContaAbstrata> listar() throws VetorVazioException;
    public ContaAbstrata consultar(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void alterar(ContaAbstrata c) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
    public void remover(String numero) throws VetorVazioException, ContaAbstrataNaoEncontradaException;
}
