package baseball.input;

import baseball.input.validator.ConsoleValidator;
import baseball.input.validator.Validator;

import camp.nextstep.edu.missionutils.Console;

import static baseball.text.StaticText.ASK_ANSWER;
import static baseball.text.StaticText.ASK_RETRY;

/**
 * camp.nextstep.edu.missionutils.Console에 의존하는 구현체
 */
public class ConsoleInput implements UserInput {
    /**
     * 편의적으로 구현체에서 의존하도록 설정됨
     */
    private final Validator validator = new ConsoleValidator();

    /**
     * @return 서로 다른 3자리 숫자만 허용
     */
    @Override
    public String readAnswer() {
        ASK_ANSWER.print();
        String input = Console.readLine();
        validator.validateAnswer(input);
        return input;
    }

    /**
     * @return 숫자 1, 2만 허용
     */
    @Override
    public String readRetryable() {
        ASK_RETRY.print();
        String input = Console.readLine();
        validator.validateRetryable(input);
        return input;
    }
}
