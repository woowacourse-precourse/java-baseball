package baseball.game;

import java.util.EnumMap;

public class Game {
    private static final int RESULT_HAVE_BALL_AND_STRIKE = 2;
    private static final int RESULT_HAVE_ONLY_BALL_OR_STRIKE = 1;

    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String ENDING_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private int numberOfBall;
    private int numberOfAttempts = 0;

    private BallMaker ballMaker;
    private BallReader ballReader;

    public Game() {
        this.numberOfBall = 3;
        this.ballMaker = new BallMaker();
        this.ballReader = new BallReader();
    }

    public Game(BallMaker ballMaker, BallReader ballReader) {
        this.numberOfBall = 3;
        this.ballMaker = ballMaker;
        this.ballReader = ballReader;
    }

    public Game(int ballCount) {
        this.numberOfBall = ballCount;
        this.ballReader = new BallReader(ballCount);
        this.ballMaker = new BallMaker(ballCount, 0);
    }

    public String play() {
        Ball computerBall = ballMaker.getRandomBall();
        boolean gameOver = false;
        while (gameOver != true) {
            Ball userBall = ballMaker.getUserBall();
            gameOver = ballReader.isGameOver(userBall, computerBall);
            printResult(userBall, computerBall);
            numberOfAttempts += 1;
        }
        printEndingMessage();
        return "";
    }

    public void printStartingMessage() {
        System.out.printf(STARTING_MESSAGE);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    private void printResult(Ball userBall, Ball computerBall) {
        EnumMap<ResultOfBall, Integer> result = ballReader.getStrikeAndBall(userBall, computerBall);
        if (result.isEmpty()) {
            System.out.printf(NOTHING_MESSAGE);
        }
        if (result.size() == RESULT_HAVE_BALL_AND_STRIKE) {
            System.out.printf(BALL_AND_STRIKE_MESSAGE, result.get(ResultOfBall.STRIKE), result.get(ResultOfBall.BALL));
        }
        if (result.size() == RESULT_HAVE_ONLY_BALL_OR_STRIKE && result.containsKey(ResultOfBall.STRIKE)) {
            System.out.printf(STRIKE_MESSAGE, result.get(ResultOfBall.STRIKE));
        }
        if (result.size() == RESULT_HAVE_ONLY_BALL_OR_STRIKE && result.containsKey(ResultOfBall.BALL)) {
            System.out.printf(BALL_MESSAGE, result.get(ResultOfBall.BALL));
        }
    }

    private void printEndingMessage() {
        System.out.printf(ENDING_MESSAGE, numberOfBall);
    }

}
