package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public static int ball;
    public static int strike;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int RESTART = 1;
    private static final int QUIT = 2;
    private static final int COUNT = 3;
    public static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = Game.COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 " + Game.RESTART + ", 종료하려면 " + Game.QUIT + "를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static List<Integer> RandomNumber() {
        List<Integer> output = new ArrayList<>();
        while (output.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!output.contains(randomNumber)) {
                output.add(randomNumber);
            }
        }
        return output;
    }
}
