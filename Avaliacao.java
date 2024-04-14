import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Avaliacao {
    private Date dataAvaliacao;
    private int notaAvaliacao;
    private String descricaoAvaliacao;

    public Avaliacao(Date dataAvaliacao, int notaAvaliacao, String descricaoAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.descricaoAvaliacao = descricaoAvaliacao;
    }

    

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }



    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }



    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }



    public void setNotaAvaliacao(int notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }



    public String getDescricaoAvaliacao() {
        return descricaoAvaliacao;
    }



    public void setDescricaoAvaliacao(String descricaoAvaliacao) {
        this.descricaoAvaliacao = descricaoAvaliacao;
    }



    public void editarAvaliacao(Date dataAvaliacao, int notaAvaliacao, String descricaoAvaliacao) {
        try {
            String sql = "UPDATE avaliacoes SET data_avaliacao = ?, nota_avaliacao = ?, descricao_avaliacao = ? WHERE id = ?";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(dataAvaliacao.getTime()));
            statement.setInt(2, notaAvaliacao);
            statement.setString(3, descricaoAvaliacao);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void exibirAvaliacao(int idAvaliacao) {
        try {
            String sql = "SELECT * FROM avaliacoes WHERE id = ?";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAvaliacao);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Date data = resultSet.getDate("data_avaliacao");
                int nota = resultSet.getInt("nota_avaliacao");
                String descricao = resultSet.getString("descricao_avaliacao");
                System.out.println("Data da avaliação: " + data);
                System.out.println("Nota da avaliação: " + nota);
                System.out.println("Descrição da avaliação: " + descricao);
            } else {
                System.out.println("Avaliação não encontrada.");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        try {
            String sql = "INSERT INTO avaliacoes (data_avaliacao, nota_avaliacao, descricao_avaliacao) VALUES (?, ?, ?)";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(avaliacao.getDataAvaliacao().getTime()));
            statement.setInt(2, avaliacao.getNotaAvaliacao());
            statement.setString(3, avaliacao.getDescricaoAvaliacao());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerAvaliacao(int idAvaliacao) {
        try {
            String sql = "DELETE FROM avaliacoes WHERE id = ?";
            Connection connection = getConnection(); // Método fictício para obter conexão com o banco de dados
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAvaliacao);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM avaliacoes";
            Connection connection = getConnection(); // Método fictício para obter conexão com o banco de dados
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Date data = resultSet.getDate("data_avaliacao");
                int nota = resultSet.getInt("nota_avaliacao");
                String descricao = resultSet.getString("descricao_avaliacao");
                Avaliacao avaliacao = new Avaliacao(data, nota, descricao);
                avaliacoes.add(avaliacao);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avaliacoes;
    }

    // Método fictício para obter conexão com o banco de dados
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:8080/POOdb";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // Getters e setters omitidos para brevidade

    public static void main(String[] args) {
        Avaliacao avaliacao = new Avaliacao(new Date(), 5, "Avaliação muito boa");
        avaliacao.adicionarAvaliacao(avaliacao);
        avaliacao.listarAvaliacoes().forEach(a -> System.out.println("Avaliação: " + a.getDescricaoAvaliacao()));
    }


}

