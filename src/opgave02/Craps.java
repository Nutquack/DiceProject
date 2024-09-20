package opgave02;

import java.util.Scanner;

public class Craps
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Craps");
        printRules();
        System.out.println();
        playCraps();
        System.out.println();
    }

    public static void printRules()
    {
        System.out.println("========================================");
        System.out.println("The player rolls two six-sided die");
        System.out.println("The sum of the two die are calculated");
        System.out.println("If the sum is 7 or 11 on the first throw, the player wins");
        System.out.println("If the sum is 2,3, or 12 on the first throw, this is called Craps, and the player loses");
        System.out.println("If the sum is 4,5,6,8,9 or 10 on the first throw, that becomes the players point");
        System.out.println("The player must keep rolling until they make their point");
        System.out.println("The player loses if they roll a 7 before making their point");
        System.out.println("========================================");
    }

    public static void playCraps()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Play Craps?? ('Yes/No') ");
        String answer = scanner.nextLine();

        while (!answer.equals("No"))
        {
            int[] rolledDice = rollTwoDice();
            int sumOfDie = rolledDice[0] + rolledDice[1];
            System.out.println("You rolled = " + sumOfDie);

            if (sumOfDie == 7 || sumOfDie == 11)
            {
                System.out.println("You rolled " + sumOfDie + ", You are a winner!");
            }
            else if (sumOfDie == 2 || sumOfDie == 3 || sumOfDie == 12)
            {
                System.out.println("Aw shucks! You rolled " + sumOfDie + " You lose!");
            }
            else{
                System.out.println("Your point is " + sumOfDie + ". You need to again to hit your point");
                rollForPoint(sumOfDie);
            }
            playAgainAsk();
        }
    }

    public static void rollForPoint(int currentPoint)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Roll again? ('Yes/No') ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("No"))
            {
                System.out.println("Thanks for playing Craps!");
                break;
            }

            int[] rolledDice = rollTwoDice();
            int sumOfNewDice = rolledDice[0] + rolledDice[1];
            System.out.println("You rolled a " + sumOfNewDice);

            if (sumOfNewDice == currentPoint)
            {
                System.out.println("You hit your point! You win!");
                break;
            } else if (sumOfNewDice == 7)
            {
                System.out.println("You rolled a 7. You lose!");
                break;
            }
        }
    }

    public static int[] rollTwoDice()
    {
        int rollDieOne = (int) (Math.random() * 6 + 1);
        int rollDieTwo = (int) (Math.random() * 6 + 1);
        int[] diceArray = {rollDieOne, rollDieTwo};
        return diceArray;
    }

    public static void playAgainAsk()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again? ('Yes/No') ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Yes"))
        {
            playCraps();
        }
        else
        {
            System.out.println("Thanks for playing Craps");
        }
    }
}