package sistemabanco;

import dados.*;
import excecoes.*;
import fachada.Banco;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author henriquenasc
 */
public class SistemaBanco {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Banco banco = new Banco();
        String numero, origem, destino;
        double saldo;
        int op = 0;
        
        ArrayList<ContaAbstrata> cas;
        ContaAbstrata ca;
        do {
            System.out.println("1 - cadastrar conta (padrão)");
            System.out.println("2 - cadastrar conta (poupança)");
            System.out.println("3 - cadastrar conta (especial)");
            System.out.println("4 - cadastrar conta (imposto)");
            System.out.println("5 - consultar");
            System.out.println("6 - listar");
            System.out.println("7 - remover");
            System.out.println("8 - transferir");
            System.out.println("9 - creditar");
            System.out.println("10 - debitar");
            System.out.println("11 - reder juros");
            System.out.println("12 - render bônus");
            System.out.println("13 - sair");
            System.out.print("escolha: ");
            op = scan.nextInt();
            
            switch(op){
                case 1:
                    try{
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("saldo: ");
                        saldo = scan.nextDouble();
                        ca = new Conta(numero, saldo);
                        banco.cadastrar(ca);
                        System.out.println("operação realizada com sucesso!");
                        System.out.println("");
                    }catch(ValorNegativoException|SaldoNegativoException e){
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("saldo: ");
                        saldo = scan.nextDouble();
                        ca = new Poupanca(numero, saldo);
                        banco.cadastrar(ca);
                        System.out.println("operação realizada com sucesso!");
                        System.out.println("");
                    } catch (ValorNegativoException|SaldoNegativoException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("saldo: ");
                        saldo = scan.nextDouble();
                        ca = new Especial(numero, saldo);
                        banco.cadastrar(ca);
                        System.out.println("operação realizada com sucesso!");
                        System.out.println("");
                    } catch (ValorNegativoException|SaldoNegativoException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("saldo: ");
                        saldo = scan.nextDouble();
                        ca = new Imposto(numero, saldo);
                        banco.cadastrar(ca);
                        System.out.println("operação realizada com sucesso!");
                        System.out.println("");
                    } catch (ValorNegativoException|SaldoNegativoException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        ca = banco.consulta(numero);
                        System.out.println("número da conta: " + ca.getNumero());
                        System.out.println("saldo: " + ca.getSaldo());
                        System.out.println("");
                        if(ca instanceof Especial){
                            System.out.println("bônus: " + ((Especial) ca).getBonus());
                            System.out.println("");
                        }
                    } catch (VetorVazioException|ContaAbstrataNaoEncontradaException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("");
                        cas = banco.listar();
                        for (int i = 0; i < cas.size(); i++) {
                            System.out.println("número: " + cas.get(i).getNumero());
                            System.out.println("saldo: " + cas.get(i).getSaldo());
                            if(cas.get(i) instanceof Especial){
                                System.out.println("bônus: " + ((Especial)cas.get(i)).getBonus());
                                System.out.println("");
                            }
                        }
                    } catch (VetorVazioException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 7:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        banco.remover(numero);
                        System.out.println("");
                    } catch (VetorVazioException|ContaAbstrataNaoEncontradaException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 8:
                    try {
                        System.out.println("");
                        System.out.print("conta origem: ");
                        origem = scan.next();
                        System.out.print("conta destino: ");
                        destino = scan.next();
                        System.out.print("quantia: ");
                        saldo = scan.nextDouble();

                        banco.tranferir(origem, destino, saldo);
                        System.out.println("");
                    } catch (VetorVazioException|ValorNegativoException|SaldoNegativoException|ContaAbstrataNaoEncontradaException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 9:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("quantia: ");
                        saldo = scan.nextDouble();
                        banco.creditar(numero, saldo);
                        System.out.println("");
                    } catch (ValorNegativoException|VetorVazioException|ContaAbstrataNaoEncontradaException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 10:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        System.out.print("quantia: ");
                        saldo = scan.nextDouble();
                        banco.creditar(numero, saldo);
                        System.out.println("");
                    } catch (ValorNegativoException|VetorVazioException|ContaAbstrataNaoEncontradaException e) {
                        System.out.println("");
                        System.out.println("exceção: " + e.getMessage());
                        System.out.println("");
                    }
                    break;
                case 11:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        banco.renderJuros(numero);
                        System.out.println("");
                    } catch (VetorVazioException|ContaAbstrataNaoEncontradaException|NaoEhContaPoupancaException e) {
                       System.out.println("");
                       System.out.println("exceção: " + e.getMessage());
                       System.out.println(""); 
                    }
                    break;
                case 12:
                    try {
                        System.out.println("");
                        System.out.print("número: ");
                        numero = scan.next();
                        banco.renderBonus(numero);
                        System.out.println("");
                    } catch (VetorVazioException|ContaAbstrataNaoEncontradaException|NaoEhContaEspecialException e) {
                       System.out.println("");
                       System.out.println("exceção: " + e.getMessage());
                       System.out.println(""); 
                    }
                    break;
                case 13:
                    System.out.println("Até mais...");
                    break;
                default:
                    System.out.println("opção inválida!");
            }
        } while(op != 13);
        
    }
    
}
