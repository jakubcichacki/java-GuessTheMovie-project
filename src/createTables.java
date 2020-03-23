public class createTables {

    public static char[] createShownTitleTable(String title) {
        char [] shownTitleTable = new char[title.length()];
        for (int i = 0; i < title.length(); i++)
            shownTitleTable[i] = title.charAt(i);
        return shownTitleTable;
    }

    public static char[] createHiddenTitleTable(String title, char[] shownTitleTable) {
        char [] hiddenTitleTable = new char[title.length()];
        for (int i = 0; i < title.length(); i++) {
            if(shownTitleTable[i] == ' ')
                hiddenTitleTable[i] = shownTitleTable[i];
            else hiddenTitleTable[i] = '_';
        }
        return hiddenTitleTable;
    }
}
