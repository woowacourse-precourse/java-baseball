package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            int randomNumber = makeRandomNumber();

            playGame(randomNumber);

            if (restartOrEndGame() == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }


    public static int makeRandomNumber() {
        String numList = "";
        for (int i = 0; i < 10; i++) {
            int num = (int) ((Math.random() * 9) + 1);
            numList += num;
        }

        return removeRepetitionNumber(numList);
    }


    public static int removeRepetitionNumber(String numList) {
        String result = "";
        for (int i = 0; i < numList.length(); i++) {
            String number = String.valueOf(numList.charAt(i));
            if (!(result.contains(number))) result += number;
        }
        result = result.substring(0,3);

        return Integer.parseInt(result);
    }


    public static int userNumber() {
        System.out.printf("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        return exceptionHandler(n);
    }


    public static int exceptionHandler(int n) {
        if (!(n >= 100 && n <1000)) throw new IllegalArgumentException("n은 세자리 숫자입니다.");

        return n;
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
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
        Scanner sc = new Scanner(System.in);
        System.out.println("게임 다시하기: 1 \n게임 종료: 2");
        int n = sc.nextInt();

        return breakExceptionHandler(n);
    }

    public static int breakExceptionHandler(int n) {
        if (!(n == 1 || n ==2)) throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");

        return n;
    }
}
