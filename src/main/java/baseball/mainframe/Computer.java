package baseball.mainframe;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static String randomNumber;

    public static void setRandomNumber(String number) {
        randomNumber = number;
    }

    public static String getRandomNumber() {
        return randomNumber;
    }

    public static void generateRandomNumber() {
        List<String> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(String.valueOf(randomNumber))) {
                randomNumberList.add(String.valueOf(randomNumber));
            }
        }
        setRandomNumber(String.join("",randomNumberList));
    }
}
