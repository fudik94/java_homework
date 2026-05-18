package challenge13;

public class Weed extends Stone {

    protected boolean alive = true;
    protected int age = 0;

    static final int    MAX_AGE          = 30;
    static final double DEATH_CHANCE     = 0.03;
    static final double REPRODUCE_CHANCE = 0.12;

    public Weed(int row, int col) {
        super(row, col);
    }

    public void grow() {
        age++;
    }

    public boolean shouldDie() {
        return age >= MAX_AGE || Math.random() < DEATH_CHANCE;
    }

    public boolean shouldReproduce() {
        return alive && Math.random() < REPRODUCE_CHANCE;
    }

    public boolean isAlive() { return alive; }
    public void die() { alive = false; }

    @Override
    public char symbol() { return 'W'; }
}
