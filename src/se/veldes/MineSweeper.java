package se.veldes;

public class MineSweeper {

    private static final int BOMB = -1;
    private static final int HIDDEN_EMPTY = 0;
    private static final int REVEALED_EMPTY = -2;

    private final int[][] field;
    private final int rows;
    private final int cols;

    public MineSweeper(int rows, int cols) {
        this.field = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }



    public void placeBombs(final int[][] bombLocations) {

        for (int i=0; i < bombLocations.length; i++) {
            placeBomb(bombLocations[i][0],bombLocations[i][1]);
        }

    }

    public void placeBomb(final int row, final int col) {
        if(row >= this.rows)
            throw new IllegalArgumentException("Bomb row "+row+" is outside field. Field has "+rows+" rows.");
        if(col >= this.cols)
            throw new IllegalArgumentException("Bomb col "+col+" is outside field. Field has "+col+" columns.");

        for(int r=row-1; r <= row+1 && r < this.rows; r++) {
            for (int c = col - 1; c <= col + 1 && c < this.cols; c++) {
            if(r >= 0 && c >= 0) {
                if (r == row && c == col)
                    this.field[r][c] = BOMB;
                else if(this.field[r][c] != BOMB)
                    this.field[r][c] += 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        MineSweeper mineSweeper = new MineSweeper(3, 4);

        int[][] bombLocations = {{0,0},{0,1}};

        mineSweeper.placeBombs(bombLocations);

        for(int[] i : mineSweeper.field) {
            for(int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }


    }

}
