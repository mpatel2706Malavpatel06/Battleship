import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    public MenuListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == MainWindow.startVsPlayer)
        {
            TwoPlayers.resetGame();
            TwoPlayers.game.setVisible(true);
            TwoPlayers.game1.setVisible(true);
            MainWindow.frame.setVisible(false);

        }
        if (event.getSource() == MainWindow.startVsComputer)
        {
            Battleship.resetGame();
            Battleship.game.setVisible(true);
            MainWindow.frame.setVisible(false);
        }

        if (event.getSource() == MainWindow.rules)
        {
            Instructions rules = new Instructions(900, 300);
        }

    }

}
