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
            }
        }
    }
}