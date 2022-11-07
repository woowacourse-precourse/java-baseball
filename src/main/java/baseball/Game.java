package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RIGHT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AFTER_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    public static final String RESTART_RESPONSE = "1";
    public static final String QUIT_RESPONSE = "2";
    public static final int LENGTH = 3;

    public Computer computer = new Computer();
    public Player player = new Player();
}
