import java.util.ArrayList;

public class Aves extends Animal{
    public String plumagem;
    public ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Aves> aves = new ArrayList<Aves>();

    public Aves (
        int id, 
        String nome, 
        String especie,
        String plumagem
    ) {
        super(id, nome, especie);
        this.plumagem = plumagem;
        this.alimentacoes = new ArrayList<Alimentacao>();

        aves.add(this);
        super.animais.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumagem: " + this.plumagem;
    }
}
