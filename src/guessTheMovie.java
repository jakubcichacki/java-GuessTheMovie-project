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

            String title = chooseTitleFromFile(scanner1, scanner2);

            char [] shownTitleTable = new char[title.length()];
            for (int i = 0; i < title.length(); i++)
                shownTitleTable[i] = title.charAt(i);

            char [] hiddenTitleTable = new char[title.length()];
            for (int i = 0; i < title.length(); i++) {
                if(shownTitleTable[i] == ' ')
                    hiddenTitleTable[i] = shownTitleTable[i];
                else hiddenTitleTable[i] = '_';
            }


            while(numberOfCorrectLetters < title.length()) {

                System.out.print("\nYou are guessing: ");
                for (int i = 0; i < title.length(); i++)
                    System.out.print(hiddenTitleTable[i] + " ");

                System.out.print("\nYou have guessed (" + numberOfWrongLetters + ") wrong letters: ");
                    if (numberOfWrongLetters != 0) {
                        for (int i = 0; i < numberOfWrongLetters; i++)
                            System.out.print(wrongLetters[i] + " ");
                    };
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

                if (numberOfWrongLetters == 10) {
                    System.out.println("\nYou have guessed (" + numberOfWrongLetters + ") wrong letters.");
                    System.out.println("You lose. The answer was " + title);
                    break;
                }

                boolean win = true;
                for (int i = 0; i < title.length(); i++) {
                    if(hiddenTitleTable[i] != shownTitleTable[i])
                        win = false;
                }

                if (win){
                    System.out.println("You won! Congratulations!");
                    break;
                }

            }

    }

    public static String chooseTitleFromFile (Scanner scanner1, Scanner scanner2) {
        int lineCounter = 0;

        while(scanner1.hasNextLine()) {
            lineCounter++;
            scanner1.nextLine();
        }

        String [] titlesArray = new String[lineCounter];
        for (int i = 0; i < lineCounter; i++) {
            titlesArray[i] = scanner2.nextLine();
        }

        int randomLine = (int) (Math.random()*lineCounter) + 1;

        return titlesArray[randomLine];
    }
}
