import java.util.ArrayList;

public class Repteis extends Animal{
    public String habitat;
    public ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Repteis> repteis = new ArrayList<Repteis>();

    public Repteis (
        int id, 
        String nome, 
        String especie,
        String habitat
    ) {
        super(id, nome, especie);
        this.habitat = habitat;
        this.alimentacoes = new ArrayList<Alimentacao>();

        repteis.add(this);
        super.animais.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Habitat: " + this.habitat;
    }
}
