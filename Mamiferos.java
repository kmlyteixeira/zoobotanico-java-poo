import java.util.ArrayList;

public class Mamiferos extends Animal {
    public String tempoGestacao;
    public ArrayList<Alimentacao> alimentacoes;
    public Jaula jaula;

    public static ArrayList<Mamiferos> mamiferos = new ArrayList<Mamiferos>();

    public Mamiferos (
        int id, 
        String nome, 
        String especie,
        String tempoGestacao,
        Jaula jaula
    ) {
        super(id, nome, especie);
        this.tempoGestacao = tempoGestacao;
        this.alimentacoes = new ArrayList<Alimentacao>();
        this.jaula = jaula;

        mamiferos.add(this);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tempo de gestação: " + this.tempoGestacao;
    }
}
