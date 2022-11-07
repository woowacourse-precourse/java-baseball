package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Const.*;

public class UserInput {

    private int[] expectedAnswer;
    private UserInputValidation userInputValidation = new UserInputValidation();

    public UserInput() {
        expectedAnswer = new int[NUMBER_LENGTH];
    }

    public int[] getUserInput() {
        return expectedAnswer;
    }

    public String inputNumber() {
        System.out.println(INPUT_MESSAGE);
        String names = Console.readLine();
        userInputValidation.userInputValidation(names);
        return names;
    }

    public void setNumberOfUser() {
        String userInput =inputNumber();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            expectedAnswer[i] = userInput.charAt(i)-'0';
        }
    }

    public String inputRestartOrStop() {
        System.out.println(RESTART_MESSAGE);
        String restartInput = Console.readLine();
        userInputValidation.restartInputValidation(restartInput);
        return restartInput;
    }
}
