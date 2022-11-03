package baseball;

import java.util.*;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int startAndEndCondition = 1;
        while (startAndEndCondition != 2) {
            game();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            startAndEndCondition = Integer.parseInt(Console.readLine());
        }
    }

    static void game() {
        List<Integer> computer = createRandomThreeDigitNum();
        List<Integer> user;

        int strikes = 0;
        while (strikes < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            user = userInput();

            List<Integer> strikesAndBalls = countAndSave(computer, user);
            strikes = strikesAndBalls.get(0);
            int balls = strikesAndBalls.get(1);
            printResult(strikes, balls);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static List<Integer> createRandomThreeDigitNum() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) computer.add(randomNumber);
        }

        return computer;
    }

    static List<Integer> userInput() {
        List<Integer> user = new ArrayList<>();

        String input = Console.readLine();
        isCorrectedInput(input);

        for(char number : input.toCharArray()) {
            user.add(number-'0');
        }

        return user;
    }

    static boolean isCorrectedInput(String input) {
        if (input.length() != 3) throw new IllegalArgumentException();

        Set<Character> set = new HashSet<>();
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i) || i == '0') throw new IllegalArgumentException();

            if(!set.contains(i)) set.add(i);
            else throw new IllegalArgumentException();
        }

        return true;
    }

    static List<Integer> countAndSave(List<Integer> computer, List<Integer> user) {
        Map<String, Integer> strikeAndBallCounter = new LinkedHashMap<>();

        int strikeCounts = countEqualDigits(computer, user);
        strikeAndBallCounter.put("strike", strikeCounts);

        int ballCounts = countUserNumInComputerNum(computer, user) - strikeCounts;
        strikeAndBallCounter.put("ball", ballCounts);

        return new ArrayList<>(strikeAndBallCounter.values());
    }

    static int countEqualDigits(List<Integer> computer, List<Integer> user) {
        return (int)IntStream.range(0, 3).
                filter(x -> user.get(x)==computer.get(x)).
                count();
    }

    static int countUserNumInComputerNum(List<Integer> computer, List<Integer> user) {
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
}
