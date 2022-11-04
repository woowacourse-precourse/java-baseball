package baseball;

public class Ball {
    Computer computer = new Computer();
    Strike strike = new Strike();

    public int compareCharacterDifferentLocationMatch() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.randomNumberListToString().contains(InputNumber.number.substring(i, i + 1))) {
                count++;
            }
        }
        count = count - strike.compareCharacterLocationMatch();
        return count;
    }
}
