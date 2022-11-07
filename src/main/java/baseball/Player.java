package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.MAX_LENGTH;

public class Player {
    Validator validator = new Validator();

    public Balls inputGuess() throws IllegalArgumentException {
        Balls guess = new Balls();
        String input = Console.readLine();

        validator.isNumeric(input);
        validator.checkGuessLength(input);
        for (int i = 0; i < MAX_LENGTH; i++) {
            int num = input.charAt(i) - '0';
            validator.checkRange(num);
            guess.add(num);
        }
        return guess;
    }
}