package Controladores.controladorOrdemServico;

import service.automovel.AutomovelService;
import service.cliente.ClienteService;
import service.laudo.LaudoService;
import service.ordemservico.OrdemServicoService;
import service.produto.ProdutoService;
import service.servico.ServicoService;
import util.CoresTerminal;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;

public class ControladorOrdemServico {
    private OrdemServicoService ordemServicoService = new OrdemServicoService();
    private ProdutoService produtoService = new ProdutoService();
    private LaudoService laudoService = new LaudoService();
    private AutomovelService automovelService;
    private ClienteService clienteService;
    private ServicoService servicoService;

    public ControladorOrdemServico(AutomovelService automovelService, ClienteService clienteService, ServicoService servicoService) {
        this.automovelService = automovelService;
        this.clienteService = clienteService;
        this.servicoService = servicoService;
    }

    public void menuOrdemServico() {
        LimpaTerminal.limparTela();
        int opcao = -1;

        while (opcao != 0) {
            MenuView.exibirOrdemServico();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    criarOrdemServico();
                    break;
                case 2:
                    editarOrdemServico();
                    break;
                case 3:
                    excluirOrdemServico();
                    break;
                case 4:
                    finalizarOrdemServico();
                    break;
                case 5:
                    ordemServicoService.listarTodos();
                    break;
            }
        }
    }

    private void criarOrdemServico() {
        if (!clienteService.verificaClientesCadastrados()) {
            System.out.println("\nNenhum cliente cadastrado!");
            System.out.println("Cadastre um cliente para continuar a operação");
            return;
        }
        System.out.println("========== ESCOLHA O CLIENTE DA ORDEM DE SERVIÇO ==========");
        clienteService.listarTodos();
        Long idCliente = VerificaEntradas.lerLong("Digite o ID do cliente: ");
        if (!clienteService.temAutomoveis(idCliente)) {
            System.out.println("\nNenhum automóvel vinculado ao cliente informado");
            System.out.println("Operação encerrada\n");
            return;
        }
        clienteService.exibirClienteComAutomoveis(idCliente);
        Long idAutomovel = VerificaEntradas.lerLong("Digite o ID do automóvel: ");
        ordemServicoService.cadastrarOrdem(idCliente, idAutomovel);
    }

    private void editarOrdemServico() {
        if (!ordemServicoService.verificaOsCadastrados()) {
            System.out.println(CoresTerminal.VERMELHO + "Nenhuma OS foi encontrada!" + CoresTerminal.RESET);
            return;
        }
        ordemServicoService.listarTodos();
        Long idOrdem = VerificaEntradas.lerLong(CoresTerminal.AMARELO + "Selecione o ID da Ordem de Servico: " + CoresTerminal.RESET);

        MenuView.exibirMenuEdicaoOs();
        int opcaoEdicao = VerificaEntradas.lerInteiro(CoresTerminal.AMARELO + "Selecione o que deseja Editar: " + CoresTerminal.RESET);
        switch (opcaoEdicao) {
            case 1:
                gerenciarServicosOs(idOrdem);
                break;
            case 2:
                gerenciarProdutosOs(idOrdem);
                break;
            case 3:
                automovelService.listarTodos();
                Long idAutomovel = VerificaEntradas.lerLong("Digite o ID do novo automóvel: ");
                ordemServicoService.alterarAutomovelOs(idOrdem, idAutomovel);
                break;
            case 4:
                gerarLaudo(idOrdem);
                break;
            case 5:
                laudoService.exibirLaudo(idOrdem);
                break;
        }
    }

    private void gerenciarServicosOs(Long idOrdem) {
        MenuView.exibirMenuOsServicos();
        int opcao = VerificaEntradas.lerInteiro(CoresTerminal.AMARELO + "Escolha entre as opções acima: " + CoresTerminal.RESET);
        switch (opcao) {
            case 1:
                System.out.println("========== ESCOLHA O SERVIÇO QUE DESEJA ADICIONAR ==========");
                servicoService.listarTodos();
                Long idServico = VerificaEntradas.lerLong("Insira o ID do serviço: ");
                ordemServicoService.cadastrarServicoOs(idOrdem, idServico);
                break;
            case 2:
                ordemServicoService.exibirServicosOs(idOrdem);
                Long idServicoRemover = VerificaEntradas.lerLong("Insira o ID do serviço a remover: ");
                ordemServicoService.removerServicoOs(idOrdem, idServicoRemover);
                break;
            case 3:
                ordemServicoService.exibirServicosOs(idOrdem);
                break;
        }
    }

    private void gerenciarProdutosOs(Long idOrdem) {
        MenuView.exibirMenuOsProdutos();
        int opcao = VerificaEntradas.lerInteiro(CoresTerminal.AMARELO + "Escolha entre as opções acima: " + CoresTerminal.RESET);
        switch (opcao) {
            case 1:
                System.out.println("========== ESCOLHA O PRODUTO QUE DESEJA ADICIONAR ==========");
                produtoService.listarTodos();
                Long idProduto = VerificaEntradas.lerLong("Insira o ID do produto: ");
                ordemServicoService.cadastrarProdutoOs(idOrdem, idProduto);
                break;
            case 2:
                ordemServicoService.exibirProdutosOs(idOrdem);
                Long idProdutoRemover = VerificaEntradas.lerLong("Insira o ID do produto a remover: ");
                ordemServicoService.removerProdutoOs(idOrdem, idProdutoRemover);
                break;
            case 3:
                ordemServicoService.exibirProdutosOs(idOrdem);
                break;
        }
    }

    private void gerarLaudo(Long idOrdem) {
        String diagnostico = VerificaEntradas.lerTexto("Digite o diagnóstico: ");
        String observacoes = VerificaEntradas.lerTexto("Digite as observações: ");
        laudoService.gerarLaudo(idOrdem, diagnostico, observacoes);
    }

    private void excluirOrdemServico() {
        if (!ordemServicoService.verificaOsCadastrados()) {
            System.out.println(CoresTerminal.VERMELHO + "Nenhuma OS foi encontrada!" + CoresTerminal.RESET);
            return;
        }
        ordemServicoService.listarTodos();
        Long idOrdem = VerificaEntradas.lerLong("Digite o ID da Ordem de Serviço a excluir: ");
        ordemServicoService.excluirOrdem(idOrdem);
    }

    private void finalizarOrdemServico() {
        if (!ordemServicoService.verificaOsCadastrados()) {
            System.out.println(CoresTerminal.VERMELHO + "Nenhuma OS foi encontrada!" + CoresTerminal.RESET);
            return;
        }
        ordemServicoService.listarTodos();
        Long idOrdem = VerificaEntradas.lerLong("Digite o ID da Ordem de Serviço a finalizar: ");
        ordemServicoService.finalizarOrdem(idOrdem);
    }
}