package baseball;

import java.util.List;

class Number {
    private static List<Integer> userNumbers;
    private static List<Integer> computers;

    private void addRandomNumber(int randomNumber, List<Integer> computer) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    public static List<Integer> getComputers() {
        return computers;
    }

    public static List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
