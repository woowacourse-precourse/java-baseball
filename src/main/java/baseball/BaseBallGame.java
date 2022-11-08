package baseball;

import baseball.catcher.Catcher;
import baseball.user.OptionSelector;
import baseball.user.pitcher.Pitcher;
import baseball.user.UserInput;
import baseball.user.util.InputReaderImpl;
import baseball.catcher.util.NumberGeneratorImpl;

public class BaseBallGame {

    private static final String WELCOME_MSG = "숫자 야구 게임을 시작합니다.\n";
    private static final String SELECT_OPTION_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static final String REQ_INPUT_MSG = "숫자를 입력해주세요 : ";
    public static final Integer GAME_NUMBER_LENGTH = 3;
    public static final Integer GAME_RESTART = 1;
    public static final Integer GAME_EXIT = 2;

    private final Pitcher pitcher;
    private final Catcher catcher;
    private final OptionSelector optionSelector;

    public BaseBallGame() {
        UserInput userInput = new UserInput(new InputReaderImpl());
        optionSelector = userInput;
        pitcher = userInput;
        catcher = new Catcher(new NumberGeneratorImpl());
    }

    public void startGame() {
        print(WELCOME_MSG);
        do {
            play();
            print(SELECT_OPTION_MSG);
        } while (optionSelector.isContinue());
    }

    private void play() {
        GameResult gameResult;
        catcher.initRandomNumbers();
        do {
            print(REQ_INPUT_MSG);
            gameResult = catcher.catching(pitcher.pitching());
            print(gameResult.toString());
        } while (!gameResult.isFinished());
    }

    private void print(String msg) {
        System.out.print(msg);
    }
}
