package baseball.utility;

import baseball.constant.GameConstant;
import baseball.constant.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class GameManager {
    private static GameManager gameManager;

    private GameStatus gameStatus;
    private String computerNumber;

    private GameManager() {
        this.gameStatus = GameStatus.STOPPED;
    }

    public static GameManager getGameManager() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    private boolean isGamePlaying() {
        return this.gameStatus == GameStatus.PLAYING;
    }

    private String generateComputerNumber() {
        HashSet<Integer> hashSet = new LinkedHashSet<>();

        while (hashSet.size() < GameConstant.VALID_NUMBER_LENGTH.getValue()) {
            hashSet.add(Randoms.pickNumberInRange(1, 9));
        }

        StringBuilder computerNumberBuilder = new StringBuilder();
        hashSet.forEach(computerNumberBuilder::append);

        return computerNumberBuilder.toString();
    }

    private void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }

}
