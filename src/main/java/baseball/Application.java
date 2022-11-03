package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumbersBaseballGame numbersBaseballGame = new NumbersBaseballGame();
        numbersBaseballGame.play();
    }

    static class NumbersBaseballGame {
        private static final int START_NUMBER = 1;
        private static final int END_NUMBER = 9;
        private static final int PICK_COUNT = 3;
        public void play() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> targetNumbers = getTargetNumbers();
        }

        private List<Integer> getTargetNumbers() {
            return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT);
        }
    }
}
