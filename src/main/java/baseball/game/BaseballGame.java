package baseball.game;

public class BaseballGame implements Game {

    private final static int BASEBALL_START_NUMBER = 1;
    private final static int BASEBALL_END_NUMBER = 9;
    public final static int BASEBALL_LENGTH_LIMIT = 3;
    private final static String RESTART = "1";
    private final static String TERMINATE = "2";
    private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";


    public BaseballGame() {
    }

    @Override
    public void start() {
        
    }

    @Override
    public boolean isRestart() {
        return true;
    }

    @Override
    public void showStartMessage() {
        
    }

    @Override
    public void showEndMessage() {
        
    }
}
