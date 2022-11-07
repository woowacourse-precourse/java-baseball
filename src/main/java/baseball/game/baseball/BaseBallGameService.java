package baseball.game.baseball;

import baseball.domain.baseball.Ball;
import baseball.domain.baseball.BaseBallGamePlayer;
import baseball.domain.baseball.BaseBallGameResult;

public class BaseBallGameService implements GameService {

    private final Ball ball;
    private final int LIMITED_NUMBER_SIZE = 3;
    public static final String inputMessage = "숫자를 입력해주세요 : ";
    public static final String startMessage = "숫자 야구 게임을 시작합니다.\n";


    public BaseBallGameService() {
        this.ball = new Ball();
    }

    @Override
    public void execute() {
        BaseBallGamePlayer player;
        startMessage();
        do {
            inputMessage();
            player = new BaseBallGamePlayer(ball);
            showGameResult(player);
        } while (player.getStrikeCount() != LIMITED_NUMBER_SIZE);
    }

    public void inputMessage() {
        System.out.print(inputMessage);
    }

    public void startMessage() {
        System.out.print(startMessage);
    }

    public void showGameResult(BaseBallGamePlayer player) {
        BaseBallGameResult result = new BaseBallGameResult();
        long ballCount = player.getBallCount();
        long strikeCount = player.getStrikeCount();
        if (isNothing(player)) {
            result.printNothing();
        }
        if (strikeCount == LIMITED_NUMBER_SIZE) {
            result.printGameEnd();
        }
        if (!isNothing(player) && strikeCount != LIMITED_NUMBER_SIZE) {
            result.printGameResult(ballCount, strikeCount);
        }
    }

    boolean isNothing(BaseBallGamePlayer player) {
        return player.getUserInput().stream()
                .noneMatch(ball::isContains);
    }
}