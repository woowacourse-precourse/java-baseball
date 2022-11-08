package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.Exception.*;

public class Application {

    public static void main(String[] args) {
        List<Integer> computerBall = makeRandomBall();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> userBall = getStringToIntList(Console.readLine());
            String result = compareBall(computerBall, userBall);

            if (!result.equals("3스트라이크")) {
                System.out.println(result);
                continue;
            }

            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if (Objects.equals(input, "1")) {
                computerBall = makeRandomBall();
            } else if (Objects.equals(input, "2")) {
                break;
            } else {
                throw new IllegalArgumentException();
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
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
