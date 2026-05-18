package challenge13;

import java.util.ArrayList;
import java.util.List;

public class Pond {

    private Stone[][] grid;
    private int rows;
    private int cols;

    // 8 possible directions (including diagonals)
    private static final int[][] DIRS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        {-1,-1}, {-1, 1}, {1,-1}, {1, 1}
    };

    public Pond(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Stone[rows][cols];
        // border stones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    grid[r][c] = new Stone(r, c);
                }
            }
        }
    }

    public void populate(int numWeeds, int numFish) {
        placeObjects(numWeeds, false);
        placeObjects(numFish, true);
    }

    private void placeObjects(int count, boolean isFish) {
        int placed = 0;
        while (placed < count) {
            int r = 1 + (int)(Math.random() * (rows - 2));
            int c = 1 + (int)(Math.random() * (cols - 2));
            if (grid[r][c] == null) {
                grid[r][c] = isFish ? new Fish(r, c) : new Weed(r, c);
                placed++;
            }
        }
    }

    public void simulate(int cycles) {
        print(0);
        for (int cycle = 1; cycle <= cycles; cycle++) {
            update();
            print(cycle);
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }
    }

    private void update() {
        boolean[][] processed = new boolean[rows][cols];

        // snapshot positions at start of cycle
        List<int[]> fishList = new ArrayList<>();
        List<int[]> weedList = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] instanceof Fish) fishList.add(new int[]{r, c});
                else if (grid[r][c] instanceof Weed) weedList.add(new int[]{r, c});
            }
        }

        // --- update fish ---
        for (int[] pos : fishList) {
            int r = pos[0], c = pos[1];
            if (processed[r][c]) continue;
            if (!(grid[r][c] instanceof Fish)) continue; // displaced by another fish

            Fish fish = (Fish) grid[r][c];

            int[] weedCell = findAdjacent(r, c, "weed");
            if (weedCell != null) {
                // eat adjacent weed
                grid[weedCell[0]][weedCell[1]] = null;
                fish.ate();
            } else {
                // no food — try to move to empty cell
                int[] emptyCell = findAdjacent(r, c, "empty");
                if (emptyCell != null && !processed[emptyCell[0]][emptyCell[1]]) {
                    grid[emptyCell[0]][emptyCell[1]] = fish;
                    fish.row = emptyCell[0];
                    fish.col = emptyCell[1];
                    grid[r][c] = null;
                    processed[emptyCell[0]][emptyCell[1]] = true;
                }
                fish.incrementHunger(); // starving
            }

            if (!fish.isAlive()) grid[fish.row][fish.col] = null;
            processed[r][c] = true;
        }

        // --- update weeds ---
        List<int[]> toReproduce = new ArrayList<>();

        for (int[] pos : weedList) {
            int r = pos[0], c = pos[1];
            if (processed[r][c]) continue;
            if (!(grid[r][c] instanceof Weed) || grid[r][c] instanceof Fish) continue; // eaten

            Weed weed = (Weed) grid[r][c];
            if (weed.shouldReproduce()) toReproduce.add(new int[]{r, c});

            weed.grow();
            if (weed.shouldDie()) {
                weed.die();
                grid[r][c] = null;
            }
            processed[r][c] = true;
        }

        // spawn new weeds from reproduction
        for (int[] pos : toReproduce) {
            if (!(grid[pos[0]][pos[1]] instanceof Weed)) continue; // parent died this cycle
            int[] empty = findAdjacent(pos[0], pos[1], "empty");
            if (empty != null) {
                grid[empty[0]][empty[1]] = new Weed(empty[0], empty[1]);
            }
        }
    }

    // find a random adjacent cell of the given type ("empty" or "weed")
    private int[] findAdjacent(int r, int c, String type) {
        int[] order = {0, 1, 2, 3, 4, 5, 6, 7};
        // shuffle for random direction each time
        for (int i = 7; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));
            int tmp = order[i]; order[i] = order[j]; order[j] = tmp;
        }
        for (int idx : order) {
            int nr = r + DIRS[idx][0];
            int nc = c + DIRS[idx][1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            Stone cell = grid[nr][nc];
            if (type.equals("empty") && cell == null) return new int[]{nr, nc};
            if (type.equals("weed") && cell instanceof Weed && !(cell instanceof Fish)) return new int[]{nr, nc};
        }
        return null;
    }

    private void print(int cycle) {
        int fishCount = 0, weedCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] instanceof Fish) fishCount++;
                else if (grid[r][c] instanceof Weed) weedCount++;
            }
        }
        System.out.println("Cycle " + cycle + " | Fish: " + fishCount + " | Weeds: " + weedCount);
        for (Stone[] row : grid) {
            for (Stone cell : row) {
                System.out.print(cell == null ? '.' : cell.symbol());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pond pond = new Pond(16, 24);
        pond.populate(35, 5); // 35 weeds, 5 fish
        pond.simulate(80);
    }
}
