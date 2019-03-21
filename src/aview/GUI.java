package aview;

import controller.*;
import ownUtil.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class GUI implements Observer, KeyListener {
    private controller ctrl;
    private int dimWidth = 15;
    private int dimHeight = 9;

    private JFrame mainFrame;

    private JLabel player;

    public GUI (controller c){
        this.ctrl = c;
    }

    public void GUI() {


        /*
        //Loading in the needed images
        try {
            BufferedImage tree = ImageIO.read(new File("src\\artset\\tree64.png"));
            BufferedImage bounds = ImageIO.read(new File("src\\artset\\bounds64.png"));
            BufferedImage free = ImageIO.read(new File("src\\artset\\ground64.png"));
            BufferedImage player = ImageIO.read(new File("src\\artset\\player64.png"));
            //BufferedImage tree = ImageIO.read(new File("src\\artset\\tree64.png"));
        } catch (IOException ex) {
            System.exit(1);
        }
*/


        //Initializing the Main Frame
        mainFrame = new JFrame("Papa best hoe");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        //3x3 Frame here
        mainFrame.setLayout(new GridLayout(dimHeight,dimWidth));


        player = new JLabel(new ImageIcon( "src\\artset\\player64.png"));

        mainFrame.addKeyListener(this);



        //Not checked for loading errors. weird.
        //if (free.getIcon() == null)
        //    System.exit(1);

        update();


//     Test adds to the Frame
/*        mainFrame.removeAll();
        mainFrame.add(tree);
        mainFrame.add(free);
        mainFrame.add(player);
        mainFrame.add(bounds);

        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
*/

    }

    //Horrible hardcoded numbers, optimasition needed when going BIG DICK MODE
    @Override
    public void update() {

        mainFrame.setVisible(false);
        mainFrame.dispose(); //Destroy the JFrame object

        mainFrame = new JFrame("Papa best hoe");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new GridLayout(dimHeight,dimWidth));
        mainFrame.addKeyListener(this);

        intTouple pos = new intTouple (ctrl.getPosition());
        int currWidth = pos.get(0);
        int currHeight = pos.get(1);
        for (int rows = currHeight + (dimHeight / 2); rows >= currHeight - (dimHeight / 2); rows--){
            for (int collums = currWidth - (dimWidth / 2); collums <= currWidth + (dimWidth / 2); collums++){

                switch (ctrl.getObjectCurrMap(collums, rows)){
                    case "bounds": this.mainFrame.add(new JLabel(new ImageIcon( "src\\artset\\bounds64.png"))); break;
                    case "free": this.mainFrame.add(new JLabel(new ImageIcon( "src\\artset\\ground64.png"))); break;
                    case "player": this.mainFrame.add(player); break;
                    case "tree": this.mainFrame.add(new JLabel(new ImageIcon( "src\\artset\\tree64.png"))); break;
                }
            }
        }
        //this.mainFrame.revalidate();
        //this.mainFrame.repaint();
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);

    }


    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 87: ctrl.move('N'); break;
            case 83: ctrl.move('S'); break;
            case 68: ctrl.move('E'); break;
            case 65: ctrl.move('W'); break;
            case 27: System.exit(0); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
