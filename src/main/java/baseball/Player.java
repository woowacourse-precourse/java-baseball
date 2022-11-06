package baseball;

public class Player {
    private static final int DESIRED_LENGTH = 3;

    public boolean isContainOnlyDigit(String input) {
        for (Character character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCorrectLength(String input) {
        return input.length() == DESIRED_LENGTH;
    }
}
