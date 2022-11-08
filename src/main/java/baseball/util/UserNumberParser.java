package baseball.util;

public class UserNumberParser {
    public int[] parseUserNumber(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return parseNumber(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] parseNumber(String input, int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            if (!checkRange(input, i)) {
                throw new IllegalArgumentException();
            }
            numbers[i] = toInt(input, i);
        }
        return numbers;
    }

    private Boolean checkRange(String input, int index) {
        return '0' <= input.charAt(index) && input.charAt(index) <= '9';
    }

    private int toInt(String input, int index) {
        return input.charAt(index) - '0';
    }
}
