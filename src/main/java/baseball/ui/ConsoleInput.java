package baseball.ui;

import camp.nextstep.edu.missionutils.Console;
import baseball.domain.InputValidityChecker;
import java.util.Objects;

public class ConsoleInput implements Input{

    @Override
    public String scan(final String PURPOSE, final int MAX_LEN) {
        final String REPLAY_GAME = "1";
        final String GUESSING_NUMBER = "2";
        InputValidityChecker Checker = new InputValidityChecker();

        String input = Console.readLine();

        if (Objects.equals(PURPOSE, REPLAY_GAME)) {
            Checker.validateRepalyGameInput(input);
        } else if (Objects.equals(PURPOSE, GUESSING_NUMBER)) {
            Checker.validateNumberInput(input, MAX_LEN);
        }

        return input;
    }
}
