package baseball;

public class GameException {

    public void restartException(int startOrEnd) {

        if (startOrEnd != 1 && startOrEnd != 2) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }

    }

    public void inputException(String inputNum) {
        if (inputNum.length() != 3) throw new IllegalArgumentException("잘못된 입력 값입니다.");

        char min = '1';
        char max = '9';

        for (int i = 0; i < inputNum.length(); i++) {
            char c = inputNum.charAt(i);

            if (c < min || c > max) {
                throw new IllegalArgumentException("잘못된 입력 값입니다.");
            }

            if (inputNum.replace(String.valueOf(c), "").length() != 2) {
                throw new IllegalArgumentException();
            }

        }
    }


}
