package de.knxamk.aview;


import de.knxamk.controller.Controller;
import de.knxamk.util.TwoTouple;
import de.knxamk.util.observerPattern.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Gui implements Observer, KeyListener
{
    private Controller controller;
    private int pixelWidth = 11;
    private int pixelHeight = 7;

    private JFrame mainFrame;
    private JPanel mainJPanel;

    public Gui(Controller c)
    {
        this.controller = c;
        this.setUpGui();
    }

    private void setUpGui()
    {
        //Initializing the Main Frame
        mainFrame = new JFrame("Thomas = best Pokemon");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.addKeyListener(this);

        MenuBar menuBar = new MenuBar();
        Menu menuDropdown = new Menu("File");
        MenuItem menuItem = new MenuItem("SAVE");

        menuDropdown.add(menuItem);
        menuBar.add(menuDropdown);
        mainFrame.setMenuBar(menuBar);

        mainJPanel = new JPanel();
    }

    public void GUI()
    {
        mainFrame.setLayout(new GridLayout(pixelHeight, pixelWidth));

        update();

    }

    //Horrible hardcoded numbers, optimasition needed when going BIG DICK MODE
    public void update()
    {
        //mainJPanel.removeAll();
        mainFrame.setLayout(new GridLayout(pixelHeight, pixelWidth));

        TwoTouple<Integer> pos = new TwoTouple<>(controller.getPosition());
        int currWidth = pos.get(0);
        int currHeight = pos.get(1);

        for (int rows = currHeight + (pixelHeight / 2); rows >= currHeight - (pixelHeight / 2); rows--)
        {
            for (int collums = currWidth - (pixelWidth / 2); collums <= currWidth + (pixelWidth / 2); collums++)
            {

                switch (controller.getObjectCurrMap(collums, rows))
                {
                    case "bounds":
                        this.mainFrame.add(new JLabel(new ImageIcon(getClass().getResource("/bounds64.png"))));
                        break;
                    case "free":
                        this.mainFrame.add(new JLabel(new ImageIcon(getClass().getResource("/ground64.png"))));
                        break;
                    case "player":
                        this.mainFrame.add(new JLabel(new ImageIcon(getClass().getResource("/player64.png"))));
                        break;
                    case "tree":
                        this.mainFrame.add(new JLabel(new ImageIcon(getClass().getResource("/tree64.png"))));
                        break;
                }
            }
        }
        //this.mainFrame.revalidate();
        //this.mainFrame.repaint();
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case 87:
                controller.move('N');
                break;
            case 83:
                controller.move('S');
                break;
            case 68:
                controller.move('E');
                break;
            case 65:
                controller.move('W');
                break;
            case 27:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
