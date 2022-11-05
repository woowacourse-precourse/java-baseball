package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    int strike = 0;
    int ball = 0;

    public final int ballsLength = 3;
    Player player = new Player();
    Validator validator = new Validator();

    final String strikeCall = "스트라이크";
    final String ballCall = "볼";
    final String Nothing = "낫싱";

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
                strike++;
            }
            if (isBall(playerBalls, computerBalls, i)) {
                ball++;
            }
        }
    }

    private boolean isStrike(Balls playerBalls, Balls computerBalls, int i) {
        return playerBalls.get(i).equals(computerBalls.get(i));
    }

    private boolean isBall(Balls playerBalls, Balls computerBalls, int i) {
        return computerBalls.contains(playerBalls.get(i))&&computerBalls.indexOf(playerBalls.get(i))!=i;
    }

    public void playBall() {
        do {
            start();
        } while (restart());
    }

    public void start() {
        Balls computerBalls = makeComputerBalls();
        while(!isAnswer()){
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
        validator.validRestartIndex(restartIndex);
        return restartIndex.equals("1");
    }

    private void initializeBallCount() {
        strike=0;
        ball=0;
    }

    private boolean isAnswer() {
        return strike==3;
    }

    public String printMessage() {
        if (strike == 0 && ball != 0) {
            return ball + ballCall;
        }
        if (strike != 0 && ball == 0) {
            return strike + strikeCall;
        }
        if (strike != 0) {
            return ball + ballCall + " " + strike + strikeCall;
        }
        return Nothing;
    }
}
