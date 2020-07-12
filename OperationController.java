import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class OperationController implements ActionListener
{

    int rows;
    int columns;
    int[][] field;
    int[][] enemyField;

    JButton buttonClicked;

    public OperationController(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.field = Battleship.getEnemyBoatPositions();
        this.enemyField = Battleship.getBoatPositions();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        buttonClicked = (JButton) event.getSource();
        buttonClicked.setEnabled(false);

        this.field = Battleship.getEnemyBoatPositions();
        this.enemyField = Battleship.getBoatPositions();

        for (int row = 0; row < Battleship.gridSize; row++)
        {
            for (int column = 0; column < Battleship.gridSize; column++)
            {
                if (field[row][column] != 1)
                {
                    Battleship.hitsAndMisses[row][column] = field[row][column];
                }
            }
        }
        for (int row = 0; row < Battleship.gridSize; row++)
        {
            for (int column = 0; column < Battleship.gridSize; column++)
            {
                if (enemyField[row][column] != 1)
                {
                    Battleship.enemyHitsAndMisses[row][column] = enemyField[row][column];
                }
            }
        }

        if (field[rows][columns] == 1)
        {
            System.out.println("HIT");
            buttonClicked.setBackground(Color.RED);
            Battleship.hitsAndMisses[rows][columns] = field[rows][columns];
            Battleship.enemiesShipsSunk++;
            OperationBoard.enemyHealthPercent.setText(Integer.toString(100 - Battleship.enemiesShipsSunk * 100 / 20) + "%");
        }

        else {
            System.out.println("MISS");
            buttonClicked.setBackground(Color.BLUE);
            Battleship.hitsAndMisses[rows][columns] = field[rows][columns];
        }

        checkWin();

        computerTurn();

    }

    private void checkWin()
    {

        if (Battleship.gameState != "gameFinished")
        {
            System.out.println("Enemy boats fired: " + Battleship.playersShipDestroy);

            if (Arrays.deepEquals(Battleship.hitsAndMisses, field) || Battleship.enemiesShipsSunk == 20)
            {
                System.out.println("You win!");
                Battleship.gameState = "gameFinished";
                JOptionPane.showMessageDialog(null, "All ships sunk, you win!");
            }
            if (Arrays.deepEquals(Battleship.enemyHitsAndMisses, field) || Battleship.playersShipDestroy == 20)
            {
                System.out.println("You lose!");
                Battleship.gameState = "gameFinished";
                JOptionPane.showMessageDialog(null, "Computer sunk all ships, you lose!");
            }

        }
        else if (Battleship.gameState == "gameFinished")
        {
            for (int i = 0; i < PlayerGUI.button.length; i++)
            {
                for (int j = 0; j < PlayerGUI.button[i].length; j++)
                {
                    OperationBoard.button[i][j].setEnabled(false);
                }
            }
        }
    }

    private void computerTurn()
    {
        Boolean shotFired = false;
        Random randRow = new Random();
        Random randColumn = new Random();

        int row;
        int column;
        int count = 0;

        while (!shotFired)
        {
            row = randRow.nextInt(9 - 0 + 1) + 0;
            column = randColumn.nextInt(9 - 0 + 1) + 0;
            System.out.println("Random row: " + row);
            System.out.println("Random column: " + column);

            if (Battleship.enemySpotFired[row][column] == 0)
            {
                if (enemyField[row][column] == 1)
                {
                    System.out.println("Enemy hit: Row: " + row + " Column: " + column);
                    Battleship.enemyHitsAndMisses[row][column] = enemyField[row][column];
                    Battleship.enemySpotFired[row][column] = 1;
                    PlayerGUI.button[row][column].setBackground(new Color(110, 25, 28));
                    PlayerGUI.button[row][column].setText("X");
                    Battleship.playersShipDestroy++;
                    OperationBoard.yourHealthPercent.setText(Integer.toString(100 - Battleship.playersShipDestroy * 100 / 20) + "%");
                }
                else {
                    System.out.println("Enemy miss: Row: " + row + " Column: " + column);
                    Battleship.enemyHitsAndMisses[row][column] = enemyField[row][column];
                    Battleship.enemySpotFired[row][column] = -1;
                    PlayerGUI.button[row][column].setBackground(Color.BLUE);
                    PlayerGUI.button[row][column].setText("X");
                }
                shotFired = true;

            }
            else {
                System.out.println("Already fired here.");
            }

            if (count == 100)
            {
                System.out.println("Too many computer attempts made");
                for (int i = 0; i < Battleship.enemySpotFired.length; i++) {
                    System.out.println(Arrays.toString(Battleship.enemySpotFired[i]));
                }
                shotFired = true;
            }
            count++;
        }
        checkWin();
    }

}
