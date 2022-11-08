package baseball.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int gameInProgress() {
        List<Integer> computer = pickThreeNumbers();
        System.out.println(computer.toString());

        List<Integer> user = guessThreeNumbers();

        while (!resultOfGuess(computer, user)) {
            user = guessThreeNumbers();
        }

        // 1or 2 입력 받기
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choiceInput = Integer.parseInt(Console.readLine());

        // 잘못된 값 입력하면 예외 던지기

        return choiceInput;

    }

    public List<Integer> pickThreeNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public List<Integer> guessThreeNumbers() {
        List<Integer> user = new ArrayList<>();

        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }

        char[] inputs = input.toCharArray();

        for (char inputChar : inputs) {
            user.add(inputChar - '0');
        }

        return user;
    }

    public boolean resultOfGuess(List<Integer> computer, List<Integer> user) {

        // 숫자 + 자리수가 모두 맞는 경우
        if (areCorrectAllNumbers(computer, user)) {
            return true;
        }

        // 스트라이크와 볼 계산
        checkBallAndStrike(computer, user);
        return false;
    }

    public boolean areCorrectAllNumbers(List<Integer> computer, List<Integer> user) {
        boolean areCorrectAllNumbers = true;

        for (int i = 0; i < 3; i++) {
            if (user.get(i) != computer.get(i)) {
                areCorrectAllNumbers = false;
            }
        }

        if (areCorrectAllNumbers) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return true;
        }

        return false;
    }

    private void checkBallAndStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;

        // 스트라이크 계산
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            }
        }

        // 볼 계산
        if (user.get(0) == computer.get(1) || user.get(0) == computer.get(2)) {
            ball++;
        }
        if (user.get(1) == computer.get(0) || user.get(1) == computer.get(2)) {
            ball++;
        }
        if (user.get(2) == computer.get(0) || user.get(2) == computer.get(1)) {
            ball++;
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }


    public boolean validateInput(String input) {
        if (areThreeLength(input) && areNumbersFromOneToNine(input) && areNumbersDuplicated(input)) {
            return true;
        }

        return false;
    }

    public boolean areThreeLength(String input) {
        if (input.length() == 3) {
            return true;
        }

        return false;
    }

    public boolean areNumbersFromOneToNine(String input) {
        char[] inputs = input.toCharArray();

        for (char inputChar : inputs) {
            int number = inputChar - '0';

            if (number < 1 || number > 9) {
                return false;
            }
        }

        return true;
    }

    public boolean areNumbersDuplicated(String input) {
        char[] inputs = input.toCharArray();

        if (inputs[0] == inputs[1] || inputs[0] == inputs[2] || inputs[1] == inputs[2]) {
            return false;
        }

        return true;
    }
}
