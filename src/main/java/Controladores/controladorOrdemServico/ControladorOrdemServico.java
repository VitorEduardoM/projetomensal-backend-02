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

}