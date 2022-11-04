package baseball;

public class BaseballApplicationManager {
    private int answer;
    BaseballApplicationManager() {
        // IOManager.printProgramStartMessage
    }

    public void startProgram() {
        try {
            while(true) {
                // play one game
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
