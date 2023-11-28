import java.io.*;

public class Pokemons {
    private Pokemon[] pokemons;
    private String[] type1s;
    private int numPokemons;
    private int numType1s;

    public Pokemons() throws IOException {
        pokemons = new Pokemon[1000];
        type1s = new String[100];
        numPokemons = 0;
        numType1s = 0;
        readFromFile();
        readType1s();
    }

    private void readFromFile() throws IOException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("Pokemons.csv"));
            input.readLine();
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String name = items[1];
                String type1 = items[2];
                String type2 = items[3];
                int generation =  Integer.parseInt(items[11]);
                int attack = Integer.parseInt(items[6]);
                int defense = Integer.parseInt(items[7]);
                Pokemon pokemon = new Pokemon(name, type1, type2,
                        generation, attack, defense);
                pokemons[numPokemons] = pokemon;
                numPokemons++;
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private void readType1s() throws IOException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("Pokemons.csv"));
            input.readLine();
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String type = items[2];
                if (!exists(type)) {
                    type1s[numType1s] = type;
                    numType1s++;
                }
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private boolean exists(String type) {
        boolean exists = false;
        for (int i = 0; i < numType1s; i++) {
            if (type1s[i].equalsIgnoreCase(type)) {
                exists = true;
                break;
            }
        }
        return exists;
    }


    public void writeBestToFile() throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("BestPokemons.csv"));
            out.println("name,type1,type2,generation,attack,defense");
            for (int i = 0; i < numType1s; i++) {
                Pokemon best = null;
                for (int j = 0; j < numPokemons; j++) {
                    Pokemon p = pokemons[j];
                    if (p.getType1().equalsIgnoreCase(type1s[i])) {
                        if (best == null) {
                            best = p;

                        } else {
                            if (p.getTotal() > best.getTotal()) {
                                best = p;
                            }
                        }
                    }
                }
                out.println(best.getName() + "," + best.getType1() +
                        "," + best.getType2() + "," + best.getGeneration() +
                        "," + best.getAttack() + "," + best.getDefense());
            }

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void displayStrongest(String type) {
        Pokemon best = null;
        for (int i = 0; i < numPokemons; i++) {
            if (type.equalsIgnoreCase(pokemons[i].getType1())) {
                if (best == null) {
                    best = pokemons[i];
                } else {
                    if (pokemons[i].getAttack() > best.getAttack()) {
                        best = pokemons[i];
                    }
                }
            }
        }
        if (best == null) {
            System.out.println("Type " + type + " doesn't exist");
        } else {
            System.out.println(best);
        }
    }
}
