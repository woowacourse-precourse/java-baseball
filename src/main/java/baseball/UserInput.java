package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Const.*;

public class UserInput {

    private UserInputValidation userInputValidation;

    public UserInput() {
        userInputValidation = new UserInputValidation();
    }

    public String inputNumber() {
        System.out.println(INPUT_MESSAGE);

        String names = Console.readLine();
        userInputValidation.userInputValidation(names);
        return names;
    }

    public List<Integer> setNumberOfUser() {
        List<Integer> expectedAnswer = new ArrayList<>();

        String userInput =inputNumber();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            expectedAnswer.add(userInput.charAt(i)-'0');
        }
        return expectedAnswer;
    }

    public String inputRestartOrStop() {
        System.out.println(RESTART_MESSAGE);

        String restartInput = Console.readLine();
        userInputValidation.restartInputValidation(restartInput);
        return restartInput;
    }
}
