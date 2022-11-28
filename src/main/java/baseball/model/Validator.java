package baseball.model;

import static baseball.model.NumberProperty.SIZE;
import static baseball.model.GameCommand.END;
import static baseball.model.GameCommand.REPLAY;

public class Validator {

    public static void validateNum(String num) throws IllegalArgumentException {
        checkSize(num);
        checkDuplicate(num);
        checkNumScope(num);
    }

    public static void validateGameCommand(String gameCommand) throws IllegalArgumentException {
        if (!(gameCommand.equals(REPLAY.get()) || gameCommand.equals(END.get()))) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkSize(String num) throws IllegalArgumentException {
        if (num.length() != SIZE.get()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(String num) throws IllegalArgumentException {
        StringBuilder tmp = new StringBuilder();
        for (char x : num.toCharArray()) {
            if (tmp.toString().contains(String.valueOf(x))) {
                throw new IllegalArgumentException();
            }
            tmp.append(x);
        }
    }

    private static void checkNumScope(String num) {
        for (char x : num.toCharArray()) {
            if (!('0' < x && x <= '9')) {
                throw new IllegalArgumentException();
            }
        }
    }
}
