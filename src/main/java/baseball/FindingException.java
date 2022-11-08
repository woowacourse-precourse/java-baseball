package baseball;

public class FindingException {
    public void checkOutOfInputNumber(String answer) {
        if (answer.length() != 3) {
            throw new IllegalArgumentException("OutOfBoundsException. you input 3 number");
        }
    }

    public int checkOutOfChoiceNumber(int choice) {
        if (1 > choice || choice > 2) {
            throw new IllegalArgumentException("OutOfBoundsException. you input 1 or 2");
        }
        return choice;
    }
}
