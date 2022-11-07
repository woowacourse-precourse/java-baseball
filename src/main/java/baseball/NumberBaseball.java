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

        new ValidInput().inspectInputLength(userInput);
        new ValidInput().inspectAlphabetOrSpecialCharacter(userInput);
        new ValidInput().inspectDuplicatedNumber(userInput);

        // 데이터가 무결하면 사용자의 입력을 분할하여 String형 List에 저장
        String[] strArr = userInput.split("");
        List<String> list = new ArrayList<>(Arrays.asList(strArr));

        // String형 List를 Integer형 List로 변환과 동시에 반환
        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
