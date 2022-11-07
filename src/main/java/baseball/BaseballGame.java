package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void playGame() {
        int going = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (going == 1) {
            List<Integer> numbers = makeRandomNumbers();
            progressGame(numbers);
        }
    }

    private List<Integer> makeRandomNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private void progressGame(List<Integer> numbers) {
        boolean isRight = false;

        while (!isRight) {
            System.out.println("숫자를 입력해주세요 : ");
            int inputNumber = getNumber();
            isRight = checkNumber(numbers, inputNumber);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int getNumber() {
        String inputString =  Console.readLine();
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해주세요.");
        }

        if (inputString.charAt(0) == inputString.charAt(1)
                || inputString.charAt(0) == inputString.charAt(2)
                || inputString.charAt(1) == inputString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 숫자 3자리를 입력해주세요.");
        }

        return inputNumber;
    }

    private boolean checkNumber(List<Integer> numbers, int inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentNumber = inputNumber / (int) Math.pow(10, 2-i);
            if (!numbers.contains(currentNumber)) {
                continue;
            }
            if (numbers.indexOf(currentNumber) == i) {
                strike += 1;
            } else {
                ball += 1;
            }
        }

        printResult(strike, ball);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

}
