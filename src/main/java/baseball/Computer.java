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
        HashMap<String, Integer> hint = new HashMap<>();
        hint.put("strike", 0);
        hint.put("ball", 0);

        strike(hint, userNumber, goalNumber);
        ball(hint, userNumber, goalNumber);

        return hint;
    }

    public static HashMap<String, Integer> strike(HashMap<String, Integer> hint, String userNumber, String goalNumber) {
        for (int i = 0; i < goalNumber.length(); i++) {
            if (goalNumber.charAt(i) == userNumber.charAt(i)) {
                hint.put("strike", hint.get("strike") + 1);
            }
        }
        return hint;
    }

    public static HashMap<String, Integer> ball(HashMap<String, Integer> hint, String userNumber, String goalNumber) {
        StringBuffer userNumber_sb = new StringBuffer();
        StringBuffer goalNumber_sb = new StringBuffer();
        userNumber_sb.append(userNumber);
        goalNumber_sb.append(goalNumber);

        for (int i = 0; i < userNumber_sb.length(); i++) {
            if (goalNumber.charAt(i) == userNumber.charAt(i)) {
                goalNumber_sb.deleteCharAt(i);
                userNumber_sb.deleteCharAt(i);
            }
        }

        goalNumber = goalNumber_sb.toString();
        int count = 0;

        for (int i = 0; i < userNumber.length(); i++) {
            if (goalNumber.contains(String.valueOf(userNumber.charAt(i)))) {
                count++;
            }
        }
        if (count != 0) {
            hint.put("ball", hint.get("ball") + count);
        }
        return hint;
    }
}