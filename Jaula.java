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

    public static Jaula deleteJaulaById(int id) {
        for (Jaula jaula : Jaula.jaulas) {
            if (jaula.id == id) {
                Jaula.jaulas.remove(jaula);
                return jaula;
            }
        }

        return null;
    }

    public static boolean VerificaJaulaAnimal(Jaula jaula, Animal animal) {
        boolean valida = true;

        if (jaula.tipo != "M") {
            if (!(animal instanceof Mamiferos)) {
                valida = false;
            } 
        } else if (jaula.tipo != "A") {
            if (!(animal instanceof Aves)) {
                valida = false;
            } 
        } else if (jaula.tipo != "R") {
            if (!(animal instanceof Repteis)) {
                valida = false;
            } 
        } 

        return valida;
    }
}
