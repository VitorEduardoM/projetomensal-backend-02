package view.controladorMenuPrincipal;

import Controladores.controladorAutomoveis.ControladorAutomoveis;
import Controladores.controladorClientes.ControladorClientes;
import Controladores.controladorOrdemServico.ControladorOrdemServico;
import Controladores.controladorProdutos.ControladorProduto;
import Controladores.controladorServicos.ControladorServico;
import service.servico.ServicoService;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;
import service.automovel.AutomovelService;
import service.cliente.ClienteService;

public class ControladorMenu {
    private ClienteService clienteService = new ClienteService();
    private AutomovelService automovelService = new AutomovelService();
    private ServicoService servicoService = new ServicoService();


    private ControladorProduto controladorProduto = new ControladorProduto();
    private ControladorClientes controladorClientes = new ControladorClientes(clienteService);
    private ControladorAutomoveis controladorAutomoveis = new ControladorAutomoveis(automovelService, clienteService);
    private ControladorOrdemServico controladorOrdemServico = new ControladorOrdemServico(automovelService, clienteService, servicoService);
    private ControladorServico controladorServico = new ControladorServico(servicoService);

    public void menuPrincipal() {
        MenuView.entradaSistema();
        int opcao = -1;
        while (opcao != 0) {
            MenuView.exibirMenuPrincipal();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    controladorProduto.menuProdutos();
                    break;
                case 2:
                    controladorServico.menuServico();
                    break;
                case 3:
                    controladorClientes.menuClientes();
                    break;
                case 4:
                    controladorAutomoveis.menuAutomoveis();
                    break;
                case 5:
                    controladorOrdemServico.menuOrdemServico();
                    break;
            }
        }
    }
}
