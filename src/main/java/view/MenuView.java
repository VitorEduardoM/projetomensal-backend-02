package view;

import util.CoresTerminal;
import util.VerificaEntradas;

import java.util.ArrayList;

public class MenuView {

    public static void entradaSistema() {
        System.out.println(CoresTerminal.AZUL + "==========" + CoresTerminal.RESET + " SISTEMA AUTO CENTER SILVA " + CoresTerminal.AZUL + "==========" + CoresTerminal.RESET);
    }

    public static void exibirMenuPrincipal() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU PRINCIPAL " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET
                + "\n1 - Gerenciar Produtos"
                + "\n2 - Gerenciar Serviços"
                + "\n3 - Gerenciar Clientes"
                + "\n4 - Gerenciar Automóveis"
                + "\n5 - Gerenciar Ordem de Serviço"
                + "\n0 -" + CoresTerminal.VERMELHO + " Sair" + CoresTerminal.RESET
                + CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirMenuAutomovel() {
        System.out.println(CoresTerminal.VERDE + "\n==========" + CoresTerminal.RESET + " MENU DE AUTOMÓVEIS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Cadastrar Automóvel" +
                "\n2 - Atualizar Automóvel" +
                "\n3 - Vincular ao Cliente" +
                "\n4 - Remover Automóvel" +
                "\n5 - Listar Automóveis" +
                "\n6 - Remover Automóveis de Clientes" +
                "\n0 -" + CoresTerminal.VERMELHO + " Voltar" + CoresTerminal.RESET +
                CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirMenuClientes() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU DE CLIENTES " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Cadastrar Cliente" +
                "\n2 - Listar Clientes" +
                "\n3 - Atualizar Dados do Cliente" +
                "\n4 - Remover Cliente" +
                "\n5 - Buscar Cliente por Nome" +
                "\n6 - Listar Automóveis" +
                "\n0 -" + CoresTerminal.VERMELHO + " Voltar" + CoresTerminal.RESET +
                CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirMenuServicos() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU DE SERVIÇOS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Cadastrar Serviço" +
                "\n2 - Listar Serviços" +
                "\n3 - Atualizar Serviço" +
                "\n4 - Remover Serviço" +
                "\n5 - Buscar por Nome" +
                "\n6 - Buscar por Tipo" +
                "\n7 - Relatório de Serviços" +
                "\n0 -" + CoresTerminal.VERMELHO + " Voltar" + CoresTerminal.RESET +
                CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirMenuProdutos() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU DE PRODUTOS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Cadastrar Produto" +
                "\n2 - Listar Produtos" +
                "\n3 - Atualizar Produtos" +
                "\n4 - Remover Produto" +
                "\n5 - Buscar por Nome" +
                "\n6 - Buscar por Categoria" +
                "\n7 - Relatório de Produtos" +
                "\n0 -" + CoresTerminal.VERMELHO + " Voltar" + CoresTerminal.RESET +
                CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirOrdemServico() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ORDEM DE SERVIÇO " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Criar Ordem de Serviço" +
                "\n2 - Editar Ordem de Serviço" +
                "\n3 - Excluir Ordem de Serviço" +
                "\n4 - Finalizar Ordem de Serviço" +
                "\n5 - Listar Ordem de Serviço" +
                "\n0 -" + CoresTerminal.VERMELHO + " Voltar" + CoresTerminal.RESET +
                CoresTerminal.VERMELHO + "\n============================" + CoresTerminal.RESET);
    }

    public static void exibirMenuEdicaoOs() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU EDIÇÃO DE ORDEM DE SERVIÇO " + CoresTerminal.VERDE + "==========\n" + CoresTerminal.RESET +
                "1 - Gerenciar Serviço\n" +
                "2 - Gerenciar Venda\n" +
                "3 - Alterar Automóvel\n" +
                "4 - Gerar Laudo\n" +
                "5 - Visualizar Laudo\n");
    }

    public static void exibirMenuOsServicos() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ORDEM DE SERVIÇO GERENCIADOR SERVIÇOS " + CoresTerminal.VERDE + "==========\n" + CoresTerminal.RESET +
                "1 - Adicionar Serviço\n" +
                "2 - Remover Serviço\n" +
                "3 - Listar Serviços da Ordem de Serviço\n");

    }

    public static void exibirMenuOsProdutos() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ORDEM DE SERVIÇO GERENCIADOR PRODUTOS " + CoresTerminal.VERDE + "==========\n" + CoresTerminal.RESET +
                "1 - Adicionar Produto\n" +
                "2 - Remover Produto\n" +
                "3 - Listar Produtos da Ordem de Serviço\n");
    }

    public static void exibirMenuAtualizaPneu() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ATUALIZAÇÃO DE PRODUTOS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Marca\n" +
                "2 - Estoque\n" +
                "3 - Preço\n" +
                "4 - Medida\n");
    }

    public static void exibirMenuAtualizaRestante() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ATUALIZAÇÃO DE PRODUTOS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Nome\n" +
                "2 - Estoque\n" +
                "3 - Preço\n");
    }

    public static void exibirMenuAtualizaServico() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ATUALIZAÇÃO DE SERVIÇOS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Nome\n" +
                "2 - Tipo\n" +
                "3 - Duração\n" +
                "4 - Preço\n");
    }

    public static int menuCameraDeAr() {
        System.out.println("\n========== CADASTRO DE CÂMERAS DE AR ==========");
        ArrayList<String> lista = new ArrayList<>();

        lista.add("Câmaras de Ar de Carro");
        lista.add("Câmaras de Ar de Caminhonete");
        lista.add("Câmaras de Ar de Caminhão");
        lista.add("Outros");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + 1 + "- " + lista.get(i));
        }
        return VerificaEntradas.lerInteiro("Escolha uma opção: ");
    }

    public static int exibirMenuAtualizaCliente() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ATUALIZAÇÃO CLIENTES " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Nome\n" +
                "2 - Cpf\n" +
                "3 - Telefone\n");
        return VerificaEntradas.lerInteiro("Escolha uma opção: ");
    }

    public static int exibirMenuAtualizaAutomovel() {
        System.out.println(CoresTerminal.VERDE + "==========" + CoresTerminal.RESET + " MENU ATUALIZAÇÃO AUTOMÓVEIS " + CoresTerminal.VERDE + "==========" + CoresTerminal.RESET +
                "\n1 - Modelo\n" +
                "2 - Placa\n" +
                "3 - Ano Fabricação\n");
        return VerificaEntradas.lerInteiro("Escolha uma opção: ");
    }
    
}
