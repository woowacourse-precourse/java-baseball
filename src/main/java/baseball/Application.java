package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private final String correctNumber;
    private boolean userCorrect = false;
    private int userSelectContinue = 1;

    public Application() {
        int[] randomNumberSet = new int[3];
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumberSet[i] = randomNumber;
        }

        correctNumber = Arrays.stream(randomNumberSet).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    public void start() {
        String userNumber;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (userSelectContinue == 1) {
            System.out.print("숫자를 입력해주세요: ");
            userNumber = Console.readLine();

            if (validNumber(userNumber)) {
                System.out.println(judgeCorrectNumber(userNumber));
                if (userCorrect) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    userSelectContinue = Integer.parseInt(Console.readLine());
                    if (userSelectContinue == 1) {
                        Application numberBaseballGame = new Application();
                        numberBaseballGame.start();
                    }
                }
            }
        }
    }

    private String judgeCorrectNumber(String userNumber) {
        int ball = countBall(userNumber);
        int strike = countStrike(userNumber);
        String result;

        if (ball > 0 && strike > 0) {
            result = ball + "볼" + " " + strike + "스트라이크";
        } else if ((ball != 0 && strike == 0) || (ball == 0 && strike != 0)) {
            if (ball != 0) {
                result = ball + "볼";
            } else {
                result = strike + "스트라이크";
            }
        } else {
            result = "낫싱";
        }
        return result;
    }

    private int countBall(String userNumber) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) != correctNumber.charAt(i) && correctNumber.indexOf(userNumber.charAt(i)) > -1) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike(String userNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber.charAt(i) == correctNumber.charAt(i)) {
                strike++;
            }
        }
        if (strike == 3) {
            userCorrect = true;
        }
        return strike;
    }

    private boolean validNumber(String userNumber) {
        List<String> userNumberList = new ArrayList<>(Arrays.asList(userNumber.split("")));
        if (userNumber.length() == 3 && userNumberList.size() == userNumberList.stream().distinct().count()) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Application numberBaseballGame = new Application();
        numberBaseballGame.start();
    }
}