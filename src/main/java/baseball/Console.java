package baseball;

import java.util.NoSuchElementException;

public interface Console {
    static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (NoSuchElementException e) {
            throw new MyInputMismatchException();
        }
    }

    static String readLineWithValidation(String regex) {
        final String line = readLine();
        if (line.matches(regex)) {
            return line;
        }
        throw new MyInputMismatchException(line);
    }
}
