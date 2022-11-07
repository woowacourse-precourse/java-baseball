package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private final String answer;

    public Computer() {
        this.answer = createAnswer();
    }

    public int countBall(String inputNum) {
        int count = 0;

        for (int i = 0; i < 3; i++) {

            if (answer.contains(String.valueOf(inputNum.charAt(i)))) {
                count++;
            }

            if (answer.charAt(i) == inputNum.charAt(i)) {
                count--;
            }
        }

        return count;
    }

    public int countStrike(String inputNum) {
        int count = 0;

        for (int i = 0; i < 3; i++) {

            if (answer.charAt(i) == inputNum.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private String createAnswer() {
        Set<Integer> set = createAnswerSet();
        StringBuilder answer = new StringBuilder();

        for (Integer integer : set) {
            answer.append(integer);
        }

        return answer.toString();
    }

    private Set<Integer> createAnswerSet() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            set.add(n);
        }

        return set;
    }

    public String getAnswer() {
        return answer;
    }
}
