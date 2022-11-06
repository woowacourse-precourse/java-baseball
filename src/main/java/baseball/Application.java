package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> createComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean printScore(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = strikeNumbers(computerNumber, playerNumber);
        int ball = ballNumbers(computerNumber, playerNumber);

        if (strike == 0 && ball == 0) System.out.println("낫싱");
        else if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (ball == 0) System.out.println(strike + "스트라이크");
        else if (strike == 0) System.out.println(ball + "볼");
        else System.out.println(ball + "볼 " + strike + "스트라이크");
        return false;
    }

    public static int strikeNumbers(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i).equals(playerNumber.get(i))) strike++;
        }
        return strike;
    }

    public static int ballNumbers(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;

        for (int i = 0; i < playerNumber.size(); i++) {
            if (!(Objects.equals(computerNumber.get(i), playerNumber.get(i))) && computerNumber.contains(playerNumber.get(i)))
                ball++;
        }
        return ball;
    }

    public static int askUserTheNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());
        if (!isNumberValid(input)) throw new IllegalArgumentException();
        return input;
    }

    public static boolean isNumberValid(int number) {
        List<Integer> prototype = breakInteger(number);
        return hasDuplicates(prototype) && !hasZero(prototype) && isNumberInRange(number);
    }

    public static List<Integer> breakInteger(int number) {
        List<Integer> list = new ArrayList<>();
        int reverse = 0;
        // reverse the number
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        while (reverse > 0) {
            list.add(reverse % 10);
            reverse /= 10;
        }
        return list;
    }

    public static boolean hasZero(List<Integer> list) {
        int sum = 1;
        for (int elem : list) sum *= elem;
        return sum == 0;
    }

    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int elem : list) {
            if (!set.add(elem)) return false;
        }
        return true;
    }

    public static boolean isNumberInRange(int number){
        return ((number / 100 >= 1) && (number / 100 < 10));
    }
}
