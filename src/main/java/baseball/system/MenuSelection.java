package baseball.system;

public class MenuSelection {

    private final boolean PLAY_GAME = true;
    private final boolean QUIT = false;


    public boolean startMenuSelection() {

        printMenuSelection();

        String selectionNumber = inputSelectionNumber();

        if(selectionNumber.equals("1")){
            return PLAY_GAME;
        }

        return QUIT;

    }
}
