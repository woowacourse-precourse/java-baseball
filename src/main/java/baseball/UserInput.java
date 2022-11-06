package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private final String USER_Input_Message = "숫자를 입력해주세요 :";
    private final int NUMBER_LENGTH = 3;
    private int[] expectedAnswer;

    public int[] getUserInput() {
        return expectedAnswer;
    }

    public String inputNumber() {
        System.out.println(USER_Input_Message);
        String names = Console.readLine();
        return names;
    }

    public void setNumberOfUser() {
        String userInput =inputNumber();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            expectedAnswer[i] = userInput.charAt(i)-'0';
        }
    }
}
