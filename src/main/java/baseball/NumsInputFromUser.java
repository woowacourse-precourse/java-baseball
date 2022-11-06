package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumsInputFromUser {
    private int hundred, ten , one;

    public int[] getInputNumForGame() throws IllegalArgumentException{
        int input = Integer.parseInt(Console.readLine());

        computeEach(input);

        checkInputException(hundred, ten, one);

        int[] InputArr = toArr();

        return InputArr;
    }

    private void computeEach(int input) {
        hundred = input / 100;
        ten     = (input % 100) / 10;
        one     = ((input % 100) % 10);
    }

    private void checkInputException(int hundred, int ten , int one) throws IllegalArgumentException {
        IllegalArgumentException exception = new IllegalArgumentException();

        if (hundred > 9) throw exception;
        if (hundred < 0 || ten < 0 || one < 0) throw exception;

        if (hundred == ten || hundred == one || ten == one) {
            throw exception;
        }
    }

    private int[] toArr() {
        int[] InputArr = new int[3];
        InputArr[0]    = hundred;
        InputArr[1]    = ten;
        InputArr[2]    = one;

        return InputArr;
    }

}
