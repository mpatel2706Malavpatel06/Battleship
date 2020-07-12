import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class PlayerGUI extends JFrame
{
    private JPanel panel = new JPanel();
    private JPanel buttonPanel;
    private JPanel directionPanel;
    private JPanel progressPanel;
    private JPanel menuButtonsPanel;

    Color skyBlueColor = new Color(11, 188, 191);
    GridBagConstraints gridConstraints;

    public static JLabel shipSizeLabel;

    public static JButton button[][] = new JButton[10][10];
    public static JButton vertical;
    public static JButton horizontal;
    public static JButton mainMenu;
    public static JButton instructions;

    static int rows;
    static int columns;
    static int gridSize;

    public PlayerGUI(int gridSize, int height, int width) {
        this.gridSize = gridSize;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        setTitle("Player Game");
        setResizable(false);

        panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(10, 10));


        for (rows = 0; rows < gridSize; rows++)
        {
            for (columns = 0; columns < gridSize; columns++)
            {
                button[rows][columns] = new JButton();
                button[rows][columns].setBackground(skyBlueColor);
                button[rows][columns].setPreferredSize(new Dimension(100, 100));
                button[rows][columns].addActionListener(new BoxPress(rows, columns));
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

        gridConstraints.weighty = 0.05;
        gridConstraints.gridy = 1;

        directionPanel = new JPanel();
        directionPanel.setLayout(new GridLayout());

        JLabel instructionLabel = new JLabel("Place Ships On Given Boxes ::: ");
        directionPanel.add(instructionLabel);

        horizontal = new JButton("Horizontal");
        horizontal.setBackground(Color.black);
        horizontal.setForeground(Color.white);
        horizontal.setBorder(BorderFactory.createMatteBorder(2, 3, 2, 2, Color.green));

        horizontal.addActionListener(new gameMenuListener()); //allows user to correctly interact with game menu on the main GUI
        horizontal.setPreferredSize(new Dimension(15, 25));
        horizontal.setEnabled(false);
        directionPanel.add(horizontal);

        vertical = new JButton("Vertical");
        vertical.setBackground(Color.black);
        vertical.setForeground(Color.white);
        vertical.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

        vertical.addActionListener(new gameMenuListener());
        vertical.setPreferredSize(new Dimension(15, 25));
        directionPanel.add(vertical);

        panel.add(directionPanel, gridConstraints);

        gridConstraints.weighty = 0.20;
        gridConstraints.gridy = 2;

        progressPanel = new JPanel();
        progressPanel.setLayout(new GridLayout());

        JLabel textLabel = new JLabel("Place Ship Size ----------------------------------------------- ");
        progressPanel.add(textLabel);

        shipSizeLabel = new JLabel(Integer.toString(Battleship.boatSize[Battleship.whichBoat]));
        progressPanel.add(shipSizeLabel);

        panel.add(progressPanel, gridConstraints);

        gridConstraints.weighty = 0.10;
        gridConstraints.gridy = 3;

        menuButtonsPanel = new JPanel();
        menuButtonsPanel.setLayout(new GridLayout());

        mainMenu = new JButton("Main Menu");
        mainMenu.setForeground(Color.white);
        mainMenu.setBackground(Color.black);
        mainMenu.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
        mainMenu.addActionListener(new gameMenuListener());
        mainMenu.setPreferredSize(new Dimension(15, 25));
        menuButtonsPanel.add(mainMenu);


        instructions = new JButton("Instructions");
        instructions.setBackground(Color.black);
        instructions.setForeground(Color.white);
        instructions.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));

        //allows user to interact with the in-game instructions built by the original authors
        instructions.addActionListener(new gameMenuListener());
        instructions.setPreferredSize(new Dimension(15, 25));
        menuButtonsPanel.add(instructions);

        panel.add(menuButtonsPanel, gridConstraints);

        setContentPane(panel);
        pack();
    }

}

class gameMenuListener implements ActionListener
{

    public gameMenuListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {

        if (event.getSource() == PlayerGUI.vertical)
        {
            Battleship.vertical = true;
            Battleship.horizontal = false;
            PlayerGUI.vertical.setEnabled(false);
            PlayerGUI.horizontal.setEnabled(true);
        }

        else if (event.getSource() == PlayerGUI.horizontal)
        {
            Battleship.vertical = false;
            Battleship.horizontal = true;
            PlayerGUI.vertical.setEnabled(true);
            PlayerGUI.horizontal.setEnabled(false);

        }
        else if (event.getSource() == PlayerGUI.mainMenu)
        {
            Battleship.game.setVisible(false);
            Battleship.game2.setVisible(false);
            MainWindow.frame.setVisible(true);
        }
        else if (event.getSource() == PlayerGUI.instructions)
        {
            Instructions rules = new Instructions(900, 300);
        }

    }

}
