package baseball;

public class Player {
    private final Integer[] value;
    private static final int MAX_LENGTH = 3;

    public Player() {
        value = new Integer[MAX_LENGTH];
    }

    public void setInputValue(String input) {
        for (int index = 0; index < MAX_LENGTH; index++) {
            value[index] = Character.getNumericValue(input.charAt(index));
        }
    }

    public Integer[] getValue() {
        return value;
    }
}