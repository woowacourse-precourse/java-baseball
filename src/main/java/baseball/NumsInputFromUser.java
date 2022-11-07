package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumsInputFromUser {
    private int hundred, ten , one;
    private int[] InputArr;
    private final static IllegalArgumentException BIGINPUT = new IllegalArgumentException("999 이하의 각 자리가 중복되지 않는 값을 입력해주세요");
    private final static IllegalArgumentException SMALLINPUT = new IllegalArgumentException("000 이상의 각 자리가 중복되지 않는 값을 입력해주세요");
    private final static IllegalArgumentException DUPLICATEDINPUT = new IllegalArgumentException("값이 중복됩니다. 각 자리수가 다른 값을 입력해주세요");
    private final static IllegalArgumentException NOTNUMBER = new IllegalArgumentException("세자리의 서로 다른 \"숫자\" 를 입력해주세요");


    public int[] getInputNumForGame() throws IllegalArgumentException{
        try {
            int input = Integer.parseInt(Console.readLine());
            computeEach(input);

            checkInputException(hundred, ten, one);

            InputArr = toArr();

            return InputArr;
        } catch (NumberFormatException ne) {
            throw NOTNUMBER;
        }
    }

    private void computeEach(int input) {
        hundred = input / 100;
        ten     = (input % 100) / 10;
        one     = ((input % 100) % 10);
    }

    private void checkInputException(int hundred, int ten , int one) throws IllegalArgumentException {
        if (hundred > 9) throw BIGINPUT;
        if (hundred < 0 || ten < 0 || one < 0) throw SMALLINPUT;

        if (hundred == ten || hundred == one || ten == one) {
            throw DUPLICATEDINPUT;
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
