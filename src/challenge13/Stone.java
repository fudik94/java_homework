package challenge13;

public class Stone {

    protected int row;
    protected int col;

    public Stone(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public char symbol() { return '#'; }
}
