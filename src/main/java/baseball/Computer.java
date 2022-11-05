package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int MAX = 3;
    public static final String STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public List<Integer> createRandomNumber() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < MAX) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public String judgeNumber(List<Integer> answer, List<Integer> userInput) {

    }

    private boolean validateConcord(int answer, int userInput) {
        return answer == userInput;
    }

    private int countStrike(List<Integer> answer, List<Integer> userInput) {
        int strike = 0;

        for(int index = 0; index < MAX; index++) {
            if(validateConcord(answer.get(index), userInput.get(index))) {
                strike++;
            }
        }

        return strike;
    }


}
