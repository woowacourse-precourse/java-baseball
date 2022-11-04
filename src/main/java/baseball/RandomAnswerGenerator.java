package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomAnswerGenerator {
    public static int getRandomAnswer() {
        int answer = 0;
        Set<Integer> usedNumeric = new HashSet<>();

        // generate random answer
        for(int i = 0; i < 3; i++) {
            int numeric = getRandomNumeric(usedNumeric);
            answer = 10*answer + numeric;
        }

        return answer;
    }

    private static int getRandomNumeric(Set<Integer> usedNumeric) {
        return 0;
    }
}
