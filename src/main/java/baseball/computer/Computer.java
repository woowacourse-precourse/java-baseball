package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answers;

    private List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private void processBaseBall(Integer n) {
        int strike = 0;
        int ball = 0;

        int hundred = n / 100;
        if (hundred == answers.get(0))
            strike += 1;
        else if (hundred == answers.get(1) || hundred == answers.get(2))
            ball += 1;

        int tens = (n / 10) % 10;
        if (tens == answers.get(1))
            strike += 1;
        else if (tens == answers.get(0) || tens == answers.get(2))
            ball += 1;

        int ones = n % 10;
        if (ones == answers.get(2) || ones == answers.get(1))
            ball += 1;


    }

    public void start() {
        this.answers = generateRandomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
