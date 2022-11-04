package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public Reader() {
    }

    protected int readInt() {
        return Integer.parseInt(Console.readLine());
    }

    public int readInt(int min, int max) {
        try {
            int value = readInt();
            validateValue(value, min, max);
            return value;
        } catch (Exception e) {
            throw new IllegalArgumentException("it is not Number");
        }
    }

    private void validateValue(int value, int min, int max) {
        if (value < min || value > max)
            throw new IllegalArgumentException("value must be min<=value<=max");
    }
}
