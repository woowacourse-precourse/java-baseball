package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.game.InputManager.validateInputDuringGame;
import static baseball.game.InputManager.validateInputPostGame;
import static baseball.util.StringConverter.stringToIntList;

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

    private Baseball baseball;

    private List<Integer> userInput;

    public BaseballGame() {
    }

    @Override
    public void start() {
        createNewBaseball();
        do {
            input();
            createResult().showResult();
        } while (baseball.isGuessFailed(userInput));
    }

    @Override
    public boolean isRestart() {
        System.out.println(RESTART_MESSAGE);

        final String userInput = Console.readLine();
        validateInputPostGame(userInput);

        if (userInput.equals(RESTART)) return true;
        if (userInput.equals(TERMINATE)) return false;
        throw new IllegalArgumentException("INPUT : " + userInput);
    }

    @Override
    public void showStartMessage() {
        System.out.println(START_MESSAGE);
    }

    @Override
    public void showEndMessage() {
        System.out.println(END_MESSAGE);
    }

    private void createNewBaseball() {
        baseball = new Baseball(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER, BASEBALL_LENGTH_LIMIT);
    }

    private void input() {
        System.out.print(INPUT_MESSAGE);

        final String input = Console.readLine();
        validateInputDuringGame(input);
        userInput = stringToIntList(input);
    }

    private GameResult createResult() {
        final int strikeCount = baseball.getStrikeCount(userInput);
        final int ballCount = baseball.getBallCount(userInput);
        return new BaseballGameResult(strikeCount, ballCount);
    }
}
