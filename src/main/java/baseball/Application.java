package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Number playerNumFactory = new PlayerNum();
        Computer computer = new Computer();
        List<Integer> playerNumber;
        do {
            playerNumber = playerNumFactory.createNumber();
            playerNumFactory.verifyNumber(playerNumber);
            String gameStatus = computer.getResult(playerNumber);
            if (gameStatus == GameComment.RESTART) {
                computer = new Computer();
            } else if (gameStatus == GameComment.TERMINATE) {
                break;
            }
        } while (true);
    }

}
