package baseball.util;

import java.util.Random;

public class RandomUtil {

    public static String generateNumber() {
        Random random = new Random();
        StringBuilder resultString = new StringBuilder();

        while (resultString.length() < 3) {
            int randomDigit = random.nextInt(9) + 1;
            if (!resultString.toString().contains(String.valueOf(randomDigit))) {
                resultString.append(randomDigit);
            }
        }
        return resultString.toString();
    }
}
