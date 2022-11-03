package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public List<Integer> getRandomNumberList() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    public void checkValidString(String string) {
        if (!isStringLengthThree(string) || !isNumber(string)) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean isStringLengthThree(String string) {
        return string.length() == 3;
    }

    private Boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public List<Integer> getUserNumberList(String string) {
        List<Integer> user = new ArrayList<>();

        String[] split = string.split("");
        for (String s : split) {
            user.add(Integer.parseInt(s));
        }

        return user;
    }

    public String getAnswerString(List<Integer> computer, List<Integer> user) {
        int ballCount = getBallCount(computer, user);
        int strikeCount = getStrikeCount(computer, user);

        String string = "";
        if (ballCount == 0 && strikeCount == 0) {
            string = "낫싱";
        } else {
            if (ballCount != 0) {
                string += ballCount + "볼 ";
            }
            if (strikeCount != 0) {
                string += strikeCount + "스트라이크";
            }
        }

        return string.trim();
    }

    private int getBallCount(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (isBall(computer, user, i)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isBall(List<Integer> computer, List<Integer> user, int index) {
        return computer.contains(user.get(index)) && !computer.get(index).equals(user.get(index));
    }

    private int getStrikeCount(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (isStrike(computer, user, i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private boolean isStrike(List<Integer> computer, List<Integer> user, int index) {
        return computer.contains(user.get(index)) && computer.get(index).equals(user.get(index));
    }
}
