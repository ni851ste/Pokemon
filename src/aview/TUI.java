package aview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import controller.*;
import ownUtil.Observer;



public class TUI implements Observer{
    private controller ctrl;

    public TUI (controller c){
        this.ctrl = c;
    }


    public void TUI(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            printPos();
            while (true) {
                System.out.println("\nType Here:");
                String b = br.readLine();
                processInput(b);
            }
        } catch (Exception e){
            System.out.println("Fehler:" + e);
            System.exit(1);
        }
    }

    private void printPos(){
    System.out.println("X-Axis: " + ctrl.getPosition().get(0) +
            "   Y-Axis: " + ctrl.getPosition().get(1));
    }

    private void processInput(String input){
        switch (input){
            case "exit": System.exit(0);
            case "test": System.out.println(input + "\n\n"); break;
            case "w":   System.out.println("north");
                        if (ctrl.move('N')){
                            System.out.println("Move successfull");
                        } else {
                            System.out.println("Move failed");
                        }
                        break;
            case "d":   System.out.println("east");
                        if (ctrl.move('E')){
                            System.out.println("Move successfull");
                        } else {
                            System.out.println("Move failed");
                        }
                        break;
            case "s":   System.out.println("south");
                        if (ctrl.move('S')){
                            System.out.println("Move successfull");
                        } else {
                            System.out.println("Move failed");
                        }
                        break;
            case "a":   System.out.println("west");
                        if (ctrl.move('W')){
                            System.out.println("Move successfull");
                        } else {
                            System.out.println("Move failed");
                        }
                        break;
            case "position": printPos(); break;
            default: System.out.println("Wrong command");
        }


    }


    @Override
    public void update() {
        printPos();
    }
}
