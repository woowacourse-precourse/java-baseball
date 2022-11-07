package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Computer {
    final int numberLength = 3;

    public String createRandomNumber() {
        String randomNumber = "";
        while (randomNumber.length() < numberLength) {
            int temp = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(Integer.toString(temp))) {
                randomNumber = randomNumber + temp;
            }
        }
        return randomNumber;
    }

    public HashMap<String, Integer> getHint(String userNumber, String randomNumber) {
        HashMap<String, Integer> hint = new HashMap<>();
        hint.put("strike", 0);
        hint.put("ball", 0);

        strike(hint, userNumber, randomNumber);
        ball(hint, userNumber, randomNumber);

        return hint;
    }

    private HashMap<String, Integer> strike(HashMap<String, Integer> hint, String userNumber, String randomNumber) {
        for (int i = 0; i < numberLength; i++) {
            if (randomNumber.charAt(i) == userNumber.charAt(i)) {
                hint.put("strike", hint.get("strike") + 1);
            }
        }
        return hint;
    }

    private HashMap<String, Integer> ball(HashMap<String, Integer> hint, String userNumber, String randomNumber) {
        StringBuffer userNumber_sb = new StringBuffer();
        StringBuffer randomNumber_sb = new StringBuffer();
        userNumber_sb.append(userNumber);
        randomNumber_sb.append(randomNumber);

        for (int i = 0; i < randomNumber_sb.length(); i++) {
            if (randomNumber.charAt(i) == userNumber.charAt(i)) {
                randomNumber_sb.deleteCharAt(i);
                userNumber_sb.deleteCharAt(i);
            }
        }

        randomNumber = randomNumber_sb.toString();
        int count = 0;

        for (int i = 0; i < numberLength; i++) {
            if (randomNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                count++;
            }
        }
        if (count != 0) {
            hint.put("ball", hint.get("ball") + count);
        }
        return hint;
    }
}