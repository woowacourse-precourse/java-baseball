package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumsInputFromUser {
    public int[] getInputNumForGame() throws IllegalArgumentException{
        int input = Integer.parseInt(Console.readLine());
        int hundred = input / 100;
        int ten     = (input % 100) / 10;
        int one     = ((input % 100) % 10);

        checkIfInputDuplicated(hundred, ten, one);

        int[] InputArr = new int[3];
        InputArr[0]    = hundred;
        InputArr[1]    = ten;
        InputArr[2]    = one;

        return InputArr;
    }

    public void checkIfInputDuplicated(int hundred, int ten , int one) throws IllegalArgumentException {
        IllegalArgumentException exception = new IllegalArgumentException();

        if (hundred > 9) throw exception;
        if (hundred < 0 || ten < 0 || one < 0) throw exception;

        if (hundred == ten || hundred == one || ten == one) {
            throw exception;
        }
    }
}
