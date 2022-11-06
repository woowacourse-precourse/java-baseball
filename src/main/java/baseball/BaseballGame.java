package baseball;

public class BaseballGame extends AbstractBaseballGame {
    private static final String EVENT_MESSAGE_BEFORE_PLAY = "숫자 야구 게임을 시작합니다.";
    private static final String EVENT_MESSAGE_PLAYING = "숫자를 입력해주세요 : ";

    private final NumberService numberService = new NumberServiceImpl();

    @Override
    protected void startEventBeforePlay() {
        System.out.println(EVENT_MESSAGE_BEFORE_PLAY);
    }

    @Override
    protected void play() {
        Score score;

        numberService.pickNumbersByComputer();
        do {
            System.out.print(EVENT_MESSAGE_PLAYING);
            numberService.enterNumbersByUser();
            score = numberService.evaluateNumbers();
            System.out.println(score);
        } while (!score.allMatch());
    }

    @Override
    protected boolean startEventAfterPlay() {
        return false;
    }
}
