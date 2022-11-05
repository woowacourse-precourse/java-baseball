package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    public static void main(String[] args) {
        System.out.println(START_SENTENCE);
        List<Integer> answer = generateRandomNumber();

        String inputNum = input();
        List<Integer> ballAndStrikeList = calculate(answer, inputNum);
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
        System.out.println(ball + ", " + strike);
        ballAndStrikeList.add(ball); // index: 0 에 ball
        ballAndStrikeList.add(strike); // index: 1 에 strike
        return ballAndStrikeList;
    }

    public static void printStatus(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println(); // 줄바꿈
    }
}