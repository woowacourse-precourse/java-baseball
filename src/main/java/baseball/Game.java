package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final List<Integer> answer = new ArrayList<>();

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public void setAnswer() {
        this.answer.clear();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    // 입력 받은 숫자에 대해 정답과 비교해서 첫번째 인덱스에 볼 개수, 두번째 인덱스에 스트라이크 개수를 담은 리스트를 반환
    public List<Integer> getBallAndStrikeList(List<Integer> answer, List<Integer> number) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(number.get(i))) {
                strike++;
            } else if (answer.contains(number.get(i))) {
                ball++;
            }
        }
        return new ArrayList<>(Arrays.asList(ball, strike));
    }

    public void start() {
        this.setAnswer();
        while (true) {
            Print.inputNumber();
            List<Integer> number = Input.number();
            List<Integer> ballAndStrikeList = this.getBallAndStrikeList(this.answer, number);
            int ball = ballAndStrikeList.get(0);
            int strike = ballAndStrikeList.get(1);
            Print.ballAndStrike(ball, strike);
            if (ball == 0 && strike == 3) {
                this.newGameOrExit();
                break;
            }
        }
    }

    public void newGameOrExit() {
        Print.inputOneOrTwo();
        int oneOrTwo = Input.oneOrTwo();
        if (oneOrTwo == 1) {
            this.start();
        }
    }
}
