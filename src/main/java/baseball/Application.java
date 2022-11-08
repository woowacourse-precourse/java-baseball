package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            int randomNumber = makeRandomNumber();

            playGame(randomNumber);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (restartOrEndGame() == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }


    public static int makeRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        while (numList.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!(numList.contains(num))) numList.add(num);
        }

        String randomNumber = "";
        for (int i = 0; i < numList.size(); i++) {
            randomNumber += numList.get(i);
        }
        return Integer.parseInt(randomNumber);
    }


    public static int userNumber() {
        System.out.printf("숫자를 입력해주세요: ");

        String n = Console.readLine();
        return exceptionHandler(n);
    }


    public static int exceptionHandler(String n) {
        int num = Integer.parseInt(n);
        if (!(num >= 100 && num <1000)) throw new IllegalArgumentException("n은 세자리 숫자입니다.");

        return num;
    }


    public static void playGame(int computerInput) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int userInput = userNumber();
            int strikeCount = checkStrikeCount(computerInput, userInput);
            int ballCount = checkBallCount(computerInput, userInput);

            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱\n");
                continue;
            }
            if (strikeCount == 0 || strikeCount == 1 || strikeCount == 2) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크\n");
                continue;
            }
            if (strikeCount == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }


    public static int checkStrikeCount(int computerInput, int userInput) {
        String computer = ""+computerInput;
        String user = ""+userInput;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) strike++;
        }
        return strike;
    }


    public static int checkBallCount(int computerInput, int userInput) {
        int ball =0;
        String computer = ""+computerInput;
        String user = ""+userInput;

        for (int i = 0; i < 3; i++) {
            String s = String.valueOf(user.charAt(i));
            if (computer.contains(s) && computer.charAt(i)!=user.charAt(i)) ball++;
        }

        return ball;
    }


    public static int restartOrEndGame() {
        String input = Console.readLine();
        int n = Integer.parseInt(input);

        return breakExceptionHandler(n);
    }

    public static int breakExceptionHandler(int n) {
        if (!(n == 1 || n ==2)) throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");

        return n;
    }
}
