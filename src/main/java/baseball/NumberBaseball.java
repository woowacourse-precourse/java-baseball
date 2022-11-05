package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    private User user;
    private Computer computer;

    private List<Integer> userInputList;
    private ValidInput validInput;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다");
        System.out.print("숫자를 입력해주세요 : ");
        try {
            this.userInputList = inputNumber();
            user = new User(userInputList);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        computer.generateRandomNumber();


    }

    private List<Integer> inputNumber() throws IllegalArgumentException {
        String userInput = Console.readLine();
        validInput = new ValidInput(userInput);

        validInput.inspectInputLength();
        validInput.inspectAlphabetOrSpecialCharacter();
        validInput.inspectDuplicatedNumber();

        String[] strArr = userInput.split("");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));

        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
