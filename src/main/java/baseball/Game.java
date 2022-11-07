package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import baseball.logic.GameLogic;
import baseball.screen.OutputResolver;

public class Game {
    GameLogic gameLogic;
    OutputResolver outputResolver;

    public Game(GameLogic gameLogic, OutputResolver outputResolver) {
        this.gameLogic = gameLogic;
        this.outputResolver = outputResolver;
    }

    public void start(Computer computer, User user) {
        gameLogic.setUp(computer.getNumbers());

        outputResolver.printResult("숫자 야구 게임을 시작합니다.\n");

        play(user);

        outputResolver.printResult("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private void play(User user) {
        while (Result.getStrike() != 3) {
            outputResolver.printResult("숫자를 입력해주세요 : ");
            user.inputNumbers();
            gameLogic.process(user.getNumbers());
            outputResolver.printResult();
        }
    }
}
