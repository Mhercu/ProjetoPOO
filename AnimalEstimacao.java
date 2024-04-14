import java.util.ArrayList;
import java.util.List;

public class AnimalEstimacao{

    private int idPet;
    private String nomePet;
    private String racaPet;
    private String idadePet;
    private float tamanhoPet;
    private float pesoPet;

    private List<AnimalEstimacao> animaisEstimacao = new ArrayList<>();

    public AnimalEstimacao(int idPet, String nomePet, String racaPet, String idadePet, float tamanhoPet, float pesoPet){
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.racaPet = racaPet;
        this.idadePet = idadePet;
        this.tamanhoPet = tamanhoPet;
        this.pesoPet = pesoPet;
    }

    public void adicionarAnimal(int idPet, String nomePet, String racaPet, String idadePet, float tamanhoPet, float pesoPet){
        AnimalEstimacao animal = new AnimalEstimacao(idPet, nomePet, racaPet, idadePet, tamanhoPet, pesoPet);
        animaisEstimacao.add(animal);
    }

    public void removerAnimal(int idPet){
        animaisEstimacao.removeIf(animal -> animal.getIdPet() == idPet);
    }

    public void visualizarAnimal(int idPet){
        for(AnimalEstimacao animal : animaisEstimacao){
            if(animal.getIdPet() == idPet){
                System.out.println("ID: " + animal.getIdPet());
                System.out.println("Nome: " + animal.getNomePet());
                System.out.println("Raça: " + animal.getRacaPet());
                System.out.println("Idade: " + animal.getIdadePet());
                System.out.println("Tamanho: " + animal.getTamanhoPet());
                System.out.println("Peso: " + animal.getPesoPet());
            }
        }
    }

    public void editarAnimal(int idPet, String nomePet, String racaPet, String idadePet, float tamanhoPet, float pesoPet){
        for(AnimalEstimacao animal : animaisEstimacao) {
            if(animal.getIdPet() == idPet){
                animal.setNomePet(nomePet);
                animal.setRacaPet(nomePet);
                animal.setIdadePet(idadePet);
                animal.setTamanhoPet(tamanhoPet);
                animal.setPesoPet(pesoPet);
            }
        }
    }

    public void listarAnimal(){
        for(AnimalEstimacao animal : animaisEstimacao){
            System.out.println("ID: " + animal.getIdPet());
            System.out.println("Nome: " + animal.getNomePet());
            System.out.println("Raça: " + animal.getRacaPet());
            System.out.println("Idade: " + animal.getIdadePet());
            System.out.println("Tamanho: " + animal.getTamanhoPet());
            System.out.println("Peso: " + animal.getPesoPet());
        }
    }

    // Getters e setters
    public int getIdPet(){
        return(idPet);
    }
    public void setIdPet(int idPet){
        this.idPet = idPet;
    }

    public String getNomePet(){
        return(nomePet);
    }
    public void setNomePet(String nomePet){
        this.nomePet = nomePet;
    }

    public String getRacaPet(){
        return(racaPet);
    }
    public void setRacaPet(String racaPet){
        this.racaPet = racaPet; 
    }

    public String getIdadePet(){
        return(idadePet);
    }
    public void setIdadePet(String idadePet){
        this.idadePet = idadePet; 
    }

    public float getTamanhoPet(){
        return(tamanhoPet);
    }
    public void setTamanhoPet(float tamanhoPet){
        this.tamanhoPet = tamanhoPet; 
    }

    public float getPesoPet(){
        return(pesoPet);
    }
    public void setPesoPet(float pesoPet){
        this.pesoPet = pesoPet; 
    }
}