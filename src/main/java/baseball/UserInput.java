package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static final String MESSAGE_INPUT = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_RESTART_CODE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RESTART_CODE = 1;

    private final UserInputValidator userInputValidator;


    public UserInput() {
        this.userInputValidator = new UserInputValidator();
    }

    public List<Integer> inputNumber(){
        System.out.print(MESSAGE_INPUT);
        String inputNumbers = Console.readLine();
        userInputValidator.validateNumber(inputNumbers);
        return stringToList(inputNumbers);
    }

    private List<Integer> stringToList(String numbers){
        List<Integer> numberList = new ArrayList<>();

        for (char number : numbers.toCharArray())
            numberList.add(number - '0');
        return numberList;
    }

    public boolean isContinue() {
        System.out.println(MESSAGE_RESTART_CODE);
        int code = Integer.parseInt(Console.readLine());

        userInputValidator.validateRestartCode(code);
        return code == RESTART_CODE;
    }

}
