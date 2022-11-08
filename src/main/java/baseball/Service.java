package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private final HashMap<String, Integer> map;
    private String comInput;
    private int strike, ball;

    public Service() {
        map = new HashMap<>();
    }

    public void initGame() {
        comInput = getComNumInput();
    }

    public String getComNumInput() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String convertedNum = String.valueOf(randomNumber);
            if (!computer.contains(convertedNum)) {
                computer.add(convertedNum);
            }
        }
        return String.join("", computer);
    }

    public Score calculateScore(String userInput) {
        map.clear();
        strike = 0; ball = 0;
        setComputerData();
        checkMapContainsString(userInput.toCharArray());
        return new Score(strike, ball);
    }

    public void setComputerData() {
        String[] strArr = comInput.split("");
        String str;

        for (int i = 0; i < strArr.length; i++) {
            str = strArr[i];
            map.put(str, i);
        }
    }

    public void checkMapContainsString(char[] array) {
        for (int userIdx = 0; userIdx < array.length; userIdx++) {
            String c = Character.toString(array[userIdx]);
            if (map.containsKey(c)) {
                int comIdx = map.get(c);
                compareIdxAndIncreaseScore(userIdx, comIdx);
            }
        }
    }

    public void compareIdxAndIncreaseScore(int comIdx, int userIdx) {
        if (userIdx == comIdx) {
            increaseScore("S");
            return;
        }
        increaseScore("B");
    }

    public void increaseScore(String type) {
        if (type.compareTo("S") == 0) {
            strike++;
            return;
        }
        ball++;
    }
}