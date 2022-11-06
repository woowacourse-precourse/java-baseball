package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean gameFinishFlag = false, equalNumberFlag = false;
        int userNumber = 0, strikeCount, ballCount;
        while (!gameFinishFlag) {

            equalNumberFlag = false;
            int randomNumber = makeRandomNumber();
            System.out.println(randomNumber);

            // TODO : 게임 진행 과정은 추가적인 메소드로 분리해야 할 듯!
            while (!equalNumberFlag) {
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    userNumber = Integer.parseInt(Console.readLine());
                } catch (NumberFormatException ex) {
                    // 유효하지 않은 사용자 입력에 대해 예외 처리하는 메소드 호출
                }

                strikeCount = countStrike(userNumber, randomNumber);
                ballCount = countBall(userNumber, randomNumber);
                System.out.println(strikeCount + " " + ballCount);

                boolean nothing = isNothing(strikeCount, ballCount);

                // TODO : 결과 출력에 대해 추가적인 메소드로 분리해야 할 듯!
                if (nothing) {
                    System.out.println("낫싱");
                } else {
                    if (strikeCount == 0 && ballCount != 0)
                        System.out.println(ballCount + "볼");
                    else if (strikeCount != 0 && ballCount == 0)
                        System.out.println(strikeCount + "스트라이크");
                    else
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }

                // 판정 결과를 정답과 비교하는 메소드 호출
                equalNumberFlag = equalNumber(strikeCount);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // TODO : 3스트라이크 이후의 로직은 추가적인 메소드로 분리해야 할 듯!
            userNumber = Integer.parseInt(Console.readLine());
            if(userNumber == 1)
                gameFinishFlag = false;
            else if(userNumber == 2) {
                gameFinishFlag = true;
            }
        }
    }

    public static int makeRandomNumber() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        int computerNumber = computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
        return computerNumber;
    }

    public static int countStrike(int userNumber, int randomNumber) {

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber % 10 == randomNumber % 10) count += 1;

            userNumber /= 10;
            randomNumber /= 10;
        }

        return count;
    }

    public static int countBall(int userNumber, int randomNumber) {

        int count = 0;

        List<Integer> userDigits = new ArrayList<>();
        List<Integer> randomDigits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userDigits.add(userNumber % 10);
            randomDigits.add(randomNumber % 10);
            userNumber /= 10;
            randomNumber /= 10;
        }

        for (int i = 0; i < 3; i++) {

            int number = userDigits.get(i);
            if (randomDigits.contains(number)) {
                if (randomDigits.get(i) != number)
                    count += 1;
            }
        }

        return count;
    }

    public static boolean isNothing(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    public static boolean equalNumber(int strikeCount) {
        return strikeCount == 3;
    }
}
