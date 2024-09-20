package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int playerOneSum = 0;
    private static int playerTwoSum = 0;
    private static double playerOneThrows = 0;
    private static double playerTwoThrows = 0;
    private static double playerOneTurns = 0;
    private static double playerTwoTurns = 0;
    private static double playerOneAverage = 0;
    private static double playerTwoAverage = 0;


    public static void main(String[] args) {
        playPig();
    }

    private static void playPig() {
        System.out.println("Type winner value");
        Scanner scanner = new Scanner(System.in);
        int winnerValue = scanner.nextInt();

        while (playerOneSum < winnerValue || playerTwoSum < winnerValue){
           playerOne(winnerValue);
           playerOneTurns++;

           if(playerOneSum >= winnerValue){
               break;
           }
           playerTwo(winnerValue);
           playerTwoTurns++;
           if(playerTwoSum >= winnerValue){
               break;
           }
        }

        if(playerOneSum > playerTwoSum){
            System.out.println("Player 1 wins!!!");
        }
        else {
            System.out.println("Player 2 wins!!!");
        }
        updateStatistics();
        System.out.println("========================================");
        System.out.println("Statistics");
        System.out.println("Player one throws pr. turn: " + playerOneAverage);
        System.out.println("Player Two trows pr. turn: " + playerTwoAverage);
        System.out.println("========================================");
        System.out.println("Thank you for playing :)");
    }

    private static int[] rollDice() {
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        int[] diceArray = {die1,die2};
        return diceArray;
    }

    private static void playerOne(int winnerValue){
        Scanner scanner = new Scanner(System.in);
        String answer;
        int currentSum = 0;
        System.out.println("Player 1.: your total is " + playerOneSum);
        System.out.println("Roll dice? (yes/no)");
        answer = scanner.nextLine();
        while (!answer.equals("no")) {
            currentSum = 0;
            int[] faces = rollDice();
            System.out.print("You rolled: ");
            for (int i = 0; i < faces.length; i++){
                System.out.print(faces[i]+ " ");
                if(i<1){
                    System.out.print("and ");
                }
                currentSum+=faces[i];
            }
            playerOneThrows++;

            if(faces[0] == 1 || faces[1] == 1){
                currentSum = 0;
                break;
            }
            else if(faces[0] == 1 && faces[1] == 1){
                currentSum = 0;
                playerOneSum = 0;
                break;
            }
            playerOneSum+=currentSum;
            System.out.println("Total: " + playerOneSum);
            if(playerOneSum >= winnerValue){
                break;
            }
            System.out.println("Roll again? (yes/on)");
            answer = scanner.nextLine();
        }
        System.out.println("Your turn is over... your total is " + playerOneSum);
    }

    private static void playerTwo(int winnerValue){
        Scanner scanner = new Scanner(System.in);
        String answer;
        int currentSum = 0;
        System.out.println("Player 2.: your total is " + playerTwoSum);
        System.out.println("Roll dice? (yes/no)");
        answer = scanner.nextLine();
        while (!answer.equals("no")) {
            currentSum = 0;
            int[] faces = rollDice();
            System.out.print("You rolled: ");
            for (int i = 0; i < faces.length; i++){
                System.out.print(faces[i]+ " ");
                if(i<1){
                    System.out.print("and ");
                }
                currentSum+=faces[i];
            }
            playerTwoThrows++;

            if(faces[0] == 1 || faces[1] == 1){
                currentSum = 0;
                break;
            }
            else if(faces[0] == 1 && faces[1] == 1){
                currentSum = 0;
                playerTwoSum = 0;
                break;
            }
            playerTwoSum+=currentSum;
            System.out.println("Total: " + playerTwoSum);
            if(playerTwoSum >= winnerValue){
                break;
            }
            System.out.println("Roll again? (yes/on)");
            answer = scanner.nextLine();
        }
        System.out.println("Your turn is over... your total is " + playerTwoSum);
    }

    private static void updateStatistics(){
        playerOneAverage = playerOneThrows/playerOneTurns;
        playerTwoAverage = playerTwoThrows/playerTwoTurns;
    }
}
