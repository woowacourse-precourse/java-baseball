package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
public class GetInput {
    public GetInput() {
    }
    public int getInput() throws IllegalArgumentException {
        int inputNumber = Integer.parseInt(Console.readLine());
        if (inputNumber != 0 && inputNumber <= 999) {
            return inputNumber;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
