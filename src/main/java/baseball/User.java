package baseball;

import camp.nextstep.edu.missionutils.Console;

import details.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> userNumbers;

    public User() {
        userNumbers = new ArrayList<>();
    }

    public void inputNumbers() {
        System.out.println(Message.INPUT_MESSAGE);
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
        String[] userInputForConvert = userInput.split(Detail.NULL);
        for (String s : userInputForConvert)
            userNumbers.add(Integer.parseInt(s));
        System.out.println(userNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public String getUserOpinion() {
        System.out.println(Message.LAST_MESSAGE);

        String userOpinion = Console.readLine();
        checkOpinionException(userOpinion);
        return userOpinion;
    }

    public void checkOpinionException(String userOpinion) {
        Exceptions.checkOpinionMessage(userOpinion);
    }
}
