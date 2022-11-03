package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumsInputFromUser {
    public int getInputNumForGame() throws IllegalArgumentException{
        int input = Integer.parseInt(Console.readLine());
        checkIfInputDuplicated(input);

        return input;
    }

    public void checkIfInputDuplicated(int input) throws IllegalArgumentException {
        IllegalArgumentException exception = new IllegalArgumentException();

        // 범위 확인
        if (input < 100 || input > 999) throw exception;

        int hundred = input / 100;
        int ten     = (input % 100) / 10;
        int one     = ((input % 100) % 10);

        if (hundred == ten || hundred == one || ten == one) {
            throw exception;
        }
    }
}
