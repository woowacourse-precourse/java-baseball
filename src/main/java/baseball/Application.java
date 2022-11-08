package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;

public class Application {
    static boolean restartGame = true;
    static boolean repeatUserInput = true;
    static List<Integer> countedNumber;

    //  구현시 주의 사항
    //  1) indent의 depth가 3을 넘지 않도록 하기
    //  2) 3항 연산자 사용 금지
    //  3) 메소드가 한 가지 일만 하도록 최대한 작게 만들기
    //  4) 주어진 라이브러리 사용
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (restartGame) {
            baseballGame();
        }
    }

    //  야구 게임을 실행하는 메소드
    //  전체적인 흐름을 담당
    public static void baseballGame() throws IllegalArgumentException {
        int[] randomNumber = generateRandomNumber();
        int[] userInputNumber = new int[3];
        repeatUserInput = true;
        restartGame = true;

        System.out.print("RandomNum : ");
        for (int num :
                randomNumber) {
            System.out.print(num);
        }
        System.out.println();

        while (repeatUserInput) {
            userInputNumber = userInput();
            checkScore(randomNumber, userInputNumber);
        }

        userInputRestartGame();
    }


    //  서로 다른 3자리 랜덤 숫자 생성기
    //  숫자는 반드시 1 ~ 9사이의 범위
    //  랜덤 세부 구현은 camp.nextstep.edu.missionutils.Randoms 이용
    public static int[] generateRandomNumber() {
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int holder = Randoms.pickNumberInRange(1, 9);
            //  같은 숫자가 나오지 않도록
            if (intList.contains(holder)) {
                i--;
                continue;
            }
            intList.add(holder);
        }

        return intList.stream().mapToInt(i -> i).toArray();
    }

    //  유저로부터 입력받는 기능
    //  아래와 같은 경우 IllegalArgumentException 발생
    //  1) 3자리가 아닐 경우
    //  2) 숫자가 아닐 경우
    //  3) 입력에 0이 포함될 경우
    //  4) 중복된 숫자가 있을 경우
    public static int[] userInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String input = Console.readLine();

            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            if (input.contains("0")) {
                throw new IllegalArgumentException();
            }

            return splitUserInput(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    //  유저 입력 숫자중에 중복이 있는지 확인하는 과정
    public static int[] splitUserInput(String userInput) throws IllegalArgumentException {
        int[] userInputIntAry = new int[3];

        userInputIntAry[0] = Integer.parseInt(userInput.substring(0, 1));

        for (int i = 1; i < userInput.length(); i++) {
            if (userInput.charAt(i - 1) == userInput.charAt(i)) {
                throw new IllegalArgumentException();
            }

            userInputIntAry[i] = Integer.parseInt(userInput.substring(i, i + 1));
        }

        return userInputIntAry;
    }

    //  스트라이크와 볼 갯수를 구하는 메소드
    public static void checkScore(int[] randomNumber, int[] userInput) {
        int score = 0;
        countedNumber = new ArrayList<>();

        for (int i = 0; i < randomNumber.length; i++) {
            if (randomNumber[i] == userInput[i]) {
                score += 10;
                countedNumber.add(userInput[i]);
                continue;
            }

            score += getBallScore(randomNumber, userInput[i]);
        }

        printScore(score);
    }

    //  볼 점수를 구하는 메소드
    public static int getBallScore(int[] randomNum, int userInputNum) {
        int res = 0;

        for (int i = 0; i < randomNum.length; i++) {
            if (countedNumber.contains(randomNum[i])) {
                continue;
            }

            if (userInputNum == randomNum[i]) {
                res++;
                countedNumber.add(userInputNum);
            }
        }

        return res;
    }

    //  점수를 출력하는 메소드
    public static void printScore(int score) {
        int strikeCount = score / 10;
        int ballCount = score % 10;

        //  하나도 맞추지 못한 경우
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        //  정확한 위치를 맞추지 못한 경우
        if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
            return;
        }

        //  위치와 숫자를 맞춘 경우
        if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            if (strikeCount == 3) {
                System.out.println(strikeCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                repeatUserInput = false;
            }
            return;
        }

        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }

    //  유저의 입력에 따라 게임을 종료하거나 재시작하는 메소드
    public static void userInputRestartGame() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String input = Console.readLine();
            int inputInt = Integer.parseInt(input);

            if (inputInt == 1) {}
            else if (inputInt == 2) {
                restartGame = false;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
