package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int sameEyesCount = 0;
    private static int highestSum = 0;
    private static int[] eyesRolled = {0,0,0,0,0,0};

    public static void main(String[] args) {
        System.out.println("Welcome to the game, RollTwoDice!!!.");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Thanks for playing :)");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules for RollTwoDice.");
        System.out.println("The player will roll two dice for as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll dice? ('yes'/'no')");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            System.out.print("You rolled: ");
            for (int i = 0; i < faces.length; i++){
                System.out.print(faces[i]+ " ");
                if(i<1){
                    System.out.print("and ");
                }
            }
            System.out.println();

            updateStatistics(faces);

            System.out.print("Roll dice? ('yes'/'no')");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        int[] diceArray = {die1,die2};
        return diceArray;
    }

    private static void updateStatistics(int[] faces) {
        rollCount+=2;
        if(faces[0] == faces[1]){
            sameEyesCount++;
        }
        if(faces[0] + faces[1] > highestSum){
            highestSum = faces[0] + faces[1];
        }
        eyesRolled[faces[0] - 1]++;
        eyesRolled[faces[1] - 1]++;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------------------------------");
        System.out.printf("%17s %4d\n", "Times rolled:", rollCount, "\n");
        System.out.printf("%17s %4d\n", "Doubles rolled:", sameEyesCount, "\n");
        System.out.printf("%17s %4d\n", "Highest sum:", highestSum, "\n");
        for(int i = 0; i < eyesRolled.length; i++){
            System.out.printf("%13s %1d %s %3d %s\n", "You rolled", i+1, ": ", eyesRolled[i], " times");
        }
    }
}
