package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> rand() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean retry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final int check = in.nextInt();
        if (check == 1) {
            return true;
        }
        return false;
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> digitList = new ArrayList<>();
        Set<Integer> digitSet = new HashSet<>();
        try {
            int number = in.nextInt();
            while (number != 0) {
                final int digit = number % 10;
                digitList.add(digit);
                digitSet.add(digit);
                number /= 10;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (digitList.size() != 3 || digitSet.size() != 3) {
            throw new IllegalArgumentException();
        }
        return digitList;
    }

    private static boolean score(List<Integer> answer, List<Integer> guess) {
        Set<Integer> digitSet = new HashSet<>();
        for (final Integer a: answer) {
            digitSet.add(a);
        }
        for (final Integer g: guess) {
            digitSet.add(g);
        }
        int balls = 6 - digitSet.size();
        if (balls == 0) {
            System.out.println("낫싱");
            return false;
        }
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(guess.get(i)) {
                strikes++;
                balls--;
            }
        }
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (balls != 0) {
            System.out.println(balls+"볼 ");
        }
        if (strikes != 0) {
            System.out.println(strikes+"스트라이크");
        }
        return false;
    }
}
