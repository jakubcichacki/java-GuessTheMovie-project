import java.util.Scanner;

public class choosingTitle {
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
