package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class GameHandler {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INSERT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    public static List<Integer> computerNumber;
    public static List<Integer> inputNumber;
    public static List<Integer> compareResult;

    public void init() {
        computerNumber = new ArrayList<>(3);
        inputNumber = new ArrayList<>(3);
        compareResult = new ArrayList<>(2);
    }

    public void inputHandler() {
        String input = Console.readLine();
        // validation check
        for(char c : input.toCharArray()) {
            inputNumber.add(c - '0');
        }
    }

    public void compareNumber() {
        int strike = 0, ball = 0, number;
        for(int i = 0; i < 3; i++) {
            number = inputNumber.get(i);
            if(number == computerNumber.get(i)) {
                strike++;
            } else if (computerNumber.contains(number)) {
                ball++;
            }
        }
        compareResult.add(strike);
        compareResult.add(ball);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        int strike = compareResult.get(0), ball = compareResult.get(1);
        if(strike == 0 && ball == 0) {
            sb.append(NOTHING);
        } else if(strike > 0 && ball > 0) {
            sb.append(String.format("%d%s %d%s", ball, BALL, strike, STRIKE));
        } else if(ball > 0) {
            sb.append(String.format("%d%s", ball, BALL));
        } else if(strike > 0) {
            sb.append(String.format("%d%s", strike, STRIKE));
        }
        if(strike == 3) {
            sb.append(String.format("\n%s\n%s\n", GAME_END, GAME_RESTART));
        }
        return sb.toString();
    }
}
