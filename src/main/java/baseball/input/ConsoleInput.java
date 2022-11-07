package baseball.input;

import static baseball.text.StaticText.ASK_ANSWER;
import static baseball.text.StaticText.ASK_RETRY;

import baseball.input.validator.ConsoleValidator;
import baseball.input.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * camp.nextstep.edu.missionutils.Console에 의존하는 구현체
 */
public class ConsoleInput implements UserInput {
    /**
     * 편의적으로 구현체에서 의존하도록 설정됨
     */
    private final Validator validator = new ConsoleValidator();

    @Override
    public String readAnswer() {
        ASK_ANSWER.print();
        String input = Console.readLine();
        validator.validateAnswer(input);
        return input;
    }

    @Override
    public String readRetryable() {
        ASK_RETRY.print();
        String input = Console.readLine();
        validator.validateRetryable(input);
        return input;
    }
}
