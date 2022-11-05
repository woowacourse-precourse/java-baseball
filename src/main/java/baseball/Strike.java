package baseball;

public class Strike {
    public int compareCharacterLocationMatch(String inputNumber, String computerNumber) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (inputNumber.charAt(i)
                    == computerNumber.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
