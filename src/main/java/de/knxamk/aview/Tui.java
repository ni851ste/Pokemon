package de.knxamk.aview;

import de.knxamk.controller.Controller;
import de.knxamk.util.TwoTouple;
import de.knxamk.util.observerPattern.Observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static de.knxamk.util.ConsoleAnsiColorCodes.*;


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
            printStage();
            while (true)
            {
                System.out.println("\nType Here:");
                String b = br.readLine();
                processInput(b.toLowerCase());
            }
        } catch (IOException e)
        {
            System.out.println("Fehler:" + e);
            System.exit(1);
        }
    }

    private void processInput(String input)
    {
        if (input.equals("exit"))
            System.exit(0);

        switch (controller.controllerState)
        {
            case MOVE:
                processInputMove(input);
                printStage();
                break;

            default:
                throw new RuntimeException("Game state Error: Wrong state for given input!");
        }
    }

    private void processInputMove(String input)
    {
        switch (input)
        {
            case "w":
                System.out.println("north");
                initiateMove('N');
                break;
            case "d":
                System.out.println("east");
                initiateMove('E');
                break;
            case "s":
                System.out.println("south");
                initiateMove('S');
                break;
            case "a":
                System.out.println("west");
                initiateMove('W');
                break;
            case "pos":
                printPos();
                break;
            case "json":
                System.out.println(controller.toJson());
                break;
            case "help":
                System.out.println(getTuiCommands());
                break;
            default:
                System.out.println(ANSI_RED + "Unknown Command\nTry one of those:\n" + ANSI_RESET + getTuiCommands());
        }
    }

    private void initiateMove(char input)
    {
        if (controller.move(input))
            System.out.println(ANSI_GREEN + "Move successful" + ANSI_RESET);
        else
            System.out.println(ANSI_RED + "Move failed" + ANSI_RESET);
    }

    private void printPos()
    {
        System.out.println("X-Axis: " + controller.getPosition().get(0) +
                "   Y-Axis: " + controller.getPosition().get(1) + "\n");
    }

    private void printStage()
    {
        TwoTouple<Integer> playerPos = controller.getPosition();
        for (int i = playerPos.get(1) + 2; i >= playerPos.get(1) - 2; i--)
        {
            System.out.printf("\t%s\t%s\t%s\t%s\t%s\n",
                    this.getStageContentAsStringWithCoordAndAnsiColor(playerPos.get(0) - 2, i),
                    this.getStageContentAsStringWithCoordAndAnsiColor(playerPos.get(0) - 1, i),
                    this.getStageContentAsStringWithCoordAndAnsiColor(playerPos.get(0), i),
                    this.getStageContentAsStringWithCoordAndAnsiColor(playerPos.get(0) + 1, i),
                    this.getStageContentAsStringWithCoordAndAnsiColor(playerPos.get(0) + 2, i)
            );
        }
    }

    private String getStageContentAsStringWithCoordAndAnsiColor(int w, int h)
    {
        String stageContent = controller.getStageContentAsStringWithCoord(w, h);

        switch (stageContent)
        {
            case "player":
                return ANSI_YELLOW_BACKGROUND + ANSI_BLACK + stageContent + ANSI_RESET;
            case "bounds":
                return ANSI_BLACK_BACKGROUND + ANSI_WHITE + stageContent + ANSI_RESET;
            case "free":
                return ANSI_PURPLE_BACKGROUND + ANSI_BLACK + stageContent + ANSI_RESET;
            case "tree":
                return ANSI_GREEN_BACKGROUND + ANSI_BLACK + stageContent + ANSI_RESET;
            default:
                return "";
        }
    }

    private String getTuiCommands()
    {
        return ANSI_GREEN +
                "\tw\t\tMove north\n" +
                "\td\t\tMove east\n" +
                "\ts\t\tMove south\n" +
                "\ta\t\tMove west\n" +
                "\tpos\t\tGive current position\n" +
                "\tjson\tController and Model as JSON\n" + ANSI_RESET;
    }



    @Override
    public void update()
    {
        printPos();
    }
}
