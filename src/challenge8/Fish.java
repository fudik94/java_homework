package challenge8;

import java.util.List;

public class Fish extends Weed {

    private String fishName;

    public Fish(int x, int y, String fishName) {
        super(x, y);
        this.fishName = fishName;
    }

    public void move(int newX, int newY, List<Stone> pond) {
        for (Stone obj : pond) {
            if (obj == this) continue; // skip self
            if (obj.getX() == newX && obj.getY() == newY) {
                System.out.println(fishName + " can't move to (" + newX + ", " + newY + ") - blocked!");
                return;
            }
        }
        x = newX;
        y = newY;
        System.out.println(fishName + " moved to (" + x + ", " + y + ")");
    }

    public String getFishName() { return fishName; }

    @Override
    public String toString() {
        return "Fish " + fishName + " at (" + x + ", " + y + ")";
    }
}
