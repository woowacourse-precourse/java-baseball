package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_SENTENCE = "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료" +
                                               "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL_WORD = "볼 ";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOTHING_WORD = "낫싱";

    private boolean gameContinue = true;

    private List<Integer> computer;
    private List<Integer> player;

    private int ball = 0;
    private int strike = 0;

    public void startGame() {
        System.out.println(START_SENTENCE);

        setComputer();

        while (gameContinue) {
            setPlayer();
            resetCount();
            countHit();
        }
    }

    private void setComputer() {
        Number number = new Number();
        this.computer = number.getComputerNumber();
    }

    private void setPlayer() {
        Number number = new Number();
        this.player = number.getPlayerNumber();
    }

    private void resetCount() {
        ball = 0;
        strike = 0;
    }

    private void countHit() {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
    }

    private String getResultString() {
        if (ball == 0 && strike == 0) {
            return NOTHING_WORD;
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball).append(BALL_WORD);
        }
        if (strike > 0) {
            result.append(strike).append(STRIKE_WORD);
        }
        if (strike == 3) {
            result.append(WIN_SENTENCE);
        }
        return result.toString();
    }
}
