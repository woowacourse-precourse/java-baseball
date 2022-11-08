package baseball.util;

public class UserNumberParser {
    public int[] parseUserNumber(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = toInt(input, i);
        }
        return numbers;
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int toInt(String input, int index) {
        return input.charAt(index) - '0';
    }
}
