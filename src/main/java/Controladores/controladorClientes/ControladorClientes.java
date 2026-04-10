package Controladores.controladorClientes;

mport entity.Cliente;
import entity.Cliente;
import service.cliente.AtualizaCliente;
import service.cliente.CadastroCliente;
import service.cliente.ClienteService;
import util.CoresTerminal;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;


public class ControladorClientes {
    private ClienteService clienteService;

    public ControladorClientes(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void menuClientes() {
        LimpaTerminal.limparTela();
        int opcao = -1;

        while (opcao != 0) {
            MenuView.exibirMenuClientes();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    Cliente cliente = CadastroCliente.cadastrarCliente();
                    clienteService.cadastrarCliente(cliente);
                    break;
                case 2:
                    clienteService.listarTodos();
                    break;
                case 3:
                    Cliente clienteAtualizado = AtualizaCliente.atualizarCliente(clienteService);
                    if (clienteAtualizado != null) {
                        clienteService.atualizar(clienteAtualizado);
                    }
                    break;
            }
        }
    }

}