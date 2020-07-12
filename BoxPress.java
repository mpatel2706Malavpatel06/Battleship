
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;

public class BoxPress implements ActionListener
{
    int rows;
    int columns;
    int[][] field;

    Boolean vertical;
    Boolean horizontal;

    public BoxPress(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        this.field = Battleship.getBoatPositions();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        this.field = Battleship.getBoatPositions();
        this.vertical = Battleship.vertical;
        this.horizontal = Battleship.horizontal;

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

        if (Battleship.gameState == "placeShips")
        {
            if (Battleship.whichBoat < Battleship.boatSize.length)
            {
                placeWholeBoat(event);
            }
            else {
                Battleship.gameState = "gameStarted";

            }

        }
        else if (Battleship.gameState == "gameStarted")
        {
            for (int i = 0; i < PlayerGUI.button.length; i++)
            {
                for (int j = 0; j < PlayerGUI.button[i].length; j++)
                {
                    PlayerGUI.button[i][j].setEnabled(false);
                }
            }
        }
    }

    private Boolean freeSpot()
    {
        if (Battleship.getBoatPositions()[rows][columns] == 0)
        {
            return true;
        }
        return false;
    }
    private Boolean validSpot(int boatNumber)
    {
        try
        {
            if (vertical)
            {
                for (int i = 1; i < boatNumber; i++) {
                    if (field[rows + i][columns] != 0) {
                        return false;
                    }
                }
            }
            else if (horizontal)
            {
                for (int i = 1; i < boatNumber; i++) {
                    if (field[rows][columns + i] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return false;
        }
    }

    private void placeWholeBoat(ActionEvent event)
    {
        JButton buttonClicked = (JButton) event.getSource();


        if (Battleship.boatSize[Battleship.whichBoat] == 1 && freeSpot() && validSpot(Battleship.boatSize[Battleship.whichBoat]))
        {
            Battleship.tempField[rows][columns] = 1;
            buttonClicked.setBackground(Color.RED);
            buttonClicked.setEnabled(false);

            blockSurroundSpace();

            Battleship.setBoatPositions(field);

            System.out.println("----------Final:");
            for (int i = 0; i < field.length; i++)
            {
                System.out.println(Arrays.toString(field[i]));
            }


            Battleship.whichBoat++;
            if (Battleship.gameState == "placeShips") {
                PlayerGUI.shipSizeLabel.setText(Integer.toString(Battleship.boatSize[Battleship.whichBoat]));
            }
            else {
                PlayerGUI.shipSizeLabel.setText("All boats placed.");
            }
        }
        else if (Battleship.boatSize[Battleship.whichBoat] == 2 && freeSpot() && validSpot(Battleship.boatSize[Battleship.whichBoat]))
        {
            try {
                Battleship.tempField[rows][columns] = 1;

                if (vertical) {
                    Battleship.tempField[rows + 1][columns] = 1;

                } else if (horizontal) {
                    Battleship.tempField[rows][columns + 1] = 1;
                }

                blockSurroundSpace();
                Battleship.setBoatPositions(field);

                for (int i = 0; i < field.length; i++)
                {
                    System.out.println(Arrays.toString(field[i]));
                }
                buttonClicked.setBackground(Color.RED);
                buttonClicked.setEnabled(false);
                if (vertical)
                {
                    PlayerGUI.button[rows + 1][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 1][columns].setEnabled(false);

                }
                else if (horizontal)
                {
                    PlayerGUI.button[rows][columns + 1].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 1].setEnabled(false);
                }
                Battleship.whichBoat++;
                if (Battleship.gameState == "placeShips")
                {
                    PlayerGUI.shipSizeLabel.setText(Integer.toString(Battleship.boatSize[Battleship.whichBoat]));
                }
                else {
                    PlayerGUI.shipSizeLabel.setText("All boats placed.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

        }
        else if (Battleship.boatSize[Battleship.whichBoat] == 3 && freeSpot() && validSpot(Battleship.boatSize[Battleship.whichBoat]))
        {
            try {
                Battleship.tempField[rows][columns] = 1;

                if (vertical)
                {
                    Battleship.tempField[rows + 1][columns] = 1;
                    Battleship.tempField[rows + 2][columns] = 1;

                }
                else if (horizontal)
                {
                    Battleship.tempField[rows][columns + 1] = 1;
                    Battleship.tempField[rows][columns + 2] = 1;
                }

                blockSurroundSpace();
                Battleship.setBoatPositions(field);

                for (int i = 0; i < field.length; i++)
                {
                    System.out.println(Arrays.toString(field[i]));
                }

                buttonClicked.setBackground(Color.RED);
                buttonClicked.setEnabled(false);
                if (vertical)
                {
                    PlayerGUI.button[rows + 1][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 2][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 1][columns].setEnabled(false);
                    PlayerGUI.button[rows + 2][columns].setEnabled(false);

                }
                else if (horizontal)
                {
                    PlayerGUI.button[rows][columns + 1].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 2].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 1].setEnabled(false);
                    PlayerGUI.button[rows][columns + 2].setEnabled(false);
                }

                Battleship.whichBoat++;

                if (Battleship.gameState == "placeShips")
                {
                    PlayerGUI.shipSizeLabel.setText(Integer.toString(Battleship.boatSize[Battleship.whichBoat]));
                }
                else {
                    PlayerGUI.shipSizeLabel.setText("All boats placed.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        else if (Battleship.boatSize[Battleship.whichBoat] == 4 && freeSpot() && validSpot(Battleship.boatSize[Battleship.whichBoat]))
        {
            try {
                Battleship.tempField[rows][columns] = 1;

                if (vertical) {
                    Battleship.tempField[rows + 1][columns] = 1;
                    Battleship.tempField[rows + 2][columns] = 1;
                    Battleship.tempField[rows + 3][columns] = 1;

                } else if (horizontal) {
                    Battleship.tempField[rows][columns + 1] = 1;
                    Battleship.tempField[rows][columns + 2] = 1;
                    Battleship.tempField[rows][columns + 3] = 1;
                }

                blockSurroundSpace();
                Battleship.setBoatPositions(field);

                for (int i = 0; i < field.length; i++)
                {
                    System.out.println(Arrays.toString(field[i]));
                }
                buttonClicked.setBackground(Color.RED);
                buttonClicked.setEnabled(false);
                if (vertical)
                {
                    PlayerGUI.button[rows + 1][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 2][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 3][columns].setBackground(Color.RED);
                    PlayerGUI.button[rows + 1][columns].setEnabled(false);
                    PlayerGUI.button[rows + 2][columns].setEnabled(false);
                    PlayerGUI.button[rows + 3][columns].setEnabled(false);

                }
                else if (horizontal)
                {
                    PlayerGUI.button[rows][columns + 1].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 2].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 3].setBackground(Color.RED);
                    PlayerGUI.button[rows][columns + 1].setEnabled(false);
                    PlayerGUI.button[rows][columns + 2].setEnabled(false);
                    PlayerGUI.button[rows][columns + 3].setEnabled(false);
                }
                Battleship.whichBoat++;
                PlayerGUI.shipSizeLabel.setText("All boats placed.");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {

            }
        }
        if (Battleship.whichBoat >= 10)
        {
            Battleship.gameState = "gameStarted";
            Battleship.game2.setVisible(true);

            for (int i = 0; i < PlayerGUI.button.length; i++)
            {
                for (int j = 0; j < PlayerGUI.button[i].length; j++)
                {
                    PlayerGUI.button[i][j].setEnabled(false);
                }
            }
        }
    }

    public void blockSurroundSpace()
    {
        for (int row = 0; row < Battleship.gridSize; row++)
        {
            for (int column = 0; column < Battleship.gridSize; column++)
            {
                if (Battleship.tempField[row][column] == 1)
                {
                    field[row][column] = 1;
                    try
                    {
                        if (field[row - 1][column - 1] != 1)
                        {
                            field[row - 1][column - 1] = -1;
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e)
                    {

                    }
                    try
                    {
                        if (field[row - 1][column + 1] != 1)
                        {
                            field[row - 1][column + 1] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row - 1][column] != 1) {
                            field[row - 1][column] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row + 1][column] != 1) {
                            field[row + 1][column] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row + 1][column - 1] != 1) {
                            field[row + 1][column - 1] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row + 1][column + 1] != 1) {
                            field[row + 1][column + 1] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row][column - 1] != 1) {
                            field[row][column - 1] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (field[row][column + 1] != 1) {
                            field[row][column + 1] = -1;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }
        }
    }

}
