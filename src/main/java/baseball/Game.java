package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    int strikeCount = 0;
    int ballCount = 0;
    public final int ballsLength = 3;
    final String strikeCall = "스트라이크";
    final String ballCall = "볼";
    final String Nothing = "낫싱";

    Player player = new Player();
    Validator validator = new Validator();

    public Game() {

    }

    public Balls makeComputerBalls() {
        List<Ball> comBalls = new ArrayList<>();

        while (comBalls.size() != ballsLength) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!comBalls.contains(ball)) {
                comBalls.add(ball);
            }
        }

        return new Balls(comBalls);
    }

    public void checkBallCounts(Balls playerBalls, Balls computerBalls) {
        for (int i = 0; i < ballsLength; i++) {
            if (isStrike(playerBalls, computerBalls, i)) {
                strikeCount++;
            }
            if (isBall(playerBalls, computerBalls, i)) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(Balls playerBalls, Balls computerBalls, int i) {
        return playerBalls.get(i).equals(computerBalls.get(i));
    }

    private boolean isBall(Balls playerBalls, Balls computerBalls, int i) {
        return computerBalls.contains(playerBalls.get(i)) && computerBalls.indexOf(playerBalls.get(i)) != i;
    }

    public void playBall() {
        do {
            start();
        } while (restart());
    }

    public void start() {
        Balls computerBalls = makeComputerBalls();

        while (!isAnswer()) {
            initializeBallCount();
            Balls playerBalls = player.makePlayerBalls();
            checkBallCounts(playerBalls, computerBalls);
            System.out.println(printMessage());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        initializeBallCount();
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartIndex = Console.readLine();
        validator.validateRestartIndex(restartIndex);
        return restartIndex.equals("1");
    }

    private void initializeBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private boolean isAnswer() {
        return strikeCount == 3;
    }

    public String printMessage() {
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + ballCall;
        }
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + strikeCall;
        }
        if (strikeCount != 0) {
            return ballCount + ballCall + " " + strikeCount + strikeCall;
        }
        return Nothing;
    }
}
