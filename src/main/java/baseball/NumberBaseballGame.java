package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String RESULT_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Answer answer = new Answer();
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> inputNumber = new ArrayList<>();

    public void startGame() {
        System.out.println(START_TEXT);
        computerNumber = answer.generateAnswer();

        while (true) {
            System.out.println(INPUT_TEXT);
            String userInput = Console.readLine();
            UserInputException.checkUserInput(userInput);
            inputNumber = changeStringToList(userInput);

        }
    }

    public List<Integer> changeStringToList(String userInput) {
        List<Integer> changedList = new ArrayList<>();

        for (char digit : userInput.toCharArray()) {
            changedList.add(Character.getNumericValue(digit));
        }
        return changedList;
    }
}
