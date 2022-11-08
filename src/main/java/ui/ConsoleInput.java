package ui;

import camp.nextstep.edu.missionutils.Console;
import domain.ValidityChecker;
import java.util.Objects;

public class ConsoleInput implements Input{

    @Override
    public String scan(final int PURPOSE, final int MAX_LEN) {
        final int REPLAY_GAME = 1;
        final int GUESSING_NUMBER = 2;
        ValidityChecker Checker = new ValidityChecker();
        String input = Console.readLine();

        if (Objects.equals(PURPOSE, REPLAY_GAME)) {
            Checker.validateRepalyGameInput(input);
        } else if (Objects.equals(PURPOSE, GUESSING_NUMBER)) {
            Checker.validateNumberInput(input, MAX_LEN);
        }

        return input;
    }
}
