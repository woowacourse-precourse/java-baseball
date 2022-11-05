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
        if (!isValidInput(userInput)) {
            throw new IllegalArgumentException();
        }
        Collections.reverse(userInputNumber);
    }

    public boolean isValidInput(String userInput) {
        if (!isValidLength(userInput) || !isValidString(userInput) || !isNotDuplicate()) {
            return false;
        }
        return true;
    }
    public boolean isValidLength(String userInput) {
        if (userInput.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean isValidString(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) > 57 || userInput.charAt(i) < 49) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotDuplicate() {
        Set<Integer> userInputSet = new HashSet<>(userInputNumber);
        if (userInputSet.size() != 3) {
            return false;
        }
        return true;
    }
}
