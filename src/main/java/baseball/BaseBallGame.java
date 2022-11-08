package baseball;

import baseball.utils.InputReaderImpl;
import baseball.utils.UserInput;

public class BaseBallGame {

    public static final Integer GAME_NUMBER_LENGTH = 3;
    public static final Integer GAME_RESTART = 1;
    public static final Integer GAME_EXIT = 2;

    private UserInput userInput = new UserInput(new InputReaderImpl());

    public void startGame() {
        // '숫자 야구 게임을 시작합니다.'
        do {
            play();
        } while (userInput.isContinue());
    }


    private void play() {
        // '숫자를 입력해주세요 : '
        GameResult gameResult = getGameResultFromUserInput();
    }

    private GameResult getGameResultFromUserInput() {
        Integer[] balls = userInput.getGameInput();
        return null;
    }

}
