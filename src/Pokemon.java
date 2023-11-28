public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private int generation;
    private int attack;
    private int defense;

    public Pokemon(String name, String type1, String type2, int generation, int attack, int defense) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.generation = generation;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return name + " (" + type1 + ", " + type2 + "). " +
            "Generation: " + generation + ". Attack: " +
                attack + ". Defense: " + defense + ". Total: " +
                (attack + defense);
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getGeneration() {
        return generation;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getTotal() {
        return attack + defense;
    }
}
