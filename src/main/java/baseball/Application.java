package baseball;

import java.util.*;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int runState = 0;
        while (runState != 2) {
            runState = game();
        }
    }

    static int game() {
        List<Integer> computer = createRandomThreeDigitNumber();
        List<Integer> user;

        int strikes = 0;
        while (strikes < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            inputValidationOfUser(userInput);
            user = userInputToList(userInput);

            List<Integer> strikesAndBalls = strikeAndBallCounter(computer, user);
            strikes = strikesAndBalls.get(0);
            int balls = strikesAndBalls.get(1);
            printResult(strikes, balls);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String startEndCondition = Console.readLine();
        inputValidationOfStartEndCondition(startEndCondition);

        return Integer.parseInt(startEndCondition);
    }


    static List<Integer> createRandomThreeDigitNumber() {
        List<Integer> computer = new ArrayList<>();

        int first = Randoms.pickNumberInRange(1,9);
        computer.add(first);

        int second = Randoms.pickNumberInRange(1,9);
        while (second == first) {
            second = Randoms.pickNumberInRange(1,9);
        }
        computer.add(second);

        int third = Randoms.pickNumberInRange(1,9);
        while (third == first || third == second) {
            third = Randoms.pickNumberInRange(1,9);
        }
        computer.add(third);

        return computer;
    }

    static List<Integer> userInputToList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for(char number : userInput.toCharArray()) {
            user.add(number-'0');
        }
        return user;
    }

    static List<Integer> strikeAndBallCounter(List<Integer> computer, List<Integer> user) {
        Map<String, Integer> strikeAndBall = new LinkedHashMap<>();

        int strikeCounts = countDigitMatched(computer, user);
        strikeAndBall.put("strike", strikeCounts);
        int ballCounts = countContainedAll(computer, user) - strikeCounts;
        strikeAndBall.put("ball", ballCounts);

        return new ArrayList<>(strikeAndBall.values());
    }

    static int countDigitMatched(List<Integer> computer, List<Integer> user) {
        return (int)IntStream.range(0, 3).
                filter(x -> user.get(x)==computer.get(x)).
                count();
    }

    static int countContainedAll(List<Integer> computer, List<Integer> user) {
        return (int)user.stream().
                filter(computer::contains).
                count();
    }

    static void printResult(int strikes, int balls) {
        if (strikes + balls == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikes != 0 && balls == 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }
        if (strikes == 0 && balls != 0) {
            System.out.printf("%d볼\n", balls);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
    }


    static void inputValidationOfUser(String input) {
        //1~9 범위의 숫자가 아닌 문자를 포함하는 경우
        String temp = input.replaceAll("[1-9]", "");
        if (temp.length() != 0){
            throw new IllegalArgumentException();
        }
        //3자리 수가 아닌 경우
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        //중복 숫자를 포함하는 경우
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException();
        }
    }

    static void inputValidationOfStartEndCondition(String input) {
        if (!(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException();
        }
    }
}
