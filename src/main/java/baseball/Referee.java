package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Referee {

    int strike;
    int ball;

    Ball comBall = new Ball();
    Ball humanBall = new Ball();

    final String Strike = "스트라이크";
    final String Ball = "볼";
    final String Nothing = "낫싱";

    public Referee() {

    }

    public void playBall() {
        do {
            start();
        } while (restart());
    }

    private void start() {
        comBall.makeComputerBalls();
        giveHint();
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartIndex = Console.readLine();
        if (!validRestartIndex(restartIndex)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        if (restartIndex.equals("1")) {
            comBall.clear();
            return true;
        }
        return false;
    }

    private boolean validRestartIndex(String restartIndex) {
        return restartIndex.equals("1") || restartIndex.equals("2");
    }

    public void giveHint() {
        while (!isAnswer()) {
            strike = 0;
            ball = 0;
            humanBall.makeHumanBalls();
            compareStrike(comBall, humanBall);
            compareBall(comBall, humanBall);
            if (strike == 0 && ball == 0) {
                System.out.println(Nothing);
            }
            if (strike != 0 && ball != 0) {
                System.out.println(ball + Ball + " " + strike + Strike);
            }
            if (strike != 0 && ball == 0) {
                System.out.println(strike + Strike);
            }
            if (strike == 0 && ball != 0) {
                System.out.println(ball + Ball);
            }
        }
        strike = 0;
        ball = 0;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void compareBall(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) != i) {
                ball++;
            }
        }
    }

    public void compareStrike(Ball comBall, Ball humanBall) {
        for (int i = 0; i < comBall.size(); i++) {
            if (humanBall.contains(comBall.get(i)) && humanBall.indexOf(comBall.get(i)) == i) {
                strike++;
            }
        }
    }

    public boolean isAnswer() {
        return strike == 3;
    }


}
