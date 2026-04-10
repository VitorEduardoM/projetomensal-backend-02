package Controladores.controladorProdutos;

import entity.Produto;
import service.produto.AtualizarProduto;
import service.produto.CadastroDeProduto;
import service.produto.ProdutoService;
import util.LimpaTerminal;
import util.VerificaEntradas;
import view.MenuView;

public class ControladorProduto {
    private ProdutoService produtoService = new ProdutoService();

    public void menuProdutos() {
        LimpaTerminal.limparTela();
        int opcao = -1;

        while (opcao != 0) {
            MenuView.exibirMenuProdutos();
            opcao = VerificaEntradas.lerInteiro("Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    Produto produtoCadastrar = CadastroDeProduto.cadastrarProduto();
                    if (produtoCadastrar != null) {
                        produtoService.cadastrar(produtoCadastrar);
                    }
                    break;
                case 2:
                    produtoService.listarTodos();
                    break;
                case 3:
                    Produto produtoAtualizado = AtualizarProduto.atualizarProduto(produtoService);
                    if (produtoAtualizado != null) {
                        produtoService.atualizar(produtoAtualizado);
                    }
                    break;
            }
        }
    }
}