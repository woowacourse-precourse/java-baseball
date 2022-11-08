package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static String createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return toString(computer);
    }

    public static String toString(List<Integer> list) {
        return list.toString().replaceAll("[^1-9]", "");
    }

    public static String inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String baseballNumber = Console.readLine();
        return baseballNumber;
    }

    public static int getStrike(String randomNumber, String baseballNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == (baseballNumber.charAt(i))) {
                strike++;
            }
        }

        return strike;
    }

    public static int getBall(String randomNumber, String baseballNumber) {
        int ball = 0;
        String[] randomNumberList = randomNumber.split("");

        for (String number : randomNumberList) {
            if (baseballNumber.contains(number)) {
                ball++;
            }
        }

        ball = ball - getStrike(randomNumber, baseballNumber);
        return ball;
    }

    public static void baseballGame() {
        String randomNumber = "";
        String restartNumber = "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            randomNumber = createRandomNumber();
            restartNumber = startGame(randomNumber);
        } while (!restartNumber.equals("2"));
    }

    public static String startGame(String randomNumber) {
        // TODO: 숫자 입력받기
        // TODO: 입력한 수에 대한 힌트
        return "";
    }

    public static void main(String[] args) {
        baseballGame();
    }
}
