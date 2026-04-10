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
            }
        }
    }

}