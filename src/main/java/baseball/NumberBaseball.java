package baseball;

import baseball.dto.Computer;
import baseball.dto.GameScore;
import baseball.dto.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    static User user;
    static Computer computer;
    static ValidInput validInput;
    static GameScore gameScore;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다");
        computer = new Computer(new GenerateRandomNumber().generateRandomNumber());

        do {
            System.out.print("숫자를 입력해주세요 : ");

            user = new User(inputNumber());
            gameScore = new CompareNumber().compareNumber(user, computer);
            new PrintResult().printResult(gameScore);
        } while (gameScore.getStrike() != 3);
    }

    private List<Integer> inputNumber() throws IllegalArgumentException {
        String userInput = Console.readLine();
        validInput = new ValidInput();

        validInput.inspectInputLength(userInput);
        validInput.inspectAlphabetOrSpecialCharacter(userInput);
        validInput.inspectDuplicatedNumber(userInput);

        String[] strArr = userInput.split("");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));

        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
