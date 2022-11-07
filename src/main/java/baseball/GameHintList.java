package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GameHintList {
    static ArrayList<String> computerSelectedNumbers;
    static ArrayList<String> userSelectedNumbers;

    public void printAllHintListToString() {
        StringBuilder hintListToString = sortHintHashMap();

        if (isNothingSame()) {
            System.out.println("낫싱");
        } else {
            System.out.println(hintListToString);
        }
    }

    public StringBuilder sortHintHashMap() {
        HashMap<String, Integer> allHintHashMap = allHintListHashMap();

        List<String> keySet = new ArrayList<>(allHintHashMap.keySet());
        Collections.sort(keySet);

        StringBuilder hintListToString = new StringBuilder();
        for (String key : keySet) {
            hintListToString.append(allHintHashMap.get(key)).append(key).append(' ');
        }

        return hintListToString;
    }

    public HashMap<String, Integer> allHintListHashMap() {
        HashMap<String, Integer> allHintHashMap = new HashMap<>();

        if (countOfBall() == 0 && countOfStrike() != 0) {
            allHintHashMap.put("스트라이크", countOfStrike());
        } else if (countOfBall() != 0 && countOfStrike() == 0) {
            allHintHashMap.put("볼", countOfBall());
        } else {
            allHintHashMap.put("볼", countOfBall());
            allHintHashMap.put("스트라이크", countOfStrike());
        }
        return allHintHashMap;
    }

    public static int countOfStrike() {
        int count = 0;
        for (int digits = 0; digits < 3; digits++) {
            if (computerSelectedNumbers.get(digits).equals(userSelectedNumbers.get(digits))) {
                count++;
            }
        }
        return count;
    }

    public int countOfBall() {
        int count = 0;

        for (int digit = 0; digit < 3; digit++) {
            String computerNumbersDigit = computerSelectedNumbers.get(digit);
            String userNumberDigit = userSelectedNumbers.get(digit);

            if (!computerNumbersDigit.equals(userNumberDigit) && computerSelectedNumbers.contains(userNumberDigit)) {
                count++;
            }
        }

        return count;
    }

    public boolean isNothingSame() {
        return countOfBall() == 0 && countOfStrike() == 0;
    }

}
