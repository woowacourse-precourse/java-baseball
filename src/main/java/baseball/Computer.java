package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public boolean isNothing(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (answer.contains(input.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrike(int number, int index) {
        if (answer.get(index) == number) {
            return true;
        }
        return false;
    }

    public boolean isBall(int number, int index) {
        if (answer.contains(number) && answer.indexOf(number) != index) {
            return true;
        }
        return false;
    }

    public int getStrikeCount(String input) {
        int strikeCount = 0;
        for (int index = 0; index < input.length(); index++) {
            int number = input.charAt(index) - '0';
            if (isStrike(number, index)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }


}
