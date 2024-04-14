import java.util.ArrayList;
import java.util.List;

class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private float preco;

    // Construtor
    public Produto(int idProduto, String nome, String descricao, float preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}

class SistemaProdutos {
    private List<Produto> produtos;

    // Construtor
    public SistemaProdutos() {
        this.produtos = new ArrayList<>();
    }

    // Método para adicionar um produto
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover um produto pelo ID
    public void removerProduto(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                produtos.remove(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    // Método para visualizar um produto pelo ID
    public void visualizarProduto(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                System.out.println("ID: " + produto.getIdProduto());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("Preço: " + produto.getPreco());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    // Método para listar todos os produtos
    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getIdProduto() + ", Nome: " + produto.getNome() + ", Descrição: " + produto.getDescricao() + ", Preço: " + produto.getPreco());
        }
    }

    // Método para editar um produto pelo ID
    public void editarProduto(int idProduto, String novoNome, String novaDescricao, float novoPreco) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                produto.setNome(novoNome);
                produto.setDescricao(novaDescricao);
                produto.setPreco(novoPreco);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
