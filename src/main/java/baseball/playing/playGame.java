package baseball.playing;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class playGame {

    private String computerNumber;
    private String userNumber;

    public playGame() {
        startGame();
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumbers();
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private List<Integer> stringToList(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (char num : number.toCharArray()) {
            numbers.add(Character.getNumericValue(num));
        }

        return numbers;
    }

    private String printStrikeOrBall(String computerNumber, String userNumber) {

        String printResult = "";
        List<Integer> computerNumberList = stringToList(computerNumber);
        List<Integer> userNumberList = stringToList(userNumber);

        return printResult;
    }

    private Map<String, Integer> checkStrikeOrBall(List<Integer> computerNumberList, List<Integer> userNumberList) {

        Map<String, Integer> strikeBall = new HashMap<>();

        strikeBall.put("Strike", Strike(computerNumberList, userNumberList));
        strikeBall.put("Ball", Ball(computerNumberList, userNumberList));

        return strikeBall;
    }

    private int Strike(List<Integer> computerNumberList, List<Integer> userNumberList) {

        int numberSize = 3;
        int strike = 0;

        for (int i = 0; i < numberSize; i++) {
            if (computerNumberList.get(i) == userNumberList.get(i))
                strike++;
        }

        return strike;
    }

    private int Ball(List<Integer> computerNumberList, List<Integer> userNumberList) {

        int numberSize = 3;
        int ball = 0;

        for (int i = 0; i < numberSize; i++) {
            if (!(computerNumberList.get(i) == userNumberList.get(i))
                    && computerNumberList.contains(userNumberList.get(i)))
                ball++;
        }

        return ball;
    }

    private String inputUserNumbers() {

        String inputNumber = Console.readLine();
        User user = new User(inputNumber);

        userNumber = user.getUserNumbers();

        return userNumber;
    }
}
