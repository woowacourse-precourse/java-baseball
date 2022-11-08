package baseball;

import static baseball.Message.END_INPUT;
import static baseball.Message.REPLAY_INPUT;

public class ReplayNumber {

    public boolean validate(String input) {

        if (input.equals(REPLAY_INPUT) || input.equals(END_INPUT)) {
            return input.equals(REPLAY_INPUT);
        }

        throw new IllegalArgumentException();
    }
}
