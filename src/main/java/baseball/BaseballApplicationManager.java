package baseball;

public class BaseballApplicationManager {
    BaseballApplicationManager() {
        IOManager.printProgramStartMessage();
    }

    public void startProgram() {
        try {
            boolean play = true;
            while(play) {
                BaseballGameManager gameManager = new BaseballGameManager();
                gameManager.playGame();
                play = keepPlaying();
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean keepPlaying() {
        return false;
    }
}
