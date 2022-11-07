package baseball;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseBall {
    private final String NOTHING = "낫싱";
    private final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private final String ENTER_INPUT = "숫자를 입력해주세요 : ";
    private final String BALL = "볼 ";
    private final String STRIKE = "스트라이크";
    private final String END_MENTION = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART_MENTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String RESTART_NUMBER = "1";
    private final String END_NUMBER2 = "2";
    private final int END_CONDITION = 3;
    private final int NUMBER_OF_DIGITS = 3;

    private int strike;
    private int ball;
    private boolean isRestart;
    private List<String> randomList;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
        this.isRestart = true;
        this.randomList = new ArrayList<>();
    }

    public void playBaseBall() {
        System.out.println(START_GAME);
        randomList = makeRandom();
        while (true) {
            initGame();
            playGame();
            boolean isStrike3 = isStrike3();
            if (isStrike3) {
                restart();
            }
            if (this.isRestart == true) {
                continue;
            } else {
                break;
            }
        }
    }

}
