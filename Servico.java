import java.util.ArrayList;
import java.util.List;

public class Servico {
    private List<String> servicos;

    public Servico() {
        servicos = new ArrayList<>();
    }

    public void agendarServico(String servico) {
        servicos.add(servico);
    }

    public void adicionarServico(String servico) {
        servicos.add(servico);
    }

    public void removerServico(String servico) {
        servicos.remove(servico);
    }

    public void visualizarServico(String servico) {
        System.out.println("Serviço: " + servico);
    }

    public void editarServico(String servicoAtual, String servicoNovo) {
        int index = servicos.indexOf(servicoAtual);
        if (index != -1) {
            servicos.set(index, servicoNovo);
        }
    }

    public void listarServico() {
        System.out.println("Lista de serviços:");
        for (String servico : servicos) {
            System.out.println(servico);
        }
    }
}
