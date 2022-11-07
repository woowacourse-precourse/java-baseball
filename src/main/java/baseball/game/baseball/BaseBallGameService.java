package baseball.game.baseball;

import baseball.domain.baseball.GameNumbers;
import baseball.domain.baseball.BaseBallGamePlayer;
import baseball.domain.baseball.BaseBallGameResult;
import baseball.util.NumberGenerator;

public class BaseBallGameService implements GameService {

    private final GameNumbers computerNumbers;
    private final int LIMITED_NUMBER_SIZE = 3;
    public static final String inputMessage = "숫자를 입력해주세요 : ";
    public static final String startMessage = "숫자 야구 게임을 시작합니다.\n";


    public BaseBallGameService() {
        this.computerNumbers = new GameNumbers(NumberGenerator.createGameNumbers());
    }

    @Override
    public void execute() {
        BaseBallGamePlayer player;
        startMessage();
        do {
            inputMessage();
            player = new BaseBallGamePlayer(computerNumbers);
            showGameResult(player);
        } while (player.getStrikeCount() != LIMITED_NUMBER_SIZE);
    }

    @Override
    public void inputMessage() {
        System.out.print(inputMessage);
    }

    @Override
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
        return player.getUserInput().getNumberList().stream()
                .noneMatch(computerNumbers::isContains);
    }
}