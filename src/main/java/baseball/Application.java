package baseball;

import java.util.*;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.*;

public class Application {

    private static Map<String, Integer> strikeAndBallCounter;

    public static void main(String[] args) {
        initializerOfStrikeAndBallCounter();

        List<Integer> computer = createRandomThreeDigitNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해 주세요 : ");
        List<Integer> user = userInput();

        countAndSave(computer, user);

    }

    static void initializerOfStrikeAndBallCounter() {
        strikeAndBallCounter = new LinkedHashMap<>();
        strikeAndBallCounter.put("strike", 0);
        strikeAndBallCounter.put("ball", 0);
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

    static void countAndSave(List<Integer> computer, List<Integer> user) {
        int strikeCounts = countEqualDigits(computer, user);
        strikeAndBallCounter.put("strike", strikeCounts);

        int ballCounts = countUserNumInComputerNum(computer, user) - strikeCounts;
        strikeAndBallCounter.put("ball", ballCounts);
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


}
