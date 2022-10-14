import java.util.ArrayList;

public class Aves extends Animal{
    public String plumagem;
    public ArrayList<Alimentacao> alimentacoes;
    Jaula jaula;

    public static ArrayList<Aves> aves = new ArrayList<Aves>();

    public Aves (
        int id, 
        String nome, 
        String especie,
        String plumagem,
        Jaula jaula
    ) {
        super(id, nome, especie);
        this.plumagem = plumagem;
        this.alimentacoes = new ArrayList<Alimentacao>();
        this.jaula = jaula;

        aves.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumagem: " + this.plumagem;
    }

    public static Aves getAveById(int id) {
        for (Aves ave : Aves.aves) {
            if (ave.id == id) {
                return ave;
            }
        }

        return null;
    }
}
