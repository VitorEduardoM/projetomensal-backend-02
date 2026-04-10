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
                case 4:
                    System.out.println("\n========== REMOVER PRODUTO ==========");
                    produtoService.listarTodos();
                    Long idRemover = VerificaEntradas.lerLong("ID do produto a remover: ");
                    produtoService.remover(idRemover);
                    break;
                case 5:
                    String buscarNome = VerificaEntradas.lerTexto("Digite o nome para buscar: ");
                    produtoService.buscarPorNome(buscarNome);
                    break;
                case 6:
                    String buscarCategoria = VerificaEntradas.lerTexto("Digite a categoria para buscar: ");
                    produtoService.buscarPorCategoria(buscarCategoria);
                    break;
                case 7:
                    produtoService.exibirRelatorio();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;
            }
        }
    }
}