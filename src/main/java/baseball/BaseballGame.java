package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private HashMap<String, Integer> answer = new HashMap<>();

    public BaseballGame(List<String> answer) {
        for (int idx = 0; idx < answer.size(); idx++) {
            this.answer.put(answer.get(idx), idx);
        }
    }
    
    BaseballGame() {
        List<String> convertedList = convertComputerList();
        for (int idx = 0; idx < convertedList.size(); idx++) {
            answer.put(convertedList.get(idx), idx);
        }
        System.out.println(convertedList);
    }

    private List<String> convertComputerList() {
        List<Integer> computerList = generateRandNum();
        List<String> convertedList = new ArrayList<>();
        for (Integer integer : computerList) {
            convertedList.add(String.valueOf(integer));
        }
        return convertedList;
    }

    private List<Integer> generateRandNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int countStrike(List<String> userInput) {
        int strikeCnt = 0;
        for (int idx = 0; idx < userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && isSamePosition(separatedInput, idx)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int countBall(List<String> userInput) {
        int BallCnt = 0;
        for (int idx = 0; idx < userInput.size(); idx++) {
            String separatedInput = userInput.get(idx);
            if (isSameNumber(separatedInput) && !isSamePosition(separatedInput, idx)) {
                BallCnt++;
            }
        }
        return BallCnt;
    }

    private boolean isSameNumber(String separatedInput) {
        boolean isSameNumber = false;
        if (answer.get(separatedInput) != null) {
            isSameNumber = true;
        }
        return isSameNumber;
    }

    private boolean isSamePosition(String separatedInput, int position) {
        boolean isSamePosition = false;
        if (answer.get(separatedInput) == position) {
            isSamePosition = true;
        }
        return isSamePosition;
    }

    public void showResults(List<String> userInput) {
        String results = "";
        results = getString(userInput, results);
        results = getResults(userInput, results);
        results = getString1(userInput, results);
        System.out.println(results);
    }

    private String getString1(List<String> userInput, String results) {
        if (countStrike(userInput) == 0 && countBall(userInput) == 0) {
            results += "낫싱";
        }
        return results;
    }

    private String getResults(List<String> userInput, String results) {
        if (countStrike(userInput) > 0) {
            results += countStrike(userInput) + "스트라이크";
        }
        return results;
    }

    private String getString(List<String> userInput, String results) {
        if (countBall(userInput) > 0) {
            results += countBall(userInput) + "볼 ";
        }
        return results;
    }

    private List<String> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        raiseErrorWhenInputLengthOver3(userInput);
        List<String> inputList = convertUserInputToList(userInput);

        return inputList;
    }

    private List<String> convertUserInputToList(String userInput) {
        List<String> convertedList = new ArrayList<>();
        for (int idx = 0; idx < userInput.length(); idx++) {
            char separatedInput = userInput.charAt(idx);
            raiseErrorWhenInputIsNotDigitOrZero(separatedInput);
            convertedList.add(String.valueOf(userInput.charAt(idx)));
        }
        return convertedList;
    }

    public String playGame() {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            List<String> userInput = getUserInput();
            showResults(userInput);
            if (countStrike(userInput) == 3) {
                isThreeStrike = true;
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return raiseErrorWhenInputIsNot1Or2();
    }

    private String raiseErrorWhenInputIsNot1Or2() throws IllegalArgumentException {
        String userInput = Console.readLine();

        try {
            if (!(userInput.equals("1") || userInput.equals("2"))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1과 2만 입력할 수 있습니다.");
            return raiseErrorWhenInputIsNot1Or2();
        }
        return userInput;
    }

    private void raiseErrorWhenInputIsNotDigitOrZero(char separatedInput) {
        if (!Character.isDigit(separatedInput)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (separatedInput == '0') {
            throw new IllegalArgumentException("1과 9사이의 숫자만 입력해주세요.");
        }
    }

    private void raiseErrorWhenInputLengthOver3(String userInput) {
        if (userInput.length() > 3) {
            throw new IllegalArgumentException("입력은 세자리 숫자만 허용됩니다.");
        }
    }
}
