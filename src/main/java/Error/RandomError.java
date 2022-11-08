package Error;

import static MathUtils.Digit.findDigitNumber;

public class RandomError {

    public static boolean isDuplicateNumber(int random, int num, int size) {
        for (int i = 0; i < size; i++) {
            if (findDigitNumber(random, i + 1) == num) {
                return true;
            }
        }
        return false;
    }
}
