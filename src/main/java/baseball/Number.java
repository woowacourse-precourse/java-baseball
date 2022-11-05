package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Number {
    public void setRandomNumbers() {
        Set<Integer> NumberSet = new HashSet<>();
        while (NumberSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!NumberSet.contains(randomNumber)) {
                NumberSet.add(randomNumber);
            }

        }
    }

    public String getInputNumber() {
        String input = readLine();
        if(!isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public int countStrike(List<Character> answer, List<Character> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) == input.get(idx)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Character> answer, List<Character> input) {
        int count = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) != input.get(idx) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

    public String makeHint (List<Character> answer, List<Character> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);
        if(strike != 0) {
            if(ball != 0) {
                return ball + "볼" + strike + "스트라이크 ";
            }
            return strike + "스트라이크";
        }
        if(ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }

    private List<Character> stringToList(String str) {
        return str.chars().mapToObj(number -> (char) number).collect(Collectors.toList());
    }

    private boolean isValidString(String input) {
        if(isNotDuplicate(input) || isNumber(input) || isThreeDigits(input)) {
            return true;
        }
        return false;
    }

    private boolean isThreeDigits(String input) {
        if(input.length() > 3) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }

    private boolean isNotDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for(char num : str.toCharArray()) {
            set.add(num);
        }
        return set.size() == str.length();
    }
}
