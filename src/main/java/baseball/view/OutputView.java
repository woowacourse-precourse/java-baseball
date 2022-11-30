package baseball.view;

import baseball.game.ResultOfBall;

import java.util.EnumMap;

public class OutputView {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String ENDING_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public void printResultOfGame(EnumMap<ResultOfBall, Integer> gameData) {
        removeMissBall(gameData);
        if (gameData.isEmpty()) {
            printNothingMessage();
            return;
        }
        printBallOrStrikeMessage(gameData);
    }

    public void printGameEndingMessage(int ballSize) {
        System.out.println(String.format(ENDING_MESSAGE, ballSize));
    }

    private void removeMissBall(EnumMap<ResultOfBall, Integer> gameData) {
        if (gameData.containsKey(ResultOfBall.MISS)) {
            gameData.remove(ResultOfBall.MISS);
        }
    }

    private void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void printBallOrStrikeMessage(EnumMap<ResultOfBall, Integer> gameData) {
        if (gameData.containsKey(ResultOfBall.STRIKE) && gameData.containsKey(ResultOfBall.BALL)) {
            printStrikeAndBallMessage(gameData);
            return;
        }
        printOnlyStrikeOrBallMessage(gameData);
    }

    private void printStrikeAndBallMessage(EnumMap<ResultOfBall, Integer> gameData) {
        System.out.println(String.format(BALL_AND_STRIKE_MESSAGE, gameData.get(ResultOfBall.BALL), gameData.get(ResultOfBall.STRIKE)));
    }

    private void printOnlyStrikeOrBallMessage(EnumMap<ResultOfBall, Integer> gameData) {
        if (gameData.containsKey(ResultOfBall.STRIKE)) {
            System.out.println(String.format(STRIKE_MESSAGE, gameData.get(ResultOfBall.STRIKE)));
            return;
        }
        System.out.println(String.format(BALL_MESSAGE, gameData.get(ResultOfBall.BALL)));
    }
}
