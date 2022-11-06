package baseball;

public class BaseballGame extends AbstractBaseballGame {
    private static final String EVENT_MESSAGE_BEFORE_PLAY = "숫자 야구 게임을 시작합니다.";
    private static final String EVENT_MESSAGE_PLAYING = "숫자를 입력해주세요 : ";
    private static final String EVENT_MESSAGE_AFTER_PLAY = "${numMatch}개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 ${startNum}, 종료하려면 ${endNum}를 입력하세요.";

    private final NumberService numberService = new NumberServiceImpl();
    private final GameOverService gameOverService = new GameOverServiceImpl();

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
        System.out.println(parsedEventMessageAfterPlay());
        return gameOverService.retries();
    }

    private String parsedEventMessageAfterPlay() {
        return EVENT_MESSAGE_AFTER_PLAY
                .replaceAll("\\$\\{numMatch}", Integer.toString(NumberServiceImpl.NUM_MATCHES))
                .replaceAll("\\$\\{startNum}", ControlNumber.START_NUM.toString())
                .replaceAll("\\$\\{endNum}", ControlNumber.END_NUM.toString());
    }
}
