package baseball.utility;

import baseball.constant.GameConstant;
import baseball.constant.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class GameManager {
    private static final String TEXT_FOR_START_GAME = "숫자 야구 게임을 시작합니다.";

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

    public void runGame() {
        System.out.println(TEXT_FOR_START_GAME);
        this.gameStatus = GameStatus.PLAYING;
        setComputerNumber(generateComputerNumber());

        while (isGamePlaying()) {

        }
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
