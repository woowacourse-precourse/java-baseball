package baseball.Service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameInProgress() {
        List<Integer> computer = pickThreeNumbers();
        System.out.println(computer.toString());

        List<Integer> user = guessThreeNumbers();

        while (!resultOfGuess(computer, user)) {
            user = guessThreeNumbers();
        }

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
