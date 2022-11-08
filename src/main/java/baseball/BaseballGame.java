package baseball;

public class BaseballGame {

    public void play() {
        run();
    }

    static void run() {
        Result.printStartBaseballGameMessage();

        do {
            startGame();
        } while(Player.wantRestart());
    }

    static void startGame() {
        Computer.generateRandomNumbers();

        boolean isMatched = false;
        while (!isMatched) {
            String input = Player.receiveUserInput();
            isMatched = Computer.checkScore(input);

            if(isMatched) break;
        }
    }

}
