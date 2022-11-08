package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static int threeStrikesIdentifier = 0;

    public static void main(String[] args) {
        processBaseballGame();
    }

    public static void processBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computer = getComputersValue();

        threeStrikesIdentifier = 0;
        while (threeStrikesIdentifier == 0) {
            System.out.print("숫자를 입력해 주세요 : ");
            String user = validateUserInput(Console.readLine());
            countBallStrike(computer, user);
        }
    }

    public static String getComputersValue() {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < 3) {
            String randInt = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!stringBuilder.toString().contains(randInt)) {
                stringBuilder.append(randInt);
            }
        }
        return stringBuilder.toString();
    }

    public static String validateUserInput(String num) {
        int count = 0;
        for (int idx = 0; idx < num.length() ; idx++, count++) {
            if (num.charAt(idx) == '0') {
                throw new IllegalArgumentException("자릿수에 0이 존재할 수 없습니다.");
            }
        }
        if (count != 3) {
            throw new IllegalArgumentException("세 자릿수를 입력해주세요.");
        }
        if (num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2)) {
            throw new IllegalArgumentException("세 자릿수 각각은 서로 달라야 합니다.");
        }

        return num;
    }

    public static void countBallStrike(String computer, String user) {
        int strike = 0;
        int ball = 0;

        for (int idx = 0; idx < computer.length(); idx++) {
            String computersValue = String.valueOf(computer.charAt(idx));
            String usersValue = String.valueOf(user.charAt(idx));

            if (computersValue.equals(usersValue)) {
                strike++;
            } else if (computer.contains(usersValue)) {
                ball++;
            }
        }
        printResult(strike, ball);
    }

    private static void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exitOrRestart();
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static void exitOrRestart() {
        threeStrikesIdentifier = 1;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String response = Console.readLine();
        switch (response) {
            case "1":
                processBaseballGame();
                break;
            case "2":
                return;
            default:
                throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }
}
