package baseball.mainframe;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static String randomNumber;

    public static void setRandomNumber(String number) {
        randomNumber = randomNumber;
    }

    public static String getRandomNumber() {
        return randomNumber;
    }

    public static String makeListToString(List<Integer> list) {
        return String.join(list.toString());
    }

    public static void generateRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        setRandomNumber(makeListToString(randomNumberList));
    }
}
