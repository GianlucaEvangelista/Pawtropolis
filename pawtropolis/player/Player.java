package pawtropolis.player;

public class Player {

    private String name;
    private int lifePoints;
    private static final int MAX_LIFE_POINTS = 100;
    private final Bag bag;

    public Player(String name) {
        this.name = name;
        this.lifePoints = MAX_LIFE_POINTS;
        this.bag = new Bag();
    }

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bag getBag() {
        return bag;
    }
}
