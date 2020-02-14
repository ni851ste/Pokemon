package de.knxamk.aview;

import de.knxamk.controller.Controller;
import de.knxamk.util.observerPattern.Observer;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Tui implements Observer
{
    private Controller controller;

    public Tui(Controller c)
    {
        this.controller = c;
    }


    public void TUI()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            printPos();
            while (true)
            {
                System.out.println("\nType Here:");
                String b = br.readLine();
                processInput(b.toLowerCase());
                printStage();
            }
        } catch (Exception e)
        {
            System.out.println("Fehler:" + e);
            System.exit(1);
        }
    }

    private void printPos()
    {
        System.out.println("X-Axis: " + controller.getPosition().get(0) +
                "   Y-Axis: " + controller.getPosition().get(1) + "\n");
    }

    private void processInput(String input)
    {
        if (input.equals("exit"))
            System.exit(0);

        switch (controller.controllerState)
        {
            case MOVE:
                processInputMove(input);
                break;

            default:
                System.out.println("Game state Error: Wrong state for given input!");

        }


    }

    private void processInputMove(String input)
    {
        switch (input)
        {
            case "w":
                System.out.println("north");
                if (controller.move('N'))
                {
                    System.out.println("Move successfull");
                }
                else
                {
                    System.out.println("Move failed");
                }
                break;
            case "d":
                System.out.println("east");
                if (controller.move('E'))
                {
                    System.out.println("Move successfull");
                }
                else
                {
                    System.out.println("Move failed");
                }
                break;
            case "s":
                System.out.println("south");
                if (controller.move('S'))
                {
                    System.out.println("Move successfull");
                }
                else
                {
                    System.out.println("Move failed");
                }
                break;
            case "a":
                System.out.println("west");
                if (controller.move('W'))
                {
                    System.out.println("Move successfull");
                }
                else
                {
                    System.out.println("Move failed");
                }
                break;
            case "pos":
                printPos();
                break;
            default:
                System.out.println("Wrong command");
        }
    }

    private void printStage()
    {
        //controller
    }


    @Override
    public void update()
    {
        printPos();
    }
}
