package baseball.Game;

public class Vaildate {
    final int NUM_LEN = 3;

    public int [] userInputVaildate(String input) {
        checkLen(input, NUM_LEN);
        int targetInt [] = vailInput(input);

        return targetInt;
    }

    /* 입력받은 숫자 길이 확인 */
    public void checkLen(String input, int numLen) {
        if (input.length() != numLen) {
            throw new IllegalArgumentException();
        }
    }

    /* 입력받은 숫자 검증 */
    public int [] vailInput(String input) {
        int targetInt[] = new int[NUM_LEN];

        for (int i = 0; i < input.length(); i++) {
            if('0' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            targetInt[i] = input.charAt(i) - '0';
        }

        return targetInt;
    }


}
