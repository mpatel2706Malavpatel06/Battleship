import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame
{
    public static JFrame frame;
    public static JButton startVsComputer;
    public static JButton startVsPlayer;
    public static JButton rules;


    public MainWindow(int height, int width)
    {
        frame = new JFrame();
        frame.setTitle("Battleship Game !!!");
        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        ImageIcon windowImage = new ImageIcon("Window.jpg");
        ImageIcon welcomeImage = new ImageIcon("welcome.png");
        JLabel l = new JLabel();
        JLabel labelWelcome = new JLabel(welcomeImage, JLabel.CENTER);
        l.setIcon(windowImage);
        labelWelcome.setIcon(welcomeImage);

        l.setSize(width, height);
        labelWelcome.setSize(555,555);
        labelWelcome.setLocation(500,-20);

        startVsComputer = new JButton("Vs Computer");
        startVsComputer.setBounds(700, 400, 150, 40);
        startVsComputer.setFont(new Font("Calibri", Font.BOLD, 14));
        startVsComputer.setBackground(new Color(0x2dce98));
        startVsComputer.setForeground(Color.white);
        startVsComputer.addActionListener(new MenuListener());

        startVsPlayer = new JButton("Vs Player");
        startVsPlayer.setBounds(700, 500, 150, 40);
        startVsPlayer.setFont(new Font("Calibri", Font.BOLD, 14));
        startVsPlayer.setBackground(new Color(0x2dce98));
        startVsPlayer.setForeground(Color.white);
        startVsPlayer.addActionListener(new MenuListener());

        rules = new JButton("Instructions");
        rules.setBounds(700, 600, 150, 40);
        rules.setFont(new Font("Calibri", Font.BOLD, 14));
        rules.setBackground(new Color(0x2dce98));
        rules.setForeground(Color.white);
        rules.addActionListener(new MenuListener());

        mainPanel.add(labelWelcome);
        mainPanel.add(startVsComputer);
        mainPanel.add(startVsPlayer);
        mainPanel.add(rules);
        mainPanel.add(l);

        mainPanel.revalidate();
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);


    }


}
