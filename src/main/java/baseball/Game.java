package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private List<Integer> userNumber = new ArrayList<>();
    private List<Integer> computerNumber = new ArrayList<>();
    private Score score;

    public Game() {
        this.computerNumber = Generate.randomNumber();
    }

    public void play() {
        for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
            if (this.userNumber.get(i).equals(this.computerNumber.get(i))) {
                this.score.setStrike(score.getStrike() + 1);
                continue;
            }

            if (this.computerNumber.contains(this.userNumber.get(i))) {
                this.score.setBall(score.getBall() + 1);
            }
        }
    }
}
