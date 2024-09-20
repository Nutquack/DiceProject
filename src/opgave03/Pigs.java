package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int playerOneSum = 0;
    private static int playerTwoSum = 0;

    public static void main(String[] args) {

    }

    private static void playPig() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int face = rollDie();
            System.out.println("Du rullede: " + face);
            System.out.println();

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
        scanner.close();
    }

    private static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }

    private static void playerOne(){
        System.out.println("Player 1. \n your total is " + playerOneSum);
    }

    private static void playerTwo(){
        System.out.println("Player 2. \n your total is " + playerTwoSum);
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul en terning");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }
}
