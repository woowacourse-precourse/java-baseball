package baseball.resources;

import static baseball.resources.GameConfig.*;

public abstract class Sentence {
    public final static String START = "숫자 야구 게임을 시작합니다.";
    public final static String ASK_INPUT = "숫자를 입력해주세요 : ";
    public final static String ASK_RESTART = SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + FINISH + "를 입력하세요.";
    public final static String BALL_STRIKE = "%d볼 %d스트라이크\n";
    public final static String STRIKE = "%d스트라이크\n";
    public final static String BALL = "%d볼\n";
    public final static String NOTHING = "낫싱";
    public final static String EXCEPTION = "서로 다른 " + SIZE + "개의 자연수를 입력하세요";
}
