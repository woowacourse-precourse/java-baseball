package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Number numFactory = new PlayerNum();
        Computer computer = new Computer();
        List<Integer> playerNumber;
        while (true) {
            playerNumber = numFactory.createNumber();
            numFactory.verifyNumber(playerNumber);
            if (computer.getResult(playerNumber) == "3스트라이크") {
                if (computer.closeGame()) {
                    computer = new Computer();
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
