package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        String input;
        boolean retry;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            gameLoop();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            if (input.equals("1"))
                retry = true;
            else if (input.equals("2"))
                retry = false;
            else
                throw new IllegalArgumentException();
        } while (retry);
    }

    private static void gameLoop() {
		List<Integer> computerNumber = generateThreeRandomNumber();
        List<Integer> userNumber;

        do {
            String input;

            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            userNumber = parseInput(input);
        } while (!judgement(computerNumber, userNumber));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static List<Integer> generateThreeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            Integer num = Randoms.pickNumberInRange(1, 9);

            if (computerNumber.contains(num)) {
                i--;
                continue;
            }
            computerNumber.add(num);
        }

        return computerNumber;
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> inputNumber = new ArrayList<>(3);

        if (input.length() != 3)
            throw new IllegalArgumentException();

        for (int i = 0;i < 3;i++) {
            char c = input.charAt(i);

            if (c < '1' || c > '9')
                throw new IllegalArgumentException();
            if (inputNumber.contains(c - '0'))
                throw new IllegalArgumentException();

            inputNumber.add(c - '0');
        }

        return inputNumber;
    }

    private static boolean judgement(List<Integer> computerNumber, List<Integer> userNumber) {
        int ball = 0, strike = 0;

        for (int i = 0;i < 3;i++) {
            if (userNumber.get(i) == computerNumber.get(i))
                strike++;
            else if (computerNumber.contains(userNumber.get(i)))
                ball++;
        }

        if (ball > 0 || strike > 0) {
            if (ball > 0)
                System.out.print(ball + "볼");
            if (strike > 0 && ball > 0)
                System.out.print(" ");
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println("");
        }
        else {
            System.out.println("낫싱");
        }

        if (strike == 3)
            return true;
        return false;
    }
}
