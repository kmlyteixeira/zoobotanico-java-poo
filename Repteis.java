import java.util.ArrayList;

public class Repteis extends Animal{
    public String habitat;
    public ArrayList<Alimentacao> alimentacoes;
    public Jaula jaula;

    public static ArrayList<Repteis> repteis = new ArrayList<Repteis>();

    public Repteis (
        int id, 
        String nome, 
        String especie,
        String habitat,
        Jaula jaula
    ) {
        super(id, nome, especie);
        this.habitat = habitat;
        this.alimentacoes = new ArrayList<Alimentacao>();
        this.jaula = jaula;

        repteis.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Habitat: " + this.habitat;
    }

    public static Repteis getReptilById(int id) {
        for (Repteis reptil : Repteis.repteis) {
            if (reptil.id == id) {
                return reptil;
            }
        }

        return null;
    }
}
