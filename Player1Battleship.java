public class Player1Battleship
{
    static int gridSize = 10;
    static int[][] shipPositions = new int[gridSize][gridSize];
    static int[][] player2ShipPositions = new int[gridSize][gridSize];

    public static int[][] hitsAndMisses = new int[gridSize][gridSize];
    public static int[][] enemyHitsAndMisses = new int[gridSize][gridSize];
    public static int[][] player2SpotFired = new int[gridSize][gridSize];

    public static int whichBoat;

    public static int[] boatSize = { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };

    public static Boolean vertical = false;
    public static Boolean horizontal = true;

    public static int[][] tempField = new int[gridSize][gridSize];

    public static String gameState = "placeShips";

    public static PlayerGUI gamePlayer1;
    public static OperationBoard game2;


    MainWindow menu = new MainWindow(1080, 1920);

    public static int[][] getBoatPositions() {
        return shipPositions;
    }

    public static void setBoatPositions(int[][] updateBoats)
    {
        shipPositions = updateBoats;
    }

    public static int[][] getEnemyBoatPositions() {
        return player2ShipPositions;
    }

    public static void setEnemyBoatPositions(int[][] updateBoats)
    {
        player2ShipPositions = updateBoats;
    }

    public static void resetGame() {
        try {
            gamePlayer1.dispose();
            game2.dispose();
        } catch (NullPointerException e) {

        }
        for (int rows = 0; rows < gridSize; rows++) {
            for (int columns = 0; columns < gridSize; columns++) {
                try {
                    shipPositions[rows][columns] = 0;
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    player2ShipPositions[rows][columns] = 0;
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
                    player2SpotFired[rows][columns] = 0;
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

        gamePlayer1 = new PlayerGUI(gridSize, 600, 600);
        gamePlayer1.setSize(600, 800);
        gamePlayer1.setVisible(false);

        game2 = new OperationBoard(gridSize, 600, 600);
        game2.setSize(600, 800);
        game2.setLocation(600, 0);
        game2.setVisible(false);

    }
}
