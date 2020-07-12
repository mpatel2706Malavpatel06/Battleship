import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OperationBoard extends JFrame
{
    static JPanel panel;
    public static JPanel buttonPanel;
    public static JPanel playerProgressPanel;
    public static JPanel enemyProgressPanel;

    public static JLabel yourHealthPercent;
    public static JLabel enemyHealthPercent;

    static JButton button[][] = new JButton[10][10];

    GridBagConstraints gridConstraints;
    Color skyBlueColor = new Color(11, 188, 191);


    static int rows;
    static int columns;
    static int gridSize;

    public OperationBoard(int gridSize, int height, int width)
    {
        this.gridSize = gridSize;

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10, 10));
        buttonPanel.setBackground(skyBlueColor);

        for (rows = 0; rows < gridSize; rows++)
        {
            for (columns = 0; columns < gridSize; columns++)
            {
                button[rows][columns] = new JButton();
                button[rows][columns].setBackground(skyBlueColor);
                button[rows][columns].setPreferredSize(new Dimension(100, 100));
                button[rows][columns].addActionListener(new OperationController(rows, columns));
                buttonPanel.add(button[rows][columns]);
            }
        }

        gridConstraints = new GridBagConstraints();
        gridConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridConstraints.fill = GridBagConstraints.BOTH;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1.0;
        gridConstraints.weighty = 0.65;
        panel.add(buttonPanel, gridConstraints);

        gridConstraints.weighty = 0.15;
        gridConstraints.gridy = 1;

        playerProgressPanel = new JPanel();
        playerProgressPanel.setLayout(new GridLayout());

        JLabel yourHealthLabel = new JLabel("YOUR HEALTH -------- ");
        playerProgressPanel.add(yourHealthLabel);

        yourHealthPercent = new JLabel("100%");
        playerProgressPanel.add(yourHealthPercent);

        panel.add(playerProgressPanel, gridConstraints);

        gridConstraints.weighty = 0.20;
        gridConstraints.gridy = 2;

        enemyProgressPanel = new JPanel();
        enemyProgressPanel.setLayout(new GridLayout());

        JLabel enemyHealthLabel = new JLabel("ENEMIES HEALTH -------------- ");
        enemyProgressPanel.add(enemyHealthLabel);

        enemyHealthPercent = new JLabel("100%");
        enemyProgressPanel.add(enemyHealthPercent);

        panel.add(enemyProgressPanel, gridConstraints);

        setContentPane(panel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        setTitle("Computer's Board");
        setResizable(false);
        pack();

    }
}
