package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Integer[] generateAnswer() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int generated = Randoms.pickNumberInRange(1, 9);
            if (answerList.contains(generated)) {
                continue;
            }
            answerList.add(generated);
        }
        return answerList.toArray(Integer[]::new);
    }


    public static Integer[] userInputToIntegerArray(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 이닙니다.");
        }

        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) > '9' || userInput.charAt(i) < '1') {
                throw new IllegalArgumentException("입력값이 1~9 사이의 숫자가 아닙니다.");
            }
        }

        Integer[] result = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            result[i] = userInput.charAt(i) - '0';
        }
        return result;
    }

    public static int countStrike(Integer[] realAnswer, Integer[] userAnswer){
        int cnt = 0;
        for(int i= 0; i<3; i++){
            if(realAnswer[i].equals(userAnswer[i]))
                cnt++;
        }
        return cnt;
    }
}
