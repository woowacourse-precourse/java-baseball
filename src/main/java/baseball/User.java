package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumbers;

    public User() {
        userNumbers = new ArrayList<>();
    }

    public void inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        checkInputException(userInput);
        convertInput(userInput);
    }

    public void checkInputException(String userInput) {
        Exceptions.checkInputIsNumber(userInput);
        Exceptions.checkInputIsTooLong(userInput);
        Exceptions.checkInputIsTooShort(userInput);
    }

    public void convertInput(String userInput) {
        String[] userInputForConvert = userInput.split("");
        for (String s : userInputForConvert)
            userNumbers.add(Integer.parseInt(s));
        System.out.println(userNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public String getUserOpinion() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userOpinion = Console.readLine();
        checkOpinionException(userOpinion);
        return userOpinion;
    }

    public void checkOpinionException(String userOpinion) {
        Exceptions.checkOpinionMessage(userOpinion);
    }
}
