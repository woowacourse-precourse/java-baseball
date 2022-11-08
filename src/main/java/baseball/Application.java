package baseball;

import baseball.component.Computer;
import baseball.component.Targetable;
import baseball.gameRule.GameRule;
import baseball.gameRule.GameRuleDetail;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.initGame(new Computer(), new GameRuleDetail());
    }

    /**
     * 게임 진행을 담당하는 함수
     */
    public void initGame(Targetable target, GameRule gameRule) {
        GameStatus status = GameStatus.CONTINUE;
        do {
            if (GameStatusUtil.isStopStatus(status)) {
                break;
            }
            GameStatusUtil.validateExceptionStatus(status);
            GameFormatter.gameStartMessage();
            String answer = target.initAnswer();
            gameRule.playByGameRule(answer);
            GameFormatter.gameEndMessage();
            status = GameStatusUtil.setGameStatus(Console.readLine());
        } while (true);
    }
}
