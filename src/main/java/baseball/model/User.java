package baseball.model;

public class User {
    int[] userNumbers;

    public int[] getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }

    public int[] userNumber(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getCorrectNum(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getCorrectNum(String input, int size) throws IllegalArgumentException {
        int[] numList = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!checkNumber(input, i)) {
                throw new IllegalArgumentException();
            }
            numList[i] = convertCharToInt(input, i);
        }
        return numList;
    }

    private int convertCharToInt(String input, int i) {
        return input.charAt(i) - '0';
    }

    private Boolean checkNumber(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }
}
