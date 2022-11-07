package baseball;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class BaseBall {

    private int strike;
    private int ball;
    private int nothing;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public void playBaseBall() {
        while (true) {
            playGame();
            boolean isStrike3 = isStrike3();
            if (isStrike3) {
                restart();
            }
        }
    }

    private void playGame() {
        String random = makeRandom();
        String input = makeMyInput();
        List<String> randomList = getList(random);
        List<String> inputList = getList(input);
        checkSameOfRandomAndMy(randomList, inputList);
    }

    private String makeRandom() {
        return String.valueOf(pickNumberInRange(111, 999));
    }

    private String makeMyInput() {
        String input = readLine();
        List<String> inputList = getList(input);
        Set<String> inputSet = new HashSet<>(inputList);
        if (inputSet.size() != inputList.size()) {
            throw new IllegalArgumentException("입력값이 서로 다른 3자리의 수가 아닙니다.");
        }
        return input;
    }

    private List<String> getList(String s) {
        return Arrays.asList(s.split(""));
    }

    private void checkSameOfRandomAndMy(List<String> randomList, List<String> inputList) {
        Boolean isSameNumber = false;
        for (int i = 0; i < randomList.size(); i++) {
            isSameNumber = inputList.contains(randomList.get(i));
        }
        if (isSameNumber == false) {
            nothing++;
        }
        checkSameNumberOfDigits(randomList, inputList);
    }

    private void checkSameNumberOfDigits(List<String> randomList, List<String> inputList) {
        for (int i = 0; i < randomList.size(); i++) {
            if (!randomList.get(i).equals(inputList.get(i))) {
                ball++;
            }
            strike++;
        }
    }

}
