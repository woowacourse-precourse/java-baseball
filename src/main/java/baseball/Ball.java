package baseball;

public class Ball {
    Computer computer = new Computer();
    Strike strike = new Strike();

    public int compareCharacterDifferentLocationMatch(String inputNumber, String computerNumber) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(inputNumber.substring(i, i + 1))) {
                count++;
            }
        }
        count = count - strike.compareCharacterLocationMatch(inputNumber, computerNumber);
        return count;
    }
}
