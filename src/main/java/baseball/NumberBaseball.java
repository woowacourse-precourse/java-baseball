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

    // 프로그램 실행 시 가장 먼저 호출되는 메소드
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다");

        // 랜덤한 수를 가진 Integer형 List를 생성하여 객체 computer 생성
        computer = new Computer(new GenerateRandomNumber().generateRandomNumber());

        // 게임은 스트라이크 수가 3이 될 때까지 계속 진행됨
        do {
            System.out.print("숫자를 입력해주세요 : ");

            // inputNumer 클래스를 호출하여 사용자의 입력을 받아 객체 user 생성
            user = new User(inputNumber());

            // 객체 user과 computer를 매개변수로 전달하며 compareNumber 메소드 호출
            gameScore = new CompareNumber().compareNumber(user, computer);

            // printResult 메소드를 호출하여 게임 결과 출력
            new PrintResult().printResult(gameScore);
        } while (gameScore.getStrike() != 3);
    }

    // 사용자의 입력을 받기 위해 호출되는 메소드
    private List<Integer> inputNumber() throws IllegalArgumentException {
        String userInput = Console.readLine();

        // 클래스 validInput에 존재하는 각종 검증 메소드 호출
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
