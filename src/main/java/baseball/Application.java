package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Exception.*;

public class Application {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_USER_BALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String THREE_STRIKE = "3스트라이크";
    private static final String SUCCESS_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";

    public static void main(String[] args) {
        List<Integer> computerBall = makeRandomBall();
        System.out.println(GAME_START_MESSAGE);

        while (true) {
            System.out.print(INPUT_USER_BALL_MESSAGE);
            List<Integer> userBall = getStringToIntList(Console.readLine());
            String result = compareBall(computerBall, userBall);

            if (!result.equals(THREE_STRIKE)) {
                System.out.println(result);
                continue;
            }

            System.out.println(result);
            System.out.println(SUCCESS_GAME_MESSAGE);
            System.out.println(RESTART_OR_EXIT_MESSAGE);
            String restart = Console.readLine();
            if (restart.equals(RESTART_GAME)) {
                computerBall = makeRandomBall();
            } else if (restart.equals(END_GAME)) {
                return;
            }
        }
    }

    public static List<Integer> makeRandomBall() {
        List<Integer> computerBall = new ArrayList<>();
        while (computerBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBall.contains(randomNumber)) {
                computerBall.add(randomNumber);
            }
        }

        return computerBall;
    }

    public static List<Integer> getStringToIntList(String user) {
        isNumber(user);
        List<Integer> userBall = new ArrayList<>();

        for (int i = 0; i < user.length(); i++) {
            userBall.add(user.charAt(i) - '0');
        }
        isOverThreeDigit(userBall);
        isSameNum(userBall);

        return userBall;
    }

    public static String compareBall(List<Integer> computerBall, List<Integer> userBall) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerBall.size(); i++) {
            int computerNum = computerBall.get(i);
            int userNum = userBall.get(i);

            if (computerBall.contains(userNum) && computerNum == userNum) {
                strike++;
            } else if (computerBall.contains(userNum) && computerNum != userNum) {
                ball++;
            }
        }

        return getStringToStrikeAndBall(strike, ball);
    }

    private static String getStringToStrikeAndBall(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING_MESSAGE;
        } else if (ball == 0) {
            return strike + STRIKE_MESSAGE;
        } else if (strike == 0) {
            return ball + BALL_MESSAGE;
        }

        return ball + BALL_MESSAGE + strike + STRIKE_MESSAGE;
    }
}
