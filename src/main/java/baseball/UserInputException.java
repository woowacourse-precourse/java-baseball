package baseball;

public class UserInputException {
    public boolean isContainLetter(String input) {
        for (char eachChar : input.toCharArray()) {
            if (Character.isLetter(eachChar)) {
                return true;
            }
        }
        return false;
    }
}
