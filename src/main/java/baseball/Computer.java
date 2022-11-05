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
        // 스트라이크 개수
        int strike = countStrike(answer, userInput);

        // 볼 개수
        int ball = countBall(answer, userInput);

        if(strike == 3) {
            return STRIKE;
        }

        if(strike == 0 && ball == 0) {
            return "낫싱";
        }
        if(strike == 0) {
            return (ball + "볼");
        }
        if(ball == 0) {
            return (strike + "스트라이크");
        }
        return (ball + "볼 " + strike + "스트라이크");
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

    private int countBall(List<Integer> answer, List<Integer> userInput) {
        int ball = 0;

        if(validateConcord(answer.get(0), userInput.get(1))
                || validateConcord(answer.get(0), userInput.get(2))) {
            ball++;
        }
        if(validateConcord(answer.get(1), userInput.get(0))
                || validateConcord(answer.get(1), userInput.get(2))) {
            ball++;
        }
        if(validateConcord(answer.get(2), userInput.get(0))
                || validateConcord(answer.get(2), userInput.get(1))) {
            ball++;
        }

        return ball;
    }


}
