package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private final String USER_Input_Message = "숫자를 입력해주세요 :";
    private final String InputRestartOrStop_Message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final int NUMBER_LENGTH = 3;
    private int[] expectedAnswer;
    private final UserInputValidation userInputValidation = new UserInputValidation();

    public UserInput() {
        expectedAnswer = new int[NUMBER_LENGTH];
    }

    public int[] getUserInput() {
        return expectedAnswer;
    }

    public String inputNumber() {
        System.out.println(USER_Input_Message);
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
        System.out.println(InputRestartOrStop_Message);
        String restartInput = Console.readLine();
        userInputValidation.restartInputValidation(restartInput);
        return restartInput;
    }
}
