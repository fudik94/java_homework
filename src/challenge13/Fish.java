package challenge13;

public class Fish extends Weed {

    private int hunger = 0;
    static final int MAX_HUNGER = 8; // cycles without food before dying

    public Fish(int row, int col) {
        super(row, col);
    }

    public void ate() {
        hunger = 0;
    }

    public void incrementHunger() {
        hunger++;
        if (hunger >= MAX_HUNGER) {
            alive = false;
        }
    }

    public int getHunger() { return hunger; }

    @Override
    public char symbol() { return 'F'; }
}
