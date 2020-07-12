import java.util.Random;

public class Battleship
{
    static int gridSize = 10;
    static int[][] shipPositions = new int[gridSize][gridSize];
    static int[][] enemyBoatPositions = new int[gridSize][gridSize];

    public static int[][] hitsAndMisses = new int[gridSize][gridSize];
    public static int[][] enemyHitsAndMisses = new int[gridSize][gridSize];
    public static int[][] enemySpotFired = new int[gridSize][gridSize];

    public static int whichBoat;

    public static int[] boatSize = { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };

    public static Boolean vertical = false;
    public static Boolean horizontal = true;

    public static int[][] tempField = new int[gridSize][gridSize];

    public static String gameState = "placeShips";

    public static int enemiesShipsSunk;
    public static int playersShipDestroy;

    public static PlayerGUI game;

    public static OperationBoard game2;

    public static void main(String[] args) {

        MainWindow menu = new MainWindow(1080, 1920);

        setSampleEnemyBoatBoard();

    }

    public static int[][] getBoatPositions() {
        return shipPositions;
    }

    public static void setBoatPositions(int[][] updateBoats)
    {
        shipPositions = updateBoats;
    }

    public static int[][] getEnemyBoatPositions() {
        return enemyBoatPositions;
    }

    public static void setEnemyBoatPositions(int[][] updateBoats)
    {
        enemyBoatPositions = updateBoats;
    }

    public static void resetGame()
    {
        try
        {
            game.dispose();
            game2.dispose();
        }
        catch (NullPointerException e) { }
        for (int rows = 0; rows < gridSize; rows++) {
            for (int columns = 0; columns < gridSize; columns++) {
                try {
                    shipPositions[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    enemyBoatPositions[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    hitsAndMisses[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    enemyHitsAndMisses[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    enemySpotFired[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    tempField[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }

            }
        }
        gameState = "placeShips";
        whichBoat = 0;

        game = new PlayerGUI(gridSize, 600, 600);
        game.setSize(600, 800);
        game.setVisible(false);

        game2 = new OperationBoard(gridSize, 600, 600);
        game2.setSize(600, 800);
        game2.setLocation(600, 0);
        game2.setVisible(false);

        setSampleEnemyBoatBoard();
    }

    private static void setSampleEnemyBoatBoard()
    {
        Random rand = new Random();
        int board = rand.nextInt(2 - 0 + 1) + 0;
        if (board == 0) {
            int[] array0 = { -1, -1, -1, 0, 0, 0, 0, 0, 0, 0 };
            enemyBoatPositions[0] = array0;

            int[] array1 = { 1, 1, -1, 0, 0, 0, 0, 0, 0, 0 };
            enemyBoatPositions[1] = array1;

            int[] array2 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[2] = array2;

            int[] array3 = { 1, 1, 1, 1, -1, -1, 1, 1, 1, -1 };
            enemyBoatPositions[3] = array3;

            int[] array4 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[4] = array4;

            int[] array5 = { -1, 1, 1, 1, -1, -1, 1, -1, -1, -1 };
            enemyBoatPositions[5] = array5;

            int[] array6 = { -1, -1, -1, -1, -1, -1, 1, -1, 1, 1 };
            enemyBoatPositions[6] = array6;

            int[] array7 = { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1 };
            enemyBoatPositions[7] = array7;

            int[] array8 = { -1, -1, -1, -1, -1, -1, -1, -1, 0, 0 };
            enemyBoatPositions[8] = array8;

            int[] array9 = { 1, -1, 1, -1, 1, -1, 1, -1, 0, 0 };
            enemyBoatPositions[9] = array9;
        }
        else if (board == 1)
        {
            int[] array0 = { 1, -1, 1, -1, 1, -1, 1, -1, 0, 0 };
            enemyBoatPositions[0] = array0;

            int[] array1 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[1] = array1;

            int[] array2 = { 0, -1, 1, 1, -1, -1, -1, -1, 1, 1 };
            enemyBoatPositions[2] = array2;

            int[] array3 = { -1, -1, -1, -1, -1, 1, 1, -1, -1, -1 };
            enemyBoatPositions[3] = array3;

            int[] array4 = { 1, 1, 1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[4] = array4;

            int[] array5 = { -1, -1, -1, -1, 0, -1, 1, 1, 1, -1 };
            enemyBoatPositions[5] = array5;

            int[] array6 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[6] = array6;

            int[] array7 = { -1, 1, 1, 1, 1, -1, 0, 0, 0, 0 };
            enemyBoatPositions[7] = array7;

            int[] array8 = { -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 };
            enemyBoatPositions[8] = array8;

            int[] array9 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            enemyBoatPositions[9] = array9;
        }
        else {

            int[] array0 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[0] = array0;

            int[] array1 = { -1, 1, -1, -1, 1, 1, -1, -1, 1, -1 };
            enemyBoatPositions[1] = array1;

            int[] array2 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[2] = array2;

            int[] array3 = { -1, 1, -1, 1, 1, 1, -1, -1, -1, -1 };
            enemyBoatPositions[3] = array3;

            int[] array4 = { -1, 1, -1, -1, -1, -1, -1, -1, 1, -1 };
            enemyBoatPositions[4] = array4;

            int[] array5 = { -1, 1, -1, 1, 1, 1, 1, -1, 1, -1 };
            enemyBoatPositions[5] = array5;

            int[] array6 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[6] = array6;

            int[] array7 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[7] = array7;

            int[] array8 = { -1, 1, -1, -1, 1, 1, -1, -1, 1, -1 };
            enemyBoatPositions[8] = array8;

            int[] array9 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
            enemyBoatPositions[9] = array9;
        }
    }
}
