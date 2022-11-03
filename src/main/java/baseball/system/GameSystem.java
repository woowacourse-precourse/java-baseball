package baseball.system;

public class GameSystem {

    public void runGame() {

        printRunGameText();

        for (; ; ) {

            startGame();

            if (!selectMenu()) {
                break;
            }
            
        }


    }

    private void startGame() {

    }

    private void printRunGameText() {
    }


}
