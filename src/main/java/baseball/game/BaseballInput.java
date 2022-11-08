package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballInput {

    public List<Integer> inputNumList;

    public void userInputGame() {
        String userInput = receiveInput();
        makeInputNumList(userInput);
        makeErrorCheckingInputSize();
    }

    public String receiveInput() {
        String inputNum;
        inputNum = Console.readLine();
        return inputNum;
    }

    private void makeInputNumList(String inputNum) {
        String[] inputStringArray = inputNum.split("");
        List<String> inputStringList = new ArrayList<>(Arrays.asList(inputStringArray));
        inputNumList = inputStringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }

    private void makeErrorCheckingInputSize() {
        try {
            if (inputNumList.size() > 3)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("세 자리 이상의 수를 입력하였습니다");
            System.exit(0);
        }
    }
}
