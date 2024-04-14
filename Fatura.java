import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Fatura {
    private Date dataFatura;
    private float valorFatura;
    private String metodoPagamento;
    private String descricaoPagamento;
    private boolean pagamentoFatura;

    // Construtor
    public Fatura(Date dataFatura, float valorFatura, String metodoPagamento, String descricaoPagamento) {
        this.dataFatura = dataFatura;
        this.valorFatura = valorFatura;
        this.metodoPagamento = metodoPagamento;
        this.descricaoPagamento = descricaoPagamento;
        this.pagamentoFatura = false; // inicialmente não confirmado
    }

    // Getters e Setters
    public Date getDataFatura() {
        return dataFatura;
    }

    public void setDataFatura(Date dataFatura) {
        this.dataFatura = dataFatura;
    }

    public float getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(float valorFatura) {
        this.valorFatura = valorFatura;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getDescricaoPagamento() {
        return descricaoPagamento;
    }

    public void setDescricaoPagamento(String descricaoPagamento) {
        this.descricaoPagamento = descricaoPagamento;
    }

    public boolean isPagamentoFatura() {
        return pagamentoFatura;
    }

    public void setPagamentoFatura(boolean pagamentoFatura) {
        this.pagamentoFatura = pagamentoFatura;
    }

    // Método para confirmar o pagamento da fatura
    public boolean confirmarPagamentoFatura() {
        if (!pagamentoFatura) {
            pagamentoFatura = true;
            return true; // Pagamento confirmado com sucesso
        }
        return false; // Pagamento já confirmado anteriormente
    }
}

class SistemaPetShop {
    private List<Fatura> faturas;

    // Construtor
    public SistemaPetShop() {
        this.faturas = new ArrayList<>();
    }

    // Método para adicionar uma fatura
    public void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
    }

    // Método para editar uma fatura
    public void editarFatura(int indice, Fatura novaFatura) {
        if (indice >= 0 && indice < faturas.size()) {
            faturas.set(indice, novaFatura);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para remover uma fatura
    public void removerFatura(int indice) {
        if (indice >= 0 && indice < faturas.size()) {
            faturas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para visualizar uma fatura
    public void visualizarFatura(int indice) {
        if (indice >= 0 && indice < faturas.size()) {
            Fatura fatura = faturas.get(indice);
            System.out.println("Data da Fatura: " + fatura.getDataFatura());
            System.out.println("Valor da Fatura: " + fatura.getValorFatura());
            System.out.println("Método de Pagamento: " + fatura.getMetodoPagamento());
            System.out.println("Descrição do Pagamento: " + fatura.getDescricaoPagamento());
            System.out.println("Pagamento Confirmado: " + (fatura.isPagamentoFatura() ? "Sim" : "Não"));
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para listar todas as faturas
    public void listarFaturas() {
        for (int i = 0; i < faturas.size(); i++) {
            System.out.println("Fatura #" + (i + 1));
            visualizarFatura(i);
            System.out.println();
        }
    }
}
