package baseball;

import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            gameProcess();
            selectReplay();
        } while (selectReplay() == String.valueOf(2));
    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    public static List<Integer> inputNumberOfUser() {
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        List<String> stringNumberList = List.of(input.split(""));
        List<Integer> inputNumberList = stringNumberList.stream()
            .map(Integer::parseInt)
            .collect(toList());
        ArrayList<Integer> inputNumberArrayList = new ArrayList<>(inputNumberList);
        Set<Integer> inputNumberSet = new HashSet<>(inputNumberList);
        long count = stringNumberList.stream().filter("0"::equals).count();

        if ((int) (Math.log10(inputNumber) + 1) == 3 && inputNumberSet.size() == 3 && count == 0) {
            System.out.println("숫자를 입력해주세요: " + input);
            System.out.println(inputNumber);
            return inputNumberArrayList;
        } else
            throw new IllegalArgumentException();
    }

    public static int countStrikes(ArrayList<Integer> generatedNumber, ArrayList<Integer> inputNumber) {
        int strike = 0;

        for (int i = 0; i < generatedNumber.size(); i++) {
            if (Objects.equals(generatedNumber.get(i), inputNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int countRawBalls(ArrayList<Integer> generatedNumber, ArrayList<Integer> inputNumber) {
        int rawBall = 0;

        for (int i = 0; i < generatedNumber.size(); i++) {
            int dupCheck = Collections.frequency(inputNumber, generatedNumber.get(i));
            rawBall += dupCheck;
        }
        return rawBall;
    }

    public static String gameReferee(ArrayList<Integer> generatedNumber, ArrayList<Integer> inputNumber) {
        String answer = "";
        int strike = countStrikes(generatedNumber, inputNumber);
        int ball = countRawBalls(generatedNumber, inputNumber) - strike;

        if(ball > 0) {
            answer += ball + "볼 ";
        }
        if(strike > 0) {
            answer += strike + "스트라이크 ";
        }
        if(strike == 0 && ball == 0) {
            answer = "낫싱";
        }
        if(strike == inputNumber.size()) {
            answer = strike + "스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return answer;
    }

    public static void gameProcess() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        ArrayList<Integer> generatedNumber = new ArrayList<>(generateNumber());
        ArrayList<Integer> inputNumber;
        do {
            inputNumber = new ArrayList<>(inputNumberOfUser());
            System.out.println(gameReferee(generatedNumber, inputNumber));
        } while (!gameReferee(generatedNumber, inputNumber).contains("맞히셨습니다"));
    }
    public static String selectReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String action = Console.readLine();
        if (action.equals("2")) {
            System.out.println("게임 종료");
            return action;
        }
        if (action.equals("1")) {
            System.out.println("TEST");
            gameProcess();
        } else {
            throw new IllegalArgumentException();
        }
        return action;
    }
}
