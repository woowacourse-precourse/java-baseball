package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> target;

    public void startGame() {
        target = new ArrayList<>();
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }
        System.out.println(target); //난수 확인용
    }

    public boolean getResult(int number) {
        List<Integer> numbers = getListFromInt(number);
        int strike = countStrike(numbers);
        int ball = countBall(numbers);

        print(strike, ball);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    private List<Integer> getListFromInt(int number) {
        List<Integer> list = new ArrayList<>();
        int divide = 100;
        while (divide > 0) {
            list.add(number/divide);
            number = number%divide;
            divide = divide/10;
        }
        return list;
    }

    private int countStrike(List<Integer> numbers) {
        int strike = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == target.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(List<Integer> numbers) {
        int ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) != target.get(i)
                    && target.contains(numbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private void print(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 0 && ball > 0) {
            System.out.printf("%d볼\n", ball);
        } else {
            System.out.println("낫싱");
        }
    }

}
