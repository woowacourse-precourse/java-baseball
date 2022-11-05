package baseball.util.input;

import camp.nextstep.edu.missionutils.Console;

public interface UserInput {
    default String get() {
        String input = Console.readLine();
        validate(input);
        return input;
    }
    void validate(String input);
}
