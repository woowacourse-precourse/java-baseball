package baseball;

public class BaseballApplicationManager {
    public void startProgram() {
        boolean play = true;

        IOManager.printProgramStartMessage();

        while(play) {
            BaseballGameManager gameManager = new BaseballGameManager();
            gameManager.playGame();
            play = keepPlaying();
        }
    }

    private boolean keepPlaying() throws IllegalArgumentException {
        return IOManager.inputRestart();
    }
}
