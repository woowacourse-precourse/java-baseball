package baseball;

import baseball.config.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomAnswerGenerator {
    public static int getRandomAnswer() {
        int answer = 0;
        Set<Integer> usedNumeric = new HashSet<>();

        for(int i = 0; i < GameConfig.ANSWER_LEN; i++) {
            int numeric = getRandomNumeric(usedNumeric);
            usedNumeric.add(numeric);
            answer = 10*answer + numeric;
        }

        return answer;
    }

    private static int getRandomNumeric(Set<Integer> usedNumeric) {
        if(usedNumeric.size() >= 9) {
            return -1;
        }

        while(true) {
            int numeric = Randoms.pickNumberInRange(1, 9);
            if(!usedNumeric.contains(numeric)) {
                return numeric;
            }
        }
    }
}
