package baseball;

import baseball.validation.InputNumber;
import baseball.validation.Restart;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private SystemMessage systemMessage = new SystemMessage();
    private InputNumber inputNumber = new InputNumber();
    private Restart restart = new Restart();
    private List<Integer> resultNumberList;

    void start() {
        int restartController = 1;
        System.out.println(systemMessage.START_GAME_MESSAGE);
        while (restartController == 1) {
            resultNumberList = setResultNumberList();
            while (true) {
                List<Integer> number = inputNumber();
                if (strikeBallCheck(number) == 3) {
                    System.out.println(systemMessage.END_GAME_MESSAGE);
                    break;
                }
            }
            restartController = SetRestartController();
        }
    }

    private List<Integer> setResultNumberList() {
        List<Integer> resultNumbers = new ArrayList<>();
        while (resultNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!resultNumbers.contains(randomNumber)) {
                resultNumbers.add(randomNumber);
            }
        }
        return resultNumbers;
    }

    private List<Integer> inputNumber() {
        System.out.print(systemMessage.INSERT_NUMBER_MESSAGE);
        List<Integer> numberList = new ArrayList<>();
        String numberString = Console.readLine();

        if (inputNumber.inputNumberValidate(numberString)) {
            numberList = Arrays.stream(numberString.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        return numberList;
    }

    private int strikeBallCheck(List<Integer> userNumberList) {
        int strikeCount = 0, ballCount = 0;
        for (int index = 0; index < userNumberList.size(); index++) {
            int resultNumber = resultNumberList.get(index);
            int userNumber = userNumberList.get(index);

            if (resultNumber == userNumber) {
                strikeCount += 1;
            } else if (resultNumberList.contains(userNumber)) {
                ballCount += 1;
            }
        }
        printStrikeBallResult(strikeCount, ballCount);
        return strikeCount;
    }

    private void printStrikeBallResult(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + systemMessage.BALL + " " + strikeCount + systemMessage.STRIKE);
        } else if (ballCount > 0) {
            System.out.println(ballCount + systemMessage.BALL);
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + systemMessage.STRIKE);
        } else {
            System.out.println(systemMessage.NOTHING);
        }
    }

    private int SetRestartController() {
        System.out.println(systemMessage.RESTART_GAME_MESSAGE);
        String inputRestartValue = Console.readLine();
        if (restart.validate(inputRestartValue)) {
            return Integer.parseInt(inputRestartValue);
        }
        throw new IllegalArgumentException();
    }
}
