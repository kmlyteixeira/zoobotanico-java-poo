import java.util.ArrayList;

public class Alimentacao {
    public int id;
    public String data;
    public String descricao;
    public Animal animal;

    public static ArrayList<Alimentacao> alimentacoes = new ArrayList<Alimentacao>();

    public Alimentacao (
        int id, 
        String data, 
        String descricao,
        Animal animal
    ) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.animal = animal;

        alimentacoes.add(this);
    }
}
