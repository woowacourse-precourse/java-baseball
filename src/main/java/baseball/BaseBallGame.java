package baseball;

import baseball.utils.InputReaderImpl;
import baseball.utils.NumberGeneratorImpl;

public class BaseBallGame {

    public static final Integer GAME_NUMBER_LENGTH = 3;
    public static final Integer GAME_RESTART = 1;
    public static final Integer GAME_EXIT = 2;

    private final UserInput userInput = new UserInput(new InputReaderImpl());

    private Pitcher pitcher;
    private Catcher catcher;
    private OptionSelector optionSelector;

    public void startGame() {
        initPlayers();
        // '숫자 야구 게임을 시작합니다.'
        do {
            play();
            // 3개의 숫자를 모두 맞히셨습니다! 게임 종료
            //게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
        } while (optionSelector.isContinue());

    }

    private void initPlayers() {
        optionSelector = userInput;
        pitcher = userInput;
        catcher = new Catcher(new NumberGeneratorImpl());
    }

    private void play() {
        GameResult gameResult;
        do {
            // '숫자를 입력해주세요 : '
            gameResult = catcher.catching(pitcher.pitching());
        } while (gameResult.isFinished());
    }

}
