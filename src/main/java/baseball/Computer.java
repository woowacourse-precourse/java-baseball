package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Computer {
    public static String createRandomNumber() {
        String randomNumber = "";
        while (randomNumber.length() < 3) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(Integer.toString(temp))) {
                randomNumber = randomNumber + temp;
            }
        }
        return randomNumber;
    }

    public static HashMap<String, Integer> getHint(String userNumber, String goalNumber) {
        HashMap<String, Integer> hint =  new HashMap<>();

        return hint;
    }
}