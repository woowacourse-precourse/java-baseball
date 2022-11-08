package baseball.utility;

import baseball.constant.GameConstant;
import baseball.constant.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private static final String TEXT_FOR_START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String TEXT_FOR_PROMPT_PLAYER_NUMBER_INPUT = "숫자를 입력해주세요 : ";
    private static final String TEXT_FOR_END_ROUND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String THREE_STRIKE = "3스트라이크";

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
            String playerNumber = getPlayerNumber();

            PlayerNumberValidator.throwIllegalArgumentExceptionIfPlayerNumberNotValid(playerNumber);

            String hint = ResultEvaluator.getHint(this.computerNumber, playerNumber);
            System.out.println(hint);
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

    private String getPlayerNumber() {
        System.out.print(TEXT_FOR_PROMPT_PLAYER_NUMBER_INPUT);
        return readLine();
    }

    private void processGameFlowAccordingToHint(String hint) {
        assert (hint != null);

        if (hint.equals(THREE_STRIKE)) {
            System.out.println(TEXT_FOR_END_ROUND);
        }
    }
}
