import java.util.ArrayList;

public abstract class Animal {
    public int id;
    public String nome;
    public String especie;
    public ArrayList<Alimentacao> alimentacoes;

    public static ArrayList<Animal> animais = new ArrayList<Animal>();

    protected Animal (
        int id, 
        String nome, 
        String especie
    ) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " | Especie: " + this.especie;
    }

    public static Animal getAnimalById(int id) {
        for (Animal animal : Animal.animais) {
            if (animal.id == id) {
                return animal;
            }
        }

        return null;
    }
}