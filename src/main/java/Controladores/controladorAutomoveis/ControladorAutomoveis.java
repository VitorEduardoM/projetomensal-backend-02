package Controladores.controladorAutomoveis;

import entity.Automovel;
import service.automovel.AtualizaAutomovel;
import service.automovel.AutomovelService;
import service.automovel.CadastroAutomovel;
import service.cliente.ClienteService;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;

public class ControladorAutomoveis {
    private AutomovelService automovelService;
    private ClienteService clienteService;

    public ControladorAutomoveis(AutomovelService automovelService, ClienteService clienteService) {
        this.automovelService = automovelService;
        this.clienteService = clienteService;
    }

    public void menuAutomoveis() {
        LimpaTerminal.limparTela();
        int opcao = -1;
        while (opcao != 0) {
            MenuView.exibirMenuAutomovel();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    Automovel automovel = CadastroAutomovel.cadastrarAutomovel();
                    automovelService.cadastrar(automovel);
                    break;
                case 2:
                    Automovel automovelAtualizado = AtualizaAutomovel.atualizarAutomovel(automovelService);
                    if (automovelAtualizado != null) {
                        automovelService.atualizar(automovelAtualizado);
                    }
                    break;
                case 3:
                    if (automovelService.verificaAutomoveisDisponiveis() && clienteService.verificaClientesCadastrados()) {
                        automovelService.listarDisponiveis();
                        clienteService.listarTodos();
                        System.out.println("\n========== VINCULAR AUTOMÓVEL AO CLIENTE ==========");
                        Long idCliente = VerificaEntradas.lerLong("Digite o ID do cliente: ");
                        Long idAutomovel = VerificaEntradas.lerLong("Digite o ID do automóvel: ");
                        automovelService.vincularCliente(idAutomovel, idCliente);
                    } else {
                        System.out.println("Cliente ou automóvel não cadastrado!");
                        System.out.println("Cadastre eles primeiro para continuar a operação!");
                    }
                    break;
                case 4:
                    System.out.println("\n========== REMOVER AUTOMÓVEL ==========");
                    automovelService.listarTodos();
                    Long idRemover = VerificaEntradas.lerLong("ID do automóvel a remover: ");
                    automovelService.remover(idRemover);
                    break;
                case 5:
                    automovelService.listarDisponiveis();
                    automovelService.listarTodos();
                    break;
                case 6:
                    if (clienteService.verificaClientesCadastrados()) {
                        clienteService.listarTodos();
                        System.out.println("\n========== REMOVER O AUTOMÓVEL DO CLIENTE ==========");
                        Long idCliente = VerificaEntradas.lerLong("Digite o ID do cliente: ");
                        clienteService.exibirClienteComAutomoveis(idCliente);
                        Long idAutomovel = VerificaEntradas.lerLong("Digite o ID do automóvel que deseja remover: ");
                        automovelService.desvincularCliente(idAutomovel);
                    } else {
                        System.out.println("Nenhum cliente cadastrado!");
                    }
                    break;
            }
        }
    }

}