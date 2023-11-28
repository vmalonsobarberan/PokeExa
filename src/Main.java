import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Pokemons p = new Pokemons();
        p.writeBestToFile();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter type of pokemon: ");
        String type = input.next();
        p.displayStrongest(type);
    }
}
