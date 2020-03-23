public class checkWinLose {
    public static boolean checkWinning(String title, char[] shownTitleTable, char[] hiddenTitleTable) {
        boolean win = true;
        for (int i = 0; i < title.length(); i++) {
            if(hiddenTitleTable[i] != shownTitleTable[i])
                win = false;
        }

        if (win){
            System.out.println("You won! Congratulations!");
            return true;
        }
        return false;
    }

    public static boolean checkLoosing(int maxPoints, int numberOfWrongLetters, String title) {
        if (numberOfWrongLetters == maxPoints) {
            System.out.println("\nYou have guessed (" + numberOfWrongLetters + ") wrong letters.");
            System.out.println("You lose. The answer was " + title);
            return true;
        }
        return false;
    }
}
