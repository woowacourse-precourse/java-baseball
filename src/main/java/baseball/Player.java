package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.Message;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> createGuessNumber() {
        String guessNumberString = readLine();

        exceptionHandler(guessNumberString);

        List<Integer> guessNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            guessNumber.add(guessNumberString.charAt(i) - '0');
        }

        return guessNumber;
    }

    private void exceptionHandler(String number) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        if (!isValidSize(number)
                || !isValidScope(number)
                || !isDifferentNumber(number)) {
            throw illegalArgumentException;
        }
    }

    private boolean isValidSize(String number) {
        return number.length() == 3;
    }

    private boolean isValidScope(String number) {
        char minDigitNumber = '1';
        char maxDigitNumber = '9';

        for (int i = 0; i < 3; i++) {
            if (!(number.charAt(i) >= minDigitNumber && number.charAt(i) <= maxDigitNumber)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDifferentNumber(String number) {
        return number.charAt(0) != number.charAt(1)
                && number.charAt(0) != number.charAt(2)
                && number.charAt(1) != number.charAt(2);
    }

    public boolean restart() {
        System.out.println(Message.RESTART_OR_END);

        String restart = readLine();
        if (restart.equals(Message.RESTART)) {
            return true;
        } else if (restart.equals(Message.END)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
