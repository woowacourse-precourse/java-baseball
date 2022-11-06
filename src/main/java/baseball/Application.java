package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println(START_SENTENCE);
        List<Integer> answer = generateRandomNumber();

        int flag = 1; // flag가 1이면 게임을 계속 진행
        while (flag == 1) {
            String inputNum = input();
            checkInputNumber(inputNum);

            List<Integer> ballAndStrikeList = calculate(answer, inputNum);

            int ball = ballAndStrikeList.get(0);
            int strike = ballAndStrikeList.get(1);
            printStatus(ball, strike);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String input = Console.readLine();
                checkInputNewGameNumber(input);

                flag = Integer.parseInt(input);
                answer = generateRandomNumber();
            }
        }
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String input() {
        System.out.print(INPUT_SENTENCE);
        return Console.readLine();
    }

    public static List<Integer> calculate(List<Integer> answer, String input) {
        int ball = 0;
        int strike = 0;
        List<Integer> ballAndStrikeList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (answer.get(i) == num) { // 해당 숫자가 자리수까지 같다면 strike
                strike++;
                continue;
            }
            if (answer.contains(num)) { // 해당 숫자가 리스트에 존재하면 ball
                ball++;
            }
        }
        ballAndStrikeList.add(ball); // index: 0 에 ball
        ballAndStrikeList.add(strike); // index: 1 에 strike
        return ballAndStrikeList;
    }

    public static void printStatus(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println(); // 줄바꿈
    }

    public static void checkInputNumber(String inputNum) {
        if (inputNum.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        isValidNumber(inputNum);

        // 0을 포함한 수를 입력받으면 예외 처리
        if (inputNum.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }
        if (inputNum.charAt(1) == '0') {
            throw new IllegalArgumentException();
        }
        if (inputNum.charAt(2) == '0') {
            throw new IllegalArgumentException();
        }

        // 중복된 숫자가 있는지 확인 후 예외 처리
        if (inputNum.charAt(0) == inputNum.charAt(1)) {
            throw new IllegalArgumentException();
        }
        if (inputNum.charAt(0) == inputNum.charAt(2)) {
            throw new IllegalArgumentException();
        }
        if (inputNum.charAt(1) == inputNum.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputNewGameNumber(String inputNum) {
        if (!inputNum.equals("1") && !inputNum.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidNumber(String inputNum) {
        try {
            Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}