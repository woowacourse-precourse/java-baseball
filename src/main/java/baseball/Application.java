package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean finishGame = false;

        while (!finishGame) {

            int answerNumber = getAnswerNumber();

            playGame(answerNumber);

            finishGame = continueOrExit();
        }
    }

    public static int getAnswerNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer); // TODO : 테스트용 출력! 지워야 함

        int computerNumber = computer.get(0) * 100 + computer.get(1) * 10 + computer.get(2);
        return computerNumber;
    }

    public static void playGame(int answerNumber) {

        boolean equalNumber = false;

        while (!equalNumber) {
            System.out.print("숫자를 입력해주세요 : ");

            int userNumber = getUserNumber();

            int strikes = countStrikes(userNumber, answerNumber);
            int balls = countBalls(userNumber, answerNumber);

            boolean nothing = isNothing(strikes, balls);

            // TODO : 결과 출력에 대해 추가적인 메소드로 분리해야 할 듯!
            if (nothing) {
                System.out.println("낫싱");
            } else {
                if (strikes == 0 && balls != 0)
                    System.out.println(balls + "볼");
                else if (strikes != 0 && balls == 0)
                    System.out.println(strikes + "스트라이크");
                else
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
            }

            // 판정 결과를 정답과 비교하는 메소드 호출
            equalNumber = equalNumber(strikes);
        }
    }

    public static int getUserNumber() {

        int userNumber = Integer.parseInt(Console.readLine());

        String userNumberToStr = Integer.toString(userNumber);
        Set numberSet = new HashSet<>();
        for(int i=0; i<3; i++)
            numberSet.add(userNumberToStr.charAt(i));
        System.out.println(numberSet);

        if (numberSet.size() != 3)
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");

        return userNumber;
    }

    public static boolean continueOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int userChoice = Integer.parseInt(Console.readLine());

        if (userChoice == 1)
            return false;
        if (userChoice == 2)
            return true;

        // TODO : 1이나 2 이외의 잘못된 값이 들어왔을 때 예외처리 로직이 필요할 듯!
        return false;
    }

    public static int countStrikes(int userNumber, int answerNumber) {

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumber % 10 == answerNumber % 10) count += 1;

            userNumber /= 10;
            answerNumber /= 10;
        }

        return count;
    }

    public static int countBalls(int userNumber, int answerNumber) {

        int count = 0;

        List<Integer> userDigits = new ArrayList<>();
        List<Integer> answerDigits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userDigits.add(userNumber % 10);
            answerDigits.add(answerNumber % 10);
            userNumber /= 10;
            answerNumber /= 10;
        }

        for (int i = 0; i < 3; i++) {

            int number = userDigits.get(i);
            if (answerDigits.contains(number)) {
                if (answerDigits.get(i) != number)
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
