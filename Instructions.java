
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Instructions extends JFrame
{
    public static JFrame rulesFrame;

    public Instructions(int height, int width)
    {
        rulesFrame = new JFrame();
        rulesFrame.setTitle("Battleship Instructions");
        rulesFrame.setPreferredSize(new Dimension(height,width));
        rulesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel rulesPanel = new JPanel();

        JTextArea text = new JTextArea("Game Instructions\n" +
                "1) When the Battleship game starts you may begin to place ship at any position except you have to leave one box in North, East, West, South direction . \n" +
                "2) You can set two-boxes ships by clicking on a box and then the next box to the first box to orient the ship \n" +
                "3) Click on the Boxes to damage ships, a blue Box is kept form missed shot and red box is for hit.\n" +
                "4) Once all your opponent's ships are Damaged you will win !!!");

        text.setRows(10);
        text.setColumns(10);

        rulesPanel.add(text);
        rulesPanel.setBorder(new LineBorder(Color.black, 50));
        rulesFrame.add(rulesPanel,"Center");


        rulesFrame.add(rulesPanel);
        rulesFrame.setResizable(true);
        rulesFrame.setVisible(true);
        rulesFrame.pack();

    }
}
