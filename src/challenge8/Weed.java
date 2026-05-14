package challenge8;

public class Weed extends Stone {

    private boolean alive;
    private int size;

    public Weed(int x, int y) {
        super(x, y);
        this.alive = true;
        this.size = 1;
    }

    public void grow() {
        if (alive) {
            size++;
            System.out.println("Weed at (" + x + ", " + y + ") grew to size " + size);
        }
    }

    public void die() {
        alive = false;
        System.out.println("Weed at (" + x + ", " + y + ") died");
    }

    public boolean isAlive() { return alive; }
    public int getSize() { return size; }

    @Override
    public String toString() {
        return "Weed at (" + x + ", " + y + "), alive=" + alive + ", size=" + size;
    }
}
