package org.example;

import java.util.*;

public class MontyHallSimulation {
    private static enum WinOrLose {
        WINNER, LOSE
    }

    private final Random random;
    private int winCountWithStayChoice = 0;
    private int winCountWithChangeChoice = 0;
    private int miss = 0;
    private final Map<Integer, WinOrLose> boxes = new HashMap<>();

    public MontyHallSimulation() {
        this.random = new Random();
    }

    public static void main(String[] args) {
        MontyHallSimulation simulation = new MontyHallSimulation();
        simulation.runSimulation(1000);
        simulation.printResults();
    }

    private void runSimulation(int rounds) {
        for (int i = 0; i < rounds; i++) {
            initializeBoxes();
            int playerChoice = getPlayerChoice();
            int playerSwitchedChoice = getSwitchedPlayerChoice(playerChoice);

            if (boxes.get(playerChoice) == WinOrLose.WINNER) {
                winCountWithStayChoice++;
            }
            boxes.remove(playerChoice);
            if (boxes.get(playerSwitchedChoice) == WinOrLose.WINNER) {
                winCountWithChangeChoice++;
            }
        }
    }

    private void initializeBoxes() {
        int q = random.nextInt(1, 4);
        boxes.clear();

        for (int i = 0; i < 3; i++) {
            boxes.put(i, WinOrLose.LOSE);
        }

        boxes.put(q, WinOrLose.WINNER);
    }

    private int getPlayerChoice() {
        return random.nextInt(1, 4);
    }

    private int getSwitchedPlayerChoice(int originalChoice) {
        int switchedChoice = random.nextInt(1, 3);
        while (switchedChoice == originalChoice) {
            switchedChoice = random.nextInt(1, 3);
        }
        return switchedChoice;
    }

    private void printResults() {
        System.out.println("Wins with changing choice: " + winCountWithChangeChoice);
        System.out.println("Wins with staying choice: " + winCountWithStayChoice);

        double percentageChange = (double) winCountWithChangeChoice / 1000;
        double percentageStay = (double) winCountWithStayChoice / 1000;

        System.out.println("Percentage wins with changing choice: " + percentageChange * 100 + "%");
        System.out.println("Percentage wins with staying choice: " + percentageStay * 100 + "%");
    }
}
