package baseball.playing;

import baseball.players.Computer;
import baseball.players.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class PlayGame {

    private String computerNumber;
    private String userNumber;

    public PlayGame() {
        startGame();
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computerNumber = computer.getComputerNumbers();
        playingGame();
    }

    public void playingGame() {

        Map<String, Integer> strikeBall = new HashMap<>();

        inputUserNumbers();

        while (true) {
            String result = printStrikeOrBall(computerNumber, userNumber);
            System.out.println(result);

            strikeBall = checkStrikeOrBall(computerNumber, userNumber);
            if(strikeBall.get("Strike") == 3)
                break;
        }

        endGame();
    }

    private void endGame() {

        String replaying = Console.readLine();

    }

    private List<Integer> stringToList(String number) {
        List<Integer> numbers = new ArrayList<>();
        for (char num : number.toCharArray()) {
            numbers.add(Character.getNumericValue(num));
        }

        return numbers;
    }

    private String printStrikeOrBall(String computerNumber, String userNumber) {

        Map<String, Integer> strikeBall = checkStrikeOrBall(computerNumber, userNumber);

        if (strikeBall.get("Strike") == 0) {
            return strikeBall.get("Ball") + "볼";
        } else if (strikeBall.get("Ball") == 0) {
            return strikeBall.get("Strike") + "스트라이크";
        }

        return strikeBall.get("Ball") + "볼 " + strikeBall.get("Strike") + "스트라이크";
    }

    private Map<String, Integer> checkStrikeOrBall(String computerNumber, String userNumber) {

        List<Integer> computerNumberList = stringToList(computerNumber);
        List<Integer> userNumberList = stringToList(userNumber);

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

    private void inputUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        User user = new User(inputNumber);

        userNumber = user.getUserNumbers();
    }
}
