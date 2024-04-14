import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String tipoCliente;

    public Cliente(int idUsuario, String nomeUsuario, String emailUsuario, String telefoneUsuario, String enderecoUsuario, String senhaUsuario, String tipoCliente) {
        super(idUsuario, nomeUsuario, emailUsuario, telefoneUsuario, enderecoUsuario, senhaUsuario);
        this.tipoCliente = tipoCliente;
    }

    public void adicionarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO usuarios (id, nome, email, telefone, endereco, senha, tipo_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Connection connection = getConnection(); // Método fictício para obter conexão com o banco de dados
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cliente.getIdUsuario());
            statement.setString(2, cliente.getNomeUsuario());
            statement.setString(3, cliente.getEmailUsuario());
            statement.setString(4, cliente.getTelefoneUsuario());
            statement.setString(5, cliente.getEnderecoUsuario());
            statement.setString(6, cliente.getSenhaUsuario());
            statement.setString(7, cliente.getTipoCliente());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerCliente(int idUsuario) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            Connection connection = getConnection(); // Método fictício para obter conexão com o banco de dados
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarCliente(int idUsuario) {
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                String senha = resultSet.getString("senha");
                String tipoCliente = resultSet.getString("tipo_cliente");
                System.out.println("Cliente encontrado: " + nome);
            } else {
                System.out.println("Cliente não encontrado.");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarCliente(Cliente cliente) {
        try {
            String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, endereco = ?, senha = ?, tipo_cliente = ? WHERE id = ?";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNomeUsuario());
            statement.setString(2, cliente.getEmailUsuario());
            statement.setString(3, cliente.getTelefoneUsuario());
            statement.setString(4, cliente.getEnderecoUsuario());
            statement.setString(5, cliente.getSenhaUsuario());
            statement.setString(6, cliente.getTipoCliente());
            statement.setInt(7, cliente.getIdUsuario());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM usuarios WHERE tipo_cliente = ?";
            Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "cliente");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String endereco = resultSet.getString("endereco");
                String senha = resultSet.getString("senha");
                String tipoCliente = resultSet.getString("tipo_cliente");
                Cliente cliente = new Cliente(id, nome, email, telefone, endereco, senha, tipoCliente);
                clientes.add(cliente);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:8080/POOdb";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    
}

