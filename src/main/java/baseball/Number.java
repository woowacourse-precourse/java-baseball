package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Number {

    List<Integer> userInputNumber;

    public Number() {
        userInputNumber = new ArrayList<>();
    }

    public List<Integer> createRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public void userInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = System.console().readLine();
        changeStringToSet(inputNumber);
    }

    public void userInput(String userInput) {
        System.out.println("숫자를 입력해주세요 : ");
        changeStringToSet(userInput);
    }

    public void changeStringToSet(String userInput) {
        int number = Integer.parseInt(userInput);
        while (number > 0) {
            int n = number % 10;
            userInputNumber.add(n);
            number /= 10;
        }
        Collections.reverse(userInputNumber);
    }
}
