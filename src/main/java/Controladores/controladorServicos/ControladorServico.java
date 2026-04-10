package Controladores.controladorServicos;

import entity.Servico;
import service.servico.AtualizarServico;
import service.servico.CadastroServico;
import service.servico.ServicoService;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;

public class ControladorServico {
    private ServicoService servicoService;

    public ControladorServico(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    public void menuServico() {
        LimpaTerminal.limparTela();
        int opcao = -1;

        while (opcao != 0) {
            MenuView.exibirMenuServicos();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    Servico servicoCadastrar = CadastroServico.cadastrarServico();
                    if (servicoCadastrar != null) {
                        servicoService.cadastrar(servicoCadastrar);
                    }
                    break;
                case 2:
                    servicoService.listarTodos();
                    break;
                case 3:
                    Servico servicoAtualizado = AtualizarServico.atualizarServico(servicoService);
                    if (servicoAtualizado != null) {
                        servicoService.atualizar(servicoAtualizado);
                    }
                    break;
                case 4:
                    System.out.println("\n========== REMOVER SERVIÇO ==========");
                    servicoService.listarTodos();
                    Long idRemover = VerificaEntradas.lerLong("ID do serviço a remover: ");
                    servicoService.remover(idRemover);
                    break;
                case 5:
                    String buscarNome = VerificaEntradas.lerTexto("Digite o nome para buscar: ");
                    servicoService.buscarPorNome(buscarNome);
                    break;
                case 6:
                    String buscarTipo = VerificaEntradas.lerTexto("Digite o tipo para buscar: ");
                    servicoService.buscarPorTipo(buscarTipo);
                    break;
                case 7:
                    servicoService.exibirRelatorio();
                    break;
            }
        }
    }
}