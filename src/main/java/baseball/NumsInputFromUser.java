package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumsInputFromUser {
    private int hundred;
    private int ten;
    private int one;
    private int[] inputArr;

    private static final IllegalArgumentException BIG_INPUT = new IllegalArgumentException("999 이하의 각 자리가 중복되지 않는 값을 입력해주세요");
    private static final IllegalArgumentException SMALL_INPUT = new IllegalArgumentException("000 이상의 각 자리가 중복되지 않는 값을 입력해주세요");
    private static final IllegalArgumentException DUPLICATED_INPUT = new IllegalArgumentException("값이 중복됩니다. 각 자리수가 다른 값을 입력해주세요");
    private static final IllegalArgumentException NOT_NUMBER = new IllegalArgumentException("세자리의 서로 다른 \"숫자\" 를 입력해주세요");


    public int[] getInputNumForGame() throws IllegalArgumentException {
        try {
            int input = Integer.parseInt(Console.readLine());
            computeEach(input);

            checkInputException(hundred, ten, one);

            inputArr = toArr();

            return inputArr;
        } catch (NumberFormatException ne) {
            throw NOT_NUMBER;
        }
    }

    private void computeEach(int input) {
        hundred = input / 100;
        ten     = (input % 100) / 10;
        one     = ((input % 100) % 10);
    }

    private void checkInputException(int hundred, int ten , int one) throws IllegalArgumentException {
        if (hundred > 9) throw BIG_INPUT;
        if (hundred < 0 || ten < 0 || one < 0) throw SMALL_INPUT;

        if (hundred == ten || hundred == one || ten == one) {
            throw DUPLICATED_INPUT;
        }
    }

    private int[] toArr() {
        int[] inputArr = new int[3];
        inputArr[0]    = hundred;
        inputArr[1]    = ten;
        inputArr[2]    = one;

        return inputArr;
    }
}
