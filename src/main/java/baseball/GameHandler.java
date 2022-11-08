package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class GameHandler {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INSERT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public boolean isGameEnd;

    public static List<Integer> computerNumber;
    public static List<Integer> inputNumber;
    public static List<Integer> compareResult;

    private void selectNumber() {
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private void validationCheck(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }

        if(input.charAt(0) == input.charAt(1)) {
            throw new IllegalArgumentException();
        }

        if(input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }

        if(input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }

        for(char c : input.toCharArray()) {
            if(c < '1' || c > '9') {
                throw new IllegalArgumentException();
            }
        }
    }

    public void init() {
        System.out.println(GAME_START);
    }

    public void start() {
        isGameEnd = false;
        computerNumber = new ArrayList<>();
        selectNumber();
    }

    public void inputHandler() {
        System.out.println(INSERT_NUMBER);
        String input = Console.readLine();
        validationCheck(input);
        inputNumber = new ArrayList<>();
        compareResult = new ArrayList<>();
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

    public void getResult() {
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
            sb.append(String.format("\n%s\n%s", GAME_END, GAME_RESTART));
            isGameEnd = true;
        }
        System.out.println(sb);
    }

    public boolean askEnd() {
        String input = Console.readLine();
        return input.compareTo("2") == 0;
    }
}
