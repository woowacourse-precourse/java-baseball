package baseball;

public class BaseballGame extends AbstractBaseballGame {
    private static final String EVENT_MESSAGE_BEFORE_PLAY = "숫자 야구 게임을 시작합니다.";

    @Override
    protected void startEventBeforePlay() {
        System.out.println(EVENT_MESSAGE_BEFORE_PLAY);
    }

    @Override
    protected void play() {

    }

    @Override
    protected boolean startEventAfterPlay() {
        return false;
    }
}
