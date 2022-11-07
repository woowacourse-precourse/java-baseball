package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private List<Integer> computerNumber = new ArrayList<>();

    public void start() {}

    public void setComputerNumber() {
        List<Integer> newComputerNumber = new ArrayList<>();
        while (newComputerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newComputerNumber.contains(randomNumber)) {
                newComputerNumber.add(randomNumber);
            }
        }
        computerNumber = newComputerNumber;
    }

    public List<Integer> getComputerNumber() {
        if (computerNumber.isEmpty()) {
            setComputerNumber();
        }
        return computerNumber;
    }

    public void printUserInputPrompt() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public List<Integer> parseUserInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userInputList.add(Integer.parseInt(userInput.substring(i, i + 1)));
        }
        return userInputList;
    }

    public void isUserNumberValid(List<Integer> userInput) {
        if (userInput.size() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) < 1 || userInput.get(i) > 9) {
                throw new IllegalArgumentException();
            }
        }
        if (userInput.get(0) == userInput.get(1) || userInput.get(0) == userInput.get(2)
                || userInput.get(1) == userInput.get(2)) {
            throw new IllegalArgumentException();
        }
    }

    public void printGameStatus(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
    }
}
