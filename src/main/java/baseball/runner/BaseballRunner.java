package baseball.runner;

import baseball.engine.BaseballEngine;
import baseball.engine.PlayState;
import baseball.viewer.BaseballTextType;
import baseball.viewer.BaseballViewer;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballRunner implements IGameRunner {
    private final BaseballViewer viewer;
    private final BaseballEngine engine;

    public BaseballRunner(BaseballViewer viewer, BaseballEngine engine) {
        this.viewer = viewer;
        this.engine = engine;
    }

    @Override
    public void init() {
        viewer.display(BaseballTextType.WELCOME_MESSAGE);
    }


    @Override
    public PlayState run() {
        List<Integer> answerList = engine.generateAnswer();
        int tryCount = 0;

        while (tryCount < 3) {
            viewer.display(BaseballTextType.REQUEST_INPUT);

            String userInput = Console.readLine();

            if (!engine.isValidAnswerInput(userInput)) {
                throw new IllegalArgumentException("숫자 야구: 유효하지 않은 유저 답 입력 형식");
            }

            List<Integer> userInputList = engine.parseInput(userInput);
            int ballCount = engine.getBallCountIfPresentOrZero(answerList, userInputList);
            int strikeCount = engine.getStrikeCountIfPresentOrZero(answerList, userInputList);

            viewer.display(ballCount, strikeCount);

            if (strikeCount == 3) {
                viewer.display(BaseballTextType.WINNER);
                break;
            }

            tryCount++;
        }

        viewer.display(BaseballTextType.RETRY_OR_QUIT);
        String userInput = Console.readLine();

        if (!engine.isValidRetryInput(userInput)) {
            throw new IllegalArgumentException("숫자 야구: 유효하지 않은 유저 재도전 입력 형식");
        }

        if (Integer.parseInt(userInput) == PlayState.QUIT.getState()) {
            return PlayState.QUIT;
        }

        return PlayState.RUN;
    }
}
