import java.util.ArrayList;

public class Jaula {
    public int id;
    public String nome;
    public String tipo;
    public ArrayList<Animal> animais;

    public static ArrayList<Jaula> jaulas = new ArrayList<Jaula>();

    public Jaula (
        int id, 
        String nome, 
        String tipo
    ) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.animais = new ArrayList<Animal>();

        jaulas.add(this);
    }

    public void validaAnimalJaula(Animal animal) {
        if (this.tipo == "M" && animal instanceof Mamiferos) {
            this.animais.add(animal);
        } else if (this.tipo == "R" && animal instanceof Repteis) {
            this.animais.add(animal);
        } else if (this.tipo == "A" && animal instanceof Aves) {
            this.animais.add(animal);
        } else {
            System.out.println("Animal não pertence a esta jaula!");
        }
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | Nome: " + this.nome + " | Tipo: " + this.tipo + " | Animais: " + this.animais;
    }

    public static Jaula getJaulaById(int id) {
        for (Jaula jaula : Jaula.jaulas) {
            if (jaula.id == id) {
                return jaula;
            }
        }

        return null;
    }
}
