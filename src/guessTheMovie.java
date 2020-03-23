import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class guessTheMovie {
    public static void main (String [] args) throws FileNotFoundException {

        final int maxPoints = 10;

        File file = new File("movies.txt");
        Scanner scanner1 = new Scanner(file);
        Scanner scanner2 = new Scanner(file);
        Scanner scanner3 = new Scanner(System.in);

        int numberOfCorrectLetters = 0;
        int numberOfWrongLetters = 0;
        char [] wrongLetters = new char[maxPoints];

        String title = choosingTitle.chooseTitleFromFile(scanner1, scanner2);

        char[] shownTitleTable = createTables.createShownTitleTable(title);
        char[] hiddenTitleTable = createTables.createHiddenTitleTable(title, shownTitleTable);


        while(numberOfCorrectLetters < title.length()) {

            System.out.print("\nYou are guessing: ");
            for (int i = 0; i < title.length(); i++)
                System.out.print(hiddenTitleTable[i] + " ");

            System.out.print("\nYou have guessed (" + numberOfWrongLetters + ") wrong letters: ");
            if (numberOfWrongLetters != 0) {
                for (int i = 0; i < numberOfWrongLetters; i++)
                    System.out.print(wrongLetters[i] + " ");
            }

            System.out.print("\nGuess a letter: ");

            char actualAttempt = scanner3.next().charAt(0);
            boolean correct = false;

            for (int i = 0; i < title.length(); i++) {
                if (actualAttempt == shownTitleTable[i]) {
                    hiddenTitleTable[i] = actualAttempt;
                    correct = true;
                }
            }

                if (!correct) {
                    wrongLetters[numberOfWrongLetters] = actualAttempt;
                    numberOfWrongLetters++;
                }

            if (checkWinLose.checkLoosing(maxPoints, numberOfWrongLetters, title)) break;
            if (checkWinLose.checkWinning(title, shownTitleTable, hiddenTitleTable)) break;

        }

    }

}
