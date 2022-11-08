package baseball;

import camp.nextstep.edu.missionutils.Console;
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
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        changeStringToSet(inputNumber);
    }

    public void userInput(String userInput) {
        System.out.println("숫자를 입력해주세요 : ");
        changeStringToSet(userInput);
    }

    public void changeStringToSet(String userInput) {
        int number = 0;
        if (isValidInput(userInput)) {
            number = Integer.parseInt(userInput);
        }
        while (number > 0) {
            int n = number % 10;
            userInputNumber.add(n);
            number /= 10;
        }
        Collections.reverse(userInputNumber);
    }

    public boolean isValidInput(String userInput) {
        if (!(isValidLength(userInput) && isValidString(userInput) && isNotDuplicate(userInput))) {
            throw new IllegalArgumentException();
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
        for (int location = 0; location < userInput.length(); location++) {
            if (userInput.charAt(location) > 57 || userInput.charAt(location) < 49) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotDuplicate(String userInput) {
        Set<String> userInputSet = new HashSet<>();
        for (int location = 0; location < userInput.length(); location++) {
            String str = String.valueOf(userInput.charAt(location));
            userInputSet.add(str);
        }
        if (userInputSet.size() != 3) {
            return false;
        }
        return true;
    }
}