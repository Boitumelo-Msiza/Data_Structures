public class Game_Of_Life {

    public static void main(String[] args)
    {

        int X = 10, Y = 10;

        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        // Displaying the grid
        System.out.println("INPUT");
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, X, Y);
    }

    // Method to print next generation
    static void nextGeneration(int grid[][], int X, int Y)
    {
        int[][] future = new int[X][Y];

        // Loop through every cell
        for (int l = 1; l < X - 1; l++)
        {
            for (int x = 1; x < Y - 1; x++)
            {
                // finding num of alive neighbors
                int Alive = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        Alive += grid[l + i][x + j];

                Alive -= grid[l][x];

                // if cell has less than two neighbors it dies of underpopulation
                if ((grid[l][x] == 1) && (Alive < 2))
                    future[l][x] = 0;

                    //if cell has more than three live neighbors it dies of overpopulation.
                else if ((grid[l][x] == 1) && (Alive > 3))
                    future[l][x] = 0;

                    // dead cell with exactly three live neighbors becomes a live cell as of reproduction
                else if ((grid[l][x] == 0) && (Alive == 3))
                    future[l][x] = 1;

                else
                    future[l][x] = grid[l][x];
            }
        }

        System.out.println("NEXT GENERATION");
        for (int j = 0; j <Y; j++)
        {
            for (int i = 0; i <X; i++)
            {
                if (future[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }


}


