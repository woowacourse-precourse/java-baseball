package baseball;

public class GameException {

    public void restartException(int startOrEnd) {

        if (startOrEnd != 1 && startOrEnd != 2) {
            throw new IllegalArgumentException();
        }

    }

    public void inputException(String inputNum) {
        if (inputNum.length() != 3) throw new IllegalArgumentException();

        char min = '1';
        char max = '9';

        for (int i = 0; i < inputNum.length(); i++) {
            char c = inputNum.charAt(i);

            if (c < min || c > max) {
                throw new IllegalArgumentException();
            }

            if (inputNum.replace(String.valueOf(c), "").length() != 2) {
                throw new IllegalArgumentException();
            }

        }
    }


}
