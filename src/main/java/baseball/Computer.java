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

    protected String NOTHING = "낫싱";
    protected String BALL = "%d볼";
    protected String STRIKE = "%d스트라이크";
    protected String GAMEOVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public String getResult(String input) {
        if (isNothing(input)) {
            return NOTHING;
        }
        String result = "";
        if (getBallCount(input) > 0) {
            result += String.format(BALL, getBallCount(input));
        }
        if (getStrikeCount(input) > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += String.format(STRIKE, getStrikeCount(input));
        }
        if (isGameOver(input)) {
            result += ('\n' + GAMEOVER);
        }
        return result;
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

    public int getBallCount(String input) {
        int ballCount = 0;
        for (int index = 0; index < input.length(); index++) {
            int number = input.charAt(index) - '0';
            if (isBall(number, index)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public boolean isGameOver(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (answer.get(i) != (input.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }
}
