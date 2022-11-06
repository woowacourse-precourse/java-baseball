package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NumberBaseball {
    User user;
    Computer computer;
    ValidInput validInput;
    GameScore gameScore;

    public NumberBaseball() {
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다");
        System.out.print("숫자를 입력해주세요 : ");
        try {
            user = new User(inputNumber());
            computer = new Computer();
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
        computer.generateRandomNumber();

        compareNumber();

        gameScore.printResult();
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

    private void compareNumber() {
        List<List<Integer>> compareResult = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (makeCompareList(i, j).size() > 0) {
                    compareResult.add(makeCompareList(i, j));
                };
            }
        }

        for (List<Integer> result: compareResult) {
            if (Objects.equals(result.get(0), result.get(1))) {
                strike += 1;
            }

            if (!(Objects.equals(result.get(0), result.get(1)))) {
                ball += 1;
            }
        }

        gameScore = new GameScore(strike, ball);
    }

    private List<Integer> makeCompareList(int i, int j) {
        List<Integer> result = new ArrayList<>();

        if (Objects.equals(user.usersNumber.get(i), computer.computerNumber.get(j))) {
            result.add(i);
            result.add(j);
        }

        return result;
    }
}
