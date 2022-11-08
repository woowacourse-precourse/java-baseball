package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {

    public List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>(3);
    }

    public void setRandomNumbers() {
        numbers.clear();

        while (numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public boolean checkThreeStrike(List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int userNumber = userNumbers.get(i);

            if (userNumber == numbers.get(i)) {
                strike++;
            } else if (numbers.contains(userNumber)) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;

        } else if (strike + ball == 0) {
            System.out.println("낫싱");

        } else {
            if (ball == 0) {
                System.out.printf("%d스트라이크%n", strike);
            } else if (strike == 0) {
                System.out.printf("%d볼%n", ball);
            } else {
                System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            }
        }
        return false;
    }

    public boolean restart(String input) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (input.equals("2")) {
            return false;
        } else if (!input.equals("1")) {
            throw new IllegalArgumentException("잘못 입력되었습니다.");
        } else {
            return true;
        }
    }
}
