
class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String telefoneUsuario;
    private String enderecoUsuario;
    private String senhaUsuario;

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String telefoneUsuario,
            String enderecoUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.enderecoUsuario = enderecoUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public String realizarLoginUsuario() {
        // sql
        return "";
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;

    }

}
